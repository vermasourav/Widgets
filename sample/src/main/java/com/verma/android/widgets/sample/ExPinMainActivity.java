package com.verma.android.widgets.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.verma.android.widgets.ExPinView;

public class ExPinMainActivity extends AppCompatActivity {

    private static final String TAG = "ExPinMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_pin_main);

        final ExPinView pinView = findViewById(R.id.secondPinView);
        pinView.setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorAccent, getTheme()));
        pinView.setTextColor(ResourcesCompat.getColorStateList(getResources(), com.verma.android.widgets.R.color.ex_pv_text_colors, getTheme()));
        pinView.setLineColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme()));
        pinView.setLineColor(ResourcesCompat.getColorStateList(getResources(), com.verma.android.widgets.R.color.ex_pv_line_colors, getTheme()));
        pinView.setItemCount(4);
        pinView.setItemHeight(getResources().getDimensionPixelSize(com.verma.android.widgets.R.dimen.ex_pv_pin_view_item_size));
        pinView.setItemWidth(getResources().getDimensionPixelSize(com.verma.android.widgets.R.dimen.ex_pv_pin_view_item_size));
        pinView.setItemRadius(getResources().getDimensionPixelSize(com.verma.android.widgets.R.dimen.ex_pv_pin_view_item_size));
        pinView.setItemSpacing(getResources().getDimensionPixelSize(com.verma.android.widgets.R.dimen.ex_pv_pin_view_item_size));
        pinView.setLineWidth(getResources().getDimensionPixelSize(com.verma.android.widgets.R.dimen.ex_pv_pin_view_item_size));
        pinView.setAnimationEnable(true);// start animation when adding text
        pinView.setCursorVisible(false);
        pinView.setCursorColor(ResourcesCompat.getColor(getResources(), com.verma.android.widgets.R.color.ex_pv_line_selected, getTheme()));
        pinView.setCursorWidth(getResources().getDimensionPixelSize(com.verma.android.widgets.R.dimen.ex_pv_pin_view_cursor_width));
        pinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //DO Nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged() called with: s = [" + s + "], start = [" + start + "], before = [" + before + "], count = [" + count + "]");
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Do Nothing
            }
        });
        pinView.setItemBackgroundColor(Color.BLACK);

        pinView.setItemBackground(ResourcesCompat.getDrawable(getResources(), com.verma.android.widgets.R.drawable.ex_pv_item_background, null));
        pinView.setItemBackgroundResources(com.verma.android.widgets.R.drawable.ex_pv_item_background);
        pinView.setHideLineWhenFilled(false);

        ((EditText) findViewById(R.id.password)).setTransformationMethod(new AsteriskPasswordTransformationMethod());
    }


    public static class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new PasswordCharSequence(source);
        }

        private static class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;

            public PasswordCharSequence(CharSequence source) {
                mSource = source; // Store char sequence
            }

            @Override
            public char charAt(int index) {
                return '*'; // This is the important part
            }

            @Override
            public int length() {
                return mSource.length();
            }

            @Override
            public CharSequence subSequence(int start, int end) {
                char[] buf = new char[end - start];

                getChars(start, end, buf, 0);
                return new String(buf);
            }

            @Override
            public String toString() {
                return subSequence(0, length()).toString();
            }

            public void getChars(int start, int end, char[] dest, int off) {
                TextUtils.getChars(this, start, end, dest, off);
            }
        }
    }
}