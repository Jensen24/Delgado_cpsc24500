package ExerciseTrackerV2;

import java.util.Date;

import ExerciseTrackerV2.Exercise;

public class RunWalk extends Exercise {
	private double distance;
	public RunWalk(String name, Date date, double duration, String comment) {
		distance = 0;
	}
	public RunWalk(String name, Date date, double duration, double distance, String comment) {
		super(name,date,duration,distance,comment);
		setDistance(distance);
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		if (distance < 0) {
			this.distance = 0;
		} else {
			this.distance = distance;
		}
	}
	@Override
	public String getType() {
		return "runwalk";
	}
	@Override
	public double getCaloriesBurned() {
		return distance/getDuration() * 9000;
	}
	@Override
	public String toStringCustomInfo() {
		return String.format("%.2f",distance);
	}
}
