package com.laurentiuspilca.ssia.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;

public class RequestValidationFilter extends OncePerRequestFilter {

    @Override
    public void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain filterChain) throws IOException, ServletException {

        if ( httpRequest.getRequestURI().startsWith("/error")){
            filterChain.doFilter(httpRequest, httpResponse);
        }
        String requestId = httpRequest.getHeader("Request-Id");
        if (requestId == null || requestId.isBlank()) {
//            httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return;
           throw new AuthenticationException("no Request-Id header found");
        }

        filterChain.doFilter(httpRequest, httpResponse);
    }


}
