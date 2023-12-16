package com.picpay.picpaysimplificado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay.picpaysimplificado.domain.user.User;
import java.util.Optional;


/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByDocument(String document);
    
}