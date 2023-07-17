package com.laurentiuspilca.ssia.filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.logging.Logger;
@Slf4j
public class AuthenticationLoggingFilter implements Filter {



    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) request;
        String requestId = httpRequest.getHeader("Request-Id");
        //log.info("Successfully authenticated request with id " +  requestId);
        MDC.put("remoteAddr",request.getRemoteAddr());
        MDC.put("remotePort",Integer.toString(request.getRemotePort()));
        MDC.put("requestID",requestId);
        filterChain.doFilter(request, response);
    }
}
