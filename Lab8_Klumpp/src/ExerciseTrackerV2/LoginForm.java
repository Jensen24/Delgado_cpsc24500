package ExerciseTrackerV2;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JDialog {
    private boolean loggedIn;
    private String user;
    private String password;
    /**
     * This function houses many features such as password and username storage and also re asks the user
     * if the password is either right or wrong
     */
    public void setupGUI() {
        setBounds(300,300,300,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panCenter = new JPanel();
        panCenter.setLayout(new FlowLayout());
        
      panCenter.add(new JLabel("Username: "));
       JTextField txtUser = new JTextField(10);
        panCenter.add(txtUser);
        c.add(panCenter,BorderLayout.CENTER);
        
        panCenter.setLayout(new FlowLayout());
        panCenter.add(new JLabel("Username: "));
        panCenter.add(txtUser);
        c.add(panCenter,BorderLayout.CENTER);
        
        panCenter.add(new JLabel("Password: "));
        JPasswordField txtPassword = new JPasswordField(10);
        panCenter.add(txtPassword);
        c.add(panCenter,BorderLayout.CENTER);
        
        JPanel panSouth = new JPanel();
        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredUser = new String(txtUser.getText());
                String enteredPassword = new String(txtPassword.getPassword());
                if (enteredPassword.equals(password) && enteredUser.equals(user)) {
                    loggedIn = true;
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"You entered an incorrect password.");
                }
            }
        });
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loggedIn = false;
                setVisible(false);
            }
        });
        panSouth.setLayout(new FlowLayout());
        panSouth.add(btnOK);
        panSouth.add(btnCancel);
        c.add(panSouth,BorderLayout.SOUTH);
    }
    public LoginForm(JFrame owner, String title, boolean modal) {
        super(owner,title,modal);
        setupGUI();
        loggedIn = false;
        user = "healthy";
        password = "donut";
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
}
