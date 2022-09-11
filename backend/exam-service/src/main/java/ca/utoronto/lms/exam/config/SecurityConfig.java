package ca.utoronto.lms.exam.config;

import ca.utoronto.lms.shared.security.AuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

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
                        "/actuator/**",
                        "/docs/**").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                       "/exam-terms/student/{id}").hasAnyAuthority(ROLE_STUDENT, ROLE_ADMIN)
                .antMatchers(
                        HttpMethod.GET,
                        "/exams/**",
                        "/exam-periods/**",
                        "/exam-terms/**",
                        "/exam-types/**").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/exam-realizations/student/*").hasAnyAuthority(ROLE_STUDENT, ROLE_ADMIN)
                .antMatchers(
                        HttpMethod.GET,
                        "/exam-realizations/exam-term/*",
                        "/exam-realizations/exam-term/*/all/pdf").hasAnyAuthority(ROLE_TEACHER, ROLE_ADMIN)
                .antMatchers(
                        HttpMethod.POST,
                        "/exam-realizations/exam-term/*").hasAuthority(ROLE_STUDENT)
                .antMatchers(
                        HttpMethod.PATCH,
                        "/exam-realizations/*/score",
                        "/exam-realizations/exam-term/*/score").hasAnyAuthority(ROLE_TEACHER, ROLE_ADMIN)
                .anyRequest().hasAuthority(ROLE_ADMIN)
                .and()
                .build();
    }
}
