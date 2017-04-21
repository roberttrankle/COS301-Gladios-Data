import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.io.*;
/**
 *
 * @author Tlou
 */

 public class URL {

	private static String getMacAddress() {
		byte[] macAddr;
		InetAddress ipAddr;
		StringBuilder strB = new StringBuilder();
		try {
			//get the address of the local host
			ipAddr = InetAddress.getLocalHost();

			//identify local interface
			NetworkInterface ntwrk = NetworkInterface.getByInetAddress(ipAddr);

			macAddr = ntwrk.getHardwareAddress();
			for(int index = 0; index < macAddr.length; index++){
			  strB.append(String.format("%02X%s", macAddr[index], (index < macAddr.length - 1) ? ":" : ""));
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

	public static String getUrlLink( String mac ){
		String url = "https://137.215.6.208/api/v1/location?sta_eth_mac=" ;
		url += mac ;
		//System.out.println( url );
		return url ;
	}

	public static String getUrlLink(){
		
		String url = "https://137.215.6.208/api/v1/location?sta_eth_mac=" ;
		url += getMacAddress();
		//System.out.println( url );
		return url ;
	}
}