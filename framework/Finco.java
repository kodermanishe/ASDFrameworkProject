package framework;

import framework.ui.MainScreen;

import javax.swing.*;

public class Finco extends JFrame {

    protected JFrame main;

    public static void main(String[] args) { 
    	Finco finco = new Finco();
        finco.run();
    }
    
    public void run() {
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	main = new MainScreen(Finco.this);
            	main.setVisible(true);
            }
    	});
    }

}
