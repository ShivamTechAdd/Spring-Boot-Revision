package com.socisl.media.Services;

import com.socisl.media.Repository.SocialUserRepository;
import com.socisl.media.models.SocialUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialServices {
    @Autowired
    private SocialUserRepository socialUserRepository;

    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }

    public SocialUser createUsers(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }
}
