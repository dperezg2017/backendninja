package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.udemy.entity.User;
import com.udemy.entity.UserRole;
import com.udemy.repository.UserRepository;

@Repository("userService")
public class UserService implements UserDetailsService{

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userRepository.findByUsername(username);
		List<GrantedAuthority> authorities= buildAuthorities(user.getUserRole());
		return buildUser(user, authorities);
	}

	private org.springframework.security.core.userdetails.User buildUser(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(),  user.getPassword(), user.isEnabled(), 
				true, true, true, authorities);

	}
	
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles){
		Set<GrantedAuthority> auths= new HashSet<GrantedAuthority>();
		
		for (UserRole userRole: userRoles){
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		
		return new ArrayList<GrantedAuthority>(auths);
	}
}
