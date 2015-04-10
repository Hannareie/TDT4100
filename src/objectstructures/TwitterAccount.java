package objectstructures;

import java.util.ArrayList;

public class TwitterAccount {
	
	private String userName;
	private ArrayList<TwitterAccount> follows = new ArrayList<TwitterAccount>();
	private int tweetCount;
	private int retweetCount;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

//	TwitterAccount(String) - som tar inn brukernavnet
	public TwitterAccount(String bruker){
		this.userName = bruker;
	}
	
//	String getUserName() - returnerer brukernavnet
	public String getUserName(){
		return this.userName;
	}
	
//	int getTweetCount() - returner antall tweets til kontoen
	public int getTweetCount(){
		return this.tweetCount;
	}
	
//	int getRetweetCount() - returner antall retweets av tweets fra denne kontoen
	public int getRetweetCount(){
		return this.retweetCount;
	}
	
//	void follow(TwitterAccount account) - denne (this) kontoen starter å følge account
	public void follow(TwitterAccount account){
		if(this == account){
			throw new IllegalStateException("Du kan ikke følge deg selv!");
		}
		if(!this.follows.contains(account)){
			this.follows.add(account);
		}
	}
	
//	void unfollow(TwitterAccount account) - slutt å følge account
	public void unfollow(TwitterAccount account){
		if(this.follows.contains(account)){
			this.follows.remove(account);
		}
	}
	
//	boolean isFollowing(TwitterAccount account) - returnerer om denne kontoen følger account
	public boolean isFollowing(TwitterAccount account){
		return this.follows.contains(account);
	}
	
	
//	boolean isFollowedBy(TwitterAccount account) - returnerer om account følger denne kontoen
	public boolean isFollowedBy(TwitterAccount account){
		return account.follows.contains(this);
	}
	
//	void tweet(String) - lager en ny tweet for denne kontoen
	public void tweet(String tekst){
		Tweet nyTweet = new Tweet(this, tekst);
		this.tweetCount ++;
		this.tweets.add(0, nyTweet);
	}
	
//	void retweet(Tweet tweet) - retweeter tweet fra denne kontoen
	public void retweet(Tweet tweet){
		Tweet nyTweet = new Tweet(this, tweet);
		nyTweet.getOriginalTweet().getOwner().incrementRetweetCount();
		this.tweets.add(0, nyTweet);
		this.tweetCount ++;
	}
	
//	Tweet getTweet(int i) - returner tweet nummer i, der 1 er den nyeste, 2 den nest nyeste, … (merk rekkefølgen!)
	public Tweet getTweet(int i){
		return this.tweets.get(i-1);
	}
	public void incrementRetweetCount(){
		retweetCount ++;
	}
}
