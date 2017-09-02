package com.example.toshiba.secondassignment;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity  {
    EditText ed1;
    EditText ed2;
    Context context;
    String s1;
    String s2;
    double d1;
    double d2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText) findViewById(R.id.edittext1);
        ed2=(EditText) findViewById(R.id.edittext2);
        context = getApplicationContext();
        //setHasOptionsMenu(true);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        //return super.onCreateOptionsMenu(menu);
        return true;

    }
    public void parseText(String operation){
        try {
             s1 = ed1.getText().toString();
             s2 = ed2.getText().toString();
             d1 = Double.parseDouble(s1);
             d2 = Double.parseDouble(s2);
            /*int x=Integer.parseInt(s1);
            int y=Integer.parseInt(s2);
            float f1 = Float.parseFloat(s1);
            float f2 = Float.parseFloat(s2);
            double d3=d1-d2;
            String subtract=Double.toString(d3);
            double d4=d1+d2;
            String add=Double.toString(d4);*/
            if (operation=="-"){
                Toast toast = Toast.makeText(context,Double.toString(d1-d2), Toast.LENGTH_LONG);
                toast.show();
            }
            else if (operation=="+"){
                Toast toast = Toast.makeText(context,Double.toString(d1+d2), Toast.LENGTH_LONG);
                toast.show();
            }
            else if(operation=="/"){
                Toast toast = Toast.makeText(context,Double.toString(d1/d2), Toast.LENGTH_LONG);
                toast.show();
            }
            else if (operation=="*"){
                Toast toast = Toast.makeText(context,Double.toString(d1*d2), Toast.LENGTH_LONG);
                toast.show();
            }

        }
        catch(NumberFormatException e){
            Toast toast = Toast.makeText(context, "TYPE THE TWO NUMBERS", Toast.LENGTH_LONG);
            toast.show();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.subtract:
                parseText("-");
                return true;
            case R.id.multiply:
                parseText("*");
                return true;
            case R.id.add:
                parseText("+");
                return true;
            case R.id.divide:
                parseText("/");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
       // return super.onOptionsItemSelected(item);
    }
}
