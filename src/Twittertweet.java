/**
 * This class is Twittertweet class inheirted from socialMediaposts class, additionally recording the number of retweets
 * @author Yuhang Zhao, student number: 150467199
 *
 */
public class Twittertweet extends socialMediaposts {
	private int numberOfretweeted;
	
	/**
	 * constructor
	 * @param id
	 * @param userName
	 * @param message
	 */
	public Twittertweet(int id, String userName, String message)
	{
		super(id, userName, message);
		if(message.length() > 256) {
			throw new IllegalArgumentException("Message must be less than 256 characters");
		}
		this.numberOfretweeted = 0;
	}
	
	/**
	 * get methods for get some private instance variables 
	 * @return
	 */
	public int getNumOfRetweet() {return this.numberOfretweeted;};
	public void retweets() {this.numberOfretweeted++;}
	public int getNumberOfposts() {return numberOfposts;};
	
	/**
	 * this method is for changging the message and tell if the message's length exceeds 256 characters
	 */
	public void setMessage(String setMessage)
	{
		if(setMessage.length() <= 256) {
			super.setMessage(setMessage);
		}else {throw new IllegalArgumentException("Message must be less than 256 characters");};
	}
	
	/**
	 * according to the rule, set the status
	 */
	public void setStatus(int setStatus) 
	{
		if ((this.getStatus() == 2) && (setStatus == 1)) {
			throw new IllegalArgumentException("Once a tweet is published, you can't revert it back into a draft.");
		}
		super.setStatus(setStatus);
	}
	
}
