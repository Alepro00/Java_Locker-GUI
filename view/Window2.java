package view;

import control.KeyListener;
import control.CheckPasswordListener;

import javax.swing.*;
import java.awt.*;

public class Window2 extends JFrame{


    JPasswordField passwordField=new JPasswordField(20);

    JPanel titlePanel=new JPanel(), passwordPanel=new JPanel(), submitPanel=new JPanel();
    JLabel titleLabel=new JLabel("Cassaforte", SwingConstants.CENTER),
            passwordLabel=new JLabel("Password", SwingConstants.LEFT);

    public JLabel keyLabel=new JLabel();
    public JButton submit=new JButton("Submit");
    public JLabel passwordCheckLabel=new JLabel();


    public void initUI() {
        titlePanel.add(titleLabel);
        passwordPanel.add(passwordLabel); passwordPanel.add(passwordField); passwordPanel.add(keyLabel);
        submitPanel.add(submit);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Window2(Window1 finestra){

        super("Cassaforte");
        initUI();

        submit.addActionListener(new CheckPasswordListener(finestra,this));
        passwordField.addKeyListener(new KeyListener(finestra,this));

        Container c=this.getContentPane();
        c.setLayout(new GridLayout(4,2));
        c.add(this.titlePanel);
        c.add(this.passwordPanel);
        c.add(this.submitPanel);
        c.add(this.passwordCheckLabel);
        this.setMinimumSize(new Dimension(400,400));
        this.setLocation(550,200);
        this.setVisible(true);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public String getPassword() {
        return String.valueOf(passwordField.getPassword());
    }

}
