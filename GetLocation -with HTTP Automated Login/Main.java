/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientloginweb;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.*;
import javax.xml.ws.Response;
import java.net.URL;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author ORATILE
 */
public class Main {
    
    public static void main(String[] args) throws Exception{
        
        BasicConfigurator.configure();
        String URL_link = URL.getUrlLink();
        URL url = new URL(URL_link);
        
        ClientLoginWeb clientLogin = new ClientLoginWeb(url);
        clientLogin.arubaLogin();
        clientLogin.setRequest();
        clientLogin.setResponse();
        
        System.out.println("===========================Location===========================");
        System.out.println(clientLogin.json_data_location.getContentAsString());
        System.out.println("===========================Location===========================");
        
        clientLogin.closeWebClient();
    }
}
