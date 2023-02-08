package com.erinc.service;

import com.erinc.repository.UserProfileRepository;
import com.erinc.repository.entity.UserProfile;
import com.erinc.utility.MyFactoryService;

public class UserProfileService extends MyFactoryService<UserProfileRepository, UserProfile,Long> {

    private UserProfileRepository userProfileRepository;
    public UserProfileService(){
        super(new UserProfileRepository());
        this.userProfileRepository = new UserProfileRepository();
    }

    public boolean existByUsername(String username){
        return getRepository().existByUsername(username);
    }





}
