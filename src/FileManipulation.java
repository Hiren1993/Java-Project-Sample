import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManipulation {

	boolean isWritten = false;
	StudentOperation studentOperationObject = new StudentOperation();

	public void writeDataToFile(ArrayList<Student> studentArrayList) throws IOException {
		try {
			FileOutputStream foStream = new FileOutputStream("StudentData.dat");
			ObjectOutputStream outStream = new ObjectOutputStream(foStream);
			outStream.writeObject(studentArrayList);
			System.out.println("Data is Written successfully....\n\n");
			isWritten = true;
			outStream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void readDataFromFile() throws IOException {

		if (isWritten) {
			try {
				FileInputStream fiStream = new FileInputStream("StudentData.dat");
				ObjectInputStream inStream = new ObjectInputStream(fiStream);
				ArrayList<Student> list = (ArrayList<Student>) inStream.readObject();
				if (list.size()>0 && list!=null) {
					studentOperationObject.printStudentData(list);	
				}
				else
				{
					System.out.println("No data in the file.....\n\n");
				}
				
				inStream.close();
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Write the student data first....");
		}
	}
}
