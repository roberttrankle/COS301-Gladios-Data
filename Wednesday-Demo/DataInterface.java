/**THIS CLASS USES THE FOLLOWING CLASSES :
-GeoLocation
-GIS
-GISInterface
*/

package cos301;
/**
 *
 * @author Gladios-Data module
 * @version beta
 */
public class DataInterface 
{
    private static DataInterface instance = null;
    //instance of GIS -> supposed to be GISInterface
    private GIS gis;

    /**
     * Default COnstructor for DataInterface
     */
    protected DataInterface()
    {
        
    }
    
    /**
     * Create a single instance of DataInterface class
     * @return instance of DataInterface
     */
    public static DataInterface getInstance()
    {
        if(instance == null)
        {
            instance = new DataInterface();
        }
        return instance;
    }

    /**
     * Get the current location of the user, based on its MAC address.
     * @return GeoLocation
     */
    public GeoLocation getCurrentLocation()
    {
        //supposed to have ALE which has the current location
        //but we do not so it is a mock location for IT 4-5
        GeoLocation returnCoordinates = new GeoLocation(-25.755617, 28.233556);
        return returnCoordinates;
    }
    
    /**
     *
     * @param location The location or POI, that the user wishes to navigate to.
     * @return GeoLocation
     */
    public GeoLocation getLocation(String location)
    {
       //get location from GIS-building/place
        //need GIS interface -> getCoordinates("IT-45");
        GeoLocation returnCoordinates = new GeoLocation();
        float[] coord = new float[2];
        coord = gis.getCoordinates("IT 4-5");
        returnCoordinates.setLon(coord[0]);
        returnCoordinates.setLat(coord[1]);
        return returnCoordinates;
    }

}
