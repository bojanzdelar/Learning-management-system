package ca.utoronto.lms.subject.config;

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
                        "/subjects/student/*/all").hasAnyAuthority(ROLE_STUDENT, ROLE_ADMIN)
                .antMatchers(
                        HttpMethod.GET,
                        "/subjects/**",
                        "/subject-materials/**",
                        "/subject-notifications/**",
                        "/subject-terms/**").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/subject-enrollments/*",
                        "/subject-enrollments/student/*/average-grade",
                        "/subject-enrollments/student/*/total-ects").hasAnyAuthority(ROLE_STUDENT, ROLE_TEACHER, ROLE_ADMIN)
                .antMatchers(
                        HttpMethod.GET,
                        "/subject-enrollments/student/**").hasAnyAuthority(ROLE_STUDENT, ROLE_ADMIN)
                .antMatchers(
                        HttpMethod.GET,
                        "/subject-enrollments/subject/*",
                        "/subject-enrollments/subject/*/student-id/all").hasAnyAuthority(ROLE_TEACHER, ROLE_ADMIN)
                .antMatchers(
                        HttpMethod.PATCH,
                        "/subjects/*/syllabus",
                        "/subject-enrollments/*/grade").hasAnyAuthority(ROLE_TEACHER, ROLE_ADMIN)
                .antMatchers(
                        "/subject-materials/**",
                        "/subject-notifications/**",
                        "/subject-terms/**").hasAnyAuthority(ROLE_TEACHER, ROLE_ADMIN)
                .anyRequest().hasAuthority(ROLE_ADMIN)
                .and()
                .build();
    }
}
