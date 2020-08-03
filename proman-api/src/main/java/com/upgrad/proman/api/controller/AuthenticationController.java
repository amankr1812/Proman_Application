package com.upgrad.proman.api.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.proman.api.model.AuthorizedUserResponse;

@RestController
@RequestMapping("/")
public class AuthenticationController {

   @RequestMapping(method = RequestMethod.POST, path = "auth/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
   public ResponseEntity<AuthorizedUserResponse> login(final String authorization){    
  return null;
 }
}
