package com.priyavrat.Restful.Controller;


import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.priyavrat.Restful.Entity.User;
import com.priyavrat.Restful.Repository.UserRepository;

@RestController
public class UserResource {
	@Autowired
	private UserRepository service;

	@Autowired
	private MessageSource messageSource;
	
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}

	@PostMapping("/demoo")
	public int getUserdemo(@RequestBody User user){
		return user.getId();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		Optional<User> user= service.findById(id);
		if(user.isEmpty()) throw new UserNotFoundException("User Not found exception for id- "+id);
		return user;

	}


	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required =false)Locale locale){
		return messageSource
				.getMessage("good.morning.message",null,"Default Message",//locale
						LocaleContextHolder.getLocale());
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		//User savedUser=
		service.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
		//return new ResponseEntity<User>(HttpStatus.CREATED);
		
		//It can also be created as:
		
		//URI location = ServletUriComponentsBuilder
		//.fromCurrentRequest()
		//.path("{/id}")
		//.buildAndExpand(savedUser.getId()).toUri() ;
		
		//return ResponseEntity.created(location).build();
		
		
		
	}
		
	
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id) {
		try {
			service.deleteById(id);
		}
		catch(Exception e){ throw new UserNotFoundException("id - "+id);}
		
	}
	
	
	

}
