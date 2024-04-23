package control;

import view.Window1;
import view.Window2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private final Window1 finestra;
    public ButtonListener(Window1 finestra){
        this.finestra=finestra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Window2(finestra);
        finestra.dispose();

    }

}
