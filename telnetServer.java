/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cos332.Prac2;

/**
 *
 * @author Robert Trankle
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class telnetServer {
    public static void main(String[] args) throws IOException {
        
        final int portNumber = 5555;
        System.out.println("Creating server socket on port  : " + portNumber);
        ServerSocket sSocket = new ServerSocket(portNumber);
        
        while(true)
        {
            Socket socket = sSocket.accept();
            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(out,true);
            pw.println("You are now connected on port : " + portNumber);
            
            
            String str = "hsdfbjdsf";
            
            while(str.compareTo("close") != 0)
            {
                BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                str = buf.readLine();
                System.out.println(str);
            }
            
            pw.close();
            socket.close();
            break;
        }
               
    }
}
