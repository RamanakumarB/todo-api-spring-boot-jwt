package dev.code.io.HelloWorld.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    String sayHelloWorld(){
        return "HelloWorld!";
    }
    /*
Representational State Transfer (REST)
    @GetMapping("/Ramana")
    String sayHiRamana(){
        return "Hi Ramana";
    }
*/
}
