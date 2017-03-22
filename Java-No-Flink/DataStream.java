import java.util.*;


class DataStream extends Thread
{
	private Queue<UserRequest> users = new LinkedList<>();
	private Server server = new Server();

	public DataStream()
	{

	}



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

	
	public void addUser(UserRequest user)
	{
		users.add(user);
		//check();


	}

	public void removeUser()
	{
		users.remove();
	}

	
		
}
