package Supermarket;


public class Products extends Category {
//	private long categoryID=System.currentTimeMillis();
	private long productID=System.currentTimeMillis();   //can be accessed only within this class,random id is generated as product id.
	public String prodName;   
	private double prodPrice;
	
	public Products(long categoryID,String prodName,double prodPrice) {
		super.categoryID=categoryID;      //use of super keyword
		this.prodName=prodName;
		this.prodPrice=prodPrice;
	}
	
	public Products() {                      //default constructor
		
	}
	public long getcategoryID() {
		return super.categoryID;     // here, this method in products class overrides method in category class (method overriding)
	}
	public long getproductID() {
		return productID;
	}
	public String getprodName() {
		return prodName;
	}
	public double getprodPrice() {
		return prodPrice;
	}
	public void setcategoryID(long categoryID) {      
		this.categoryID=categoryID;
	}
	public void setproductID(long productID) {
		this.productID=productID;
	}
	public void setprodName(String prodName) {
		this.prodName=prodName;
	}
	public void setprodPrice(double prodPrice) {
		this.prodPrice=prodPrice;
	}

}
