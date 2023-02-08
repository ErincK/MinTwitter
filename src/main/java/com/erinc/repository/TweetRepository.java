package com.erinc.repository;

import com.erinc.repository.entity.Tweet;
import com.erinc.utility.MyFactoryRepository;

public class TweetRepository extends MyFactoryRepository<Tweet, Long> {
    public TweetRepository(){
        super(new Tweet());
    }
}
