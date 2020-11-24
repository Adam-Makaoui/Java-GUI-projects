public class stackRecord {
	/** name of the user */
	String name;
	/** age of the user */
	int age;

	/**
	 * Constructor for creating a stack Record
	 * 
	 * @param name - String name
	 * @param age  - int age
	 * @category - stackRecord
	 */
	public stackRecord(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/* -------------Getters--------------- */
	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public stackRecord getRec(stackRecord rec) {
		return rec;
	}

	/* -------------Setters-------------- */
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;

	}

	/* -------------Printers----------------- */
	public void printName() {
		System.out.println(name);
	}

	public void printAge() {
		System.out.println(age);
	}

	public void printRec() {
		System.out.println(name + " " + age);
	}

}// End of Class
