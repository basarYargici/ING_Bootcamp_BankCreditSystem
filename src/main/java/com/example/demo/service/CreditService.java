package com.example.demo.service;

import com.example.demo.model.Credit;
import com.example.demo.repository.CreditRepository;

/**
 * Created by İbrahim Başar YARGICI at 28.09.2021
 */
public class CreditService {
    private final CreditRepository creditRepository;

    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public Credit findCredit(long id) {
        Credit credit = creditRepository.getById(id);

        return credit;
    }

    public Credit save(Credit credit) {
        return creditRepository.save(credit);
    }

    public Credit update(Credit credit) {
        // TODO business code 
        return creditRepository.save(credit);
    }

    public void delete(long id) {
        // TODO business code 
        creditRepository.delete(findCredit(id));
    }
}