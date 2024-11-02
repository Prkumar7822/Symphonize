package Details;

public class Student {

	private String name;
	private int age;
	
	
	private String grade;
	public Student(String name,int age,String grade) {
		this.name=name;
		this.grade=grade;
		
		this.age=age;
		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + ", getAge()=" + getAge() + ", getName()="
				+ getName() + ", getGrade()=" + getGrade() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
