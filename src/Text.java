/**
 * This class is Text class inherited from socialMediaposts class.
 * @author Yuhang, student number: 150467199
 *
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This enum Destinations define a fixed, unmodifiable objects of emojis, like happy(":)"), sad(":("), regular("--"), annoy("><");
 *
 */
enum Emojis {
	//constant object declaration
	happy(":)"), sad(":("), regular("--"), annoy("><");

	private final String emojis;
	Emojis( String s){ emojis = s;}
	public String getEmojis() {return emojis;}
}

public class Text extends socialMediaposts {
	private static Pattern pattern = Pattern.compile("^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$");//The static pattern for the username of this Text class
	private int numOfemojis;
	public int getnumOfemojis() {return this.numOfemojis; }
	
	public Text(int id, String userName, String message)
	{
		
		super(id, userName, message);
		super.setStatus(2);
		Matcher matcher = pattern.matcher(this.getUserName());
		if(!matcher.matches()){throw new IllegalArgumentException("The username format is invalid!");}//check if the username follow the valdd format 
		this.numOfemojis = 0;
	}
	
	/**
	 * set the emojis
	 * @param e
	 */
	public void setEmojis(Emojis e)
	{	
		if(e instanceof Emojis) {
		this.numOfemojis++;
		if(this.numOfemojis > 4){throw new IllegalArgumentException("The number of emojis exceeds 4!");}
		}else {throw new IllegalArgumentException("The entered string is not an emojis!");}
	}
	
	/**
	 * change the status
	 */
	public void setStatus(int setStatus)
	{
		if(setStatus == 1) {throw new IllegalArgumentException("The status of text cannot change ");}
	}

}
