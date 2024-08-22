package com.quynhtadinh.finalexample.repository;

import com.quynhtadinh.finalexample.entity.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.quynhtadinh.finalexample.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

	@Query("SELECT e FROM User e WHERE e.username LIKE %:keyword% ")
    Page<User> FindAllByUserName(Optional<String> keyword, Pageable pageable);

    @Query("SELECT p FROM User p WHERE p.username LIKE %:keyword%")
    List<User> searchUser(@Param("keyword") String keyword);

    Page<User> findByUsernameContainingOrEmailContaining(String username, String email, Pageable pageable);

    @Query("SELECT COUNT(u) FROM User u")
    long countAllUsers();

}
