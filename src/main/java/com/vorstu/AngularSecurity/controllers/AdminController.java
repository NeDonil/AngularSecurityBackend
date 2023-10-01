package com.vorstu.AngularSecurity.controllers;

import com.vorstu.AngularSecurity.db.entities.auth.AuthUserEntity;
import com.vorstu.AngularSecurity.db.repositories.AuthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    private AuthUserRepo authUserRepo;

    @GetMapping("users")
    public Set<AuthUserEntity> getAllUsers(){

        return authUserRepo.findAll();
    }

    @PostMapping(value="users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AuthUserEntity createStudent(@RequestBody AuthUserEntity user){
        return authUserRepo.save(user);
    }
}
