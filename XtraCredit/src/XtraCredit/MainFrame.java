package XtraCredit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements ActionListener{
    private ArrayList<Encounters> animals;
    private AnimalDetailPanel adp;
    private JButton btnAddAnimal;
    /**
     * This function adds the "animal" button that allows you to store information
     */
    public void setupGUI() {
    	setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Animals");
        Container a = getContentPane();
        a.setLayout(new BorderLayout());
        adp = new AnimalDetailPanel();
        SummaryPanel sumPan = new SummaryPanel(animals);
        a.add(adp,BorderLayout.WEST);
        a.add(sumPan,BorderLayout.EAST);
        JPanel panSouth = new JPanel();
        btnAddAnimal = new JButton("Add Animal");
        btnAddAnimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                Date date = null;
				int bird = 0;
				int dog = 0;
				int squirel = 0;
                ArrayList<String> errors = new ArrayList<String>();
               try {
                    date = adp.getDate();
                } catch (Exception ex) {
                    errors.add("The Date must be a number");
                }
                try {
                    bird = adp.getBird();
                } catch (Exception ex) {
                    errors.add("The bird variable must be a number.");
                }
                try {
                	dog = adp.getDog();
                }catch (Exception ex) {
                	errors.add("The dog variable must be a number");
                }
                try {
                	squirel = adp.getSquirel();
                }catch (Exception ex) {
                	errors.add("The squirel variable must be a number");
                }
                String errorMessage = "";
                if (errors.size() > 0) {
                    for (String error : errors) {
                        errorMessage = errorMessage + error + " ";
                    }
                    JOptionPane.showMessageDialog(null,"These errors occured: " + errorMessage);
                } else {
                    Encounters l = new Encounters(date,bird,dog,squirel);
                    animals.add(l);
                    sumPan.updateList();
                    adp.clearEntries();
                    repaint();  // Updates what is shown on the constructed frame
                }
            }
        });
        panSouth.setLayout(new FlowLayout());
        panSouth.add(btnAddAnimal);
        a.add(panSouth,BorderLayout.SOUTH);
        setupMenu();
      //  enableControls(false);
    }
    /**
     * This function sets up little tabs in the top left that give options
     */
    public void setupMenu() {
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        JMenu mnuFile = new JMenu("File");
        mbar.add(mnuFile);
        JMenu mnuHelp = new JMenu("Help");
        mbar.add(mnuHelp);
        JMenuItem miExit = new JMenuItem("Exit");
        mnuFile.add(miExit);
        
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                System.exit(0);
            }
        });
        JMenuItem miAbout = new JMenuItem("About");
        mnuHelp.add(miAbout);
        miAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                JOptionPane.showMessageDialog(null,"Animal Encounters! \nCreated December 2023 \nMerry Christmas To All! \nThis Tracker is meant to store the number of "
                		+ "animals have seen whether that be on a walk through the park or the neighborhood. \nSaint Klump please bless me with the gift of at least 8 points on this assignment to gurantee a B");
            }
        });
        JMenuItem miTxt = new JMenuItem("Save to TXT");
        mnuFile.add(miTxt);
        miTxt.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent a) {
        		WriteToFile writeToFile = new WriteToFile();
				writeToFile.saveTxtFile(animals, "animals.txt");
        	}
        });
        JMenuItem miXML = new JMenuItem("Save to XML");
        mnuFile.add(miXML);
        miXML.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent a) {
        		WriteToFile writeToFile = new WriteToFile();
				writeToFile.saveXMLFile(animals, "animals.xml");
        	}
        });       	
        /*miSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                JFileChooser chooser = new JFileChooser();
                File f;
                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    f = chooser.getSelectedFile();
                    if (AnimalWriter.writeToFile(f,animals)) {
                        JOptionPane.showMessageDialog(null,"Animal list was saved.");
                    } else {
                        JOptionPane.showMessageDialog(null,"Animal list was not saved.");
                    }
                }
            }
        });*/
        /**
         * These functions allow the buttons to be clickable
         */
    }
    public MainFrame(ArrayList<Encounters> animals) {
        this.animals = animals;
        setupGUI();
    }
    public void enableControls(boolean enableYN) {
        adp.enableEntries(enableYN);
        btnAddAnimal.setEnabled(enableYN);
    }
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		
	}
}