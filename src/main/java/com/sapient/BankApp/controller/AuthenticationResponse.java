package com.sapient.BankApp.controller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

//  @JsonProperty("access_token")
//  private String accessToken;
//  @JsonProperty("refresh_token")
  private String token;
}