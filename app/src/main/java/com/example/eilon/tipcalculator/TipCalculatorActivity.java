package com.example.eilon.tipcalculator;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class TipCalculatorActivity extends ActionBarActivity {
    private View.OnClickListener p = new View.OnClickListener() {
        public void onClick(View v) {
            EditText number = (EditText)findViewById(R.id.edtBillAmount);
            double newNum = Double.parseDouble(number.getText().toString());
            newNum = newNum*0.12;
            CheckBox chk = (CheckBox)findViewById(R.id.chkRound);
            TextView tip = (TextView)findViewById(R.id.txtTipResult);
            if(chk.isChecked()){
                if(newNum - (int)newNum <= 0.5)
                    newNum = (int)(newNum);
                else {
                    newNum = (int) (newNum + 1);
                }
                tip.setText("Tip:" + (int)newNum);
            }
            else
                tip.setText("Tip:" +  newNum);

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        Button button = (Button)findViewById(R.id.btnCalculate);
        // Register the onClick listener with the implementation above
        button.setOnClickListener(p);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
