package test;
import data.JdbcPerson;
import domain.Person;
import java.util.List;
public class JdbcHandlingTest {
	public static void main(String[] args) {
		JdbcPerson jdbcPerson = new JdbcPerson();
		List<Person> people = jdbcPerson.select();
		//jdbcPerson.update(1, "HaoGia");
		//jdbcPerson.insert("Bo");
		//jdbcPerson.delete(1);
		for(Person person : people)
		{
			System.out.println(person.ToString());
		}
	}
}
