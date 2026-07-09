package com.cognizant.accountservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/accounts")
public class AccountServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @GetMapping("/{number}")
    public Map<String, Object> getAccountDetails(@PathVariable String number) {
        return Map.of(
            "number", number,
            "type", "savings",
            "balance", 234343
        );
    }
}
