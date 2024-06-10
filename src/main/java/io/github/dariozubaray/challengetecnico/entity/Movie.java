package io.github.dariozubaray.challengetecnico.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Movie {

    @JsonProperty("Title")
    @Schema(description = "Movie title", example = "Midnight in Paris")
    private String title;

    @JsonProperty("Year")
    @Schema(description = "Year of release", example = "2011")
    private String year;

    @JsonProperty("Rated")
    @Schema(description = "Movie rating", example = "PG-13")
    private String rated;

    @JsonProperty("Released")
    @Schema(description = "Release date", example = "10 Jun 2011")
    private String released;

    @JsonProperty("Runtime")
    @Schema(description = "Movie runtime", example = "94 min")
    private String runtime;

    @JsonProperty("Genre")
    @Schema(description = "Movie genre", example = "Comedy, Fantasy, Romance")
    private String genre;

    @JsonProperty("Director")
    @Schema(description = "Movie director", example = "Woody Allen")
    private String director;

    @JsonProperty("Writer")
    @Schema(description = "Movie writer", example = "Woody Allen")
    private String writer;

    @JsonProperty("Actors")
    @Schema(description = "Movie actors", example = "Owen Wilson, Rachel McAdams, Kathy Bates")
    private String actors;
}
