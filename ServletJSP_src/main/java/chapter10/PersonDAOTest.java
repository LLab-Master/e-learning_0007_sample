package chapter10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class PersonDAOTest {

	@Test
	void testFindAll() {
		PersonDAO dao = new PersonDAO();
		List<Person> persons = dao.findAll();
		assertEquals("山田", persons.get(0).getName());
		assertEquals(1, persons.get(0).getId());
		assertEquals("田中", persons.get(1).getName());
		assertEquals(2, persons.get(1).getId());
		assertEquals("中野", persons.get(2).getName());
		assertEquals(3, persons.get(2).getId());
		assertEquals("野村", persons.get(3).getName());
		assertEquals(4, persons.get(3).getId());
		assertEquals("村山", persons.get(4).getName());
		assertEquals(5, persons.get(4).getId());
	}

	@Test
	void testCreateNewId() {
		PersonDAO dao = new PersonDAO();		
		assertEquals(6, dao.createNewId());
	}
	
	@Test
	void testInsert1() {
		PersonDAO dao = new PersonDAO();
		Person p = new Person(10, "井上");
		dao.insert(p);
		List<Person> persons = dao.findAll();
		assertEquals(10, persons.get(persons.size() - 1).getId());
		assertEquals("井上", persons.get(persons.size() - 1).getName());
		dao.delete(p);
	}

}
