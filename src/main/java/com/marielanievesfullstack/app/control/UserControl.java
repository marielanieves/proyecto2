package com.marielanievesfullstack.app.control;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marielanievesfullstack.app.entity.user;
import com.marielanievesfullstack.app.service.userservice;

@RestController
@RequestMapping("/api/users")
public class UserControl {
	@Autowired
	private userservice USERservice; 
	
	//create a new user
	@PostMapping
    public ResponseEntity<?> create(@RequestBody user User){
	return ResponseEntity.status(HttpStatus.CREATED).body(USERservice.save(User));
	}
	
	@GetMapping("/{id}")

	public ResponseEntity<?> read (@PathVariable(value = "id")Long userid){
	Optional<user> OUser = USERservice.findById(userid);
	if(! OUser.isPresent()) { 
		return ResponseEntity.notFound().build();
		
	}
	return ResponseEntity.ok(OUser);
}
	@PutMapping("/{id}")
	
	public ResponseEntity<?> update(@RequestBody user userDetails, @PathVariable(value = "id") Long userId) {
		Optional<user> User = USERservice.findById(userId);

		if(!User.isPresent()) {
			
		return ResponseEntity.notFound().build();
		
		}
		User.get().setNombre(userDetails.getNombre());
		User.get().setApellido(userDetails.getApellido());
		User.get().setEmail(userDetails.getEmail());
		User.get().setAnabled(userDetails.getAnabled());
		return ResponseEntity.status(HttpStatus.CREATED).body(USERservice.save(User.get()));
}
	// Delete an User
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete (@PathVariable(value = "id") Long userId) {

			if(!USERservice.findById(userId).isPresent()) {
				return ResponseEntity.notFound().build();
			}

			USERservice.deleteById(userId);
			return ResponseEntity.ok().build();
		}
		// Read all Users
		@GetMapping
		public List<user> readAll () {

			List<user> users = StreamSupport
					.stream(USERservice.findAll().spliterator(), false)
					.collect(Collectors.toList());

			return users;
		

	}
	
}
