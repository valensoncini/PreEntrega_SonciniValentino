package tests;

import java.time.LocalDate;
import java.time.LocalTime;

import items.Category;
import items.Product;
import items.Service;
import orders.Detail;
import orders.Order;

public class TestItems {

	public static void main(String[] args) {
	
		
		Category category1 = new Category("Hogar");
		Category category2 = new Category("Tecnologia");
		Category category3 = new Category("Limpieza");
		
		Product product1 = new Product("Mouse", 500.0, 20, category2, LocalDate.of(2027, 7, 20) );
		Product product2 = new Product("Lavandina", 650.0, 10, category3, LocalDate.of(2027, 9, 20) );
		Service service1 = new Service("Soporte tecnico", 1500.0, 230);
		
		
		/*System.out.println(category1.toString());
		System.out.println(category2.toString());
		System.out.println(category3.toString());
		
		System.out.println(product1.toString());
		System.out.println(product2.toString());*/
	
		
		
		/**********************************************+*/
		
		Detail detail1 = new Detail(product1, 3);
		Detail detail2 = new Detail(product2, 6);
		Detail detail3 = new Detail(service1, 1);
		
		Order order1 = new Order(LocalDate.of(2025, 11, 23));
		
		order1.addDetail(detail1);
		order1.addDetail(detail2);
		order1.addDetail(detail3);
		
		
		System.out.println(detail1.toString());
		System.out.println(detail2.toString());
		System.out.println(detail3.toString());
		
		System.out.println(order1.toString());
		
		
		
		
	}

}
