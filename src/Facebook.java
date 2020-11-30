/**
 * This class is Facebook class inherited from socialMediaposts class.
 * @author Yuhang Zhao, student number: 150467199
 *
 */

/**
 * This enum Destinations define a fixed, unmodifiable objects of destination, destination1("page"), destination2("group"), 
 * destination3("personalnewsfeed"), destination4("friend'spage")
 * 
 *
 */
enum Destinations {
		//constant object declaration
		destination1("page"), destination2("group"), destination3("personalnewsfeed"), destination4("friend'spage");
		
		private final String destination;
		Destinations( String s){ destination = s;}
		public String getDestiantions() {return destination;}
	}

public class Facebook extends socialMediaposts {
	private int numLike;
	private int numCelebrate;
	private int numFrown;
	private String adestination;
	
	public Facebook(int id, String userName, String message, String adestination)
	{
		super(id, userName, message);
		this.numLike = 0;
		this.numCelebrate = 0;
		this.numFrown = 0;
		this.numberOfposts = 1;
		
		if ((adestination.equals(Destinations.destination1.getDestiantions())) || (adestination.equals(Destinations.destination2.getDestiantions()))|| (adestination.equals(Destinations.destination3.getDestiantions()))|| (adestination.equals(Destinations.destination4.getDestiantions())))
		{
			this.adestination = adestination;
		}else {throw new IllegalArgumentException("Destination must be one of that four parts");}
	}
	
	/**
	 * get methods for getting the private instance variables 
	 * @return
	 */
	public int getNumlike() {return this.numLike;}
	public int getNumcelebrate() {return this.numCelebrate;}
	public int getNumfrown() {return this.numFrown;}
	public String getDestination() {return this.adestination;}
	
	/**
	 * register some actions, like Like, Celebrate and Frown
	 */
	public void setLike() {this.numLike++;}
	public void setCelebrate() {this.numCelebrate++;}
	public void setFrown() {this.numFrown++;}
	
	/**
	 * in case the user wants to change the facebook post destination 
	 * @param adestination
	 */
	public void changeDestination(String adestination) 
	{
		if ((adestination == Destinations.destination1.getDestiantions()) || (adestination == Destinations.destination2.getDestiantions()) || (adestination == Destinations.destination2.getDestiantions()) || (adestination == Destinations.destination2.getDestiantions()))
		{
			this.adestination = adestination;
		}else {throw new IllegalArgumentException("Destination must be one of that four parts");}
	}

}
