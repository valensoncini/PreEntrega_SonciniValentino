package cruds;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import items.Category;
import items.Item;
import items.Product;
import items.Service;

public class ItemCrud extends GeneriCrud<Item>{
	
	private final ArrayList<Item> itemList;
	private final ArrayList<Category> categoryList;
	private final CategoryCrud crudCat;
	
	

	public ItemCrud(ArrayList<Item> itemList, ArrayList<Category> categoryList) {
		super();
		this.itemList = itemList;
		this.categoryList = categoryList;
		this.crudCat = new CategoryCrud(categoryList);
	}
	
	@Override
	public void showMenu() {
		System.out.println("===MENU ITEMS===");
		System.out.println("1) Create ITEMS");
		System.out.println("2) List ITEMS ");
		System.out.println("3) Update ITEMS");
		System.out.println("4) Delete ITEMS");
		System.out.println("0) Back");
		System.out.println("Option: ");
	}

	@Override
	public boolean create() {
		boolean flag = false;
		System.out.println("Que quiere crear?");
		System.out.println("1) Product");
		System.out.println("2) Service");
		System.out.println("Option: ");
		int op = readInt("");
		
		if(op == 1) {
			Category cat = null;
			if(categoryList.isEmpty()) {
				System.out.println("Categorias vacias! Primero ingrese una categoria.");
				return flag;
			}
			String name = readText("Ingrese El nombre de su Producto: \n");
			double price = readDouble("Ingrese el precio de su Producto: \n");
			int stock = readInt("Ingrese la cantidad de stock del producto: \n");
			System.out.println("A que categoria pertenece el producto?");
			crudCat.list();
			int idCat = readInt("\n");
			try {
				 cat  = crudCat.findByID(idCat);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			LocalDate expiration = readDate("Fecha de expiracion:\n");
			
			flag =  itemList.add(new Product(name, price, stock, cat, expiration));
			
		}
		
		
		if(op == 2) {
			String name = readText("Ingrese El nombre del Servicio: \n");
			double price = readDouble("Ingrese el precio del Servicio: \n");
			int span = readInt("Ingrese el tiempo de duracion del servicio en horas:\n");
			
			flag =  itemList.add(new Service(name, price, span));
		}
		
		return flag;
		

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		if(itemList.isEmpty()) {
			System.out.println("Sin elementos!");
			return;
		}
		
		for(Item i : this.itemList) {
			System.out.println(i.toString() + "\n");
		}
		
		
	
	}

	@Override
	public void update() {
		
		
		if(itemList.isEmpty()) {
			System.out.println("Primero cree items!");
			return;
		}
		
		
		Item item = null;
		
		
		System.out.println("Ingrese el Id del producto a Actualizar:\n");
		int id = readInt("");
		try {
			item = findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
		System.out.println("Desea cambiar el nombre?: 1) SI, 2)NO");
		int op = readInt("");
		if(op == 1) {
			String newName = readText("Nuevo nombre:\n");
			item.setName(newName);
			op = -1;
		}
		
		System.out.println("Desea cambiar el precio?: 1) SI, 2)NO");
		 op = readInt("");
		if(op == 1) {
			double newPrice = readDouble("Nuevo precio:\n");
			item.setPrice(newPrice);
			op = -1;
		}
		
		
		if(item instanceof Product) {
			
			System.out.println("Desea cambiar el stock?: 1) SI, 2)NO");
			 op = readInt("");
			if(op == 1) {
				int newStock = readInt("Nuevo stock:\n");
				((Product) item).setStock(newStock);
				op = -1;
			}
			
			System.out.println("Desea cambiar la fecha de caducidad?: 1) SI, 2)NO");
			 op = readInt("");
			if(op == 1) {
				LocalDate newDate = readDate("Nueva fecha:\n");
				((Product) item).setExpiration(newDate);
				op = -1;
			}
			
			System.out.println("Desea cambiar la Categoria del producto?: 1) SI, 2)NO");
			 op = readInt("");
			if(op == 1) {
				
				crudCat.list();
				
				System.out.println("A que categoria desea cambiar?\n");
				 int idCat = readInt("");
				 try {
					 ((Product)item).setCategory( crudCat.findByID(idCat));
				 }catch(Exception e) {
					 e.getMessage();
				 }
				 
				 op = -1;
				 
				 
			}
			
			
		}
		
		if(item instanceof Service) {
			System.out.println("Desea cambiar el tiempo de duracion?: 1) SI, 2)NO");
			 op = readInt("");
			if(op == 1) {
				int newSpan = readInt("Nuevo tiempo:\n");
				((Service) item).setSpan(newSpan);
				op = -1;
			}
		}
		
		
		
		System.out.println("Updated: " + item);
		return;
	
	}

	@Override
	public boolean delete() {
		Item item = null;
		
		System.out.println("Ingrese el Id del producto a Eliminar:");
		list();
		int id = readInt("");
		try {
			item = findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		return itemList.remove(item);
		
	}
	
	
	private LocalDate readDate(String text) {
		DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 while (true) {
	            try {
	                System.out.print(text);
	                String date = scanner.nextLine();
	                return LocalDate.parse(date.trim(), newFormat);
	            } catch (DateTimeParseException e) {
	            	System.out.println("Error: Formato de fecha incorrecto.");
	                System.out.println("Por favor, ingrese la fecha en formato DD/MM/AAAA (ej. 25/10/2025).");
	            }
	        }
		
	}
	
	public Item findById(int id) throws Exception {
		Item find = null;
		if(id < 0) {
			throw new Exception("Error: ID no valido!");
		}
		
		for(Item i : this.itemList) {
			if(i.getId() == id) {
				find = i;
			}
		}
		
		return find;
	}

}
