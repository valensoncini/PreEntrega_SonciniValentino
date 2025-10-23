package items;

import interfaces.IDiscount;

public abstract class Item implements IDiscount{
	
	protected static int count = 1;
	protected int id;
	protected String name;
	protected double price;
	
	
	
	
	public Item(String name, double price) {
		super();
		this.id = count++;
		this.name = name;
		this.price = price;

	}
	
	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	


	public abstract double estimateDiscount();




	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price;
	}
	
	
	
}
