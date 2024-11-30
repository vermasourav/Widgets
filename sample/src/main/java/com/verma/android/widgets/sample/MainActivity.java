package com.verma.android.widgets.sample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.verma.android.widgets.utils.BlinkAnimation;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayAdapter adapter;
    public ListView listView ;
    public AppCompatTextView textView ;

    String[] values = new String[] {
            "RoundedImageView - CircularImageView",
            "Pin",
            "Advance Pin",
            "Tell Me More",
            "Expandable Text View",
            "XXXXXX",
           };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.demoList);
        textView = findViewById(R.id.header_title);

        intView();
        BlinkAnimation blinkAnimation = new BlinkAnimation();
        blinkAnimation.blinkText(textView, new String[]{"A","B","C"}, 5000);
    }

    private void intView() {
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            int itemPosition  = position;
            String  itemValue    = (String) listView.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG).show();

            if(itemPosition ==0){
                startActivity(new Intent(this, RoundImageDemoActivity.class));
            }else if(itemPosition ==1){
                startActivity(new Intent(this, ExPinMainActivity.class));
            }else  if(itemPosition ==2){
                startActivity(new Intent(this, ExPinSecondActivity.class));
            }else  if(itemPosition ==3){
                startActivity(new Intent(this, ReadMoreActivity.class));
            }
        });

    }
}