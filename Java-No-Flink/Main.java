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
 import java.util.Random;
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
		Random random = new Random();
       //Display the window. 
       frame.setLocation(random.nextInt(1000), random.nextInt(1000)); 
       frame.pack();
       frame.setVisible(true); 
	   return textLabel;
    }



	public static void main(String[] args) {
	
		


		DataStream datastream = new DataStream();
		
		

		User user1 = new User(datastream);
		JLabel w1 = createWindow("",user1.user.MacAddress);
		User user2 = new User(datastream);
		JLabel w2 = createWindow("",user2.user.MacAddress);
		User user3 = new User(datastream);
		JLabel w3 = createWindow("",user3.user.MacAddress);
		User user4 = new User(datastream);
		JLabel w4 = createWindow("",user4.user.MacAddress);
		User user5 = new User(datastream);
		JLabel w5 = createWindow("",user5.user.MacAddress);
		User user6 = new User(datastream);
		JLabel w6 = createWindow("",user6.user.MacAddress);

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

/*//1. Create the frame.
		JFrame frame = new JFrame("Get Location");

		//2. Optional: What happens when the frame closes?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//3. Create components and put them in the frame.
		//...create emptyLabel...
		frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

		//4. Size the frame.
		frame.pack();

		//5. Show it.
		frame.setVisible(true);*/
