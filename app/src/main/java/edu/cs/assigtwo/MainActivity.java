package edu.cs.assigtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
//change
public class MainActivity extends AppCompatActivity {
    public static final String NAME = "NAME";
    public static final String اHIGHET="اHIGHET";
    public static final String WEIGHT="WEIGHT";
    public static final String GENDER="GENDER";


    public static final String FLAG = "FLAG";

private Spinner spinner;
private EditText nameP;
private EditText اHighet;
private EditText weight;
private Button save;
private CheckBox CHX;
private SharedPreferences prefs;
private SharedPreferences.Editor editor;
private ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       spinner =findViewById(R.id.spinner);
       CHX=findViewById(R.id.checkbox);
        addToSpinner();
        setupViews();
        setupSharedPrefs();
        checkPrefs();


    }

    public void OnClickBMI(View view) {
String name =nameP.getText().toString();
String hight=اHighet.getText().toString();
String Weight=weight.getText().toString();
        int spinnerPosition;
if (spinner.getSelectedItem().toString().equals("Male")){

    spinnerPosition = adapter.getPosition("Male");

        }
        else spinnerPosition = adapter.getPosition("Female");;

if (CHX.isChecked()){
    editor.putString(NAME, name);
    editor.putString(اHIGHET , hight);
    editor.putString(WEIGHT , Weight);
    editor.putInt(GENDER , spinnerPosition);
   editor.putBoolean(FLAG , true);
   editor.commit();

}
int BMI ;
BMI=(Integer.parseInt(hight)*Integer.parseInt(Weight));
        Toast.makeText(this , "Bmi ="+BMI  , Toast.LENGTH_SHORT).show();


    }
    private void setupSharedPrefs (){
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor =prefs.edit();
    }
    private void setupViews(){
       nameP =findViewById(R.id.name);
        اHighet=findViewById(R.id.highet);
        weight=findViewById(R.id.weight);
        CHX = findViewById(R.id.checkbox);
        spinner=findViewById(R.id.spinner);

    }
    private void checkPrefs(){
        boolean flag =prefs.getBoolean(FLAG, false);
        if (flag){
            String name =prefs.getString(NAME, "");
            String Hight=prefs.getString(اHIGHET,"");
            String Weight=prefs.getString(WEIGHT,"");
            int Gender=prefs.getInt(GENDER ,0);

            nameP.setText(name);
            اHighet.setText(Hight);
            weight.setText(Weight);
            spinner.setSelection(Gender);
            CHX.setChecked(true);

        }
    }
    private void addToSpinner (){
        String[] GenderS = new String[] {
                "Male", "Female"
        };

         adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, GenderS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void btnTimer(View view) {
        Intent intent =new Intent(this, Timer.class);

        startActivity(intent);

    }
}