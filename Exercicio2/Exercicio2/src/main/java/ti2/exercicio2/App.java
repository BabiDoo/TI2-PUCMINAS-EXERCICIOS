package ti2.exercicio2;

import java.util.List;

public class App {
	
	public static void main(String[] args) throws Exception {
		
		UserDAO userDAO = new UserDAO();
		
		System.out.println("\n\n==== Insert user ===");
		User user = new User(11, "pablo", "pablo", 'M');
		if(userDAO.insert(user)) {
			System.out.println("Insertion successful -> " + user.toString());
		}
		
		System.out.println("\n\n==== Testing authentication ===");
		System.out.println("User (" + user.getLogin() + "): " + userDAO.authenticate("pablo", "pablo"));
			
		System.out.println("\n\n==== Show male users ===");
		List<User> users = userDAO.getMaleUsers();
		for (User u: users) {
			System.out.println(u.toString());
		}

		System.out.println("\n\n==== Update password (id (" + user.getId() + ")) ===");
		user.setPassword(DAO.toMD5("pablo"));
		userDAO.update(user);
		
		System.out.println("\n\n==== Testing authentication ===");
		System.out.println("User (" + user.getLogin() + "): " + userDAO.authenticate("pablo", DAO.toMD5("pablo")));		
		
		System.out.println("\n\n==== SQL Injection attempt ===");
		System.out.println("User (" + user.getLogin() + "): " + userDAO.authenticate("pablo", "x' OR 'x' LIKE 'x"));

		System.out.println("\n\n==== Show users ordered by id ===");
		users = userDAO.getOrderById();
		for (User u: users) {
			System.out.println(u.toString());
		}
		
		System.out.println("\n\n==== Delete user (id " + user.getId() + ") ===");
		userDAO.delete(user.getId());
		
		System.out.println("\n\n==== Show users ordered by login ===");
		users = userDAO.getOrderByLogin();
		for (User u: users) {
			System.out.println(u.toString());
		}
	}
}
