package ca.utoronto.lms.auth.config;

import ca.utoronto.lms.auth.security.AuthTokenFilter;
import ca.utoronto.lms.shared.security.SecurityUtils;
import ca.utoronto.lms.shared.security.TokenUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthTokenFilter authTokenFilter(UserDetailsService service, TokenUtils token, AuthenticationManager manager) {
        AuthTokenFilter authTokenFilter = new AuthTokenFilter(service, token);
        authTokenFilter.setAuthenticationManager(manager);
        return authTokenFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthTokenFilter authTokenFilter)
            throws Exception {
        return http
                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        HttpMethod.POST,
                        "/api/auth-service/login").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/api/auth-service/users/username/*/id",
                        "/api/auth-service/users/**/public").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/api/auth-service/users/username/*").authenticated()
                .antMatchers("/api/auth-service/users/**").hasAuthority(SecurityUtils.ROLE_ADMIN)
                .anyRequest().hasAuthority(SecurityUtils.ROLE_ROOT)
                .and()
                .build();
    }
}
