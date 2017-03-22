
import java.util.Random;



public class User extends Thread
{
	public UserRequest user = null;
	DataStream Manager = null;

	public User(String mac,DataStream manager)
	{
		user = new UserRequest(mac);
		Manager = manager;
		start();
	}

	 public void run() {

		Random random = new Random();
		boolean val = random.nextBoolean();
		int counter = 0;

		while(counter < 10) //check if the user wants to get location (10 times, in real world it would run infinitely)
		{
		//System.out.println("here");
			user.viewLocation = val;

			if(val == true)// true
				requestLocation();

			val = random.nextBoolean();
			counter++;
		}
	 }

	public void requestLocation()
	{
		Manager.addUser(user);
		
	}
}
