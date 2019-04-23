package bank.ui;

import framework.Finco;

public class Bank extends Finco {
    public Bank () {
        super();
    }

    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                main = new BankFrm();
                main.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Bank creditCard = new Bank();
        creditCard.run();
    }
}
