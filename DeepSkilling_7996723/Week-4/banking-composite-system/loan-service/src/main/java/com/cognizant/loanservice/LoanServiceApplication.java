package com.cognizant.loanservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/loans")
public class LoanServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoanServiceApplication.class, args);
    }

    @GetMapping("/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable String number) {
        return Map.of(
            "number", number,
            "type", "car",
            "loan", 400000,
            "emi", 3258,
            "tenure", 18
        );
    }
}
