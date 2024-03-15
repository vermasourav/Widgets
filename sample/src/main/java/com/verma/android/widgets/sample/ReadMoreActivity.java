package com.verma.android.widgets.sample;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.verma.android.widgets.readmore.AnotherReadMore;

public class ReadMoreActivity extends AppCompatActivity {

    TextView tellMeMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_more);
        tellMeMore = findViewById(R.id.read_more_text_view);
        AnotherReadMore anotherReadMore = new AnotherReadMore.Builder()
                .moreLabel("show more")
                .lessLabel("show less")
                .moreLabelColor(R.color.colorPrimaryDark)
                .lessLabelColor(R.color.colorPrimaryDark)
                .build();
        anotherReadMore.addReadMoreTo(tellMeMore,getString(R.string.read_more_text));


    }
}