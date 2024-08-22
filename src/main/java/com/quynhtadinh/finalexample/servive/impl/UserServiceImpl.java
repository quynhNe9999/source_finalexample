package com.quynhtadinh.finalexample.servive.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.quynhtadinh.finalexample.entity.User;
import com.quynhtadinh.finalexample.repository.RoleRepository;
import com.quynhtadinh.finalexample.repository.UserRepository;
import com.quynhtadinh.finalexample.service.UserService;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public User insert(User user) {
		if (user.getPassword() != null && !user.getPassword().isEmpty()) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		}
		return userRepository.save(user);
	}

	@Override
	public boolean delete(long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public User update(User user) {
		User updateUser = userRepository.findById(user.getId()).orElse(null);
		if (updateUser != null) {
			updateUser.setUsername(user.getUsername());
			updateUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			// updateUser.setPasswordConfirm(user.getPasswordConfirm());
			// updateUser.setRoles(user.getRoles());
			return userRepository.save(updateUser);
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	@Transactional
	public User updateUser(Long id, User newUser) {
		return userRepository.findById(id)
				.map(user -> {
					user.setUsername(newUser.getUsername());
					user.setEmail(newUser.getEmail());
					user.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
					user.setStatus(newUser.getStatus());
					user.setDateTao(newUser.getDateTao());
					user.setRoles(newUser.getRoles());
					return userRepository.save(user);
				})
				.orElseGet(() -> {
					newUser.setId(id);
					return userRepository.save(newUser);
				});
	}

	@Override
	public Page<User> searchUser(Optional<String> keyword, Pageable pageable) {
		String searchKeyword = keyword.orElse(""); // Nếu không có từ khóa, tìm kiếm với chuỗi rỗng
		return userRepository.findByUsernameContainingOrEmailContaining(searchKeyword, searchKeyword, pageable);
	}
}
