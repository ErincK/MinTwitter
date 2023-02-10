package com.erinc.service;

import com.erinc.repository.CommentRepository;
import com.erinc.repository.entity.Comment;
import com.erinc.utility.MyFactoryService;

import java.util.List;

public class CommentService extends MyFactoryService<CommentRepository, Comment, Long> {
    public CommentService(){
        super(new CommentRepository());
    }

    public List<Comment> findByTweetId(Long tweetId){
        return getRepository().findByTweetId(tweetId);
    }
}
