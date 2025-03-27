package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    double s1, s2;

    private EditText w,h;
    private TextView b;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

            });
        h = (EditText) findViewById(R.id.editTextNumberDecimal);
        w = (EditText) findViewById(R.id.editTextNumberDecimal2);
        btn = (Button)findViewById(R.id.button);
        b = (TextView)findViewById(R.id.textView);
        btn.setOnClickListener(new mClick());
    }
    class mClick implements View.OnClickListener {

        double s1, s2;
        public void onClick(View v) {
            s1 = Double.parseDouble(h.getText().toString());
            s2 = Double.parseDouble(w.getText().toString());
            double bmi = (s2 / (s1 * s1));
            b.setText("你的bmi是:" + String.format("%.2f", bmi));
            var r1 = (RadioButton)findViewById(R.id.radioButton1);
            var r2 = (RadioButton)findViewById(R.id.radioButton2);

            if(r1.isChecked())
            if(bmi < 20)
            {
                b.append("\n过轻");

            }
            else if(bmi >= 20 &&bmi <25)
            {
                b.append("\n适中");
            }
            else if(bmi >= 25 && bmi < 30)
            {
                b.append("\n超重");
            }
            else if(bmi >= 30 && bmi <35)
                b.append("\n肥胖");
            else
                b.append("\n严重肥胖");
            else
            if(r2.isChecked())
                if(bmi < 19)
                {
                    b.append("\n过轻");

                }
                else if(bmi >= 19 &&bmi <24)
                {
                    b.append("\n适中");
                }
                else if(bmi >= 24 && bmi < 29)
                {
                    b.append("\n超重");
                }
                else if(bmi >= 29 && bmi <34)
                    b.append("\n肥胖");
                else
                    b.append("\n严重肥胖");

        }
    }

}
