package com.example.roberto.contadortenis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView point1;
    TextView point2;
    TextView game1;
    TextView game2;
    TextView set1;
    TextView set2;
    Button button1;
    Button button2;
    Button reset;
    int points1 = 0;
    int points2 = 0;
    int games1 = 0;
    int games2 = 0;
    int sets1 = 0;
    int sets2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        point1 = (TextView) findViewById(R.id.countPointP1);
        point2 = (TextView) findViewById(R.id.countPointP2);
        game1 = (TextView) findViewById(R.id.countGameP1);
        game2 = (TextView) findViewById(R.id.countGameP2);
        set1 = (TextView) findViewById(R.id.countSetP1);
        set2 = (TextView) findViewById(R.id.countSetP2);
        button1 = (Button) findViewById(R.id.buttonP1);
        button2 = (Button) findViewById(R.id.buttonP2);
        reset = (Button) findViewById(R.id.reset);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point1.setVisibility(View.VISIBLE);
                game1.setVisibility(View.VISIBLE);
                set1.setVisibility(View.VISIBLE);
                conteo1();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point2.setVisibility(View.VISIBLE);
                game2.setVisibility(View.VISIBLE);
                set2.setVisibility(View.VISIBLE);
                conteo2();
            }
        });

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                point1.setVisibility(View.VISIBLE);
                point2.setVisibility(View.VISIBLE);
                reset();
                point1.setText("0");
                point2.setText("0");
                game1.setText("0");
                game2.setText("0");
                set1.setText("0");
                set2.setText("0");
            }
        });

    }

    public void conteo1(){
        if (games1 < 6) {
            if (points1 < 40){
                puntos1();
            }
            else {
                comprobarPuntos1();
            }
        }
        else {
            comprobarGames1();
        }

        point1.setText(points1 + "");
        game1.setText(games1 + "");
        set1.setText(sets1 + "");
        point2.setText(points2 + "");
        game2.setText(games2 + "");
        set2.setText(sets2 + "");
    }

    public void conteo2(){
        if (games2 < 6) {
            if (points2 < 40){
                puntos2();
            }
            else {
                comprobarPuntos2();
            }
        }
        else {
            comprobarGames2();
        }
        point1.setText(points1 + "");
        game1.setText(games1 + "");
        set1.setText(sets1 + "");
        point2.setText(points2 + "");
        game2.setText(games2 + "");
        set2.setText(sets2 + "");
    }

    public void puntos1(){
        if (points1 == 0 || points1 == 15){
            points1 = points1 + 15;
        }
        else{
            points1 = points1 + 10;
        }
    }

    public void puntos2(){
        if (points2 == 0 || points2 == 15){
            points2 = points2 + 15;
        }
        else{
            points2 = points2 + 10;
        }
    }

    public void comprobarPuntos1(){
        if (points1 < points2 + 20){
            puntos1();
        }
        else {
            games1 = games1 + 1;
            points1 = 0;
            points2 = 0;
        }
    }

    public void comprobarPuntos2(){
        if (points2 < points1 + 20){
            puntos2();
        }
        else {
            games2 = games2 + 1;
            points2 = 0;
            points1 = 0;
        }
    }

    public void comprobarGames1(){
        if (games1 < games2 + 2){
            if (points1 < 40){
                puntos1();
            }
            else {
                comprobarPuntos1();
            }
        }
        else {
            sets1 = sets1 + 1;
            games1 = 0;
            points1 = 0;
            games2 = 0;
            points2 = 0;
        }
    }

    public void comprobarGames2(){
        if (games2 < games1 + 2){
            if (points2 < 40){
                puntos2();
            }
            else {
                comprobarPuntos2();
            }
        }
        else {
            sets2 = sets2 + 1;
            games2 = 0;
            points2 = 0;
            games1 = 0;
            points1 = 0;
        }
    }

    public void reset(){
        points1 = 0;
        points2 = 0;
        games1 = 0;
        games2 = 0;
        sets1 = 0;
        sets2 = 0;
    }

}
