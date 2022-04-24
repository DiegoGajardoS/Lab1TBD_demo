/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diego
 */
@RestController
public class TestService {
    
    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello World";
    }
    
    
    
}
