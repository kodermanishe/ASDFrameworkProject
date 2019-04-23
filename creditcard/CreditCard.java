package creditcard;

import creditcard.ui.CardFrm;
import framework.Finco;

public class CreditCard extends Finco {
    public CreditCard () {
        super();
    }

    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                main = new CardFrm();
                main.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard();
        creditCard.run();
    }
}