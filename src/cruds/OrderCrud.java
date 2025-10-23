package cruds;

import java.util.ArrayList;

import items.Item;
import items.Product;
import orders.Detail;
import orders.Order;

public class OrderCrud extends GeneriCrud<Order>{
	
	private final ArrayList<Order> orderList;
	private final ArrayList<Item> itemList;
	private final ItemCrud crudItems;
	
	
	

	public OrderCrud(ArrayList<Order> orderList, ArrayList<Item> itemList) {
		super();
		this.orderList = orderList;
		this.itemList = itemList;
		this.crudItems = new ItemCrud(itemList, null);
	}

	@Override
	public boolean create() {
//		Order orderAux;
//		Item itemAgregar = null;
//		do {
//			System.out.println("Desea agregar un item a su pedido?");
//			crudItems.list();
//			System.out.println("Ingrese el ID del prducto a su pedido:");
//			int idItem = readInt("");
//			System.out.println("Cuantos?");
//			int cantidad = readInt("");
//			
//			try {
//				 itemAgregar = crudItems.findById(idItem);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.getMessage();
//			}
//			
//			if(itemAgregar instanceof Product) {
//				if(((Product)itemAgregar).getStock() > cantidad) {
//					try {
//						((Product)itemAgregar).decreaseStock(cantidad);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.getMessage();
//					}	
//				}
//			}
//			
//			
//			
//			
//			
//		}while(true);
		return false;
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		for(Order o: orderList) {
			System.out.println(o.toString() + "\n");
		}
	
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}
	


	
	public void createOrder() { 
	    System.out.println("\n-- Creando Nuevo Pedido --");

	    Order orderAux = new Order(null); 

	    do {
	        System.out.println("\nItems disponibles:");
	        crudItems.list(); 

	        int idItem = readInt("Ingrese ID del item (0 para finalizar): ");
	        if (idItem == 0) {
	            break; 
	        }

	        Item itemAgregar = null;
	        try {
	            itemAgregar = crudItems.findById(idItem);
	            if (itemAgregar == null) {
	                System.err.println("Error: Item no encontrado.");
	                continue; 
	            }

	            int cantidad = readInt("Ingrese cantidad: ");
	            if (cantidad <= 0) {
	                System.err.println("Error: La cantidad debe ser positiva.");
	                continue;
	            }

	           
	            if (itemAgregar instanceof Product prod) { 
	                if (prod.getStock() < cantidad) {
	                 
	                    throw new Exception(
	                        "Stock insuficiente para '" + prod.getName() + 
	                        "'. Disponible: " + prod.getStock()
	                    );
	                }
	            }

	            Detail detail = new Detail(itemAgregar, cantidad);
	            orderAux.addDetail(detail);
	            System.out.println("-> '" + itemAgregar.getName() + "' agregado al pedido.");

	        } 
	       
	        catch (Exception e) { 
	            System.err.println("Error: " + e.getMessage());
	        }

	    } while (true);

	    
	 
	    if (orderAux.getDetailList().isEmpty()) {
	        System.out.println("Pedido cancelado (no se agregaron items).");
	        return; 
	    }

	    System.out.println("\n--- Resumen del Pedido ---");
	    System.out.println(orderAux.toString()); 
	    
	    String confirmacion = readText("¿Desea confirmar el pedido? (s/n): ");

	 
	    if (confirmacion.equalsIgnoreCase("s")) {
	        try {
	            for (Detail detail : orderAux.getDetailList()) {
	                if (detail.getItem() instanceof Product prod) {
	                    prod.decreaseStock(detail.getAmount()); 
	                }
	            }

	          
	            boolean exito = this.orderList.add(orderAux);
	            
	            if (exito) {
	                System.out.println("¡Pedido confirmado y registrado con ID: " + orderAux.getId() + "!");
	            } else {
	                System.err.println("Error: El pedido no se pudo guardar en la lista.");
	            }

	        } 
	     
	        catch (Exception e) { 
	            System.err.println("Error crítico al confirmar. Pedido cancelado.");
	           }
	    } else {
	        System.out.println("Pedido cancelado por el usuario.");
	    }
	}
	
	
	public void showMenu() {
		System.out.println("===MENU ORDERS===");
		System.out.println("1) Create");
		System.out.println("2) List");
		System.out.println("0) Back/Out");
		System.out.println("Option: ");
	}
	
	

}
