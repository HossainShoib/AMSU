import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UMSGUI {
    private JFrame frame;
    private LoginPanel loginPanel;
    private AdminMenuPanel adminMenuPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new UMSGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UMSGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add an icon to the middle of the window
        ImageIcon icon = new ImageIcon("logo.png"); // Replace "your_icon.png" with the path to your icon image
        JLabel iconLabel = new JLabel(icon);
        frame.getContentPane().add(iconLabel, BorderLayout.CENTER);

        loginPanel = new LoginPanel(this);
        frame.getContentPane().add(loginPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void showAdminMenu() {
        frame.getContentPane().removeAll();

        adminMenuPanel = new AdminMenuPanel(this);
        frame.getContentPane().add(adminMenuPanel, BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();
    }

    public JFrame getFrame() {
        return frame;
    }
}

class LoginPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private UMSGUI parent;

    public LoginPanel(UMSGUI parent) {
        this.parent = parent;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblUsername = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblUsername, gbc);

        usernameField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(usernameField, gbc);

        JLabel lblPassword = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(lblPassword, gbc);

        passwordField = new JPasswordField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(passwordField, gbc);

        JButton btnLogin = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        add(btnLogin, gbc);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (Login.authenticate(username, password)) {
                    parent.showAdminMenu();
                } else {
                    JOptionPane.showMessageDialog(parent.getFrame(), "Authentication failed. Invalid username or password.");
                }
            }
        });
    }
}

class AdminMenuPanel extends JPanel {
    private UMSGUI parent;

    public AdminMenuPanel(UMSGUI parent) {
        this.parent = parent;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton btnAddTeacher = new JButton("Add Teacher");
        btnAddTeacher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle add teacher action
                JOptionPane.showMessageDialog(parent.getFrame(), "Add Teacher functionality not implemented yet.");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(btnAddTeacher, gbc);

        JButton btnViewTeachers = new JButton("View Teachers");
        btnViewTeachers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle view teachers action
                JOptionPane.showMessageDialog(parent.getFrame(), "View Teachers functionality not implemented yet.");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(btnViewTeachers, gbc);

        JButton btnAddStudent = new JButton("Add Student");
        btnAddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle add student action
                JOptionPane.showMessageDialog(parent.getFrame(), "Add Student functionality not implemented yet.");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(btnAddStudent, gbc);

        JButton btnViewStudents = new JButton("View Students");
        btnViewStudents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle view students action
                JOptionPane.showMessageDialog(parent.getFrame(), "View Students functionality not implemented yet.");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(btnViewStudents, gbc);
    }
}
