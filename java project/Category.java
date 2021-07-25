package Supermarket;

public class Category {

	        protected long categoryID = System.currentTimeMillis(); /*returns the current time in milliseconds,it gives the random ID  
	        for category Id. Access modifier here is protected and can be accessed only within same class and child class*/
			public String catName;
			
			public Category(long categoryID, String catName)
			{                                                              //Parameterized constructor
				                                        
				this.catName = catName;                           //Use of this keyword  
				this.categoryID = categoryID;
			}
			
			public Category(String Name) {   //this is the example for constructor overloading
				this.catName = Name;
			}
			
			public Category() {
				                               //Default constructor
			}
			
			public long getcategoryID() {                   //getters and setters
				return categoryID;
			}
			
			public String getcatName() {
				return catName;
			}
			
			public void setcategoryID(long categoryID) {
				this.categoryID = categoryID;
			}
			
			public void setcatName(String Name) {
				this.catName = Name;
			}		

}

