package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Phone;
import com.example.demo.entity.User;
import com.example.demo.repository.IUserRespository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
    @Mock	
    IUserRespository repository;
	
	@Test
	public void insertTest() throws Exception {
				
		Phone phone = new Phone(new Long(1234),23,"34");
		List<Phone> listPhones = Arrays.asList(phone);
		User user = new User(UUID.randomUUID(),true, LocalDateTime.now(), null, "Franco", "test@test.com","test1234", listPhones);
		
		assertThat(user.getUuid()).isNotNull();
		assertThat(user.getUuid()).asString();
		assertTrue(user.getIsActive());
		assertEquals(new String("Franco"), user.getName());
		assertEquals(new String("test@test.com"), user.getEmail());
		assertEquals(new String("test1234"), user.getPassword());
		assertThat(listPhones.stream().findFirst().get()).isInstanceOf(Phone.class);

		Mockito.lenient().when(repository.save(user)).thenReturn(new User());
		
	}
	
	@Test
	public void getObjectByEmailTest() {
		
		String email = "test@test.com";
		Optional<User> listOptional = Optional.of(new User());
		Mockito.lenient().when(repository.findByEmail(email)).thenReturn(listOptional);
		
	}
	
}