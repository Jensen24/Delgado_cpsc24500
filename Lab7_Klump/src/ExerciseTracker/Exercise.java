package ExerciseTracker;

import java.util.Date;

public abstract class Exercise implements Comparable<Exercise>{
	
	private String name;
	private String comment;
	private int duration;
	private Date date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Exercise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Exercise [name=" + name + ", comment=" + comment + ", duration=" + duration + ", date=" + date + "]";
	}
	public abstract double calculateCalories();
	/**
	 * This function sorts the exercises by their dates
	 */
	@Override
	public int compareTo(Exercise other) {
		Long ourTime = getDate().getTime();
		Long otherTime = other.getDate().getTime();
		if(ourTime > otherTime) {
			return -1;
		} else if (ourTime == otherTime) {
			return 0;
		} else {
			return 1;
		}
	}
	public String toFileFriendlyString() {
		// TODO Auto-generated method stub
		return null;
	}
}
