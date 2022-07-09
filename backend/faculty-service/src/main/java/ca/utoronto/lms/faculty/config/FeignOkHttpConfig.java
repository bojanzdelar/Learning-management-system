package ca.utoronto.lms.faculty.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignOkHttpConfig {
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}
