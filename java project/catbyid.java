package Supermarket; //package Supermarket
//we use this class to get the category name with the help of category id.
public class catbyid{
	static Repository repo = Repository.getRepository();
     public static String getCategoryNameByID(long categoryID) {
		for(Category c : repo.catList) {                //this is used to get each category of the list 
			if(c.getcategoryID() == (categoryID)) {
				return c.getcatName();                  //if it matches with the selected category then return it
			}
			
		}
		return null;    //if there is no such category
	}
}
