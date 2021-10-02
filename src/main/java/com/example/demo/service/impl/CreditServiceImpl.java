package com.example.demo.service.impl;

import com.example.demo.exception.CustomNotDeletedException;
import com.example.demo.exception.CustomNotFoundException;
import com.example.demo.exception.CustomNotSavedException;
import com.example.demo.model.Credit;
import com.example.demo.repository.CreditRepository;
import com.example.demo.service.CreditService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Emirhan Doğandemir at 29.09.2021
 */
@Service(value = "creditService")
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
        return creditRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("Credit could not be found by id: " + id));
    }

    @Override
    public Credit save(Credit credit) {
        try {
            return creditRepository.save(credit);
        } catch (Exception e) {
            throw new CustomNotSavedException("Credit could not be saved with id: " + credit.getId());
        }
    }

    @Override
    public Credit update(Credit credit) {
        try {
            Credit savedCredit = findCreditById(credit.getId()); //if not found throws CustomNotFoundException
            savedCredit.setBankInterest(credit.getBankInterest());
            savedCredit.setExtraPercentage(credit.getExtraPercentage());
            return creditRepository.save(credit);
        } catch (Exception e) {
            throw new CustomNotSavedException("Credit could not be saved with id: " + credit.getId());
        }
    }

    @Override
    public Boolean delete(int id) {
        try {
            creditRepository.delete(findCreditById(id));
            return true;
        } catch (Exception e) {
            throw new CustomNotDeletedException("Credit could not be deleted with id: " + id);
        }
    }
}
