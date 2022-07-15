package ca.utoronto.lms.subject.config;

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
                        "/api/subject-service/subjects/student/*/all").hasAnyAuthority(SecurityUtils.ROLE_STUDENT, SecurityUtils.ROLE_ADMIN)
                .antMatchers(
                        HttpMethod.GET,
                        "/api/subject-service/subjects/**",
                        "/api/subject-service/subject-materials/**",
                        "/api/subject-service/subject-notifications/**",
                        "/api/subject-service/subject-terms/**").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/api/subject-service/subject-enrollments/*",
                        "/api/subject-service/subject-enrollments/student/*/average-grade",
                        "/api/subject-service/subject-enrollments/student/*/total-ects").hasAnyAuthority(SecurityUtils.ROLE_STUDENT, SecurityUtils.ROLE_TEACHER, SecurityUtils.ROLE_ADMIN)
                .antMatchers(
                        HttpMethod.GET,
                        "/api/subject-service/subject-enrollments/student/**").hasAnyAuthority(SecurityUtils.ROLE_STUDENT, SecurityUtils.ROLE_ADMIN)
                .antMatchers(
                        HttpMethod.GET,
                        "/api/subject-service/subject-enrollments/subject/*",
                        "/api/subject-service/subject-enrollments/subject/*/student-id/all").hasAnyAuthority(SecurityUtils.ROLE_TEACHER, SecurityUtils.ROLE_ADMIN)
                .antMatchers(
                        HttpMethod.PATCH,
                        "/api/subject-service/subjects/*/syllabus",
                        "/api/subject-service/subject-enrollments/*/grade").hasAnyAuthority(SecurityUtils.ROLE_TEACHER, SecurityUtils.ROLE_ADMIN)
                .antMatchers(
                        "/api/subject-service/subject-materials/**",
                        "/api/subject-service/subject-notifications/**",
                        "/api/subject-service/subject-terms/**").hasAnyAuthority(SecurityUtils.ROLE_TEACHER, SecurityUtils.ROLE_ADMIN)
                .anyRequest().hasAuthority(SecurityUtils.ROLE_ADMIN)
                .and()
                .build();
    }
}
