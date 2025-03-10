package ti2.exercicio2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO {

    public UserDAO() {
        super();
        connect();
    }
    
    public boolean insert(User user) {
        boolean status = false;
        try {  
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO users (id, login, password, gender) " +
                         "VALUES (" + user.getId() + ", '" + user.getLogin() + "', '"  
                         + user.getPassword() + "', '" + user.getGender() + "')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            status = true;
        } catch (SQLException e) {  
            throw new RuntimeException(e);
        }
        return status;
    }

    public User get(int id) {
        User user = null;
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM users WHERE id = " + id;
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);	
            if (rs.next()) {            
                user = new User(rs.getInt("id"),
                                rs.getString("login"),
                                rs.getString("password"),
                                rs.getString("gender").charAt(0));
            }
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

    public List<User> getAll() {
        return get("");
    }

    public List<User> getOrderById() {
        return get("id");
    }

    public List<User> getOrderByLogin() {
        return get("login");
    }

    public List<User> getOrderByGender() {
        return get("gender");
    }

    private List<User> get(String orderBy) {
        List<User> users = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM users" + (orderBy.trim().isEmpty() ? "" : " ORDER BY " + orderBy);
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);	           
            while (rs.next()) {	            	
                User u = new User(rs.getInt("id"),
                                  rs.getString("login"),
                                  rs.getString("password"),
                                  rs.getString("gender").charAt(0));
                users.add(u);
            }
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return users;
    }

    public boolean update(User user) {
        boolean status = false;
        try {  
            Statement stmt = connection.createStatement();
            String sql = "UPDATE users SET login = '" + user.getLogin() + "', password = '"  
                       + user.getPassword() + "', gender = '" + user.getGender() + "'"
                       + " WHERE id = " + user.getId();
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            status = true;
        } catch (SQLException e) {  
            throw new RuntimeException(e);
        }
        return status;
    }

    public boolean delete(int id) {
        boolean status = false;
        try {  
            Statement stmt = connection.createStatement();
            String sql = "DELETE FROM users WHERE id = " + id;
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            status = true;
        } catch (SQLException e) {  
            throw new RuntimeException(e);
        }
        return status;
    }

    public boolean authenticate(String login, String password) {
        boolean isAuthenticated = false;
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM users WHERE login = '" + login + "' AND password = '" + password + "'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            isAuthenticated = rs.next();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return isAuthenticated;
    }

	public List<User> getMaleUsers() {
		// TODO Auto-generated method stub
		return null;
	}
}
