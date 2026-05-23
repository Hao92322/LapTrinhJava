package domain;
public class Person {
	private int idPerson;
	private String name;
	public Person(int idPerson, String name) {
		this.idPerson = idPerson;
		this.name = name;
		// TODO Auto-generated constructor stub
	}
	public int GetidPerson() {
		return this.idPerson;
	}
	public void SetidPerson(int idPerson) {
		this.idPerson = idPerson;
	}
	public String GetName() {
		return this.name;
	}
	public void SetName(String name) {
		this.name = name;
	}
	public String ToString() {
		return "Person{"+"idPerson : "+idPerson+", name : "+name+"}";
	}

}
