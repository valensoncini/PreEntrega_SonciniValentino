package cruds;

import java.util.Scanner;

public abstract class GeneriCrud<T> {
	
	protected final Scanner scanner = new Scanner(System.in);
	
	public abstract boolean create();
	public abstract void list();
	public abstract void update();
	public abstract boolean delete();
	
	
	
	public void showMenu() {
		System.out.println("===MENU===");
		System.out.println("A) Create");
		System.out.println("B) List");
		System.out.println("C) Update");
		System.out.println("D) Delete");
		System.out.println("O) Back/Out");
		System.out.println("Option: ");
	}
	
	
	
	
	
	
	 protected int readInt(String text) {
	        while (true) {
	            try {
	                System.out.print(text);
	                String linea = scanner.nextLine();
	                return Integer.parseInt(linea.trim());
	            } catch (NumberFormatException e) {
	                System.out.println("Debe ser un número entero.");
	            }
	        }
	    }

	  protected double readDouble(String text) {
	        while (true) {
	            try {
	                System.out.print(text);
	                String linea = scanner.nextLine();
	                return Double.parseDouble(linea.trim());
	            } catch (NumberFormatException e) {
	                System.out.println("Debe ser un número (use punto).");
	            }
	        }
	    }

	    protected String readText(String text) {
	        System.out.print(text);
	        return scanner.nextLine();
	    }
	    
	    
	    
}
