package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.User;
import com.example.demo.dao.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public List<User> getStudents(){
		return userRepository.findAll();
	}
	
	@GetMapping("/byId/{id}")
	public User getStudentByid(@PathVariable("id") String id){
		return userRepository.findById(id).orElse(null);
	}

	@PostMapping("/add")
	public User addStudent(@RequestBody User user){
		return userRepository.save(user);
	}
	
	@PutMapping("/update")
	public User updateStudent(@RequestBody User user){
		return userRepository.save(user);
	}
	
	@DeleteMapping("/remove/{id}")
	public String deleteStudentByid(@PathVariable("id") String id){
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
			return "User deleted";
		}else {
			return "User not found";
		}
		
	}
	
	

}
