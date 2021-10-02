package com.example.demo.repository;

import com.example.demo.model.Credit;
import com.example.demo.model.CreditNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 28.09.2021
 */
@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    Optional<Credit> getByCreditNote(CreditNote creditNote);
}
