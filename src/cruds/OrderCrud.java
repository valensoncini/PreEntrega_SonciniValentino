package cruds;

import java.util.ArrayList;

import items.Item;
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
		Order orderAux;
		do {
			System.out.println("Desea agregar un item a su pedido?");
			crudItems.list();
			System.out.println("Ingrese el ID del prducto a su pedido:");
			int idItem = readInt("");
			System.out.println("Cuantos?");
			int cantidad = readInt("");
			
			
			
			
		}while(true);
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
	
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
	
	

}
