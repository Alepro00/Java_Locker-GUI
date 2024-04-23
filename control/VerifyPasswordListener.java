package control;

import view.Window1;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VerifyPasswordListener implements DocumentListener {

    private final Window1 finestra;
    public VerifyPasswordListener(Window1 finestra){
        this.finestra=finestra;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        warn();
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        warn();
    }
    @Override
    public void changedUpdate(DocumentEvent e) {}

    public void warn(){
        
        if(finestra.getPassword().matches("[a-zA-Z.0-9]{0,6}"))
            finestra.setPasswordArea(1);
        else if(finestra.getPassword().length()>=6 && finestra.getPassword().matches("[a-zA-Z.0-9]{7,11}"))
            finestra.setPasswordArea(2);
        else if(finestra.getPassword().length()>=12 && finestra.getPassword().matches("[a-zA-Z.0-9]{11,}.\\W+"))
            finestra.setPasswordArea(3);
    }

}
