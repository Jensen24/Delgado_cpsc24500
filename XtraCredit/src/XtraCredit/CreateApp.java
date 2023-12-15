package XtraCredit;

import java.util.ArrayList;

import XtraCredit.Encounters;
import XtraCredit.MainFrame;

/**
 * This allows the actual application to be opened
 * @author Nicolas Delgado
 *
 */
public class CreateApp {
	public static void main(String args[]) {
	 ArrayList<Encounters> animals = new ArrayList<>();
     MainFrame pf = new MainFrame(animals);
     pf.setVisible(true);
 }
}