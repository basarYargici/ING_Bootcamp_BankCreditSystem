package com.example.demo.service.impl;

import com.example.demo.model.Credit;
import com.example.demo.repository.CreditRepository;
import com.example.demo.service.CreditService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CreditServiceImpl implements CreditService {
    private final CreditRepository creditRepository;

    public CreditServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public Set<Credit> getAll() {
        return new HashSet<>(creditRepository.findAll());
    }

    @Override
    public Credit findCreditById(long id) {
        return null;
    }

    @Override
    public Credit save(Credit credit) {
        return null;
    }

    @Override
    public Credit update(Credit credit) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
