package com.example.demo.service;

import com.example.demo.model.Credit;
import com.example.demo.repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by İbrahim Başar YARGICI at 28.09.2021
 */
@Service
public class CreditService {
    private final CreditRepository creditRepository;

    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public Set<Credit> getAll() {
        return new HashSet<>(creditRepository.findAll());
    }

    public Credit findCreditById(long id) {
        // TODO business code
        return creditRepository.getById(id);
    }

    public Credit save(Credit credit) {
        // TODO business code
        return creditRepository.save(credit);
    }

    public Credit update(Credit credit) {
        // TODO business code 
        return creditRepository.save(credit);
    }

    public void delete(long id) {
        // TODO business code 
        creditRepository.delete(findCreditById(id));
    }
}