package com.socisl.media.Controller;

import com.socisl.media.Services.SocialServices;
import com.socisl.media.models.SocialUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
    @Autowired
    private SocialServices socialServices;

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getUsers(){
        return new ResponseEntity<>(socialServices.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> createUsers(@RequestBody SocialUser socialUser){
        return new ResponseEntity<>(socialServices.createUsers(socialUser) , HttpStatus.CREATED);
    }

}






































































