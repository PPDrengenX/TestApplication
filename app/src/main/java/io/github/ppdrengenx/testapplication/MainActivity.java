package io.github.ppdrengenx.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        btn_uxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.input_values_layout);
                //Insert buttons in input_values_layout and read these numbers
                //Possibly insert writable textfield and read inputted text when pressing enter,
                //continuing to the next required value maybe
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
