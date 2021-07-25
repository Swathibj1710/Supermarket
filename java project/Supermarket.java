package Supermarket;
import java.io.IOException;
import java.util.*;

public class Supermarket implements inter {
	protected Scanner input=new Scanner(System.in); 
	protected Repository repo=Repository.getRepository();            
	catbyid CatnamebyId = new catbyid();           
	
	public Supermarket() {
		Sample();	
	}
	private int choice;   //can be accessed only within this class
	public String[] CategoryName = new String[30];        
	public String[] ProductName = new String[30];
	public String[] CustName = new String[30];
	
    public void displayMenu()
	{
		while(true) {
			printMenu();
			switch(choice)
			{
			case 1: addCategory();
			        pressAnykeytoContinue();
			        break;
			case 2: categoryList();
			        pressAnykeytoContinue();
			        break;
			case 3: addProduct();
			        pressAnykeytoContinue();
			        break;
			case 4: Productlist();
			        pressAnykeytoContinue();
			        break;
			case 5: Invoice();
		         	pressAnykeytoContinue();
			        break;
			case 6: CustomerDetails();
			        pressAnykeytoContinue();
			        break;
			case 7: Exit();
          			pressAnykeytoContinue();
          			break;
			}
		}
	}
	
	public void printMenu()
	{
		System.out.println("-------WELCOME-------");
		System.out.println("-------Menu-------");
		System.out.println("1.Add Category");     //to add category into list
		System.out.println("2.Category List");     //to display the list of category
		System.out.println("3.Add Product");        //to add product
		System.out.println("4.ProductList");        //it displays the product list
		System.out.println("5.Invoice");             //this prints the invoice
		System.out.println("6.Add customer details");         //to add the customer details
		System.out.println("7.Exit");                          //to exit from the system
		System.out.println("Enter your choice");
        choice=input.nextInt();
	}
	public void pressAnykeytoContinue()
	{
		System.out.println("Press any key to continue");
		try {
			System.in.read();                    //this is used to read the key entered from the menu
		    }
		catch(IOException e) {   
			e.printStackTrace();
		}		
	}

	public void addCategory()  {
		input.nextLine();
		System.out.println("Enter Category Name:");
		String catName = input.nextLine();
		Category cat = new Category(catName);
		repo.catList.add(cat);
		System.out.println("Category Added:"+catName);
	}
	
	public void categoryList() {
		System.out.println("Category List");
		List<Category> clist = repo.catList;     //Here category list can be obtained
		for(int i=0; i<clist.size(); i++) {      //each and every object of the category can be obtained
			Category c = clist.get(i);          
			System.out.println((i+1)+", "+c.getcatName()+ ", " + c.getcategoryID());
		}
	}
	
	public void addProduct() {
		System.out.println("Product availability");
		categoryList();
		System.out.println("Enter the category ");
		int catChoice=input.nextInt();
		Category selectedcat=repo.catList.get(catChoice -1);        //the category chose by the user is selected
		System.out.println("Category:" +selectedcat.getcatName());
		System.out.println("Enter Product Name:");
		String prodName = input.next();                 //the product name needed is selected by user
		double prodPrice;
		System.out.println("Enter Product Price:");
	    prodPrice=input.nextDouble();
		Products p = new Products();               
		p.setcategoryID(selectedcat.getcategoryID());
		p.getproductID();
		p.setprodName(prodName);
		p.setprodPrice(prodPrice);
		repo.prodList.add(p);
		System.out.println("Product added");		
	}
	
	public void Productlist() {
		System.out.println("Products list");
		List<Products>prodList=repo.prodList;
		//List<Category>catList=repo.catList;
		for(int i=0;i<prodList.size();i++) {
			Products prod=prodList.get(i);
	     	String catName = catbyid.getCategoryNameByID(prod.getcategoryID());
	    	System.out.println((i+1) +"," +catName +"," +prod.getproductID() +"," +prod.getprodName() +"," +prod.getprodPrice());
		}
	}
	
	public void CustomerDetails() {
		System.out.println("Enter Customer Details");
		System.out.println("Enter Customer Name : ");
		String Name=input.next();
		System.out.println("Enter Customer Address : ");
		String Address=input.next();
		System.out.println("Enter Customer Phone number : ");
		Long Phone=input.nextLong();
		
		Customers c=new Customers(Name,Phone,Address);
		c.setName(Name);
		c.setPhone(Phone);
		c.setAddress(Address);
		repo.custList.add(c);
		System.out.println("Details added");
	}
	
