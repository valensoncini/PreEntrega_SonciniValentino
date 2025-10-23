package tests;

import java.util.ArrayList;

import cruds.CategoryCrud;
import cruds.ItemCrud;
import items.Category;
import items.Item;

public class CrudTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Category category1 = new Category("Hogar");
		Category category2 = new Category("Tecnologia");
		Category category3 = new Category("Limpieza");
		
		ArrayList<Category> categoryList = new ArrayList<Category>();
		
		categoryList.add(category1);
		categoryList.add(category2);
		categoryList.add(category3);
		

		//final CategoryCrud crudCategory = new CategoryCrud(categoryList);
		
		
		/*crudCategory.list();
		crudCategory.update();
		
		crudCategory.list();
		
		crudCategory.delete();
		crudCategory.list();
		*/
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		final ItemCrud crudItems = new ItemCrud(itemList,categoryList );
		
		System.out.println(crudItems.create());
		System.out.println(crudItems.create());
		crudItems.list();
		
		crudItems.update();
	}

}
