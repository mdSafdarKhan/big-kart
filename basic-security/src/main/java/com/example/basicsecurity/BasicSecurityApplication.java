package com.example.basicsecurity;

import com.example.basicsecurity.model.UserAccount;
import com.example.basicsecurity.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableOAuth2Sso
public class BasicSecurityApplication implements CommandLineRunner{

	@Autowired
	UserAccountRepository userAccountRepository;

	public static void main(String[] args) {
		SpringApplication.run(BasicSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Creating user");
		UserAccount userAccount = UserAccount.builder()
				.id(1L)
				.userName("safdar")
				.password("{noop}safdar")
				.active(true)
				.build();

		UserAccount userAccount3 = UserAccount.builder()
				.id(2L)
				.userName("bob")
				.password("{noop}bob")
				.active(true)
				.build();

		userAccountRepository.save(userAccount);
		userAccountRepository.save(userAccount3);
		System.out.println("Users created");
	}
}

