package edu.cs.assigtwo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class Timer extends AppCompatActivity {
    private NumberPicker Npic;
    private NumberPicker N2pic;
    private NumberPicker N3pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        Npic=findViewById(R.id.Npic);
        N2pic=findViewById(R.id.N2pic);
        N3pic=findViewById(R.id.N3pic);
        Npic.setMaxValue(59);
        Npic.setMinValue(00);
        N2pic.setMaxValue(23);
        N2pic.setMinValue(00);
        N3pic.setMaxValue(59);
        N3pic.setMinValue(00);




    }


    public void btnTimer(View view) {
        int min , hour ,second;
        hour=Npic.getValue()*3600;
        min=N2pic.getValue()*60;
        second=N3pic.getValue()+min+hour;
        Toast.makeText(this, second,Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,StartTimer.class);
        intent.putExtra("timer",second);
        startActivity(intent);


    }
}