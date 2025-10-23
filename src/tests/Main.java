package tests;

import java.util.ArrayList;
import java.util.Scanner;

import cruds.CategoryCrud;
import cruds.ItemCrud;
import items.Category;
import items.Item;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Inicializaciones
		
		final Scanner menuScanner = new Scanner(System.in);
		
		Category category1 = new Category("Hogar");
		Category category2 = new Category("Limpieza");
		Category category3 = new Category("Tecnologia");
		
		final ArrayList<Category> categoryList = new ArrayList<Category>();
		
		categoryList.add(category1);
		categoryList.add(category2);
		categoryList.add(category3);
		
		final ArrayList<Item> itemList = new ArrayList<Item>();
		
		final ItemCrud crudItems = new ItemCrud(itemList, categoryList);
		final CategoryCrud crudCategory = new CategoryCrud(categoryList);
		
		//---------------------------------
		
		int option = -1;
		do {
			System.out.println("===MENU===");
			System.out.println("1) CRUD ITEMS");
			System.out.println("2) CRUD CATEGORY");
			System.out.println("0) Get Out");
			System.out.println("Option? ");
			String line = menuScanner.nextLine();
			
			 try {
				 option = Integer.parseInt(line.trim());
	            } catch (NumberFormatException e) {
	            	option = -1;
	            }
			 
			 switch(option) {
			 case 1 ->{
				 int itemsOption = -1;
				 do {
					crudItems.showMenu();
					String Itemsline = menuScanner.nextLine();
					try {
						itemsOption = Integer.parseInt(Itemsline.trim());
			       } catch (NumberFormatException e) {
			    	   itemsOption = -1;
			          }
					
					switch(itemsOption) {
					case 1: crudItems.create(); break;
					case 2: crudItems.list(); break;
					case 3: crudItems.update(); break;
					case 4: crudItems.delete(); break;
					case 0: System.out.println("Volviendo al menu principal!");
					default: System.out.println("Opcion invalida!");
					}
					 
					
					 
				 }while(itemsOption != 0);
				 
				 
				 
				 
				 
				 
			 	}
			 case 2 -> {
				 
				 int catOption = -1;
				 do {
					 crudCategory.showMenu();
					String catLine = menuScanner.nextLine();
					try {
						catOption = Integer.parseInt(catLine.trim());
			       } catch (NumberFormatException e) {
			    	   catOption = -1;
			          }
					
					switch(catOption) {
					case 1: crudCategory.create(); break;
					case 2: crudCategory.list(); break;
					case 3: crudCategory.update(); break;
					case 4: crudCategory.delete(); break;
					case 0: System.out.println("Volviendo al menu principal!");
					default: System.out.println("Opcion invalida!");
					}
					 
					
					 
				 }while(catOption != 0);
				 
			 	}
			 case 0 -> System.out.println("¡Hasta luego!");
             default -> System.out.println("Opción inválida");
			 }
		}while(option != 0);
	}

}
