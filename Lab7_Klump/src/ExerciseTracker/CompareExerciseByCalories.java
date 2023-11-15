package ExerciseTracker;

import java.util.Comparator;

public class CompareExerciseByCalories implements Comparator<Exercise> {

	/**
	 * This function sorts the exercises by their calories
	 */
	@Override
	public int compare(Exercise o1, Exercise o2) {
		double cal1 = o1.calculateCalories();
		double cal2 = o2.calculateCalories();
		if (cal1 < cal2) {
			return -1;
		}else if (cal1 == cal2) {
			return 0;
		}else {
			return 1;
		}
	}
}
