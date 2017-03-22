class UserRequest
{
	 public boolean viewLocation = false;
	 public String location = "--";
	 public String MacAddress = "";

	 public UserRequest(String ma)
	 {
		MacAddress = ma;
	 }

	 public void setLocation(String loc)
	 {	
		location = loc;
	 }

	 public String getLocation()
	 {
		return location;
	 }
}
