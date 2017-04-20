import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;;

public class StudentOperation {

	static ArrayList<Student> studentArray = new ArrayList<Student>();
	static String firstName, lastName, major, bDate, phoneNumber;
	static double gpa;

	static int choice = 0;
	static Scanner keyBoard = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BirthDate birthDate;
		FileManipulation fileManipulate = new FileManipulation();
		try {
			do {

				System.out.println("*********Menu for Student Database**********");
				System.out.println("*   1. Add                                 *");
				System.out.println("*   2. Edit                                *");
				System.out.println("*   3. Delete                              *");
				System.out.println("*   4. Sort by FirstName                   *");
				System.out.println("*   5. Sort by LastName                    *");
				System.out.println("*   6. Sort by Major                       *");
				System.out.println("*   7. Search by FirstName                 *");
				System.out.println("*   8. Search by LastName                  *");
				System.out.println("*   9. Search by Major                     *");
				System.out.println("*   10. Write student data in text file    *");
				System.out.println("*   11. Read student data from text file   *");
				System.out.println("*   12. Print student data in table format *");
				System.out.println("*   13. QUIT                               *");
				System.out.println("********************************************");

				System.out.println("Enter your choice:");
				choice = keyBoard.nextInt();
				keyBoard.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Enter First Name: ");
					firstName = keyBoard.nextLine();
					System.out.println("Enter Last Name: ");
					lastName = keyBoard.nextLine();
					System.out.println("Enter Major: ");
					major = keyBoard.nextLine();
					System.out.println("Enter Phone Number: ");
					phoneNumber = keyBoard.nextLine();
					System.out.println("Enter GPA: ");
					gpa = keyBoard.nextDouble();
					keyBoard.nextLine();
					System.out.println("Enter Birthdate in DD/MM/YYYY format: ");
					bDate = keyBoard.nextLine();
					String[] dateString = bDate.split("/");
					birthDate = new BirthDate();

					birthDate.day = Short.parseShort(dateString[0]);
					birthDate.month = Short.parseShort(dateString[1]);
					birthDate.year = Integer.parseInt(dateString[2]);

					addNewStudent(firstName, lastName, major, phoneNumber, gpa, birthDate);

					break;
				case 2:
					System.out.println("Enter the student id that you want to edit :");
					int editId = keyBoard.nextInt();
					keyBoard.nextLine();
					for (int i = 0; i < studentArray.size(); i++) {
						if (studentArray.get(i).studentId == editId) {
							editStudent(i);
						}
					}
					break;

				case 3:
					System.out.println("Enter the student id that you want to delete :");
					int deleteId = keyBoard.nextInt();
					keyBoard.nextLine();
					if (studentArray != null && studentArray.size() > 0) {
						for (int i = 0; i < studentArray.size(); i++) {
							if (studentArray.get(i).studentId == deleteId) {
								deleteStudent(i);
								System.out.println("Student data with " + deleteId + " is deleted....\n\n");
							}
						}
					} else {
						System.out.println("Nothing to delete..\n\n");
					}
					break;

				case 4:
					if (studentArray != null && studentArray.size() > 0) {
						sortStudentsByFirstName();
						printStudentData(studentArray);
					} else {
						System.out.println("Please enter data first.. \n\n");
					}
					break;
				case 5:
					if (studentArray != null && studentArray.size() > 0) {
						sortStudentsByLastName();
						printStudentData(studentArray);
					} else {
						System.out.println("Please enter data first..\n\n");
					}
					break;
				case 6:
					if (studentArray != null && studentArray.size() > 0) {
						sortStudentsByLastName();
						printStudentData(studentArray);
					} else {
						System.out.println("Please enter data first..\n\n");
					}
					break;
				case 7:
					System.out.println("Enter the First Name that you want to search : ");
					firstName = keyBoard.nextLine();
					if (!firstName.isEmpty()) {
						searchStudentByFirstName(firstName);
					} else {
						System.out.println("Enter valid string please....\n\n");
					}

					break;
				case 8:
					System.out.println("Enter the Last Name that you want to search : ");
					lastName = keyBoard.nextLine();
					if (!lastName.isEmpty()) {
						searchStudentByLastName(lastName);
					} else {
						System.out.println("Enter valid string please....\n\n");
					}
					break;
				case 9:
					System.out.println("Enter the Major that you want to search : ");
					major = keyBoard.nextLine();
					if (!major.isEmpty() && studentArray.size() > 0) {
						searchStudentByMajor(major);
					} else {
						System.out.println("Enter valid string please....\n\n");
					}
					break;
				case 10:
					if (studentArray != null && studentArray.size() > 0) {
						fileManipulate.writeDataToFile(studentArray);
					} else {
						System.out.println("No data to write...\n\n");
					}

					break;
				case 11:
					fileManipulate.readDataFromFile();
					break;
				case 12:
					if (studentArray != null && studentArray.size() > 0) {
						printStudentData(studentArray);
					} else {
						System.out.println("No data to print...\n\n");
					}
					break;
				default:
					if (choice != 13) {
						System.out.println("Invalid choice.. Please enter valid number..!!!");
					} else {
						System.out.println("Thank you for using our application....!!!");
					}
					break;
				}
			} while (choice != 13);
		} catch (Exception e) {
			System.out.println("The Error is:" + e.getMessage());
		}
	}

	private static void searchStudentByMajor(String major2) {

		ArrayList<Student> searchList = new ArrayList<Student>();
		boolean isFound = false;
		for (Student student : studentArray) {
			if (student.major.equals(major2)) {
				searchList.add(student);
				isFound = true;
			}
		}
		if (isFound) {
			printStudentData(searchList);
		} else {
			System.out.println("There is no data having major = " + major2);
		}

	}

	private static void searchStudentByLastName(String lastName2) {

		ArrayList<Student> searchList = new ArrayList<Student>();
		boolean isFound = false;
		for (Student student : studentArray) {
			if (student.lastName.contains(lastName2)) {
				searchList.add(student);
				isFound = true;
			}
		}

		if (isFound) {
			printStudentData(searchList);
		} else {
			System.out.println("There is no data having LastName including " + lastName2);
		}

	}

	private static void searchStudentByFirstName(String firstName2) {
		ArrayList<Student> searchList = new ArrayList<Student>();
		boolean isFound = false;
		for (Student student : studentArray) {
			if (student.firstName.contains(firstName2)) {
				searchList.add(student);
				isFound = true;
			}
		}
		if (isFound) {
			printStudentData(searchList);
		} else {
			System.out.println("There is no data having FirstName including " + firstName2);
		}
	}

	private static void sortStudentsByMajor() {
		Collections.sort(studentArray, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.major.compareTo(o2.major);
			}
		});
	}

	public static void printStudentData(ArrayList<Student> studentArray2) {

		System.out.println("________________________________________________________________________________________");
		System.out.println("| Student Id | First Name | Last Name |  Major  |  Phone Number  |  GPA  |  Birthdate  |");
		System.out.println("________________________________________________________________________________________");

		for (Student student : studentArray2) {
			System.out.format("|%12d|%12s|%11s|%9s|%16s|%7.2f|%13s|\n", student.studentId, student.firstName,
					student.lastName, student.major, student.phoneNumber, student.gpa,
					student.birthDate.day + "/" + student.birthDate.month + "/" + student.birthDate.year);
		}
		System.out.println("________________________________________________________________________________________");
	}

	private static void sortStudentsByLastName() {
		Collections.sort(studentArray, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.lastName.compareTo(o2.lastName);
			}
		});
	}

	private static void sortStudentsByFirstName() {
		Collections.sort(studentArray, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.firstName.compareTo(o2.firstName);
			}
		});
	}

	private static void deleteStudent(int index) {
		studentArray.remove(index);

	}

	private static void editStudent(int index) {
		System.out.println("Current detail of " + studentArray.get(index).studentId);
		studentArray.get(index).toString();

		System.out.println("Enter First Name: ");
		studentArray.get(index).firstName = keyBoard.nextLine();
		System.out.println("Enter Last Name: ");
		studentArray.get(index).lastName = keyBoard.nextLine();
		System.out.println("Enter Major: ");
		studentArray.get(index).major = keyBoard.nextLine();
		System.out.println("Enter Phone Number: ");
		studentArray.get(index).phoneNumber = keyBoard.nextLine();
		System.out.println("Enter GPA: ");
		studentArray.get(index).gpa = keyBoard.nextDouble();
		keyBoard.nextLine();
		System.out.println("Enter Birthdate in DD/MM/YYYY format: ");
		bDate = keyBoard.nextLine();
		String[] dateFields = bDate.split("/");
		studentArray.get(index).birthDate.day = Short.parseShort(dateFields[0]);
		studentArray.get(index).birthDate.month = Short.parseShort(dateFields[1]);
		studentArray.get(index).birthDate.year = Short.parseShort(dateFields[2]);

		System.out.println("Student data with " + studentArray.get(index).studentId + " is updated....");
	}

	private static void addNewStudent(String firstName, String lastName, String major, String phoneNumber, double gpa,
			BirthDate birthDate) {
		Student newStudent = new Student(firstName, lastName, major, phoneNumber, gpa, birthDate);
		studentArray.add(newStudent);

		System.out.println("Student data has been added.....");
	}

}
