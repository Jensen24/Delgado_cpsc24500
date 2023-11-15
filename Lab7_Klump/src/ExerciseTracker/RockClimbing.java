package ExerciseTracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RockClimbing extends Exercise {
	
	private String rockName;
	private Date rockDate;
	private int rockMin;
	private double rockHeight;
	private int rockReps;
	private String rockCom;
	private Double Calorie;
	
	public Double getCalorie() {
		return Calorie;
	}
	public void setCalorie() {
		Calorie = ((rockHeight * rockReps) / rockMin) * 100 ;
	}
	public String getRockName() {
		return rockName;
	}
	public void setRockName(String rockName) {
		this.rockName = rockName;
	}
	public Date getRockDate() {
		return rockDate;
	}
	public void setRockDate(String rockDates) {
		try {
			rockDate = new SimpleDateFormat("MM/dd/yyyy").parse(rockDates);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getRockMin() {
		return rockMin;
	}
	public void setRockMin(int rockMin) {
		this.rockMin = rockMin;
	}
	public String getRockCom() {
		return rockCom;
	}
	public void setRockCom(String rockCom) {
		this.rockCom = rockCom;
	}
	public double getrockHeight() {
		return rockHeight;
	}
	public void setrockHeight(double rockHeight) {
		this.rockHeight = rockHeight;
	}
	public int getrockReps() {
		return rockReps;
	}
	public void setrockReps(int rockReps) {
		this.rockReps = rockReps;
	}
	public RockClimbing(String rockName, String rockDate, int rockMin, Double rockHeight, int rockReps ,String rockCom) {
		super();
		// TODO Auto-generated constructor stub
		setRockName(rockName);
		setRockDate(rockDate);
		setRockMin(rockMin);
		setrockHeight(rockHeight);
		setrockReps(rockReps);
		setRockCom(rockCom);
		setCalorie();
	}
	/**
	 * This is where the info will be displayed when asked for option 3/4
	 */
	@Override
	public String toString() {
		return "rockclimbing" + "	" + rockName + "	" + rockDate + "	" + Calorie ;
	}
	public double calculateCalories() {
		return rockReps;
		
	}
}
