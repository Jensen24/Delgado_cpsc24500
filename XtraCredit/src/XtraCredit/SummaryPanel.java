package XtraCredit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import XtraCredit.Encounters;

public class SummaryPanel extends JPanel {
    private ArrayList<Encounters> animals;
    private JTextArea tarSummary;
 
    /**
     * This is where the the animal summary will be allowed to be displayed
     * @param totalAnimals
     */
    public void setupGUI(int totalAnimals) {
        setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new FlowLayout());
        JLabel lblSummary = new JLabel("Animal Encounters");
        panNorth.add(lblSummary);
        add(panNorth,BorderLayout.NORTH);
        tarSummary = new JTextArea(10,30);
        tarSummary.setEditable(false);
        add(tarSummary,BorderLayout.CENTER);
    }
   public SummaryPanel(ArrayList<Encounters> animals) {
	   int totalAnimals = 0;
	   for(Encounters animal : animals) {
		   int total = animal.getBird() + animal.getDog() + animal.getSquirel();
		   totalAnimals += total;
	   }
	   this.animals = animals;
	   setupGUI(totalAnimals);
	   //Date	Bird:number	Dog:number	:number total:number
   }
    public void updateList() {
        tarSummary.setText("");
        String text = "";
        for (Encounters a : animals) {
            text = text + a + "\n";
        }
        tarSummary.setText(text);
    }
}