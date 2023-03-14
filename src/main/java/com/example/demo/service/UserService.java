package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.IUserRespository;

@Service
public class UserService implements IGenericDataBaseOperations{
	
	@Autowired
	private IUserRespository userRepository;
	
	@Override
	public User insert(Object objUser) throws Exception {
		
		User userToCreate = (User) objUser;
		
		userToCreate.setUuid(UUID.randomUUID());
	    LocalDateTime now = LocalDateTime.now();  
		userToCreate.setCreatedAt(now);
		userToCreate.setIsActive(true);
		userToCreate.setLastLogin(null);
		
		return userRepository.save(userToCreate);
	}

	@Override
	public Object delete(Object objectToDelete) throws Exception{
		throw new UnsupportedOperationException("The method DELETE from the User object havent been implemented yet.");
	}

	@Override
	public Object update(Long idUsr, Object modifiedObject) throws Exception{
		throw new UnsupportedOperationException("The method UPDATE from the User object havent been implemented yet.");
	}

	@Override
	public User getObjectByEmail(String email) throws Exception{
		
		Optional<User> listOptUser = userRepository.findByEmail(email);
		if(listOptUser.isPresent())
			return listOptUser.get();
		
		return null;
	}
	
	
	
}
