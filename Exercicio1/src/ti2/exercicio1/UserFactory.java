package ti2.exercicio1;



public class UserFactory {

	public static void main( String[] args) {
	
		User Maria = new User();
		Maria.setId(1);
		Maria.setLogin("Maria");
		Maria.setPassword("850");
		Maria.setGender('F');
		System.out.println("User: " + Maria.getLogin());
		System.out.println("Password: " + Maria.getPassword());
		

		
		
		User Joao = new User(2,"Joao", "247", 'M');
		System.out.println("User: " + Joao.getLogin());
		System.out.println("Password: " + Joao.getPassword());
		
		
	}
	
	
}

