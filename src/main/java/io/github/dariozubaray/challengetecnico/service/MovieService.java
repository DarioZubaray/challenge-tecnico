package io.github.dariozubaray.challengetecnico.service;

import io.github.dariozubaray.challengetecnico.config.MovieClient;
import io.github.dariozubaray.challengetecnico.dto.MovieApiResponse;
import io.github.dariozubaray.challengetecnico.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public record MovieService(MovieClient movieClient) {

    public List<Movie> getMovies(int page, int perPage) {
        MovieApiResponse response = movieClient.search(page, perPage);
        return response.getData();
    }

    public Map<String, List<Movie>> getMoviesGroupedByDirectorWithMinCount(int page, int perPage, int minCount) {
        List<Movie> movies = getMovies(page, perPage);

        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getDirector))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() >= minCount)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
