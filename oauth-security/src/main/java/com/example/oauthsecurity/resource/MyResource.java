package com.example.oauthsecurity.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
public class MyResource {

    //TODO to use these two annotations, implement global method security.

    //@PreAuthorize("hasRole('ADMIN')")
    //@RolesAllowed("ADMIN")
    @GetMapping("myresource")
    public Principal principal(Principal user){
        return user;
    }
}
