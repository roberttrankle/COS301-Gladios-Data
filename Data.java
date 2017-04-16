package cos301;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.core.fs.FileSystem.WriteMode;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.sling.commons.json.JSONObject;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rob,dedre
 */
public class Data {
    public static void main(String[] args) throws Exception //doesn't this need to be the condtructor for Data in stead of a main? -- check **
    {
        //the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //paramters are the hostname and port
        DataStream<String> text = env.socketTextStream("localhost", 443);
        //transform the data of a JSON object to a string, becuase I assumed thats what we had to do.
        //Even though we have no JSON object to actually test, so I created a fake one.
        text.map(new Mapper()).writeAsText("C:/Users/rob/Documents/NetBeansProjects/COS301/test.txt");
	
        //Not sure where to place connection, just placed it below for now
        //Used URLConnection from java, instead of flink to connect
        connect("some MAC Address");
        env.execute("Geo-Location Stream");

	//get the location string from the above textfile and return a location object
	//not sure where to place return, assuming after the connect

	return getLocation("test.txt"); // ** - cannot return something from main?
    }

    private static class Mapper implements MapFunction<String, String> 
    {
        
        @Override
        public String map(String value) throws Exception 
        {
            String str = "";
            try
               {
                   JSONObject obj = new JSONObject("{\n" +
                    "  \"Location\": {\n" +
                    "    \"Latitude\" : \"value\",\n" +
                    "    \"Longitude\": \"value\",\n" +
                    "    \"Altitude\" :  \"value\"\n" +
                    "  }\n" +
                    "}");
                    str = obj.toString();

               }
               catch(Exception e)
               {
                    System.out.println("Error");
               }
               return str;
         }
    }
    
    private static void connect(String macAddress)
    {
        try 
        {
            //The URL is the URL of the ALE server, and someMacAdress should be placed there
            URL ALE = new URL("https://137.215.6.208:443/api/v1/location?sta_eth_mac=" + macAddress);
            HttpURLConnection con = (HttpURLConnection) ALE.openConnection();
            //Setting method of HTTP
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
        } 
        catch (MalformedURLException ex) 
        {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      //Read the test.txt file for the line containing the location details, and use those details to create and return
      //a location object.
      //TO DO - format the data to read into variables that can be used to create a location object
      //Note: not tested yet
   private GeoLocation getLocation(String fileName)
   {
	    BufferedReader br = new BufferedReader(
        new InputStreamReader(new FileInputStream(fileName)));
	    try {
   		    String line;
		    String latitude,longitude,altitude;

  	        while ((line = br.readLine()) != null) {
       		 // TO DO - process line - to extract longitude value etc and store it in variable..- Greg?
   	         }
	    } finally {
  	          br.close();
	    }

	    GeoLocation loc = new Location(latitude,longitude,altitude);
	    return loc;
   }
}
