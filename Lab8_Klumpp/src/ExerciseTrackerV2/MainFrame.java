package ExerciseTrackerV2;
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
    private ArrayList<Exercise> exercises;
    private ExerciseDetailPanel edp;
    private JButton btnAddExercise;
    private JMenuItem miLogin;
    private JMenuItem miLogout;
    /**
     * This function adds the "exercise" button that allows you to store information
     */
    public void setupGUI() {
    	setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exercises");
        Container e = getContentPane();
        e.setLayout(new BorderLayout());
        edp = new ExerciseDetailPanel();
        SummaryPanel sumPan = new SummaryPanel(exercises);
        e.add(edp,BorderLayout.WEST);
        e.add(sumPan,BorderLayout.EAST);
        JPanel panSouth = new JPanel();
        btnAddExercise = new JButton("Add Exercise");
        btnAddExercise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = null;
                Date date = null;
				double duration = 0;
				double distance = 0;
                ArrayList<String> errors = new ArrayList<String>();
               try {
                    name = edp.getName();
                } catch (Exception ex) {
                    errors.add("The Name must be letters");
                }
                try {
                    date = edp.getDate();
                } catch (Exception ex) {
                    errors.add("The date must be a number.");
                }
                try {
                    duration = edp.getDuration();
                } catch (Exception ex) {
                    errors.add("The duration must be a number.");
                }
                try {
                	distance = edp.getDistance();
                }catch (Exception ex) {
                	errors.add("The distance must be a number");
                }
                String comment = edp.getComment();
                String errorMessage = "";
                if (errors.size() > 0) {
                    for (String error : errors) {
                        errorMessage = errorMessage + error + " ";
                    }
                    JOptionPane.showMessageDialog(null,"These errors occured: " + errorMessage);
                } else {
                    //Exercise e = new Exercise(name, date, duration, comment);
                    RunWalk r = new RunWalk(name, date, duration, distance, comment);
                    exercises.add(r);
                    sumPan.updateList();
                    edp.clearEntries();
                    repaint();  // Updates what is shown on the constructed frame
                }
            }
        });
        panSouth.setLayout(new FlowLayout());
        panSouth.add(btnAddExercise);
        e.add(panSouth,BorderLayout.SOUTH);
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
        JMenuItem miLogin = new JMenuItem("Log in");
        miLogin.addActionListener(this);
        JMenuItem miLogout = new JMenuItem("Log out");
        miLogout.addActionListener(this);
        JMenuItem miSave = new JMenuItem("Save");
        JMenuItem miExit = new JMenuItem("Exit");
        mnuFile.add(miLogin);
        mnuFile.add(miLogout);
        mnuFile.add(miSave);
        mnuFile.add(miExit);
        
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JMenuItem miAbout = new JMenuItem("About");
        mnuHelp.add(miAbout);
        miAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Exercise Tracker V2, Created December 2023 \n This Tracker is meant to store exercises that you have completed. Merry Christmas!");
            }
        });
        
        miSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                File f;
                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    f = chooser.getSelectedFile();
                    if (ExerciseWriter.writeToFile(f,exercises)) {
                        JOptionPane.showMessageDialog(null,"Exercises were saved.");
                    } else {
                        JOptionPane.showMessageDialog(null,"Exercises were not saved.");
                    }
                }
            }
        });
        /**
         * These functions allow the buttons to be clickable
         */
    }
    public MainFrame(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
        setupGUI();
    }
    public void enableControls(boolean enableYN) {
        edp.enableEntries(enableYN);
        btnAddExercise.setEnabled(enableYN);
    }
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == miLogin) {
    		LoginForm dlgLogin = new LoginForm(this, "Log in", true);
    		dlgLogin.setVisible(true);
    		if (dlgLogin.isLoggedIn()) {
    			enableControls(true);
    		}else {
    			enableControls(false);
    		}
    	//}else {
    		//enableControls(false);
    	}
    }
}
