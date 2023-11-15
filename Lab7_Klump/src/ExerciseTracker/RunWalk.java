package ExerciseTracker;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RunWalk extends Exercise {
	
	private String runName;
	private Double runDist;
	private Date runDate;
	private int runMin;
	private String runCom;
	private Double Calorie;

	public Double getCalorie() {
		return Calorie;
	}

	public void setCalorie() {
		Calorie = (runDist/runMin) * 9000;
	}

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(String runDates) {
		try {
			runDate = new SimpleDateFormat("MM/dd/yyyy").parse(runDates);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getRunMin() {
		return runMin;
	}

	public void setRunMin(int runMin) {
		this.runMin = runMin;
	}

	public String getRunCom() {
		return runCom;
	}

	public void setRunCom(String runCom) {
		this.runCom = runCom;
	}

	public double getrunDist() {
		return runDist;
	}

	public void setrunDist(double distance) {
		this.runDist = distance;
	}
	
	public void setrunName(String runName) {
		this.runName = runName;
	}
	public String getrunName() {
		return runName;
		
	}

	public RunWalk(String runName, String runDate, int runMin, Double runDist, String runCom) {
		super();
		// TODO Auto-generated constructor stub
		setrunName(runName);
		setRunDate(runDate);
		setRunMin(runMin);
		setrunDist(runDist);
		setRunCom(runCom);
		setCalorie();
	}
	/**
	 * This is where the info will be displayed when asked for option 3/4
	 */
	@Override
	public String toString() {
		return "runwalk" + " " + runName + " " + runDate + " " + Calorie;
	}
public double calculateCalories() {
	return runDist;
	
}

}
