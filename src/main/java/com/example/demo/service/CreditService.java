package com.example.demo.service;

import com.example.demo.model.Credit;

import java.util.Set;

/**
 * Created by Emirhan Doğandemir at 29.09.2021
 */
public interface CreditService {
    Set<Credit> getAll();

    Credit findCreditById(long id);

    Credit save(Credit credit);

    Credit update(Credit credit);

    void delete(int id);
}