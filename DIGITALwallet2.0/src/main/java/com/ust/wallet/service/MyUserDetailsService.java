package com.ust.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ust.wallet.model.UserPrincipal;
import com.ust.wallet.model.users;
import com.ust.wallet.repo.CredRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	
	@Autowired
	private CredRepo crepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		users user = crepo.findByUsername(username);
		if(user==null) {
			System.out.println("user not founnd");
			throw new UsernameNotFoundException("user not found");
		}
			
		return new UserPrincipal(user);
	}

}
