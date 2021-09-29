package com.example.demo.service;

import com.example.demo.model.Credit;
import com.example.demo.repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by İbrahim Başar YARGICI at 28.09.2021
 */

public interface CreditService {


     Set<Credit> getAll();


     Credit findCreditById(long id);

     Credit save(Credit credit);


    Credit update(Credit credit);

     void delete(int id);

}