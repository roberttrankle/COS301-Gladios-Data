/**
* <h1>UserRequest</h1>
* The UserRequest class simply stores,sets and returns basic information about the user
*such as a Mac Address and a boolean value indicating whether the user wants to 
*get their current location or not.
*
* @author  Tlou Lebelo, Kenneth Mangwane
* @version 1.0
* @since   3/23/2017
*/

public class DataInterface{

	public GeoLocation getLocation( String macAddress ){

		
		GeoLocation geo = new GeoLocation( macAddress );
		if( geo.getLat() == 0 || geo.getLon() == 0 || geo.getFloor() == 0 )
			return null ;
		return geo ;
	}
}
