/**
* <h1>Main</h1>
* The Main class creates a simulation of users requesting their locations.
*For now, only 6 users will be "requesting", but this number wil grow infinitely
*once the final system is implemented.
*Java Frames will be created for each user. Each frame will have a title
*containing the user Mac Address, and a label on the frame containing the user 
*location.
*
* @author  Dedrè Olwage
* @version 1.0
* @since   3/22/2017
*/

import java.awt.*;
 import javax.swing.*;

class Main
{	

	
	 /**
	 *This method will create a new frame (window), with a label.
	 */
	 private static JLabel createWindow(String location,String mac) {
 
       //Create and set up the window. 
       JFrame frame = new JFrame(mac);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 JLabel textLabel = new JLabel("",SwingConstants.CENTER); 
      
       textLabel.setPreferredSize(new Dimension(300, 100)); 
       frame.getContentPane().add(textLabel, BorderLayout.CENTER); 
 
       //Display the window. 
       frame.setLocationRelativeTo(null); 
       frame.pack();
       frame.setVisible(true); 
	   return textLabel;
    }



	public static void main(String[] args) {
	
		


		DataStream datastream = new DataStream();
		
		

		User user1 = new User("01:E2:A3:14:C8:29",datastream);
		JLabel w1 = createWindow("",user1.user.MacAddress);
		User user2 = new User("02:E3:A4:15:C9:30",datastream);
		JLabel w2 = createWindow("",user1.user.MacAddress);
		User user3 = new User("03:E4:A5:16:C1:31",datastream);
		JLabel w3 = createWindow("",user1.user.MacAddress);
		User user4 = new User("04:E5:A6:17:C2:32",datastream);
		JLabel w4 = createWindow("",user1.user.MacAddress);
		User user5 = new User("05:E6:A7:18:C3:33",datastream);
		JLabel w5 = createWindow("",user1.user.MacAddress);
		User user6 = new User("06:E7:A8:19:C4:34",datastream);
		JLabel w6 = createWindow("",user1.user.MacAddress);

		while(true)
		{
			datastream.check();
			w1.setText(user1.user.location);
			w2.setText(user2.user.location);
			w3.setText(user3.user.location);
			w4.setText(user4.user.location);
			w5.setText(user5.user.location);
			w6.setText(user6.user.location);
		
		}
}
}
