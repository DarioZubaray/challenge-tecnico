package io.github.dariozubaray.challengetecnico.controller;

import io.github.dariozubaray.challengetecnico.entity.Movie;
import io.github.dariozubaray.challengetecnico.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(@RequestParam("page") int page,
                                 @RequestParam("per_page") int perPage) {
        return movieService.getMovies(page, perPage);
    }

    @GetMapping("/moviesByDirectors")
    public Map<String, List<Movie>> getMoviesGroupedByDirectorWithMinCount(@RequestParam("page") int page,
                                                                           @RequestParam("per_page") int perPage,
                                                                           @RequestParam("min_count") int minCount) {
        return movieService.getMoviesGroupedByDirectorWithMinCount(page, perPage, minCount);
    }
}
