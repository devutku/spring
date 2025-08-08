package dev.patika.spring;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping("/")
    public String get() {
        return "Customer Get Çalıştı";
    }
    @PostMapping("/save")
    public String save(@RequestBody String data) {
        return "Gelen veri : " + data;
    }
}
