package com.twitter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@Service
@RequiredArgsConstructor
public class TwitterService {

    @Value("${cunsumerKey}")
    private final String consumerKey = "";
    @Value("${consumerSecret}")
    private final String consumerSecret = "";
    @Value("${accessToken}")
    private final String accessToken = "";
    @Value("${accessTokenSecret}")
    private final String accessTokenSecret = "";

    public void tweetService(String message) throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(consumerKey, consumerSecret);
        twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));
        twitter.updateStatus(message);
    }
}
