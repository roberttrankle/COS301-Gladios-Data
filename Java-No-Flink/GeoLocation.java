/**
* <h1>GeoLocation</h1>
* The GeoLocation will calculate the location of the user, and send it back.
*
* @author  Dedrè Olwage
* @version 1.0
* @since   3/22/2017
*/
import java.util.Random;
import java.text.DecimalFormat;
public class GeoLocation {

    private double lat;

    private double lon;

	private double floor;

	private String macAddress[]; //to store mac addresses eg: "00:A0:C9:14:C8:29","01:E2:A3:14:C8:29";
	private String directions[] = {"N","W","S","E","NE","SE","NW","SW"};


	/**
	 *A constructor method setting member values.
	 *@param mac The user's Mac Address that will be sent to the GeoLocation class (for future implementaion purposes.)
	 */
    public GeoLocation(String mac){
	 Random random= new Random();
		lat = Math.toRadians(Math.random() * 360);
		lon = Math.toRadians(Math.random() * 360);
		floor = random.nextInt(10);

    }

	/**
	 *This constructor method set the longitude and latitude.
	 *@param lat The latitude wil be set to this value.
	 *@param lon The longitude wil be set to this value.
	 */
    public GeoLocation(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

	/**
	 *This method will set the latitude.
	 *@param lat The latitude wil be set to this value.
	 *
	 */
    public void setLat(double lat) {
        this.lat = lat;
    }

	/**
	 *This method will set the longitude.
	 *@param lon The longitude wil be set to this value.
	 *
	 */
    public void setLon(double lon) {
        this.lon = lon;
    }

	/**
	 *This method will set the floor number.
	 *@param floor The floor wil be set to this value.
	 *
	 */
	 public void setFloor(double floor) {
        this.floor = floor;
    }


	/**
	 *This method will return the latitude.
	 *@return Double The latitude wil be set to this value.
	 *
	 */
    public double getLat() {
        return lat;
    }

	/**
	 *This method will return the longitude.
	 *@return Double The longitude wil be set to this value.
	 *
	 */
    public double getLon() {
        return lon;
    }

	/**
	 *This method will return the floor number.
	 *@return Double The floor number wil be set to this value.
	 *
	 */

	public double getFloor() {
        return floor;
    }

	/**
	 *This method will calculate the location of the user.
	 *@return Double The floor number wil be set to this value.
	 *
	 */
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
