package com.example.m6.viewmodels;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class collection {
    public static int getInt(TextView textview){
        return Integer.parseInt(textview.getText().toString());
    }
    public static int getInt(EditText editText){
        return Integer.parseInt((editText.getText().toString()));
    }
    public static int getInt(Button button) {
        return Integer.parseInt(button.getText().toString());

    }

}
