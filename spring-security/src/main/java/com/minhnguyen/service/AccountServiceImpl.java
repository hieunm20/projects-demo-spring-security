package com.minhnguyen.service;

import com.minhnguyen.entity.Account;
import com.minhnguyen.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  @Override
  public List<Account> findAll() {
    return accountRepository.findAll();
  }
}
