package io.github.dariozubaray.challengetecnico.controller;

import io.github.dariozubaray.challengetecnico.entity.Movie;
import io.github.dariozubaray.challengetecnico.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get all movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the movies",
                    content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movies not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/movies")
    public List<Movie> getMovies(@RequestParam("page") int page,
                                 @RequestParam("per_page") int perPage) {
        return movieService.getMovies(page, perPage);
    }

    @Operation(summary = "Get movies grouped by director with a minimum count")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the movies",
                    content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movies not found", content = @Content) })
    @GetMapping("/moviesByDirectors")
    public Map<String, List<Movie>> getMoviesGroupedByDirectorWithMinCount(@RequestParam("page") int page,
                                                                           @RequestParam("per_page") int perPage,
                                                                           @RequestParam("min_count") int minCount) {
        return movieService.getMoviesGroupedByDirectorWithMinCount(page, perPage, minCount);
    }
}
