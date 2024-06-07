package io.github.dariozubaray.challengetecnico.service;

import io.github.dariozubaray.challengetecnico.dto.MovieApiResponse;
import io.github.dariozubaray.challengetecnico.config.MovieClient;
import io.github.dariozubaray.challengetecnico.entity.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MovieServiceTest {

    @Mock
    private MovieClient movieClient;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMoviesGroupedByDirectorWithMinCount() {
        // Create mock data
        Movie movie1 = Movie.builder().title("Movie 1").director("Director A").build();
        Movie movie2 = Movie.builder().title("Movie 2").director("Director A").build();
        Movie movie3 = Movie.builder().title("Movie 3").director("Director B").build();
        Movie movie4 = Movie.builder().title("Movie 4").director("Director B").build();
        Movie movie5 = Movie.builder().title("Movie 5").director("Director B").build();

        List<Movie> movies = List.of(movie1, movie2, movie3, movie4, movie5);

        MovieApiResponse movieApiResponse = MovieApiResponse.builder().data(movies).build();

        // Mock the API client response
        when(movieClient.search(1, 10)).thenReturn(movieApiResponse);

        // Call the method under test
        Map<String, List<Movie>> result = movieService.getMoviesGroupedByDirectorWithMinCount(1, 10, 3);

        // Verify the results
        assertEquals(1, result.size());
        assertEquals(3, result.get("Director B").size());
    }
}
