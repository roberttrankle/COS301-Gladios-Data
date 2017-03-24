/**
* <h1>UserRequest</h1>
* The UserRequest class simply stores,sets and returns basic information about the user
*such as a Mac Address and a boolean value indicating whether the user wants to 
*get their current location or not.
*
* @author  Dedrè Olwage, Kenneth Mangwane
* @version 1.0
* @since   3/22/2017
*/

class UserRequest
{
	 public boolean viewLocation = false;
	 public String location = "--";
	 public String MacAddress = "";

	 /**
	 *This is the constructor method initializing the Mac Address of the user.
	 *@param ma This parameter contains the Mac address.
	 */
	public UserRequest(String ma)
	 {
		MacAddress = ma;
	 }

	 /**
	 *This method will set the location of the user.
	 *@param loc This parameter contains the location of the user,
	 *returned from the GeoLocation class throught the Server class and DataStream class.
	 */
	 public void setLocation(String loc)
	 {	
		location = loc;
	 }

	 /**
	 *This method will return the location of the user.
	 *@return String The location of the user is returned.
	 */
	 public String getLocation()
	 {
		return location;
	 }
}
