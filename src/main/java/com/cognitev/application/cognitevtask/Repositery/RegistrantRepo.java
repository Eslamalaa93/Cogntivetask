package com.cognitev.application.cognitevtask.Repositery;

import com.cognitev.application.cognitevtask.entity.EBRegistrant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Eslam
 *
 * Usage: Registrant Repo
 */

@Repository
public interface RegistrantRepo extends CrudRepository<EBRegistrant,Integer> {
     List<EBRegistrant> findByPhoneNumber(String Phone_number);
     List<EBRegistrant> findByEmail(String email);

}
