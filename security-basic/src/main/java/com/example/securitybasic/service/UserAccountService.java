package com.example.securitybasic.service;

import com.example.securitybasic.model.UserAccount;
import com.example.securitybasic.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService implements UserDetailsService {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //Read User from DB and map it to User.
        UserAccount userAccount = userAccountRepository.findByUsername(s).get();
        User user = new User(userAccount.getUsername(), userAccount.getPassword(), userAccount.getActive(), userAccount.getActive(), userAccount.getActive(), userAccount.getActive(), AuthorityUtils.createAuthorityList("ADMIN", "USER"));
        return user;
    }
}
