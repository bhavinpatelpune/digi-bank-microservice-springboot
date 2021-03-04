package com.payments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payments.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
