package ExerciseTracker;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class WeightLifting extends Exercise {
	
	private String weightName;
	private Date weightDate;
	private int weightMin;
	private Double weightPound;
	private String weightCom;
	private Double Calorie;

	public Double getCalorie() {
		return Calorie;
	}

	public void setCalorie() {
		Calorie = (weightPound/weightMin) * 50;
	}

	public double getWeightPound() {
		return weightPound;
	}

	public void setWeightPound(double poundsLifted) {
		this.weightPound = poundsLifted;
	}

	public String getWeightName() {
		return weightName;
	}

	public void setWeightName(String weightName) {
		this.weightName = weightName;
	}

	public Date getWeightDate() {
		return weightDate;
	}

	public void setWeightDate(String weightDates) {
		try {
			weightDate = new SimpleDateFormat("MM/dd/yyyy").parse(weightDates);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getWeightMin() {
		return weightMin;
	}

	public void setWeightMin(int weightMin) {
		this.weightMin = weightMin;
	}

	public String getWeightCom() {
		return weightCom;
	}

	public void setWeightCom(String weightCom) {
		this.weightCom = weightCom;
	}

	public WeightLifting(String weightName, String weightDate, int weightMin, Double weightPound, String weightCom) {
		super();
		// TODO Auto-generated constructor stub
		setWeightName(weightName);
		setWeightDate(weightDate);
		setWeightMin(weightMin);
		setWeightPound(weightPound);
		setWeightCom(weightCom);
		setCalorie();
	}
	/**
	 * This is where the info will be displayed when asked for option 3/4
	 */
	@Override
	public String toString() {
		return "weightlifting" + "	" + weightName + "	" + weightDate + "	" + Calorie;
	}
public double calculateCalories(){
	return weightPound;
	
}
}
