/**
* <h1>DataStream</h1>
* The DataStream class will handle requests from the user by sending it through to the Server.
*
* @author  Dedrè Olwage
* @version 1.0
* @since   3/22/2017
*/
import java.util.*;


class DataStream extends Thread
{
	private Queue<UserRequest> users = new LinkedList<>();
	private Server server = new Server();

	/**
	 *This method will check the queue for pending requests and then serve them if there are.
	 *
	 */
	 public void check() {
        
		if(users.isEmpty())
			return;
		UserRequest temp = null;

				while(!this.users.isEmpty())
				{
						if(this.users.size() != 0)
							temp = this.users.remove(); //element at the head of the queue a.k.a first element to be processed

						if(temp != null)
							temp.location = server.getLocation(temp.MacAddress);
							System.out.println("User: " + temp.MacAddress + "\nLocation: " + temp.location + "\n");
				}
		
    }

	/**
	 *This method adds a UserRequest to the queue.
	 *@param user The UserRequest object to be added to the queue to wait to be served.
	 */
	public void addUser(UserRequest user)
	{
		users.add(user);
		//check();


	}


	
		
}
