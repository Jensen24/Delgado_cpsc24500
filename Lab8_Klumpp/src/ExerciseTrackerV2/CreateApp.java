package ExerciseTrackerV2;

import java.util.ArrayList;

/**
 * This allows the actual application to be opened
 * @author Nicolas Delgado
 *
 */
public class CreateApp {
	public static void main(String args[]) {
	 ArrayList<Exercise> exercises = new ArrayList<>();
     MainFrame pf = new MainFrame(exercises);
     pf.setVisible(true);
 }
}
