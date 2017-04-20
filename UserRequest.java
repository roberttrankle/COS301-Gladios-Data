
public class UserRequest
{
	boolean location;
	String mac;
	public UserRequest(boolean loc, String mc)
	{
		location=loc;
		mac=mc;
	}
	public String getMac()
	{
		return mac;
	}
}