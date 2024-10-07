package com.minhnguyen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  private Integer id;
  private String fullName;
  private String username;
  private String password;
  private String phone;
}
