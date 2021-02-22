package pages;

import java.util.Random;

public class PetInfo {
	
	private static PetInfo info = new PetInfo();

	public int id;
	public String name;
	public String status;
	public Info category = new Info();
	public Info tags[] = { new Info()};


	private PetInfo() {
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
	
	public static PetInfo getInfo() {
		if(info == null){
			info = new PetInfo();
        }

        return info;
	}

	}
	
