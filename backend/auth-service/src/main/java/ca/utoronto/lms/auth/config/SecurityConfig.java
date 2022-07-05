package ca.utoronto.lms.auth.config;

import ca.utoronto.lms.auth.security.AuthTokenFilter;
import ca.utoronto.lms.shared.security.SecurityConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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
    public AuthTokenFilter authTokenFilter(AuthenticationManager manager) throws Exception {
        AuthTokenFilter authTokenFilter = new AuthTokenFilter();
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
                .antMatchers("/api/auth-service/login").permitAll()
                .antMatchers("/api/auth-service/users/username/*").authenticated()
                .anyRequest().hasAuthority(SecurityConstants.ROLE_ROOT)
                .and()
                .build();
    }
}