	public void Invoice() {
		int i=0,c=1;
	    double netTotal=0;
	    try {
		while(i!=1) {   //if it is 1 then it exits from the loop and prints the total price
			System.out.println("List the category");
			categoryList();
			System.out.println("Select the category");
			int choice=input.nextInt();       //here we select the category only to get category name
			Category cat=repo.catList.get(choice -1);
		    System.out.println("Category:"+cat.getcatName());
		    System.out.println("List the products");
		    Productlist();                   //all the products are listed
		    System.out.println("Select the product");
		    int pchoice=input.nextInt();
		    Products prod=repo.prodList.get(pchoice -1);    //the selected product is only given
		    System.out.println("Sl.No:"+ c +"Category:"+cat.getcatName() +"Product Name :"+prod.getprodName() +"Price :"+prod.getprodPrice());
            c++;
            netTotal=prod.getprodPrice()+netTotal;          //add the price of selected prod to the total
            System.out.println("Press 1 to exit or any other key to continue");
            i=input.nextInt();
		}
		
		System.out.println("NetTotal = "+ netTotal);
	}
	 catch(IndexOutOfBoundsException e) {
	    	System.out.println("Enter within the limit:)");
	    }
	   
	}
	
	
	
	public void Exit() {	
		System.out.println("System Exiting...");
		System.exit(0);
	}
	
	public void Sample() {
		//some sample products are added in the program 
		Category catGroceries = new Category("Groceries");    
		delay();      //so that we get unique category id
		Category catBeautyprod = new Category("BeautyProducts");
		delay();
		Category catToys = new Category("Toys");
		delay();
		Category catCookWare = new Category("CookWare");
		delay();
		repo.catList.add(catGroceries);  //objects as parameters
		repo.catList.add(catBeautyprod);
		repo.catList.add(catToys);
		repo.catList.add(catCookWare);
		
	
	    String s1="Rava 1kg";
	    String s2="Rice 1kg";
	    String s3="Ragi 1kg";
	    String s4="Corn flour 1/4 kg";
	    String s5="Chilli powder 100g";
	    String s6="Ashirvad Wheatflour 1kg";
	    
	    String s7="Nivea_bl";
	    String s8="Vaseline bl";
	    String s9="Ponds_bl";
	    String s10="Sunsilk Shampoo";
	    String s11="Indulekha Hairoil";
	    
	    String s12="Car";
	    String s13="Barbie doll";
	    String s14="Foldable slide";
	    
	    String s15="Dosa Tava";
	    String s16="Nonstick Frypan";
	    String s17="Induction base Nonstick set";
	    Products  p1=new Products(catGroceries.getcategoryID(),s1,25.00);  
	    Products  p2=new Products(catGroceries.getcategoryID(),s2,38.00);  
	    Products  p3=new Products(catGroceries.getcategoryID(),s3,50.00);  
	    Products  p4=new Products(catGroceries.getcategoryID(),s4,20.00);  
	    Products  p5=new Products(catGroceries.getcategoryID(),s5,45.00);  
	    Products  p6=new Products(catGroceries.getcategoryID(),s6,55.00);  
	    Products  p7=new Products(catBeautyprod.getcategoryID(),s7,120.00);  
	    Products  p8=new Products(catBeautyprod.getcategoryID(),s8,95.00);  
	    Products  p9=new Products(catBeautyprod.getcategoryID(),s9,65.00);  
	    Products  p10=new Products(catBeautyprod.getcategoryID(),s10,140.00);  
		Products  p11=new Products(catBeautyprod.getcategoryID(),s11,350.00);
		Products  p12=new Products(catToys.getcategoryID(),s12,1500.00);
		Products  p13=new Products(catToys.getcategoryID(),s13,650.00);
		Products  p14=new Products(catToys.getcategoryID(),s14,2500.00);
		Products  p15=new Products(catCookWare.getcategoryID(),s15,645.00);
		Products  p16=new Products(catCookWare.getcategoryID(),s16,900.00);
		Products  p17=new Products(catCookWare.getcategoryID(),s17,3500.00);
		
		
		repo.prodList.add(p1);
		repo.prodList.add(p2);
		repo.prodList.add(p3);
		repo.prodList.add(p4);
		repo.prodList.add(p5);
		repo.prodList.add(p6);
		repo.prodList.add(p7);
		repo.prodList.add(p8);	
		repo.prodList.add(p9);
		repo.prodList.add(p10);
		repo.prodList.add(p11);
		repo.prodList.add(p12);
		repo.prodList.add(p13);
		repo.prodList.add(p14);
		repo.prodList.add(p15);
		repo.prodList.add(p16);
		repo.prodList.add(p17);
	
	} void delay() {
		try{
			Thread.sleep(10);          
		}
		catch(InterruptedException e) {                  
			e.printStackTrace();
		}
	}

}
