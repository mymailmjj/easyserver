package digest;

public class Subjects {

	private String name;
	private String teacher;

	public Subjects() {
		System.out.println("One subjects waiting scheduling!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("set name of Subjects:" + name);
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		System.out.println("set teacher of Subjects :" + teacher);
		this.teacher = teacher;
	}

	public void print() {
		System.out.println("Subjects  :" + name + "of " + teacher
				+ "in schedule");
	}

	@Override
	public String toString() {
		return "Subjects [" + (name != null ? "name=" + name + ", " : "")
				+ (teacher != null ? "teacher=" + teacher : "") + "]";
	}
	

}
