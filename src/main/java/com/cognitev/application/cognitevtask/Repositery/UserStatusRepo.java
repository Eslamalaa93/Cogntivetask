package com.cognitev.application.cognitevtask.Repositery;

import com.cognitev.application.cognitevtask.entity.EBUserStatus;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Eslam
 *
 * Usage: User Status Repo
 */
public interface UserStatusRepo extends CrudRepository<EBUserStatus,Integer> {

}
