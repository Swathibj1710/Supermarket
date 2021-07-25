package Supermarket;  //package Supermarket
import java.util.ArrayList;
import java.util.List;

public class Repository   //this is used to store the data
{
	public List<Category>catList=new ArrayList();     // Declaring the ArrayList 
	public List<Products>prodList=new ArrayList();
	public List<Customers>custList=new ArrayList();
	
	private static Repository repository;
	private Repository() {
		
	}
	
	public static Repository getRepository() {
		if(repository==null) {
			repository=new Repository();            //new object is create if the other object is null
		}
		return repository;
	}
}
