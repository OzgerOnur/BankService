package com.kodluyoruz.bankservice.repositories;


import com.kodluyoruz.bankservice.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
}
