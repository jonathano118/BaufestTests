package pages;

import java.util.Random;

public class PetInfo {

	public int id;
	public String name;
	public String status;
	public Info category = new Info();
	public Info tags[] = { new Info()};


	public PetInfo() {
		Random r = new Random();
		
		id = r.nextInt(100);
		System.out.println(id);
		name = "Cheems";
		category.id = id;
		category.name = "Shiba Inu";
		tags[0].id = id;
		tags[0].name = "";
		status = "available";
		
	}
	
	}
	
