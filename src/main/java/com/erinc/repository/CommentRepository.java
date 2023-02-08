package com.erinc.repository;

import com.erinc.repository.entity.Comment;
import com.erinc.utility.MyFactoryRepository;

public class CommentRepository extends MyFactoryRepository<Comment, Long> {

    public CommentRepository() {
        super( new Comment());
    }
}
