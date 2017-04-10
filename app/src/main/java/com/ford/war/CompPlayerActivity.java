package com.ford.war;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public class CompPlayerActivity extends AppCompatActivity {

    String[] suits;
    int[] values;
    int count = 0;
    int compScore = 0;
    int playerScore = 0;

    TextView compScoreText;
    TextView playerScoreText;
    TextView compCard;
    TextView playerCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_player);

        suits = new String[]{"Clubs", "Spades", "Diamonds", "Hearts"};
        values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        ArrayList<Card> deck = deckCreator(cardCreator());
        final ArrayList<Card> compDeck = new ArrayList<>();
        final ArrayList<Card> playDeck = new ArrayList<>();

        compScoreText = (TextView)findViewById(R.id.compScoreNum);
        playerScoreText = (TextView)findViewById(R.id.playerScoreNum);
        compCard = (TextView)findViewById(R.id.compCard);
        playerCard = (TextView)findViewById(R.id.playerCard);
        Button draw = (Button)findViewById(R.id.drawButton);

        for(int i = 0; i < deck.size(); i++){
            if(i % 2 == 0){
                compDeck.add(deck.get(i));
            }
            else{
                playDeck.add(deck.get(i));
            }
        }

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count <= 25) {

                    compCard.setText(compDeck.get(count).getValue() + " of " + compDeck.get(count).getSuit());
                    playerCard.setText(playDeck.get(count).getValue() + " of " + playDeck.get(count).getSuit());

                    if (compDeck.get(count).getValue() > playDeck.get(count).getValue()) {
                        compScore++;
                        compScoreText.setText(String.valueOf(compScore));
                        count++;
                    }
                    if (compDeck.get(count).getValue() < playDeck.get(count).getValue()) {
                        playerScore++;
                        playerScoreText.setText(String.valueOf(playerScore));
                        count++;
                    }
                    if (compDeck.get(count).getValue() == playDeck.get(count).getValue()){
                        count += 3;
                        compCard.setText(compDeck.get(count).getValue() + " of " + compDeck.get(count).getSuit());
                        playerCard.setText(playDeck.get(count).getValue() + " of " + playDeck.get(count).getSuit());

                        if (compDeck.get(count).getValue() > playDeck.get(count).getValue()) {
                            compScore+=3;
                            compScoreText.setText(String.valueOf(compScore));
                        }
                        if (compDeck.get(count).getValue() < playDeck.get(count).getValue()) {
                            playerScore+=3;
                            playerScoreText.setText(String.valueOf(playerScore));
                        }
                        else {

                        }
                    }
                    else {

                    }
                }
                else{
                    if(compScore > playerScore){
                        playerCard.setText("You Lose");
                    }
                    if(compScore < playerScore){
                        playerCard.setText("You Win!");
                    }
                    else{
                        playerCard.setText("Draw!!!");
                    }
                }

            }
        });
    }

    private ArrayList<Card> cardCreator(){

        ArrayList<Card> deckCreation = new ArrayList<>();

        for(int i = 0; i < suits.length; i++ ){
            for(int j = 0; j < values.length; j++){
                Card card = new Card();
                card.setSuit(suits[i]);
                card.setValue(values[j]);
                deckCreation.add(card);
            }
        }
        return deckCreation;
    }

    private ArrayList<Card> deckCreator(ArrayList<Card> temp){

        ArrayList<Card> shuffled = new ArrayList<>();

        Random rand = new Random();

        for(int i = 0; i < 52; i++){

            int j = rand.nextInt(temp.size());

            if(temp.get(j) != null) {
                shuffled.add(temp.get(j));
                temp.remove(j);
            }
        }

        return shuffled;
    }


}
