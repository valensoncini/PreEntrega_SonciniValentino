package items;

import java.time.LocalDate;

public class Product extends Item{
	
	private int stock;
	private Category category;
	private LocalDate expiration;
	
	
	public Product(String name, double price, int stock, Category category, LocalDate expiration) {
		super(name, price);
		this.stock = stock;
		this.category = category;
		this.expiration = expiration;
	}
	
	
	
	
	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public LocalDate getExpiration() {
		return expiration;
	}




	public void setExpiration(LocalDate expiration) {
		this.expiration = expiration;
	}
	
	
	
	
	public int getStock() {
		return stock;
	}




	public void setStock(int stock) {
		this.stock = stock;
	}




	@Override
	public String toString() {
		return "Product [ " + super.toString() + " category=" + category + ", expiration=" + expiration + "]";
	}




	@Override
	public double estimateDiscount() {
		return this.price * 0.10;
	}
	
	

}
