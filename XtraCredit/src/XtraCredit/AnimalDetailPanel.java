package XtraCredit;

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
public class AnimalDetailPanel extends JPanel {
    private JTextField txtDate;
    private JTextField txtBird;
    private JTextField txtDog;
    private JTextField txtSquirel;
    /**
     * This function displays the actual information needed to fill out the exercises such as name and date.
     * It also re-asks the user where if there is an error.
     */
    public void setupGUI() {
        setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new GridLayout(4,2));
        JLabel labD = new JLabel("Date");
        txtDate = new JTextField(5);
        JLabel labB = new JLabel("# of Birds:");
        txtBird = new JTextField(5);
        JLabel labDo = new JLabel("# of Dogs: ");
        txtDog = new JTextField(5);
        JLabel labS = new JLabel("# of Squirels: ");
        txtSquirel = new JTextField(5);
        panNorth.add(labD);
        panNorth.add(txtDate);
        panNorth.add(labB);
        panNorth.add(txtBird);
        panNorth.add(labDo);
        panNorth.add(txtDog);
        panNorth.add(labS);
        panNorth.add(txtSquirel);
        add(panNorth,BorderLayout.NORTH);
    }
    public AnimalDetailPanel() {
        setupGUI();
    }
    public Date getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat ("MM/dd/yyyy");
        try {
        	return sdf.parse(txtDate.getText());
        }catch (ParseException ex) {
        	ex.printStackTrace();
        	return null;
        }
    }
    public int getBird() {
        return Integer.parseInt(txtBird.getText());
    }
    public int getDog() {
    	return Integer.parseInt(txtDog.getText());
    }
    public int getSquirel() {
    	return Integer.parseInt(txtSquirel.getText());
    }
    public void clearEntries() {
        txtDate.setText("");
        txtBird.setText("");
        txtDog.setText("");
        txtSquirel.setText("");
    }
    public void enableEntries(boolean enableYN) {
        txtDate.setEnabled(enableYN);
        txtBird.setEnabled(enableYN);
        txtDog.setEnabled(enableYN);
        txtSquirel.setEnabled(enableYN);
    }
}