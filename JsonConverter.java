import org.json.JSONArray;
/************************
@author: Kenneth Mangwane
@last edited: 20 April 2017
**************************/
public class JsonConverter
{
	String longitude;
	String latitude;

	public void converter(String jsonStr)
	{

		JSONArray array = new JSONArray(jsonStr); 

		for(int i=0; i<array.length(); i++){
		    JSONObject jsonObj  = array.getJSONObject(i);
		   	longitude=jsonObj.getString("longitude");
		   	latitude=jsonObj.getString("latitude");
		}
	}

	public String getLongitude()
	{
		return longitude;
	}

	public String getLatitude()
	{
		return latitude;
	}
}