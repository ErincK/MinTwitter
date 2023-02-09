package com.erinc.service;

import com.erinc.repository.TweetRepository;
import com.erinc.repository.UserProfileRepository;
import com.erinc.repository.entity.Tweet;
import com.erinc.repository.entity.UserProfile;
import com.erinc.repository.view.VwTweet;
import com.erinc.utility.MyFactoryService;

import java.util.ArrayList;
import java.util.List;

public class TweetService extends MyFactoryService<TweetRepository, Tweet, Long> {

    private UserProfileService userProfileService;

    public TweetService(){
        super(new TweetRepository());
        this.userProfileService= new UserProfileService();
    }
    /**
     * !!!! DİKKAT !!!!
     * Bir listeden başka servislerden bilgi çekmesi bekleniyor ise,
     * bu işlem bir kayıt başına belli bir maliyete sebep olacaktır.
     * Bu nedenle bu işlemin yani, her seferinde bir kaydın çekilmesi doğru değildir.
     * Burada 2 çözüm var;
     * 1- JOIN kullanarak iki tablonun birleştirilmesi..
     * 2- Aram yapılarak listenin tümden çekilerek filter ile bilgilerin çekilmesi.
     *
     */
    public List<VwTweet> findAllViewTweet(){
        List<VwTweet> result = new ArrayList<>();
        List<Tweet> tweetList = getRepository().findAll(); // Bütün tweetlwe çekildi.
        List<UserProfile> userProfileList = userProfileService.findAll();

        tweetList.forEach(t->{
            /**
             * Çok fazlaaaa maliyetli biiiiir işlemdir.
             */
            UserProfile userProfile = userProfileList.stream()
                            .filter(x->x.getId().equals(t.getUserid()))
                            .findFirst().get();
            VwTweet viewt = VwTweet.builder()
                    .id(t.getId())
                    .image(t.getImage())
                    .content(t.getContent())
                    .shareddate(t.getShareddate())
                    .retweetid(t.getRetweetid())
                    .tweetcomment(t.getTweetcomment())
                    .userid(t.getUserid())
                    .retweet(t.getRetweet())
                    .tweetview(t.getTweetview())
                    .tweetlike(t.getTweetlike())
                    .quotedtweetid(t.getQuotedtweetid())
                    .profileimg(userProfile.getProfileimg())
                    .nickName(userProfile.getName()+" "+userProfile.getSurname())
                    .username(userProfile.getUsername())
                    .build();
            result.add(viewt);
        });
        return result;
    }


}
