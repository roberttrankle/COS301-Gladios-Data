public interface DataInterface{

	public GeoLocation getLocation( String macAddress ){

		GeoLocation geo = new GeoLocation( macAddress );
		if( geo.getLat() == null || geo.getLon() == null || geo.getfloor() == null )
			return null ;
		return geo ;
	}
}