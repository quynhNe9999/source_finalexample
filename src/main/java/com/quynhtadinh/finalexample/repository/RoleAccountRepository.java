package com.quynhtadinh.finalexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quynhtadinh.finalexample.entity.RoleAccount;

@Repository
public interface RoleAccountRepository extends JpaRepository<RoleAccount,Integer> {
}
