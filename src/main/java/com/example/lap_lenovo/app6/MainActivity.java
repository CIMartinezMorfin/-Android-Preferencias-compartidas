package com.example.lap_lenovo.app6;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    RadioButton r1,r2,r3;
    CheckBox cb1,cb2;
    SeekBar sb;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1=(RadioButton) findViewById(R.id.radioButton);
        r2=(RadioButton) findViewById(R.id.radioButton2);
        r3=(RadioButton) findViewById(R.id.radioButton3);

        cb1=(CheckBox) findViewById(R.id.checkBox);
        cb2=(CheckBox) findViewById(R.id.checkBox2);

        sb=(SeekBar)findViewById(R.id.seekBar);

        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargar();
            }
        });

    }

    public void guardar(){
        SharedPreferences sp=getSharedPreferences("archivo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean("cb1",cb1.isChecked());
        editor.putBoolean("cb2",cb2.isChecked());
        editor.putBoolean("rb1",r1.isChecked());
        editor.putBoolean("rb2",r2.isChecked());
        editor.putBoolean("rb3",r3.isChecked());
        editor.putInt("sb",sb.getProgress());
        editor.apply();
        //editor.commit();
    }

    public void cargar(){
        SharedPreferences sp=getSharedPreferences("archivo",MODE_PRIVATE);
        cb1.setChecked(sp.getBoolean("cb1",false));
        cb2.setChecked(sp.getBoolean("cb2",false));
        r1.setChecked(sp.getBoolean("rb1",false));
        r2.setChecked(sp.getBoolean("rb2",false));
        r3.setChecked(sp.getBoolean("rb3",false));
        sb.setProgress(sp.getInt("sb",0));

    }

    public void onStop(){
        super.onStop();
        guardar();
    }
}
