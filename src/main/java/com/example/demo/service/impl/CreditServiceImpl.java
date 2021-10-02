package com.example.demo.service.impl;

import com.example.demo.exception.CustomNotDeletedException;
import com.example.demo.exception.CustomNotFoundException;
import com.example.demo.exception.CustomNotSavedException;
import com.example.demo.model.Credit;
import com.example.demo.model.CreditNote;
import com.example.demo.repository.CreditRepository;
import com.example.demo.service.CreditService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 29.09.2021
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
                .orElseThrow(() -> new CustomNotFoundException("Credit could not found by id: " + id));
    }

    @Override
    public Credit save(Credit credit) {
        try {
            float bankInterest = credit.getBankInterest();
            float extraPercentage = credit.getExtraPercentage();

            credit.setPayBack(calculatePayBack(credit, bankInterest, extraPercentage));

            return creditRepository.save(credit);
        } catch (Exception e) {
            throw new CustomNotSavedException("Credit could not be saved with id: " + credit.getId());
        }
    }

    private BigDecimal calculatePayBack(Credit credit, float bankInterest, float extraPercentage) {
        BigDecimal creditAmount = credit.getCreditAmount();
        BigDecimal a = creditAmount.add(creditAmount.multiply(new BigDecimal(extraPercentage)));
        BigDecimal b = a.multiply(new BigDecimal(bankInterest));

        return a.add(b).setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * = credit.getCreditAmount().multiply(BigDecimal(extraPercentage)) + credit.getCreditAmount() * extraPercentage
     * *bankInterest,
     *
     * @param credit
     * @return
     */

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

    @Override
    public Credit getByCreditNote(CreditNote creditNote) {
        return creditRepository.getByCreditNote(creditNote)
                .orElseThrow(() -> new CustomNotFoundException("CreditNote not found with name: '" + creditNote.name() + "'"));
    }
}
