package com.quynhtadinh.finalexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quynhtadinh.finalexample.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
//	@Query("SELECT e FROM User e WHERE e.username LIKE %:keyword% ")
//	Page<User> FindAllByUserName(Optional<String> keyword,Pageable pageable);

}