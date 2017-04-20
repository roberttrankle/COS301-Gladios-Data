
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.io.*;
/**
 *
 * @author oratile
 */
public class MacAddress {
    
      byte[] macAddr;
  InetAddress ipAddr;
  StringBuilder strB = new StringBuilder();

  public String getMacAddress() {

    try {
        FileWriter fw = null;
        BufferedWriter bw = null;
        //get the address of the local host
        ipAddr = InetAddress.getLocalHost();

        //identify local interface
        NetworkInterface ntwrk = NetworkInterface.getByInetAddress(ipAddr);

        macAddr = ntwrk.getHardwareAddress();
        for(int index = 0; index < macAddr.length; index++){
          strB.append(String.format("%02X%s", macAddr[index], (index < macAddr.length - 1) ? ":" : ""));
        }
        
        //save the device MAC Address to the text file
        try {
          fw = new FileWriter("macaddres.txt");
          bw = new BufferedWriter(fw);

          if(!strB.equals(null)) {
            bw.write(strB.toString());
          }
        }
        catch (IOException ex) {
          ex.printStackTrace();
        }
        finally {
          try {
            if(bw != null) {
              bw.close();
            }

            if(fw != null) {
              fw.close();
            }
          }
          catch(IOException ex) {
            ex.printStackTrace();
          }
        }
        
        //return the MAC Address
        return strB.toString();
    }
    catch(UnknownHostException ex) {
      ex.printStackTrace();
    }
    catch (SocketException ex) {
      ex.printStackTrace();
    }

    return null;
  }
}
