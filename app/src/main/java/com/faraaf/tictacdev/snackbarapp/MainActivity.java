package com.faraaf.tictacdev.snackbarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSimple, btnCallBackModel, btnCustomModel1, btnCustomModel2, btnCustomModel3, btnCustomModel4, btnCustomModel5;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }


    private void initUI() {
        btnSimple = findViewById(R.id.btnSimple);
        btnSimple.setOnClickListener(this);
        btnCallBackModel = findViewById(R.id.btnCallBackModel);
        btnCallBackModel.setOnClickListener(this);
        btnCustomModel1 = findViewById(R.id.btnCustomModel1);
        btnCustomModel1.setOnClickListener(this);
        btnCustomModel2 = findViewById(R.id.btnCustomModel2);
        btnCustomModel2.setOnClickListener(this);
        btnCustomModel3 = findViewById(R.id.btnCustomModel3);
        btnCustomModel3.setOnClickListener(this);
        btnCustomModel4 = findViewById(R.id.btnCustomModel4);
        btnCustomModel4.setOnClickListener(this);
        btnCustomModel5 = findViewById(R.id.btnCustomModel5);
        btnCustomModel5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSimple:
                simpleSnackBar(v);
                break;

            case R.id.btnCallBackModel:
                callBackSnackBar(v);
                break;

            case R.id.btnCustomModel1:
                customModel1(v);
                break;

            case R.id.btnCustomModel2:
                customModel2(v);
                break;

            case R.id.btnCustomModel3:
                customModel3(v);
                break;

            case R.id.btnCustomModel4:
                customModel4(v);
                break;

            case R.id.btnCustomModel5:
                customModel5(v);
                break;

            default:
                break;
        }
    }


    private void simpleSnackBar(View view) {
        snackbar = Snackbar.make(view, "Welcome", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }


    private void callBackSnackBar(View view) {
        snackbar = Snackbar.make(view, "Message is deleted", Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar = Snackbar.make(view, "Message is restored!", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });
        snackbar.show();
    }


    private void customModel1(View view) {
        Snackbar.make(view, "Snackbar with Action", Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Action!", Snackbar.LENGTH_SHORT).show();
            }
        }).setActionTextColor(Color.RED).show();


    }


    private void customModel2(View view) {
        Snackbar mSnackBar = Snackbar.make(view, "Snackbar with Custom Gravity", Snackbar.LENGTH_LONG);
        TextView mainTextView = (mSnackBar.getView()).findViewById(R.id.snackbar_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            mainTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        else
            mainTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        mainTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        mSnackBar.show();

    }


    private void customModel3(View view) {
        snackbar = Snackbar.make(view, "Custom Snackbar", Snackbar.LENGTH_SHORT);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Undo action", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.setActionTextColor(Color.BLUE);
        View snackbarView = snackbar.getView();
        TextView snackbarText = snackbarView.findViewById(R.id.snackbar_text);
        snackbarText.setTextColor(Color.YELLOW);
        snackbar.show();

    }

    private void customModel4(View view) {
        Snackbar mSnackBar = Snackbar.make(view, "With Custom Font", Snackbar.LENGTH_LONG);
        TextView mainTextView = (mSnackBar.getView()).findViewById(R.id.snackbar_text);
        TextView actionTextView = (mSnackBar.getView()).findViewById(R.id.snackbar_action);

        // To Apply Custom Fonts for Message and Action
        Typeface font = Typeface.createFromAsset(getAssets(), "sublimeregular.ttf");
        mainTextView.setTypeface(font);
        actionTextView.setTypeface(font);
        mSnackBar.show();

    }

    private void customModel5(View view) {
        snackbar = Snackbar.make(view, "TOP SNACKBAR", Snackbar.LENGTH_LONG);
        View parentView = snackbar.getView();
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) parentView.getLayoutParams();
        params.gravity = Gravity.CENTER_HORIZONTAL;
        parentView.setLayoutParams(params);
        parentView.setBackgroundColor(Color.RED);
        TextView mainTextView = (parentView).findViewById(R.id.snackbar_text);
        mainTextView.setTextColor(Color.WHITE);
        snackbar.show();
    }

}
