public class DataInterface{

	public GeoLocation getLocation( String macAddress ){

		
		GeoLocation geo = new GeoLocation( macAddress );
		if( geo.getLat() == 0 || geo.getLon() == 0 || geo.getFloor() == 0 )
			return null ;
		return geo ;
	}
}
