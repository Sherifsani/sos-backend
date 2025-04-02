
package com.example.sosbackend.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
  public String getGreeting() {
    return "Welcome to sos api";
  }
}
