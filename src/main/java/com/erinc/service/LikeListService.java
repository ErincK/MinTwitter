package com.erinc.service;

import com.erinc.repository.LikeListRepository;
import com.erinc.repository.entity.LikeList;
import com.erinc.utility.MyFactoryService;

public class LikeListService extends MyFactoryService<LikeListRepository, LikeList, Long> {
    public LikeListService(){
        super(new LikeListRepository());
    }
}
