package com.erinc.controller;

import com.erinc.repository.entity.Comment;
import com.erinc.repository.entity.Tweet;
import com.erinc.repository.entity.UserProfile;
import com.erinc.repository.view.VwTweet;
import com.erinc.repository.view.VwUserProfile;
import com.erinc.service.*;

import java.util.Map;
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
                case 2: listTweet();
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

        });

        int secim;
        do{
            System.out.println("1- View");
            System.out.println("2- <<< Back");
            secim = secim();
            if(secim == 1){
                System.out.println("Hangi tweet'i görüntüleyeceksin?...: ");
                int id = secim();
                tweetDetails(id);
            }
        }while (secim!=0);
    }

    public void tweetDetails(long tweetId){
        int secim;
        do{
            goruntulenmeArttir(tweetId);
            VwTweet tweet = tweetService.findVwTweetById(tweetId).get();
            Map<Long, VwUserProfile> userList = userProfileService.findAllVwUserList();
            System.out.println("-----------------------------------");
            System.out.println("tweetid........: "+tweet.getId());
            System.out.println(tweet.getNickName()+ " -> "+ tweet.getUsername());
            System.out.println();
            System.out.println(tweet.getContent());
            System.out.println("??????????????");
            System.out.println("??????????????");
            System.out.println("??????????????");
            System.out.println("??????????????");
            System.out.printf("  Y[%s]     R[%s]      L[%s]     W[%s]   \n",
                    tweet.getTweetcomment(),tweet.getRetweet(),tweet.getTweetlike(),tweet.getTweetview());
            System.out.println("-----------------------------------");
            System.out.println();
            System.out.println("COMMENTS");
            commentService.findByTweetId(tweetId).forEach(c->{
                VwUserProfile user = userList.get(c.getUserid());
                System.out.println(user.getUsername() + " " + c.getComment());
            });

            System.out.println("1- Yorum Yap");
            System.out.println("2- Begeni Yap");
            System.out.println("0- <<< Back");
            System.out.print("Make Your Choose!!");
            secim = secim();
            switch (secim){
                case 1: yorumYap(tweetId);
                    break;
                case 2:
                    break;
            }
        }while(secim!=0);
    }

    public void yorumYap(Long tweetId){
        System.out.println("Yorum Yaz.....: ");
        String yorum = ifade();
        commentService.save(Comment.builder()
                .userid(userProfile.getId())
                .comment(yorum)
                .tweetid(tweetId)
                .commentdate(System.currentTimeMillis())
                .build());
    }

    private void goruntulenmeArttir(Long tweetID){
        Tweet tweet = tweetService.findById(tweetID).get();
        tweet.setTweetview(tweet.getTweetview()+1);
        tweetService.update(tweet);
    }

    private void yorumArttir(Long tweetID){
        Tweet tweet = tweetService.findById(tweetID).get();
        tweet.setTweetcomment(tweet.getTweetcomment()+1);
        tweetService.update(tweet);
    }




}
