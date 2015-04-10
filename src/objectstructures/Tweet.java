package objectstructures;

public class Tweet {

	private TwitterAccount forfatter;
	private String tekst;
	private Tweet original = null;
	private int retweetCount = 0;
	
//	Tweet(TwitterAccount, String) - En ny original-tweet
	public Tweet(TwitterAccount twittrer, String tekst){
		this.forfatter = twittrer;
		this.tekst = tekst;
	}
	
//	Tweet(TwitterAccount, Tweet) - En retweet av Tweet-argumentet. Utløser et passende unntak, hvis en original-tweeten er fra samme konto.
	public Tweet(TwitterAccount twittrer, Tweet original){
		if(original.getOwner() == twittrer){
			throw new IllegalStateException("Du kan ikke retweete deg selv!");
		}
		this.forfatter = twittrer;
		this.tekst = original.getText();
		this.original = original;
		if(original.getOriginalTweet() != null){
			this.original = original.getOriginalTweet();			
		}			
		original.incrementRetweetCounter();
	}
	
//	String getText() - returnerer teksten til en tweet
	public String getText(){
		return this.tekst;
	}
	
//	TwitterAccount getOwner() - returnerer kontoen som tweeten kom fra
	public TwitterAccount getOwner(){
		return this.forfatter;
	}
	
//	Tweet getOriginalTweet() - returnerer original-tweeten, hvis den er en retweet, ellers null
	public Tweet getOriginalTweet(){
		return this.original;
	}
	
//	int getRetweetCount() - returnerer antall ganger denne tweeten har blitt retweetet
	public int getRetweetCount(){
		return this.retweetCount;
	}
	private void incrementRetweetCounter(){
		this.retweetCount ++;
	}
}