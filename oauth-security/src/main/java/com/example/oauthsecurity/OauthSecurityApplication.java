package com.example.oauthsecurity;

import com.example.oauthsecurity.model.UserAccount;
import com.example.oauthsecurity.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class OauthSecurityApplication implements CommandLineRunner {

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	UserAccountRepository userAccountRepository;

	public static void main(String[] args) {
		SpringApplication.run(OauthSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Creating user");
		UserAccount userAccount = UserAccount.builder()
				.id(1L)
				.userName("safdar")
				.password(encoder.encode("safdar"))
				.active(true)
				.build();

		UserAccount userAccount3 = UserAccount.builder()
				.id(2L)
				.userName("bob")
				.password(encoder.encode("bob"))
				.active(true)
				.build();

		userAccountRepository.save(userAccount);
		userAccountRepository.save(userAccount3);
		System.out.println("Users created");
	}

}

