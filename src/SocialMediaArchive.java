/**
 * The SocialMediaArchive application class is to generate all types of posts. According to different
 * kinds of posts, there are different reactions the user can do.
 * @author Yuhang Zhao, student number: 150467199
 */
import java.util.Scanner;


public class SocialMediaArchive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * create a array storing all post types
		 */
		Scanner input1 = new Scanner(System.in);
		System.out.println("How many posts do you want to do?");
		int n = input1.nextInt();
		socialMediaposts[] array = new socialMediaposts[n];
		
		System.out.println("Post state: 1:draft, 2:published");
		
		/**
		 * Assign the value into the array and do some actions associated with every specific post type
		 */
		for(int i=0; i < array.length; i++ ) {
			Scanner input = new Scanner(System.in);
			System.out.println("What's your unique ID?");
			int ID = input.nextInt();
			
			System.out.println("What's your message that you want to enter?");
			String message = input.next();
			System.out.println("Which post type do you want to create?");
			String type = input.next();
			
			if( type.equals("twitter")) {
				System.out.println("What's your user name?");
				String username = input.next();
				array[i]= new Twittertweet(ID, username, message);

				if(array[i] instanceof Twittertweet) {
					Twittertweet b = (Twittertweet) array[i];
					System.out.printf("The initial state is %d.\n", b.getStatus());
					System.out.println("Do u want to set the default draft state to published state for this twitter post?");
					String choice = input.next();
					if(choice.equals("yes")) {b.setStatus(2);}
					System.out.println("If u want to revert to draft, there would be an error.");
					System.out.printf("The current state is %d.\n", b.getStatus());
					//b.setStatus(1);//if u want to revert to draft, there would be an error.
					System.out.printf("The initial number of retweet is %d\n", b.getNumOfRetweet());
					System.out.println("How many retweets do you want?");
					int c = input.nextInt();
					for(int j =0; j < c; j++) {b.retweets();}
					System.out.printf("After retweets, the number of retweet is %d\n", b.getNumOfRetweet());
					System.out.printf("Print out the twitter post message: %s\n\n",b.getMessage());
				}
			}
			else if (type.equals("text") ) {
				System.out.println("What's your user name?");
				String username = input.next();
				
				array[i] = new Text(ID, username, message);
				if(array[i] instanceof Text) {
					Text b = (Text) array[i];
					System.out.println("The state is always published.");
					System.out.println("If you want to set draft state, you will get error");
					System.out.println("How many emojis do you want for this test post?");
					int c = input.nextInt();
					for(int a=0; a<c ;a++) {b.setEmojis(Emojis.happy);}// or can use Emojis.sad or Emojis.regular or Emojis.annoy
					System.out.printf("Print out the text post message: %s\n\n",b.getMessage());
					
				}
			}
			else if (type.equals("facebook")) {
				System.out.println("What's your user name?");
				String username = input.next();
				System.out.println("What's your destination for this facebook post?");
				String destination = input.next();
				
				array[i] = new Facebook(ID, username, message, destination);
				if(array[i] instanceof Facebook) {
					Facebook b = (Facebook) array[i];
					
					System.out.printf("The initial state is %d.\n", b.getStatus());
					System.out.println("Do u want to set the default draft state to published state?");
					String choice = input.next();
					if(choice.equals("yes")) {b.setStatus(2);}
					System.out.printf("The current state is %d.\n", b.getStatus());
					System.out.println("Do u want to revert to draft state?");
					String choice_ = input.next();
					if(choice_.equals("yes")) {b.setStatus(1);}
					
					System.out.printf("The current state is %d.\n", b.getStatus());
					System.out.println("How many times do u want to like, celebrate and frown for this facebook post?");
					int q = input.nextInt();
					int w = input.nextInt();
					int e = input.nextInt();
					for (int p=0; p<q;p++) {b.setLike();}
					for (int l=0; l<w;l++) {b.setCelebrate();}
					for (int m=0; m<e;m++) {b.setFrown();}
					System.out.printf("The number of Likes: %d, the number of Celebrates: %d, the number of Frowns: %d\n", b.getNumlike(), b.getNumcelebrate(), b.getNumfrown());
					System.out.printf("Print out the facebook post message: %s\n\n",b.getMessage());
				}
			}
		}
		
		int sum = 0;
		for(int z= 0; z<array.length;z++)
		{
			sum= sum+ array[z].getNumberOfposts();
		}
		System.out.printf("The number of currently published posts is %d.", sum);
		
	}

}
