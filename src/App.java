import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.Arrays;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class App {
    private JFrame root;
    private DBcon kerndb;
    private JPanel LogoP;
    private JPanel loginP;
    private JPanel buttonP;

    App(){
        start();
        kerndb = new DBcon();
    }



    public void start(){
        root = new JFrame();
        root.setTitle("Kernbohrung-DB");
        root.setDefaultCloseOperation(EXIT_ON_CLOSE);
        root.setSize(550,450);
        root.setLocationRelativeTo(null);
        loginPanle();
        ImageIcon logoMini = new ImageIcon("C:\\Users\\lolos\\IdeaProjects\\Kerni_DB\\src\\Logo.jpg");
        Image mini = logoMini.getImage();
        root.setIconImage(mini);
        root.setVisible(true);
    }

    public void loginPanle(){
        root.setLayout(new GridLayout(3,0));
        LogoP = new JPanel();
        JLabel LogoL = new JLabel();

        ImageIcon logo = new ImageIcon("C:\\Users\\lolos\\IdeaProjects\\Kerni_DB\\src\\logo.png");
        Image logo2 = logo.getImage();
        Image newimg = logo2.getScaledInstance(220, 220,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon logofin = new ImageIcon(newimg);
        LogoL.setIcon(logo);
        LogoP.add(LogoL);
        root.add(LogoP);

        loginP = new JPanel();
        buttonP = new JPanel();
        loginP.setBorder(new LineBorder(Color.BLACK));
        JTextField user = new JTextField();
        user.setColumns(20);
        JPasswordField pass = new JPasswordField();
        pass.setColumns(20);
        //pass.setMargin(new Insets(10,10,10,10));
        JLabel userL = new JLabel();
        userL.setText("Bitte Geben Sie Ihren DB Usernamen ein : ");
        JLabel passL = new JLabel();
        passL.setText("Bitte Geben Sie Ihren DB Passwort ein :");
        loginP.setLayout(new GridLayout(4,0));
        loginP.add(userL);
        loginP.add(user);
        loginP.add(passL);
        loginP.add(pass);
        root.add(loginP);
        //buttonP.setLayout(new GridLayout(1,0));
        JButton LoginB = new JButton("Login");
        JButton CleatB = new JButton("Abbrechen");

        LoginB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Passwort = "";
                char[] prePass = pass.getPassword();
                Passwort = new String(prePass);

                if(Passwort.equals("")){
                    JOptionPane.showMessageDialog(loginP,"Bitte Passwort eingeben");
                }else {

                    
                    try {
                        String succ = kerndb.Verbingun(user.getText(), Passwort);
                        Passwort = "";
                        if (succ.equals("succ")) {
                            root.remove(loginP);
                            root.remove(LogoP);
                            root.remove(buttonP);
                            root.setSize(900, 900);
                            mngm_panel();

                        } else {
                            JOptionPane.showMessageDialog(loginP, "Passwort oder Username Falsch!");
                        }

                    } catch (Exception y) {
                        JOptionPane.showMessageDialog(loginP, "Passwort oder Username Falsch!");
                    }


                }






            }
        });






        buttonP.add(LoginB);
        buttonP.add(CleatB);



        root.add(buttonP);



    }

    public void mngm_panel(){
        root.setLayout(new BorderLayout());
        JPanel Speichern = new JPanel();
        JPanel Suchen  = new JPanel();
        JPanel Drucken  = new JPanel();
        JPanel Preise = new JPanel();
        JPanel Irgendwas = new JPanel();

        JTabbedPane Menu = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT );
        Menu.addTab("Speicher",Speichern);
        Menu.addTab("Suchen",Suchen);
        Menu.addTab("Drucken",Drucken);
        Menu.addTab("Preis Liste",Preise);
        Menu.addTab("Tab",Irgendwas);

        root.add(Menu);
















    }














}
