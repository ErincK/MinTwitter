package com.erinc.controller;

import com.erinc.repository.entity.Tweet;
import com.erinc.repository.entity.UserProfile;
import com.erinc.service.*;

import java.util.Scanner;

public class TweetController {
    /**
     * Bir kullanıcının akışı şeklinde yapıyoruz. Bu nedenle login olan kullanıcının id'si üzerinden işlem yapacağız.
     * @param userid
     */

    private Scanner scanner;
    private UserProfile userProfile;
    private TweetService tweetService;
    private LikeListService likeListService;
    private FollowService followService;
    private CommentService commentService;
    private UserProfileService userProfileService;

    public TweetController(){
        this.tweetService= new TweetService();
        this.commentService= new CommentService();
        this.followService= new FollowService();
        this.likeListService= new LikeListService();
        this.userProfileService= new UserProfileService();

    }

    private int secim(){
        this.scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String ifade(){
        this.scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public void userPage(String username){
        this.userProfile=userProfileService.findByUsername(username).get();
        System.out.println("*********************************");
        System.out.println("*****      USER PAGE       ******");
        System.out.println("*********************************");
        int secim;
        do{
            System.out.println("");
            System.out.println("1- Create Tweet");
            System.out.println("2- Watch All Tweets");
            System.out.println("3- Edit Profile");
            System.out.println("Make Your Choose!");
            secim = secim();
            switch (secim){
                case 1: createTweet();
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }while (secim!=0);
    }

    private void createTweet(){
        System.out.println("*****************************");
        System.out.println("*****   CREATE TWEET    *****");
        System.out.println("*****************************");
        System.out.println();
        System.out.println("Resim........: ");
        String resim = ifade();
        System.out.println("Tweet........: ");
        String tweetContent = ifade();
        Tweet tweet = Tweet.builder()
                .userid(userProfile.getId())
                .shareddate(System.currentTimeMillis())
                .image(resim)
                .content(tweetContent)
                .build();
        tweetService.save(tweet);
    }

    private void listTweet(){
        System.out.println("***********************************");
        System.out.println("******      Tweet List      *******");
        System.out.println("***********************************");
        System.out.println();
        tweetService.findAllViewTweet().forEach(t->{
            System.out.println("-----------------------------------");
            System.out.println(t.getNickName()+ " -> "+ t.getUsername());
            System.out.println();
            System.out.println(t.getContent());
            System.out.println("??????????????");
            System.out.println("??????????????");
            System.out.println("??????????????");
            System.out.println("??????????????");
            System.out.printf("  Y[%s]     R[%s]      L[%s]     W[%s]   \n",
                    t.getTweetcomment(),t.getRetweet(),t.getTweetlike(),t.getTweetview());
            System.out.println("-----------------------------------");
            System.out.println();
        });


    }










}
