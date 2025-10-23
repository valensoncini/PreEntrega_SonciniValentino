package items;

public class Category {
	
	private static int count = 0;
	private int id;
	private String name;
	
	
	public Category(String name) {
		super();
		this.id = count++;
		this.name = name;
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


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
