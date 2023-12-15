package XtraCredit;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public class Encounters implements Serializable {
	private Date date;
	private int bird;
	private int dog;
	private int squirel;
	private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * sets date to current date
	 */
	public void setDate() {
		this.date = new Date(); // current date
	}
	public void setDate(String date) {
		try {
			this.date = df.parse(date);
		} catch (Exception ex) {
			this.date = new Date(); // now
		}
	}
	public int getBird() {
		return bird;
	}

	public int getDog() {
		return dog;
	}
	public int getSquirel() {
		return squirel;
	}
	
	public Encounters() {
		date = null;
		bird = 0;
		dog = 0;
		squirel = 0;
	}

	public void setBird(int bird) {
		if (bird < 0) {
			this.bird = 0;
		} else {
			this.bird = bird;
		}
	}
	public void setDog(int dog) {
		if (dog < 0) {
			this.dog = 0;
		} else {
			this.dog = dog;
		}
	}
	/*public Encounters() {
		setDate();
		setBird(0);
		setDog(0);
		setSquirel(0);
	}*/
	@Override
	public String toString() {
		return String.format("%s\tBirds: %d\tDogs: %d\tSquirrels: %d", getDateAsString(), getBird(), getDog(), getSquirel());
	}
	private String getDateAsString() {
		return df.format(date);
	}
	public Encounters(Date date, int bird, int dog, int squirel) {
		setDate(date);
		setBird(bird);
		setDog(dog);
		setSquirel(squirel);
	}
	public void setSquirel(int squirel) {
		if (squirel < 0) {
			this.squirel = 0;
		} else {
			this.squirel = squirel;
		}
	}
	public String toSummaryString() {
		return String.format("%-20s%-25d%-15d%10d",getDateAsString(),bird,dog,squirel);
	}
	
}
