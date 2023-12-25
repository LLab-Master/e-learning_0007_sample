package chapter10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class PersonLogicTest {

	@Test
	void testGetAll() {
		PersonLogic personLogic = new PersonLogic();
		List<String> persons = personLogic.getAll();
		assertEquals(persons.get(0), "山田");
		assertEquals(persons.get(1), "田中");
		assertEquals(persons.get(2), "中野");
		assertEquals(persons.get(3), "野村");
		assertEquals(persons.get(4), "村山");
	}

	@Test
	void testAdd() {
		PersonLogic personLogic = new PersonLogic();
		personLogic.add("佐藤");
		List<String> persons = personLogic.getAll();
		assertEquals("佐藤", persons.get(5));
		
		// 後始末
		PersonDAO dao = new PersonDAO();
		dao.delete(new Person(6, "佐藤"));
	}

}
