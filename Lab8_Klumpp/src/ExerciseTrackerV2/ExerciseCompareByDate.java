package ExerciseTrackerV2;

import java.util.Comparator;
import java.util.Date;

import ExerciseTrackerV2.Exercise;
public class ExerciseCompareByDate implements Comparator<Exercise> {
	@Override
	public int compare(Exercise ex1, Exercise ex2) {
		Date d1 = ex1.getDate();
		Date d2 = ex2.getDate();
		return d1.compareTo(d2);
	}
}
