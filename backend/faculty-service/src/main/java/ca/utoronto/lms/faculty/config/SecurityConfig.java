package ca.utoronto.lms.faculty.config;

import ca.utoronto.lms.shared.security.AuthenticationTokenFilter;
import ca.utoronto.lms.shared.security.SecurityUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationTokenFilter authenticationTokenFilter)
            throws Exception {
        return http
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        HttpMethod.GET,
                        "/api/faculty-service/faculties/**",
                        "/api/faculty-service/study-programs/**",
                        "/api/faculty-service/teachers/**",
                        "/api/faculty-service/theses/**",
                        "/api/faculty-service/addresses/**",
                        "/api/faculty-service/cities/**",
                        "/api/faculty-service/countries/**",
                        "/api/faculty-service/*/user-id/*/id").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/api/faculty-service/students/*").hasAnyAuthority(SecurityUtils.ROLE_STUDENT, SecurityUtils.ROLE_TEACHER, SecurityUtils.ROLE_ADMIN)
                .antMatchers(
                        HttpMethod.GET,
                        "/api/faculty-service/students/**").hasAnyAuthority(SecurityUtils.ROLE_TEACHER, SecurityUtils.ROLE_ADMIN)
                .anyRequest().hasAuthority(SecurityUtils.ROLE_ADMIN)
                .and()
                .build();
    }
}
