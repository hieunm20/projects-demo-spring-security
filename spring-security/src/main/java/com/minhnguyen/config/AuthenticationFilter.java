package com.minhnguyen.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Log4j2
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain)
      throws IOException, ServletException {
    // Chỗ này chỉ demo security nên ko có các phần sau
    // Validate token
    if (request.getRequestURI().contains("login")) {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (authentication == null) {
        String username = "minhnguyen";
        String password = "1";
        List<SimpleGrantedAuthority> roles = List.of(new SimpleGrantedAuthority("admin"));
        UserDetails userDetails = new User(username, password, roles);
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());

        SecurityContextHolder.getContext()
            .setAuthentication(authenticationToken);
      }
    }

    filterChain.doFilter(request, response);
  }
}
