package com.quynhtadinh.finalexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quynhtadinh.finalexample.entity.StatusAccount;

@Repository
public interface StatusAccountRepository extends JpaRepository<StatusAccount,Integer> {
}
