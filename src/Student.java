import java.io.Serializable;

public class Student implements Serializable {

	private static int counter = 1000;
	int studentId;
	String firstName, lastName, major, phoneNumber;
	double gpa;
	BirthDate birthDate;

	public Student(String firstName, String lastName, String major, String phoneNumber, double gpa,
			BirthDate birthDate) {
		super();
		// this.studentId = studentId;
		this.studentId = counter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
		this.phoneNumber = phoneNumber;
		this.gpa = gpa;
		this.birthDate = birthDate;
		counter++;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", major="
				+ major + ", phoneNumber=" + phoneNumber + ", gpa=" + gpa + ", birthDate=" + birthDate.day + "/"
				+ birthDate.month + "/" + birthDate.year + "]";
	}

	public int getStudentId() {
		return studentId;
	}

	/*
	 * public void setStudentId(int studentId) { this.studentId = studentId; }
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public BirthDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(BirthDate birthDate) {
		this.birthDate = birthDate;
	}

}
