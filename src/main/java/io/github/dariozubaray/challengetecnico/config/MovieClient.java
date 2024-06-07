package io.github.dariozubaray.challengetecnico.config;

import io.github.dariozubaray.challengetecnico.dto.MovieApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "movieClient", url = "https://directa24-movies.wiremockapi.cloud/api/movies")
public interface MovieClient {

    @GetMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE)
    MovieApiResponse search(@RequestParam("page") int page, @RequestParam("per_page") int perPage);
}
