package com.example.email3;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText w;
    private EditText e;
    private EditText p;
    private EditText n;
    private ImageView picture;
    private ImageView picture2;
    private ImageView picture3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        w=findViewById(R.id.word);
        p=findViewById(R.id.password);
        e=findViewById(R.id.email);
        n=findViewById(R.id.name);
        picture=findViewById(R.id.wrong1);
        picture2=findViewById(R.id.wrong2);
        picture3=findViewById(R.id.good);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    public void button(View view){
        int n1=Integer.parseInt(n.getText().toString());
        int p1=Integer.parseInt(p.getText().toString());
        int w1=Integer.parseInt(w.getText().toString());
        if(w.length()<4) {
            picture.setVisibility(View.VISIBLE);
            picture3.setVisibility(View.GONE);
            picture.animate().alpha(1.0f);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(("註冊失敗"))
                    .setMessage("帳號必須大於4個字")
                    .setIcon(R.drawable.iconfinder_fileclose_6038)
                    .setPositiveButton("ok",null)
                    .show();

            if(p.length()>4) {
                picture2.setVisibility(View.GONE);
            }
            if (p.length()<4){
                picture2.setVisibility(View.VISIBLE);
            }

        }
        else if(p.length()<4) {
            picture2.setVisibility(View.VISIBLE);
            picture3.setVisibility(View.GONE);
            new AlertDialog.Builder(MainActivity.this)
                    .setIcon(R.drawable.iconfinder_fileclose_6038)
                    .setTitle("註冊失敗")
                    .setMessage("密碼必須大於4個字")
                    .setPositiveButton("ok",null)
                    .show();

            if(w.length()>4){
                picture.setVisibility(View.GONE);

            }
        }
        else{
            picture.setVisibility(View.GONE);
            picture2.setVisibility(View.GONE);
            picture3.setVisibility(View.VISIBLE);
            new AlertDialog.Builder(MainActivity.this)
                    .setIcon(R.drawable.iconfinder_feel_good_41549)
                    .setTitle("註冊成功")
                    .setMessage("名字:"+n1+"\n"+"帳號:"+w1+"\n"+"密碼:"+p1+"\n"+"welcome")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            p.setText("");
                            n.setText("");
                            w.setText("");
                            e.setText("");
                            picture3.setVisibility(View.GONE);
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
