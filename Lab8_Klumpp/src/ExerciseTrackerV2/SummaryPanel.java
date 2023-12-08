package ExerciseTrackerV2;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.util.ArrayList;

public class SummaryPanel extends JPanel {
    private ArrayList<Exercise> exercises;
    private JTextArea tarSummary;
    /**
     * This is where the the exercise summary will be alloweed to be displayed
     * @param totalCalBurned
     */
    public void setupGUI(double totalCalBurned) {
        setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new FlowLayout());
        JLabel lblSummary = new JLabel("Exercise Summary " + "(" + (getCaloriesBurned(exercises)) + " burned" + ")");
        panNorth.add(lblSummary);
        add(panNorth,BorderLayout.NORTH);
        tarSummary = new JTextArea(10,30);
        tarSummary.setEditable(false);
        add(tarSummary,BorderLayout.CENTER);
    }
    public double getCaloriesBurned(ArrayList<Exercise> exercises) {
    	double totalCaloriesBurned = 0;
    	for (Exercise exercise : exercises) {
    		totalCaloriesBurned += exercise.getCaloriesBurned();
    	}
    	return totalCaloriesBurned;
    }
    public SummaryPanel(ArrayList<Exercise> exercises) {
        double totalCalBurned = 0;
    	for(Exercise Exercise: exercises ) {
        	totalCalBurned = Exercise.getCaloriesBurned(); 
        }
    	this.exercises = exercises;
        setupGUI(totalCalBurned);
    }
    public void updateList() {
        tarSummary.setText("");
        String text = "";
        for (Exercise e : exercises) {
            text = text + e + "\n";
        }
        tarSummary.setText(text);
    }
}
