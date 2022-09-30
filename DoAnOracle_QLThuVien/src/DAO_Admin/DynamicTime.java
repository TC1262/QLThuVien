package DAO_Admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class DynamicTime extends Thread {
    private JLabel lbl;
    
    public DynamicTime(JLabel lbl){
        this.lbl = lbl;
    }
    
    public void run(){
        SimpleDateFormat sdf = new SimpleDateFormat(java.time.LocalDate.now() + "       hh:mm:ss aa");
        while(true){
            Date now = new Date();
            String st = sdf.format(now);
            
            lbl.setText(st);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
}