package model;

public class Student implements User{

	public static final String ID = "id";

	private long id;
	private String name;
	private String matricula;
	private String email;

	public Student(long id, String name, String matricula, String email) {
		super();
		this.id = id;
		this.name = name;
		this.matricula = matricula;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + 
		       "\nID: " + this.getId() + 
		       "\nMatricula: " + this.getMatricula() + 
		       "\nEmail: " + this.getEmail();
	}

}
