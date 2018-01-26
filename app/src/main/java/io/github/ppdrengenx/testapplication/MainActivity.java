package io.github.ppdrengenx.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ohms_lov_layout);

        Button btn_watt = (Button) findViewById(R.id.button_watt);
        btn_watt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Watt();
            }
        });

        Button btn_volt = (Button) findViewById(R.id.button_volt);
        btn_volt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Volt();
            }
        });

        Button btn_ampere = (Button) findViewById(R.id.button_ampere);
        btn_ampere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ampere();
            }
        });

        Button btn_modstand = (Button) findViewById(R.id.button_modstand);
        btn_modstand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Modstand();
            }
        });
    }


    public void Watt() {
        setContentView(R.layout.main_watt_layout);
        Button btn_uxi = (Button) findViewById(R.id.button_uxi);
        float  i, u, p;


        //Does not currently work,as it only opens Ampere
        //Need to figure out a way to send value from onClick to parent method to calculate the value
        btn_uxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SetVolt();
                CalcWatt1();

                /*
                String Volt_String = Float.toString(Volt);*/
                Toast.makeText(getApplicationContext(), "Input Entered", Toast.LENGTH_SHORT);

            }
        });

        Button btn_i2xr = (Button) findViewById(R.id.button_i2xr);
        btn_i2xr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button btn_u2dr = (Button) findViewById(R.id.button_u2dr);
        btn_u2dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



    public void CalcWatt1() {
        setContentView(R.layout.input_uxi_test);
        Button Calc = (Button) findViewById(R.id.btn_volt);
        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText voltText = (EditText) findViewById(R.id.volt_text);
                String volt = voltText.getText().toString();
                Toast.makeText(getApplicationContext(), volt, Toast.LENGTH_SHORT);
                EditText ampereText = (EditText) findViewById(R.id.ampere_text);
                String ampere = ampereText.getText().toString();

                try {
                    float fvolt = Float.parseFloat(volt);
                    float fampere = Float.parseFloat(ampere);
                    float fWatt = (fvolt * fampere);

                    String sWatt = String.format(Locale.US, "%.2f", fWatt);

                    TextView result = (TextView) findViewById(R.id.watt_result);
                    result.setText(sWatt + " Watt");

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Exception: " + e.getMessage(), Toast.LENGTH_SHORT);
                }
            }
        }
        );
    }


    public void SetVolt() {
        setContentView(R.layout.input_volt);
        Button set_volt = (Button) findViewById(R.id.btn_volt);
        set_volt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.volt_text);
                String volt = edit.getText().toString();

                try {
                    float fvolt = Float.parseFloat(volt);
                    String svolt = Float.toString(fvolt);
                    Toast.makeText(getApplicationContext(), svolt, Toast.LENGTH_SHORT);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Exception: " + e.getMessage(), Toast.LENGTH_SHORT);
                }
            }
        });
    }

    public void Volt() {
        Toast.makeText(getApplicationContext(), "Spænding", Toast.LENGTH_SHORT).show();;
    }

    public void Ampere() {
        Toast.makeText(getApplicationContext(), "Strøm", Toast.LENGTH_SHORT).show();;
    }

    public void Modstand() {
        Toast.makeText(getApplicationContext(), "Modstand", Toast.LENGTH_SHORT).show();;
    }



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
