package com.ford.war;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class CompPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_player);

        String[] suits = {"Clubs", "Spades", "Diamonds", "Hearts"};
        int[] values = {1,2,3,4,5,6,7,8,9,10,11};

        ArrayList<Card> deck = new ArrayList<>();

        while (deck.size() != 51){

            int suitPos =(int) Math.random() * 3;
            int valuesPos = (int) Math.random() * 10;
            Card card = new Card();
            card.setSuit(suits[suitPos]);
            card.setValue(values[valuesPos]);

            for(int i = 0; i < deck.size(); i++){
                if(card.getSuit() != deck.get(i).getSuit() && card.getValue() != deck.get(i).getValue()){
                    deck.add(card);
                }
                else{
                    
                }
            }



        }


    }


}
