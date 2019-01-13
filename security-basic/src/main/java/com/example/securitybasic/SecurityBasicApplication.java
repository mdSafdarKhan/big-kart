package com.example.securitybasic;

import com.example.securitybasic.model.UserAccount;
import com.example.securitybasic.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.persistence.Id;
import java.util.Optional;

@SpringBootApplication
public class SecurityBasicApplication implements CommandLineRunner {

	@Autowired
	UserAccountRepository userAccountRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createUserAccount(1L, "Alice", "alice", true);
		createUserAccount(2L, "Bob", "bob", true);
		createUserAccount(3L, "Sam", "sam", false);
	}

	public void createUserAccount(Long id, String username, String password, Boolean active){
		UserAccount userAccount = UserAccount.builder()
				.id(id)
				.username(username)
				.password(password)
				.active(active)
				.build();
		userAccountRepository.save(userAccount);
	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder(){
		return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
	}
}

