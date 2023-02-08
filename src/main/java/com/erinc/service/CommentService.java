package com.erinc.service;

import com.erinc.repository.CommentRepository;
import com.erinc.repository.entity.Comment;
import com.erinc.utility.MyFactoryService;

public class CommentService extends MyFactoryService<CommentRepository, Comment, Long> {
    public CommentService(){
        super(new CommentRepository());
    }
}
