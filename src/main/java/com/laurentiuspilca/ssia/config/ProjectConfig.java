package com.laurentiuspilca.ssia.config;

import com.laurentiuspilca.ssia.filters.AuthenticationLoggingFilter;
import com.laurentiuspilca.ssia.filters.RequestValidationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class ProjectConfig implements WebMvcConfigurer {

  private final LoggingInterceptor loggingInterceptor;
  @Value("${spring.websecurity.debug:false}")
  boolean webSecurityDebug;

  @Autowired
  public ProjectConfig(LoggingInterceptor loggingInterceptor) {
    this.loggingInterceptor = loggingInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loggingInterceptor);
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http.addFilterBefore(new MyOncePerRequestFilter(), BasicAuthenticationFilter.class)
//            .addFilterAfter(new RequestValidationFilter(), MyOncePerRequestFilter.class)
    http.addFilterBefore(new RequestValidationFilter(),BasicAuthenticationFilter.class)
        .addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)
            .authorizeRequests()
            .anyRequest().permitAll();
    http.headers().frameOptions().disable();//just for /h2-console
    return http.build();
  }

  //@Bean
  public CommonsRequestLoggingFilter logFilter() {
    CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
    filter.setIncludeQueryString(true);
    filter.setIncludePayload(true);
    filter.setMaxPayloadLength(10000);
    filter.setIncludeHeaders(true);
    filter.setAfterMessagePrefix("REQUEST DATA: ");
    filter.setIncludeQueryString(true);
    filter.setIncludeClientInfo(true);
    return filter;
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.debug(webSecurityDebug);
  }
/*
    @Bean
    public HttpExchangeRepository httpExchangeRepository() {
//        return new InMemoryHttpExchangeRepository();
        return new HttpExchangeRepository() {
            @Override
            public List<HttpExchange> findAll() {
                return null; // only implement if you use /actuator/httpexchanges
            }

            @Override
            public void add(HttpExchange httpExchange) {
                StringBuffer out = new StringBuffer();
                out.append("Request:\n");
                httpExchange.getRequest().getHeaders().forEach((key, value) -> {
                    out.append(key + ": " + value + "\n");
                });
                if (httpExchange.getRequest().getMethod() != null && httpExchange.getRequest().getMethod().length() >
                 0) {
                    out.append(httpExchange.getRequest().getMethod());
                    out.append(" ");
                    out.append(httpExchange.getRequest().getUri());
                }
                out.append("\nResponse:\n");
                httpExchange.getResponse().getHeaders().forEach((key, value) -> {
                    out.append(key + ": " + value + "\n");
                });
                out.append(String.format("Status: %s  Time taken: %.6f sec",httpExchange.getResponse().getStatus(),
                        httpExchange.getTimeTaken().getNano()*0.0000000001));

                log.info(out.toString());
                MDC.clear();
            }
        };
    }

 */
}
