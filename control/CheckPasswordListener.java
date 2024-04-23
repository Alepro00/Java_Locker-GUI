package control;

import view.Window1;
import view.Window2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPasswordListener implements ActionListener {

    Window1 finestra1;
    Window2 finestra2;
    int tentativi=3;

    public CheckPasswordListener(Window1 finestra1, Window2 finestra2){
        this.finestra1=finestra1;
        this.finestra2=finestra2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(tentativi==0){
            JOptionPane.showMessageDialog(null,"Cassaforte Bloccata", "alert", JOptionPane.ERROR_MESSAGE);
        }
        else {
            if (finestra2.getPassword().equals(finestra1.getPassword())) {
                tentativi=3;
                finestra2.passwordCheckLabel.setText("Tentativi rimasti: " + tentativi);
                JOptionPane.showMessageDialog(null, "Messaggio:\n" + finestra1.getMessaggio(),"Password accettata",JOptionPane.INFORMATION_MESSAGE);

            }
            else {
                finestra2.passwordCheckLabel.setText("Tentativi rimasti: " + --tentativi);
                JOptionPane.showMessageDialog(null, "Password errata", "alert", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
