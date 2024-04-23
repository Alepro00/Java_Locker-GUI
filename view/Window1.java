package view;

import control.ButtonListener;
import control.KeyListener;
import control.VerifyPasswordListener;

import javax.swing.*;
import java.awt.*;

public class Window1 extends JFrame{

    JPasswordField passwordField=new JPasswordField(20);
    JPanel titlePanel=new JPanel(), messagePanel=new JPanel(), passwordPanel=new JPanel(), submitPanel=new JPanel();
    JLabel titleLabel=new JLabel("Cassaforte", SwingConstants.CENTER), messageLabel=new JLabel("Messaggio"),
            passwordLabel=new JLabel("Password"), checkPasswordLabel=new JLabel();
    JTextArea messageArea=new JTextArea(5,20);
    JScrollPane scroll=new JScrollPane();
    public JButton submit=new JButton("Submit");

    public static void start(){
        new Window1();
    }

    public void initUI(){

        scroll.setViewportView(messageArea);

        titlePanel.add(titleLabel);
        messagePanel.add(messageLabel); messagePanel.add(scroll);
        passwordPanel.add(passwordLabel); passwordPanel.add(passwordField); passwordPanel.add(checkPasswordLabel);
        submitPanel.add(submit);

        messageArea.setBorder(BorderFactory.createLineBorder(Color.black));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.black));

        passwordField.addKeyListener(new KeyListener(this,null));
        passwordField.getDocument().addDocumentListener(new VerifyPasswordListener(this));
        submit.addActionListener(new ButtonListener(this));
    }

    public Window1(){

        super("Cassaforte");

        initUI();

        Container c=this.getContentPane();
        c.setLayout(new GridLayout(4,2));
        c.add(titlePanel);
        c.add(messagePanel);
        c.add(passwordPanel);
        c.add(submitPanel);

        //this.dispose();
        this.setMinimumSize(new Dimension(400,400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(550,200);
        this.setSize(400,400);

    }

    public String getPassword() {
        return String.valueOf(passwordField.getPassword());
    }

    public String getMessaggio() {
        return messageArea.getText();
    }

    public void setPasswordArea(int i){
        final Color color = i == 1 ? Color.RED : i == 2 ? Color.ORANGE : Color.GREEN;
        checkPasswordLabel.setForeground(color);
        checkPasswordLabel.setText(i==1 ? "Scarsa" : i==2 ? "Media" : "Sicura");
        this.passwordField.setBorder(BorderFactory.createLineBorder(color));
    }
}
