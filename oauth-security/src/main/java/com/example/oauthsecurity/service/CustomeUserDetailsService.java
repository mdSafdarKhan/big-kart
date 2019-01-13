package com.example.oauthsecurity.service;

import com.example.oauthsecurity.model.UserAccount;
import com.example.oauthsecurity.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailsService implements UserDetailsService {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("start user service");

        UserAccount userAccount = userAccountRepository.findByUserName(s).get();

        if(userAccount != null){
            System.out.println("user found in db");

            //TODO Some error is coming like PaaswordEncoder

            User user = new User(
                    userAccount.getUserName(), userAccount.getPassword(),
                    userAccount.isActive(), userAccount.isActive(), userAccount.isActive(), userAccount.isActive(),
                    AuthorityUtils.createAuthorityList("ADMIN", "USER"));

            /*UserDetails user = User.withDefaultPasswordEncoder()
                    .username(userAccount.getUserName())
                    .password(userAccount.getPassword())
                    .roles("ADMIN", "USER")
                    .build();*/
            System.out.println("end user service good");
            return user;
        }
        System.out.println("end user service bad");
        return null;
    }
}
