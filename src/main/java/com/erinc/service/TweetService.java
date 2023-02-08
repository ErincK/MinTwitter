package com.erinc.service;

import com.erinc.repository.TweetRepository;
import com.erinc.repository.entity.Tweet;
import com.erinc.utility.MyFactoryService;

public class TweetService extends MyFactoryService<TweetRepository, Tweet, Long> {
    public TweetService(){
        super(new TweetRepository());
    }
}
