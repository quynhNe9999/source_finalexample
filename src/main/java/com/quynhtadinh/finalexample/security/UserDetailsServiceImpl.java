package com.quynhtadinh.finalexample.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quynhtadinh.finalexample.entity.Role;
import com.quynhtadinh.finalexample.entity.User;
import com.quynhtadinh.finalexample.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
	}

	@Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole_name()));

        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities(user.getRoles()));
    }

	private Collection<? extends GrantedAuthority> grantedAuthorities(Set<Role> roles) {
		// TODO Auto-generated method stub
		  Set<GrantedAuthority> authorities = new HashSet<>();
	        for (Role role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
	            for (User user : role.getUsers()) {
	                authorities.add(new SimpleGrantedAuthority(user.getUsername()));
	            }
	        }
	        return authorities;
	    }
}
