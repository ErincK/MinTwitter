package com.erinc.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbltweet")
public class Tweet extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userid;
    Long retweetid;
    Long quotedtweetid;
    Long shareddate;
    String image;
    String content;
    int tweetcomment;
    int tweetlike;
    int retweet;
    int tweetview;
}
