package com.ust.wallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.wallet.model.users;
@Repository
public interface CredRepo extends JpaRepository<users, Integer>{

	public users findByUsername(String username);

}
