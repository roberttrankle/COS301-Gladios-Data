package cos301;


import java.util.Random;
import java.text.DecimalFormat;
public class GeoLocation {

    private double lat;

    private double lon;

	private double floor;

	private String macAddress[]; //to store mac addresses eg: "00:A0:C9:14:C8:29","01:E2:A3:14:C8:29";
	private String directions[] = {"N","W","S","E","NE","SE","NW","SW"};

    public GeoLocation(String mac){
	 Random random= new Random();
		lat = Math.toRadians(Math.random() * 360);
		lon = Math.toRadians(Math.random() * 360);
		floor = random.nextInt(10);

    }

    public GeoLocation(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    GeoLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

	 public void setFloor(double floor) {
        this.floor = floor;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

	public double getFloor() {
        return floor;
    }

	public String getGeoLocation()
	{
		DecimalFormat df = new DecimalFormat("#.###");
		Random random = new Random();


		String loc = df.format(lon);
		loc += " " + directions[random.nextInt(7)];
		loc += " " + "\u00b0";
		loc += " " +  df.format(lat);
		loc += " " + directions[random.nextInt(7)];
		loc += " " + "\u00b0";
		loc += " " + df.format(floor);
		
		return loc;
	}
}