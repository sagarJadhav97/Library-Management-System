package library.management.system;

import java.awt.Color;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        splash_window sw = new splash_window();
        sw.setVisible(true);

        Login_window lh = new Login_window();
             try{
             for(int i=0;i<=100;i++){
             Thread.sleep(40);
             sw.bar.setForeground(Color.BLUE);
             sw.bar.setBackground(Color.white);
             sw.bar.setValue(i);
             
            if(i==100){
             sw.setVisible(false);
             lh.setVisible(true);
            }
        }
        }catch(InterruptedException e){}
    }
    
}
