package Supermarket; //package Supermarket

public class Customers extends packcust.cust{
/*	private String Name;
	private long Phone;
	private String Address;*/
	
	public Customers (String Name,long Phone,String Address) {
		this.Name=Name;
		this.Phone=Phone;
		this.Address=Address;	
	}
	
	public Customers() {
		
	}
	
	public String getName() {                         //getters and setters
		return Name;
	}
	
	public void setName(String Name) {
		this.Name=Name;
	}
	
	public long getPhone() {
		return Phone;
	}
	
	public void setPhone(long Phone) {
		this.Phone=Phone;
	}
	
	public String getAddress(){
		return Address;
	}
	
	public void setAddress(String Address) {
		this.Address=Address;
	}
	

}
