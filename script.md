# Entwickler Dojo: Logging
* loglevels: ![loglevels](https://miro.medium.com/v2/resize:fit:378/format:webp/1*Mx07nfF-ESu3oFMRkU8J9A.png)
* [How to use loglevels](https://github.com/bodote/cheatsheets/blob/master/java_logging.md#general-rules-about-logging-applies-not-only-to-javaspring-boot)
* starting `mvn sping-boot:run` making http request:
```
GET http://localhost:8080/hello
Request-Id:12345
```
* application.properities Möglichkeiten
  * management.endpoints.web.exposure.include
  * spring boot color terminal without banner ("DETECT","ALWAYS","NEVER") start in Terminal 
  * spring.websecurity.debug=true
  * server.error.include-*
  * "logging.config=" application property
* making http request:
```
GET http://localhost:8080/hello
Request-Id:12345
```
* logback-spring.xml vs logback.xml vs ownlogback.xml  
* Loggers, Appenders  and Layouts ![Loggers, Appenders  and Layouts](https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2019/09/Picture3.png)
* sending to Elasic stack or Splunk: verwende am besten ein JSON-Format mit zB. JsonLayout / com.splunk.logging.HttpEventCollectorLogbackAppender / LogstashTcpSocketAppender+LogstashEncoder / ElasticsearchAppender
* scan="true" scanPeriod="1 seconds"
* adding lomboc (for slf4j)
* add log to RequestValidationFilter

## spring boot logging
* `-Ddebug` mode , auch in Intellij
* alles mal auf `TRACE` und schauen was rauskommt
* making http request:
```
GET http://localhost:8080/hello
Request-Id:12345
```
* oder OHNE REQUEST ID
* 
## extending spring boot logging
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


