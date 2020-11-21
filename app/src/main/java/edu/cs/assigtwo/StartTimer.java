package edu.cs.assigtwo;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class StartTimer extends AppCompatActivity {


    private int seconds;
    private Boolean running=false;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_timer);
        textView=findViewById(R.id.txtView);
        Intent intent=getIntent();
        seconds =intent.getIntExtra("timer", 0);
        int hours = seconds/3600;
        int minutes = seconds % 3600 /60;
        int snds = seconds % 60;
        String time = String.format(Locale.getDefault(),
                "%d:%02d:%02d", hours, minutes, snds);
        textView.setText(time);
        if (savedInstanceState != null){
            seconds = savedInstanceState.getInt("min");
            running=savedInstanceState.getBoolean("running");

        }

        runTimer();
    }

    public void onClickStart(View view) {
        running=true;
    }

    public void onClickStop(View view) {
        running=false;
    }

    public void onClickReset(View view) {
        Intent intent=getIntent();
        seconds =intent.getIntExtra("timer", 0);
        running=false;
    }
    private void runTimer(){
        final TextView txtView = findViewById(R.id.txtView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = seconds % 3600 /60;
                int snds = seconds % 60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, snds);
                txtView.setText(time);

                if(running){
                    --seconds;
                }
                handler.postDelayed(this, 1000);
            }
        });

    }

}