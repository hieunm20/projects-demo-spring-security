package com.minhnguyen.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/login")
public class LoginController {

  @PostMapping
  public ResponseEntity<?> getUser(HttpServletRequest request) {
    // Chỗ này chỉ demo security nên ko có các phần sau
    // Xử lý login, check username, pass, quyền, trả về token
    // Mặc định hiểu là người dùng đăng nhập thành công với username: minhnguyen, pass: 1
    return ResponseEntity.ok("login oke");
  }
}
