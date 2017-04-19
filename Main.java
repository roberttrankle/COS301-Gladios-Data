/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cos301;

import cos301.ClientLoginWeb;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import javax.xml.ws.Response;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.log4j.BasicConfigurator;
import org.apache.sling.commons.json.JSONObject;

/**
 *
 * @author ORATILE
 */
public class Main {
    
    public static void main(String[] args) throws Exception{//the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment().setParallelism(1);
        //paramters are the hostname and port
        //env.socketTextStream("localhost", 5555);
        DataStream<String> text = env.socketTextStream("localhost", 5555);
        //transform the data of a JSON object to a string, becuase I assumed thats what we had to do.
        //Even though we have no JSON object to actually test, so I created a fake one.
        text.map(new Mapper()).writeAsText("C:\\Users\\rob\\Documents\\NetBeansProjects\\COS301/test.txt");
        //Not sure where to place connection, just placed it below for now
        //Used URLConnection from java, instead of flink to connect
        //connect("some MAC Address");
        env.execute("Geo-Location Stream");
    }

    private static class Mapper implements MapFunction<String, String> 
    {
        
        @Override
        public String map(String value) throws Exception 
        {
            String str = "";
            String loc = "";
            try
               {
                   BasicConfigurator.configure();
                    //String URL_link = URL.getUrlLink();
                    //URL url = new URL(URL_link);

                    ClientLoginWeb clientLogin = new ClientLoginWeb();
                    clientLogin.arubaLogin();
                    clientLogin.setRequest();
                    clientLogin.setResponse();

                    System.out.println("===========================Location===========================");
                    System.out.println(clientLogin.json_data_location.getContentAsString());
                    System.out.println("===========================Location===========================");
                    str = clientLogin.json_data_location.getContentAsString();
                    clientLogin.closeWebClient();
                    
                   
                   JSONObject obj = new JSONObject(str);
                   JSONObject sendObj = new JSONObject();
                   String latitude = obj.getString("sta_location_x");
                   String longitude = obj.getString("sta_location_y");
                   
                   loc = "{\n" +
                    "  \"Location\": {\n" +
                    "    \"Latitude\" : " + latitude + ",\n" +
                    "    \"Longitude\": " + longitude + "\n" +
                    "  }\n" +
                    "}";


               }
               catch(Exception e)
               {
                    System.out.println("Error");
               }
               return loc;
         }
    }
}
 
