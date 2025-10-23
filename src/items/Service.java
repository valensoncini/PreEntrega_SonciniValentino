package items;



public class Service extends Item{
	
	private int span;

	public Service(String name, double price, int span) {
		super(name, price);
		this.span = span;
	}

	public int getSpan() {
		return span;
	}

	public void setSpan(int span) {
		this.span = span;
	}

	@Override
	public double estimateDiscount() {
		return this.price * 0.20;
	}

	@Override
	public String toString() {
		return "Service [ "+super.toString()+" span=" + span + "]";
	}
	
	
	

}
