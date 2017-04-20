import java.io.Serializable;

public class BirthDate implements Serializable {

	short day;
	// enum Month {January, February, March, April, May, June, July, August,
	// September, October, November, December}
	short month;
	int year;

	public short getDay() {
		return day;
	}

	public void setDay(short day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
