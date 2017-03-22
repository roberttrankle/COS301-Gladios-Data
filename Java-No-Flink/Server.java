/**
* <h1>Server</h1>
* The Server class simply handles requests from the DataStream class.
*
* @author  Dedrè Olwage
* @version 1.0
* @since   3/22/2017
*/
public class Server
{
	private String  userMac;
	
	public Server()
	{
		userMac = new MacAddress().getMacAddress();
	}
	
	/**
	 *This method will request the users location from the GeoLocation class.
	 *@param mac The user's Mac Address that will be sent to the GeoLocation class (for future implementaion purposes.)
	 *@return String A string containing the user's location in x-y-z coordinates.
	 */
	public String getLocation(String mac)
	{
			GeoLocation location = new GeoLocation(mac);

			String coordinates = location.getGeoLocation();

			return coordinates;
	}

}
