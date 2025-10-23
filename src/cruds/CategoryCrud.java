package cruds;

import java.util.ArrayList;

import items.Category;

public class CategoryCrud extends GeneriCrud<Category>{
	
	private final ArrayList<Category> categories;

	
	public CategoryCrud(ArrayList<Category> categories) {
		super();
		this.categories = categories;
	}
	
	
	@Override
	public void showMenu() {
		System.out.println("===MENU CATEGORY===");
		System.out.println("1) Create CATEGORY");
		System.out.println("2) List CATEGORIES ");
		System.out.println("3) Update CATEGORY");
		System.out.println("4) Delete CATEGORY");
		System.out.println("0) Back/Out");
		System.out.println("Option: ");
	}
	
	
	

	@Override
	public boolean create(){
		String name = null;
		
		do {
			name = readText("Porfavor ingrese un nombre para su categoria");
			if(name == "" || name == null) {
				System.out.println("Por favor ingrese un nombre valido");
			}
		}while(name == "" || name == null);
		
		return categories.add(new Category(name));
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		if(categories.size() <= 0) {
			System.out.println("No hay Categorias");
			return;
		}
		
		for(Category c : this.categories) {
			System.out.println(c.toString());
		}
	}

	@Override
	public void update() {
		int op = -1;
		Category cat =null;
		int id = readInt("Ingrese el ID de la categoria a editar: ");
		try {
			cat = findByID(id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Quiere cambiar el nombre de la categoria?");
		System.out.println("1) SI,  2) NO");
		op = readInt("");
		
		if(op == 1) {
			String newName = readText("Ingrese el nuevo Nombre de su categoria: \n");
			cat.setName(newName);
			System.out.println("Updated: " + cat.toString());
			return;
			
		}else if(op == 2) {
			System.out.println("Updated: " + cat.toString());
			return;
		}
		
		
	}

	@Override
	public boolean delete() {
		Category cat = null;
		int id = readInt("Ingrese el ID de la Categoria a eliminar!");
		try {
			cat = findByID(id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return categories.remove(cat);
		
	
	}
	
	public Category findByID(int id) throws Exception {
		Category find = null;
		if(id < 0) {
			throw new Exception("Error: ID no valido!");
		}
		
		for(Category c : this.categories) {
			if(c.getId() == id) {
				find = c;
			}
		}
		
		return find;
		
	}
	


}
