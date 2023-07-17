package com.laurentiuspilca.ssia.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;
@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    StringBuilder out = new StringBuilder();

   out.append("\n-------------- Request Data --------------");
   out.append("\nMethod: " + request.getMethod());
   out.append("\nURL: " + request.getRequestURL().toString());
   out.append("\nHeaders: ");
    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
     out.append(headerName + " = " + request.getHeader(headerName)+"\n");
    }
    log.debug(out.toString());
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    StringBuilder out = new StringBuilder();
    out.append("\n-------------- Response Data --------------");
    out.append("\nStatus: " + response.getStatus());
    out.append("\nHeaders: \n");
    response.getHeaderNames().forEach(name -> out.append(name +":" +response.getHeader(name)+"\n"));
    log.debug(out.toString());
    MDC.clear();
  }
}
