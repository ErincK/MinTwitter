package com.erinc.repository;

import com.erinc.repository.entity.Follow;
import com.erinc.utility.MyFactoryRepository;

public class FollowRepository extends MyFactoryRepository<Follow, Long> {
    public FollowRepository(){
        super(new Follow());
    }
}
