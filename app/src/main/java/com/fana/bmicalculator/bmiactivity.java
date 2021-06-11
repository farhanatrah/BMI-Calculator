package com.fana.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    TextView mbmidisplay,mbmicategory,mbmihealthrisk, mgender;
    EditText mage, mweight;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float intheight, intweight;
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable =new ColorDrawable(Color.parseColor("#A5F2F3"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mbmihealthrisk=findViewById(R.id.bmihealthrisk);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);

        mbmi=Float.toString(intbmi);

        if(intbmi<18.4)
        {
            mbmicategory.setText("Underweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
            mbmihealthrisk.setText("Malnutrition Risk!");
        }
        else if (intbmi<24.9 && intbmi>18.4)
        {
            mbmicategory.setText("Normal Weight");
            mbackground.setBackgroundColor(Color.GREEN);
            mimageview.setImageResource(R.drawable.ok);
            mbmihealthrisk.setText("Low Risk");
        }
        else if (intbmi<29.9 && intbmi>24.9)
        {
            mbmicategory.setText("Overweight");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.warning);
            mbmihealthrisk.setText("Enhanced Risk!");
        }
        else if (intbmi<34.9 && intbmi>29.9)
        {
            mbmicategory.setText("Moderately Obese");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
            mbmihealthrisk.setText("Medium Risk!");
        }
        else if (intbmi<39.9 && intbmi>34.9)
        {
            mbmicategory.setText("Severely Obese");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
            mbmihealthrisk.setText("High Risk!");
        }
        else
        {
            mbmicategory.setText("Very Severely Obese");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
            mbmihealthrisk.setText("Very High Risk!");
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bmiactivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}