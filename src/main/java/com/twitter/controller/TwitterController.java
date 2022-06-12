package com.twitter.controller;

import com.twitter.service.TwitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

@RestController
@RequiredArgsConstructor
public class TwitterController {

    private final TwitterService twitterService;

    @GetMapping("/twitter")
    public String tweet(@RequestParam(value = "message") String message) {
        try {
            twitterService.tweetService(message);
            return "OK.";
        } catch (TwitterException ex) {
            return "NG." + " " + ex.getErrorMessage();
        }
    }
}
