package com.example.demo.controller;

import com.example.demo.model.Credit;
import com.example.demo.service.CreditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 29.09.2021
 */
@RestController
@RequestMapping("/credit")
public class CreditController {
    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/getAll")
    public Set<Credit> findCreditById() {
        // TODO business code
        return creditService.getAll();
    }

    @GetMapping("/{id}")
    public Credit findCreditById(@PathVariable long id) {
        // TODO business code
        return creditService.findCreditById(id);
    }

    @PostMapping("/add")
    public Credit save(@RequestBody Credit credit) {
        // TODO business code
        return creditService.save(credit);
    }

    @PostMapping("/update")
    public Credit update(@RequestBody Credit credit) {
        // TODO business code
        return creditService.update(credit);
    }

    //TODO response must be improved!
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        // TODO business code
        return ResponseEntity.ok(creditService.delete(id));
    }
}