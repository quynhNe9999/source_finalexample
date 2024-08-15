package com.quynhtadinh.finalexample.servive.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<User> findAll() {
		return userRepository.findAll();
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
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		User updateUser = userRepository.findById(user.getId()).orElse(null);
		user.setUsername(user.getUsername());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
//	    updateUser.setPasswordConfirm(user.getPasswordConfirm());
//	    updateUser.setRoles(user.getRoles());
		return userRepository.save(user);
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
					user.setPassword(newUser.getPassword());
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
}