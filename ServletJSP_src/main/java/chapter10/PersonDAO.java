package chapter10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
	private final String URL = "jdbc:h2:tcp://localhost/~/test";
	private final String USER = "sa";
	private final String PASS = "";
	
	public List<Person> findAll() {
		List<Person> personList = new ArrayList<>();		
		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			PreparedStatement psmt = con.prepareStatement("SELECT id, name FROM PERSONS");			
			ResultSet rs = psmt.executeQuery();			
			while (rs.next()) {
				Person person = new Person(rs.getInt("id"), rs.getString("name"));
				personList.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personList;
	}
	
	public int insert(Person person) {
		// id == 0 なら自動的に id を作る
		int st = 0;
		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			int id = person.getId();
			if (id == 0) { // get new id
				id = this.createNewId();
			}
			PreparedStatement psmt 
				= con.prepareStatement("INSERT INTO PERSONS (id, name) values(?, ?)");
			psmt.setInt(1, id);
			psmt.setString(2, person.getName());
			st = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	public int createNewId() {
		int newId = 0;
		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			PreparedStatement psmt = con.prepareStatement("SELECT max(id) FROM PERSONS");
			ResultSet rs = psmt.executeQuery();
			rs.next();
			newId = rs.getInt(1) + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newId;
	}
	
	public int delete(Person person) {
		int st = 0;
		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
			PreparedStatement psmt 
				= con.prepareStatement("DELETE FROM PERSONS WHERE id=? AND name=?");
			psmt.setInt(1, person.getId());
			psmt.setString(2, person.getName());
			st = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
}
