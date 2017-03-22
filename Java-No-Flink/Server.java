public class Server
{
	private String  userMac;

	public Server()
	{

	}

	public String getLocation(String mac)
	{
			GeoLocation location = new GeoLocation(mac);

			String coordinates = location.getGeoLocation();

			return coordinates;
	}

}
