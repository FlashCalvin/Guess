package com.calvin.guess;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView heyyou;
    int number;
    int counter;
    int secret = new Random().nextInt(10) +1;
    private TextView edcounter;
    private TextView num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("mainActive","secret"+secret);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edcounter = findViewById(R.id.counter);
        edcounter.setText(counter+"");
        num = findViewById(R.id.Num);
        heyyou = findViewById(R.id.heyyou);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
        public void guess(View view) {
        number = Integer.parseInt(num.getText().toString());
        counter++;
        edcounter.setText(counter+"");
        if (number < secret){
         heyyou.setText("太小");
         new AlertDialog.Builder(MainActivity.this)
                 .setTitle("Fuck You")
                 .setMessage("Bigger")
                 .setPositiveButton("Ok",null)
                 .show();
        }else if (number > secret){
            heyyou.setText("太大了");
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Fuck You")
                    .setMessage("Smaller")
                    .setPositiveButton("Ok",null)
                    .show();



        }else{
            heyyou.setText("耶");
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Fuck You")
                    .setMessage("JOLIHI")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        int secret2 = new Random().nextInt(10)+1;
                        secret = secret2;
                        counter = 0;
                        Log.d("mainActive","secret:"+secret2);
                        }
                    })
                    .show();
        }



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
