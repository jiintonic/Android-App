package itp341.yang.chingchuan.a7.Model;

import java.io.Serializable;

/**
 * Created by Jin Yang on 2/28/2017.
 */

public class Card implements Serializable {
    int cardNumber;
    String name;

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", name='" + name + '\'' +
                '}';
    }

    public Card(int cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    public Card(){
        cardNumber = 0;
        name = "";
    }

    public int getCardNumber(){
        return cardNumber;

    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setCardNumber(int n){
        this.cardNumber = n;
    }
}
