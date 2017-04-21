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
import java.net.URL;
import javax.xml.ws.Response;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author ORATILE
 */
public class ClientLoginWeb {
        
      private String username;
      private String password;
      private WebClient webClient = null;
      private WebRequest request  = null;
      public WebResponse json_data_location = null;
      private HtmlTextInput usernameAruba;
      private HtmlPasswordInput passwordAruba;
      private final URL strURL;
      
      public ClientLoginWeb(URL link) throws Exception{
          
          webClient = new WebClient();
          webClient.getOptions().setUseInsecureSSL(true);
          username = "admin";
          password = "Admin123!";
          strURL = new URL("https://137.215.6.208/api/v1/location?sta_eth_mac=9C:5C:F9:3F:CD:8B");
      }
      
      public void arubaLogin() throws Exception{
          
          HtmlPage arubaLoginPage = webClient.getPage("https://137.215.6.208");
          HtmlForm arubaLoginForm = arubaLoginPage.getHtmlElementById("login-form");
          
          HtmlSubmitInput btnLogin = arubaLoginForm.getInputByValue("Log In");
          usernameAruba = arubaLoginForm.getInputByName("j_username");
          passwordAruba = arubaLoginForm.getInputByName("j_password");
          
          usernameAruba.setValueAttribute(username);
          passwordAruba.setValueAttribute(password);
          
          HtmlPage homePage = btnLogin.click();
      }
      
      public void setRequest() {
          
         request = new WebRequest(strURL);
      }
      
      public void setResponse() throws Exception{
          
           json_data_location = webClient.loadWebResponse(request);
          
      }
      
      public void closeWebClient() {
          
          webClient.close();
      }      
}
