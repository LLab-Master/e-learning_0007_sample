package chapter10;

import java.util.ArrayList;
import java.util.List;

public class PersonLogic {
	public List<String> getAll() {
		PersonDAO dao = new PersonDAO();
		List<String> persons = new ArrayList<>();

		for (Person person : dao.findAll()) {
			persons.add(person.getName());
		}
		return persons;
	}
	
	public void add(String name) {
		PersonDAO dao = new PersonDAO();
		Person person = new Person(0, name);
		dao.insert(person);
	}
	
}
