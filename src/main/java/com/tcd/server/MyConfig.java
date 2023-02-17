package com.tcd.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConfig {

  //NOTE(Tom): Here is where you would add methods that are used to inject into other parts of the app
  // You provide a @Bean and it's injected into fields marked with @Autowired
  @Bean(name = "thing")
  String getThingString() {
    return "thing";
  }
  
  @Bean(name = "altThing")
  String getAltThingString() {
    return "altThing";
  }
}
