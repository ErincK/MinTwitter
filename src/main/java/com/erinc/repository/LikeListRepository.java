package com.erinc.repository;

import com.erinc.repository.entity.LikeList;
import com.erinc.utility.MyFactoryRepository;

public class LikeListRepository extends MyFactoryRepository<LikeList, Long> {
    public LikeListRepository(){
        super(new LikeList());
    }
}
