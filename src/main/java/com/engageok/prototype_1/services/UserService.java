package com.engageok.prototype_1.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.engageok.prototype_1.models.User;
import com.engageok.prototype_1.repositories.RoleRepo;
import com.engageok.prototype_1.repositories.UserRepo;

@Service
public class UserService {
	private final UserRepo uRepo;
	private RoleRepo rRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public UserService(UserRepo uRepo, RoleRepo rRepo,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.uRepo = uRepo;
		this.rRepo = rRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		
	}
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(rRepo.findByName("ROLE_USER"));
		uRepo.save(user);
	}
	
	public void saveUserWithAdminRole(User user) {
		System.out.println("2");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(rRepo.findByName("ROLE_ADMIN"));
		uRepo.save(user);
	}
	public void saveUser(User user) {
		uRepo.save(user);
	}
	
	public User findByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	public List<User> findAllUsers(){
		return uRepo.findAll();
	}
	
	public User findOneUser(Long id) {
		return uRepo.findOne(id);
	}
}
