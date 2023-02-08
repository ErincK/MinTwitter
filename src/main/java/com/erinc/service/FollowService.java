package com.erinc.service;

import com.erinc.repository.FollowRepository;
import com.erinc.repository.entity.Follow;
import com.erinc.utility.MyFactoryService;

public class FollowService extends MyFactoryService<FollowRepository, Follow, Long> {
    public FollowService(){
        super(new FollowRepository());
    }
}
