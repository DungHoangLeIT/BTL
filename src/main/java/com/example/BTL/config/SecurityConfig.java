package com.example.BTL.config;

import com.example.BTL.jwt.JwtAuthenticationFilter;
import com.example.BTL.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private static final String[] ADMIN_URLs = {"/users/all"};
    private static final String[] USER_URLs = {
            "/books/all",
            "/books/book/{id}"
    };
    private static final String[] PERMIT_URLs = {
            "/",
            "/api/v1/auth/register",
            "/api/v1/auth/authenticate"
    };
    private final UserRepository repository;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(PERMIT_URLs).permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(USER_URLs).hasAnyAuthority("USER","ADMIN")
                .and()
                .authorizeHttpRequests()
                .requestMatchers(ADMIN_URLs).hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
//                .formLogin().permitAll().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
