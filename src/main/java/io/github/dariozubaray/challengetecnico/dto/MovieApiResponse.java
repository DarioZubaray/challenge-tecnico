package io.github.dariozubaray.challengetecnico.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.dariozubaray.challengetecnico.entity.Movie;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MovieApiResponse {
    @Schema(description = "Page number", example = "1")
    private int page;

    @Schema(description = "Number of items per page", example = "10")
    @JsonProperty("per_page")
    private int perPage;

    @Schema(description = "Total number of items", example = "26")
    private int total;

    @Schema(description = "Total number of pages", example = "3")
    @JsonProperty("total_pages")
    private int totalPages;

    @Schema(description = "List of movies")
    private List<Movie> data;
}
