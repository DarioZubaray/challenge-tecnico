package io.github.dariozubaray.challengetecnico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.optionals.OptionalDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class FeignConfig {

    @Bean
    public Decoder feignDecoder() {
        return new OptionalDecoder(new JacksonDecoder());
    }

    @Bean
    public Encoder feignEncoder() {
        return new JacksonEncoder();
    }
}
