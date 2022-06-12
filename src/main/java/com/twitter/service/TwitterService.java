package com.twitter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@Service
@RequiredArgsConstructor
public class TwitterService {

    private final String consumerKey = "Tez1oLxiIRPMlMiP5enxLbERZ";
    private final String consumerSecret = "8tVGmZUpm2LjTST63nFrOlcOY235uXI6eXRn3KKKcjxuJ3StNt";
    private final String accessToken = "2457972307-H0KZGR7vTyGVyf6o1nGbiO12HIX6pTIOQoisKrf";
    private final String accessTokenSecret = "YlR15Ghnv3CXS6pEM2sN3p7Yp7p48z5LRVcW2fdqdP8BY";

    public void tweetService(String message) throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(consumerKey, consumerSecret);
        twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));
        twitter.updateStatus(message);
    }
}
