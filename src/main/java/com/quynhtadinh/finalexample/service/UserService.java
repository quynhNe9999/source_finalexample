package com.quynhtadinh.finalexample.service;

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

import javax.transaction.Transactional;

@Service
public class UserService {  // Chuyển từ interface thành class
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public User insert(User user) {
		if (user.getPassword() != null && !user.getPassword().isEmpty()) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		}
		return userRepository.save(user);
	}

	public boolean delete(long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public User update(User user) {
		User updateUser = userRepository.findById(user.getId()).orElse(null);
		if (updateUser != null) {
			updateUser.setUsername(user.getUsername());
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			updateUser.setPassword(encodedPassword);
			// Thêm các phần khác của update nếu cần thiết
			return userRepository.save(updateUser);
		}
		return null;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
	@Transactional
	public User updateUser(User newUser) {
		try {
			return userRepository.findById(newUser.getId())
					.map(existingUser -> {
						existingUser.setUsername(newUser.getUsername());
						existingUser.setEmail(newUser.getEmail());

						if (newUser.getPassword() != null && !newUser.getPassword().isEmpty()) {
							existingUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
						}

						existingUser.setStatus(newUser.getStatus());
						existingUser.setDateTao(newUser.getDateTao());
						existingUser.setRoles(newUser.getRoles());

						return userRepository.save(existingUser);
					})
					.orElseGet(() -> {
						newUser.setId(newUser.getId());
						return userRepository.save(newUser);
					});
		} catch (Exception e) {
			// Ghi log lỗi để kiểm tra
			System.err.println("Lỗi khi cập nhật người dùng: " + e.getMessage());
			// Hoặc dùng logger
			// logger.error("Lỗi khi cập nhật người dùng", e);
			throw new RuntimeException("Có lỗi xảy ra khi cập nhật người dùng", e);
		}
	}


	public Page<User> searchUser(Optional<String> keyword, Pageable pageable) {
		String searchKeyword = keyword.orElse("");
		return userRepository.findByUsernameContainingOrEmailContaining(searchKeyword, searchKeyword, pageable);
	}
}
