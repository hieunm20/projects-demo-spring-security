package com.minhnguyen.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Log4j2
@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

  private final AuthenticationFilter authenticationFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            authorize -> authorize
                .requestMatchers("/login").permitAll()
                .anyRequest().authenticated());
    http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
    http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
