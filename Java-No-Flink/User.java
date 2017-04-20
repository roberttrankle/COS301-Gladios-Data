/**
* <h1>User</h1>
* The User class simply requests the location from the DataStream.
*
* @author  Dedrè Olwage
* @version 1.0
* @since   3/22/2017
*/
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class User extends Thread
{
	public UserRequest user = null;
	DataStream Manager = null;


	/**
	 *This is the constructor method initializing the Mac Address of the user.
	 *@param mac This parameter contains the Mac address.
	 */
	public User(DataStream manager)
	{
		String mac = new MacAddress().getMacAddress();
		System.out.println("Mac" + " " + mac);
		user = new UserRequest(mac);
		Manager = manager;
		start();
	}

	/**
	 *This method continuosly request the user's location.'
	 *Random boolean values are chosen to determine whether the\
	 *user wants to request the location or not.
	 *In the real implementation, the user might
	 *request their location unlimitedly.
	 */
	 public void run() {

		Random random = new Random();
		boolean val = random.nextBoolean();
		int counter = 0;

		while(counter < 1000) //check if the user wants to get location (10 times, in real world it would run infinitely)
		{
		//System.out.println("here");
			user.viewLocation = val;

			if(val == true)// true
				requestLocation();

			val = random.nextBoolean();
			counter++;
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	 }

	 /**
	 *This method will set request the user's current location.
	 *The user adds itsel to a queue, and waits until the
	 *DataStream can handle its request.
	 */
	public void requestLocation()
	{
		Manager.addUser(user);
		
	}
}
