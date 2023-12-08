package ExerciseTrackerV2;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
/*
 * the panel that occupies the west side of our frame
 */
public class ExerciseDetailPanel extends JPanel {
    private JTextField txtName;
    private JTextField txtDate;
    private JTextField txtDuration;
    private JTextField txtDistance;
    private JTextArea tarComment;
    /**
     * This function displays the actual information needed to fill out the exercises such as name and date.
     * It also re-asks the user where if there is an error.
     */
    public void setupGUI() {
        setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new GridLayout(4,2));
        JLabel labN = new JLabel("Name");
        txtName = new JTextField(5);
        JLabel labD = new JLabel("Date");
        txtDate = new JTextField(5);
        JLabel labDu = new JLabel("Duration");
        txtDuration = new JTextField(5);
        JLabel labDi = new JLabel("Distance: ");
        txtDistance = new JTextField(5);
        panNorth.add(labN);
        panNorth.add(txtName);
        panNorth.add(labD);
        panNorth.add(txtDate);
        panNorth.add(labDu);
        panNorth.add(txtDuration);
        panNorth.add(labDi);
        panNorth.add(txtDistance);
        add(panNorth,BorderLayout.NORTH);
        JPanel panComment = new JPanel();
        panComment.setLayout(new BorderLayout());
        JLabel labComment = new JLabel("Add Comment");
        panComment.add(labComment,BorderLayout.NORTH);
        tarComment = new JTextArea(5,10);
        panComment.add(tarComment,BorderLayout.CENTER);
        add(panComment,BorderLayout.CENTER);
    }
    public ExerciseDetailPanel() {
        setupGUI();
    }
    public String getName() {
        return txtName.getText();
    }
    public Date getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat ("mm/dd/yyyy");
        try {
        	return sdf.parse(txtDate.getText());
        }catch (ParseException ex) {
        	ex.printStackTrace();
        	return null;
        }
    }
    public double getDuration() {
        return Double.parseDouble(txtDuration.getText());
    }
    public String getComment() {
        return tarComment.getText();
    }
    public double getDistance() {
    	return Double.parseDouble(txtDistance.getText());
    }
    public void clearEntries() {
        txtName.setText("");
        txtDate.setText("");
        txtDuration.setText("");
        txtDistance.setText("");
        tarComment.setText("");
    }
    public void enableEntries(boolean enableYN) {
        txtName.setEnabled(enableYN);
        txtDate.setEnabled(enableYN);
        txtDuration.setEnabled(enableYN);
        txtDistance.setEnabled(enableYN);
        tarComment.setEnabled(enableYN);
    }
}
