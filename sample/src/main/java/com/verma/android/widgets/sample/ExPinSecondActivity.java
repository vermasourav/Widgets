package com.verma.android.widgets.sample;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import com.verma.android.widgets.ExPinView;


public class ExPinSecondActivity extends AppCompatActivity implements CheckBox.OnCheckedChangeListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_pin_second);

        ((ExPinView) findViewById(R.id.firstPinView)).setAnimationEnable(true);
        ((ExPinView) findViewById(R.id.secondPinView)).setAnimationEnable(true);
        ((CheckBox) findViewById(R.id.firstPasswordHidden)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.secondPasswordHidden)).setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (compoundButton.getId() == R.id.firstPasswordHidden)
            ((ExPinView) findViewById(R.id.firstPinView)).setPasswordHidden(isChecked);
        else
            ((ExPinView) findViewById(R.id.secondPinView)).setPasswordHidden(isChecked);
    }

    @Override
    public void addMenuProvider(@NonNull MenuProvider provider, @NonNull LifecycleOwner owner, @NonNull Lifecycle.State state) {
        //Do Nothing
    }
}