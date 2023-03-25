package com.cdac.nashik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.nashik.entity.User;
import com.cdac.nashik.repository.UserRepo;

@Service
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User insertUser(User user) {
		return userRepo.save(user);	
	}

	@Override
	public List<User> getUserByEmailAndPassword(String email,String password) {
		return userRepo.findByEmailAndPassword(email,password);
	}
	
	@Override
	public List<User> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public List<User> findByPhone(String phone) {
		return userRepo.findByPhone(phone);
	}
	
	@Override
	public List<User> getAllUsers() {
		
		return this.userRepo.findAll();
	}

	@Override
	public List<User> forgetPassword(String email,String securityQues, String securityAns) {
		return userRepo.findByEmailAndSecurityQuesAndSecurityAns(email,securityQues, securityAns);
	}

	@Override
	public void deleteUser(String email) {
		User user =  userRepo.getById(email);
		userRepo.delete(user);	
	}

	@Override
	public User updatePassword(User user) {
		User u = userRepo.getById(user.getEmail());
		u.setPassword(user.getPassword());
		return userRepo.save(u);
	}
	
	
	
	
}
