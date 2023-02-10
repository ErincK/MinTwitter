package com.erinc.controllerspring;

import com.erinc.TweetterSpringWebApplication;
import com.erinc.repository.entity.Tweet;
import com.erinc.repository.view.VwTweet;
import com.erinc.service.TweetService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweeterRestController {

    private final TweetService tweetService;

    public TweeterRestController(){
        this.tweetService = new TweetService();
    }
    @GetMapping("/findall")
    public ResponseEntity<List<VwTweet>> findAllTweet(){
        return  ResponseEntity.ok(tweetService.findAllViewTweet());
    }
}
