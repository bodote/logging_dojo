# Script
* making http request:
```
GET http://localhost:8080/hello
Request-Id:12345
```
* application.properities Möglichkeiten
  * management.endpoints.web.exposure.include
  * spring boot color terminal without banner
  * spring.websecurity.debug=true
  * server.error.include-*
  * "logging.config=" application property
* making http request:
```
GET http://localhost:8080/hello
Request-Id:12345
```

* logback-spring.xml vs logback.xml vs ownlogback.xml and 
* scan="true" scanPeriod="1 seconds"
* adding lomboc (for slf4j)
* add log to AuthenticationLoggingFilter
* defining new LoggingInterceptor implements HandlerInterceptor copy content from [bodo cheetsheets](https://github.com/bodote/cheatsheets)
* add LoggingInterceptor to WebMvcConfigurer copy from [bodo cheetsheets](https://github.com/bodote/cheatsheets)
* making http request:
```
GET http://localhost:8080/hello
Request-Id:12345
```
* add MDC.put("remoteAddr",request.getRemoteAddr()); to AuthenticationLoggingFilter
* add MDC.clear to LoggingInterceptor



* making http request:
```
GET http://localhost:8080/hello
Request-Id:12345
```

* add `logback-spring.xml`
* add `logging.config=/Users/xxx/src/main/resources/logback-spring.xml`
* 
