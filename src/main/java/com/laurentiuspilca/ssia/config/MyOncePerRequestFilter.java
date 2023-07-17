package com.laurentiuspilca.ssia.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@Slf4j
public class MyOncePerRequestFilter extends OncePerRequestFilter {
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    // Process the request and catch exceptions from other filters , therefore avoid spring boots own
    // exception handling which would reroute the request to "/error" page , which does not make much sense for
    // REST requests
    try {
      filterChain.doFilter(request, response);
    } catch (Exception ex){
      log.error("exception: ",ex);
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
  }
}
