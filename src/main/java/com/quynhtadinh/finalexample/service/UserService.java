package com.quynhtadinh.finalexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.quynhtadinh.finalexample.entity.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);

	Page<User> findAll(Pageable pageable);

	User insert(User user);

	boolean delete(long id);

	User update(User user);

	List<User> getAllUsers();

	Optional<User> getUserById(Long id);

	User saveUser(User user);

	void deleteUserById(Long id);

	User updateUser(Long id, User newUser);

	Page<User> searchUser(Optional<String> keyword, Pageable pageable);
}
