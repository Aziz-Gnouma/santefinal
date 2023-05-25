package com.iset.sante.service;

import com.iset.sante.entities.Appointment;
import com.iset.sante.repositories.ConsultationRepository;
import com.iset.sante.repositories.RoleRepository;
import com.iset.sante.repositories.UserRepository;
import com.iset.sante.entities.Role;
import com.iset.sante.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	@Autowired
	ConsultationRepository ConsultationRepository;
	@Autowired PasswordEncoder passwordEncoder;

	
	public void registerDefaultUser(User user) {
		Role roleUser = roleRepo.findByName("User");
		user.addRole(roleUser);
		encodePassword(user);
		userRepo.save(user);
	}
	
	public List<User> listAll() {
		return userRepo.findAll();
	}
	public List<Appointment> listcons() {
		return ConsultationRepository.findAll();
	}


	public User get(Long id) {
		return userRepo.findById(id).get();
	}
	
	public List<Role> listRoles() {
		return roleRepo.findAll();
	}
	
	public void save(User user) {
		encodePassword(user);		
		userRepo.save(user);
	}
	
	private void encodePassword(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);		
	}

	public void deleteuserById(long id) {
		this.userRepo.deleteById(id);
	}

}
