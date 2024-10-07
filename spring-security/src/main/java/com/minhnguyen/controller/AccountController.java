package com.minhnguyen.controller;

import com.minhnguyen.entity.Account;
import com.minhnguyen.service.AccountService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

  private final AccountService accountService;

  @GetMapping
  public ResponseEntity<?> findAll() {

    List<Account> accounts = accountService.findAll();
    return ResponseEntity.ok(accounts);
  }

}
