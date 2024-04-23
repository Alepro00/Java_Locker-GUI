package control;

import view.Window1;
import view.Window2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    Window2 finestra2;
    Window1 finestra1;

    public KeyListener(Window1 finestra1, Window2 finestra2){this.finestra1=finestra1;this.finestra2=finestra2;}

    @Override public void keyPressed( KeyEvent ev ) {
        boolean check = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
        int code=ev.getKeyCode();

        if(finestra2!=null) {
            if ( code==KeyEvent.VK_CAPS_LOCK && check ) {
                finestra2.keyLabel.setText("Caps Lock");
                finestra2.keyLabel.setForeground(Color.RED);
            }
            else if( !check ){
                finestra2.keyLabel.setText("");
            }
            if( code==KeyEvent.VK_ENTER ){
                finestra2.submit.doClick();
            }
        }
        else {
            if( code==KeyEvent.VK_ENTER ) {
                finestra1.submit.doClick();
            }
        }

    }
}
