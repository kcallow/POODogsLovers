package elementos.CategoryAdmin;

import java.util.ArrayList;

public class CategoryAdmin {
	private ArrayList<String> categories = new ArrayList<String>();
	
	public CategoryAdmin(){
		
	}
	
	public CategoryAdmin(String[] initialCategories){
		for(String category : initialCategories){
			addCategory(category);
		}
	}
	
	public boolean hasCategories(){
		return categories.isEmpty();
	}
	
	public void addCategory(String category){
		category = category.toUpperCase();
		if(! categories.contains(category)){//Avoid duplicate entries
			categories.add(category);
		}
	}
	
	public void deleteCategory(String category){
		category = category.toUpperCase();
		categories.remove(category);
	}
	
	public boolean containsCategory(String category){
		category = category.toUpperCase();
		return categories.contains(category);
	}
	
	public ArrayList<String> getMatchingCategories(String query){
		ArrayList<String> result = new ArrayList<String>();
		query = query.toUpperCase();
		for(String category : categories){
			if(category.contains(query) || query.contains(category)){
				result.add(category);				
			}
		}
		return result;
	}
	
	public ArrayList<String> getCategories(){
		return categories;
	}

}
