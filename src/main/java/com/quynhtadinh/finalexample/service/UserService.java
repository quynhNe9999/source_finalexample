package com.quynhtadinh.finalexample.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.quynhtadinh.finalexample.entity.User;

@Service
public interface UserService {
	void save(User user);

	User findByUsername(String username);

	List<User> findAll();

	User insert(User user);

	boolean delete(long id);

	User update(User user);

	User findById(long id);

//	Page<User> searchSinhVien(Optional<String> keyword, Pageable pageable);
//
}