package orders;

import items.Item;

public class Detail {
	
	private static int count = 0;
	private int id;
	private Item item;
	private int amount;
	
	public Detail(Item item, int amount) {
		super();
		this.id = count++;
		this.item = item;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Detail [id=" + id + ", item=" + item + ", amount=" + amount + "]";
	}
	
	
	
	

}
