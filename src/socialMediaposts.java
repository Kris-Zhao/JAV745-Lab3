/**
 * This abstract socialMediaposts class is the superclass for Twittertweet, Facebook and Text subclasses, including id, creationDate, 
 * userName, message, status instance variables and some get/set methods to track these posts.
 * 
 *  @author Yuhang Zhao, student number: 150467199
 */

import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class socialMediaposts {
	/**
	 * instance variables are the posts' attributes, like id, creationDate, userName, message, status, numberOfpsots
	 * 
	 */
	private int id;
	private String creationDate;
	private String userName;
	private String message;
	private int status;//1:draft 2:published
	protected int numberOfposts;
	
	/**
	 * The constructor
	 * @param id
	 * @param userName
	 * @param message
	 */
	public socialMediaposts(int id, String userName, String message)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		this.id = id;
		this.creationDate = formatter.format(date);
		this.userName = userName;
		this.message = message;
		this.status = 1;
		this.numberOfposts = 0;
	}
	
	/**
	 * Some get methods to get these private instance variables
	 * @return
	 */
	public int getId() {return id;};
	public String getCreationDate() {return creationDate;};
	public String getUserName() {return userName;};
	public String getMessage() {return message;};
	public int getStatus() {return status;};
	public int getNumberOfposts() {return numberOfposts;};
	
	/**
	 * This method is for changing the message
	 * @param setMessage
	 */
	public void setMessage(String setMessage)
	{
		if(this.status == 1) {
			this.message = setMessage;
		}else{System.out.println("it's already in published state, cannnot change the message");}
	}
	
	/**
	 * This method is to change the status.
	 * @param setStatus
	 */
	public void setStatus(int setStatus) {
		if(setStatus==2) {this.numberOfposts = 1;}
		if(setStatus==1) {this.numberOfposts = 0;}
		this.status = setStatus;
	}
	
}
