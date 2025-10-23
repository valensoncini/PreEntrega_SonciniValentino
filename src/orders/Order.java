package orders;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
	
	private static int count = 1;
	private int id;
	private LocalDate date;
	private final ArrayList<Detail> detailList ;
	
	public Order(LocalDate date) {
		super();
		this.id = count++;
		this.date = date;
		this.detailList = new ArrayList<Detail>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public ArrayList<Detail> getDetailList() {
		return detailList;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", detailList=" + detailList + "]";
	}

	
	public void addDetail(Detail detail) {
		this.detailList.add(detail);
	}
	
	
	

}
