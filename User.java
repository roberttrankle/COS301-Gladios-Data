//Demo function for User 

public class User{

	public static DataStream dataStream = new DataStream();

	public class myLocation implements Runnable{
		private UserRequest data ;

		public void setUserRequest( UserRequest results){
			data = results ;
		}

		public void SendUserRequest(){
			dataStream.request( Thread.currentThread().getName() );
		}

		public UserRequest getUserRequest(){
			return dataStream.getRequest();		//Note... "DataStream" is use 
		}

		@Override
		public void run() {
			SendUserRequest() ;
			setUserRequest( getUserRequest() ) ;
			System.out.println( Thread.currentThread().getName() + "  is currently at  X: " + data.getLatitude() + "  Y: "+ data.getLongitude() ) ;
		}

	}

	

	public static void main(String args[]){
		//create multiple threads

		Thread thread[] = new Thread[50];
		
		for (int i = 0; i < 50 ; i++)	{
			thread[i] = new Thread( new myLocation() );
		}
		
		for (int i=0; i<50; i++)	{
			thread[i].start();
		}
	}

}