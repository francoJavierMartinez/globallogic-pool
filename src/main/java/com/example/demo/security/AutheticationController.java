//package com.example.demo.security;
//
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.http.MediaType;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.dto.UserDto;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@RestController
//public class AutheticationController {
//	
//	
//	@RequestMapping(value = "/sign-in", method = RequestMethod.POST)
//	public String login(@RequestBody UserDto user) {
//		
//		String token = getJWTToken(user.getEmail());	
//		return token;
//		
//	}
//	
//	private String getJWTToken(String username) {
//		
//		String secretKey = "mySecretKey";
//		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
//		
//		String token = Jwts.builder().setId("softtekJWT").setSubject(username).claim("authorities", grantedAuthorities.stream()
//						   .map(GrantedAuthority::getAuthority)
//						   .collect(Collectors.toList()))
//						   .setIssuedAt(new Date(System.currentTimeMillis()))
//				           .setExpiration(new Date(System.currentTimeMillis() + 600000))
//				           .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
//		
//		return "Bearer " + token;
//	}
//	
//
//}
