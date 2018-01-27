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
        btn_uxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcWatt1();
            }
        });

        Button btn_i2xr = (Button) findViewById(R.id.button_i2xr);
        btn_i2xr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcWatt2();
            }
        });

        Button btn_u2dr = (Button) findViewById(R.id.button_u2dr);
        btn_u2dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcWatt3();
            }
        });
    }

    public void CalcWatt1() {
        setContentView(R.layout.input_uxi_test);
        Button Calc = (Button) findViewById(R.id.btn_result);
        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText voltText = (EditText) findViewById(R.id.volt_text);
                String volt = voltText.getText().toString();
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
                    Toast exceptionToast = Toast.makeText(getApplicationContext(), "Exception: " + e.getMessage(), Toast.LENGTH_SHORT);
                    exceptionToast.show();
                }
            }
        }
        );
    }

    public void CalcWatt2() {
        setContentView(R.layout.input_isquared_x_r);
        Button Calc = (Button) findViewById(R.id.btn_result);
        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ampereText = (EditText) findViewById(R.id.ampere_text);
                String ampere = ampereText.getText().toString();
                EditText modstandText = (EditText) findViewById(R.id.modstand_text);
                String modstand = modstandText.getText().toString();

                try {
                    float fampere = Float.parseFloat(ampere);
                    float fmodstand = Float.parseFloat(modstand);
                    float fWatt = (fampere*fampere) * fmodstand;

                    String sWatt = String.format(Locale.US, "%.2f", fWatt);

                    TextView result = (TextView) findViewById(R.id.watt_result);
                    result.setText(sWatt + " Watt");

                } catch (Exception e) {
                    Toast exceptionToast = Toast.makeText(getApplicationContext(), "Exception: " + e.getMessage(), Toast.LENGTH_SHORT);
                    exceptionToast.show();
                }
            }
        }
        );
    }

    public void CalcWatt3() {
        setContentView(R.layout.input_usquared_div_r);
        Button Calc = (Button) findViewById(R.id.btn_result);
        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText voltText = (EditText) findViewById(R.id.volt_text);
                String volt = voltText.getText().toString();
                EditText modstandText = (EditText) findViewById(R.id.modstand_text);
                String modstand = modstandText.getText().toString();

                try {
                    float fvolt = Float.parseFloat(volt);
                    float fmodstand = Float.parseFloat(modstand);
                    float fWatt = (fvolt*fvolt) / fmodstand;

                    String sWatt = String.format(Locale.US, "%.2f", fWatt);

                    TextView result = (TextView) findViewById(R.id.watt_result);
                    result.setText(sWatt + " Watt");

                } catch (Exception e) {
                    Toast exceptionToast = Toast.makeText(getApplicationContext(), "Exception: " + e.getMessage(), Toast.LENGTH_SHORT);
                    exceptionToast.show();
                }
            }
        }
        );
    }


    public void Volt() {
        setContentView(R.layout.main_volt_layout);

        Button btn_ixr = (Button) findViewById(R.id.button_ixr);
        btn_ixr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcVolt1();
            }
        });

        Button btn_pdivi = (Button) findViewById(R.id.button_pdivi);
        btn_pdivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcVolt2();
            }
        });

        Button btn_squaredpxr = (Button) findViewById(R.id.button_squaredpxr);
        btn_squaredpxr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcVolt3();
            }
        });
    }

    public void CalcVolt1() {
        setContentView(R.layout.input_ixr);
        Button Calc = (Button) findViewById(R.id.btn_result);
        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ampereText = (EditText) findViewById(R.id.ampere_text);
                String ampere = ampereText.getText().toString();
                EditText modstandText = (EditText) findViewById(R.id.modstand_text);
                String modstand = modstandText.getText().toString();

                try {
                    float fampere = Float.parseFloat(ampere);
                    float fmodstand = Float.parseFloat(modstand);
                    float fvolt = (fampere * fmodstand);

                    String svolt = String.format(Locale.US, "%.2f", fvolt);

                    TextView result = (TextView) findViewById(R.id.volt_result);
                    result.setText(svolt + " Volt");

                } catch (Exception e) {
                    Toast exceptionToast = Toast.makeText(getApplicationContext(), "Exception: " + e.getMessage(), Toast.LENGTH_SHORT);
                    exceptionToast.show();
                }
            }
        }
        );
    }

    public void CalcVolt2() {
        setContentView(R.layout.input_pdivi);
        Button Calc = (Button) findViewById(R.id.btn_result);
        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText effektText = (EditText) findViewById(R.id.effekt_text);
                String effekt = effektText.getText().toString();
                EditText ampereText = (EditText) findViewById(R.id.ampere_text);
                String ampere = ampereText.getText().toString();


                try {
                    float fampere = Float.parseFloat(ampere);
                    float feffekt = Float.parseFloat(effekt);
                    float fvolt = (feffekt / fampere);

                    String svolt = String.format(Locale.US, "%.2f", fvolt);

                    TextView result = (TextView) findViewById(R.id.volt_result);
                    result.setText(svolt + " Volt");

                } catch (Exception e) {
                    Toast exceptionToast = Toast.makeText(getApplicationContext(), "Exception: " + e.getMessage(), Toast.LENGTH_SHORT);
                    exceptionToast.show();
                }
            }
        }
        );
    }

    public void CalcVolt3() {
        setContentView(R.layout.input_squaredpxr);
        Button Calc = (Button) findViewById(R.id.btn_result);
        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText effektText = (EditText) findViewById(R.id.effekt_text);
                String effekt = effektText.getText().toString();
                EditText modstandText = (EditText) findViewById(R.id.modstand_text);
                String modstand = modstandText.getText().toString();


                try {
                    float feffekt = Float.parseFloat(effekt);
                    float fmodstand = Float.parseFloat(modstand);
                    float fvolt = (float)Math.sqrt(feffekt * fmodstand);

                    String svolt = String.format(Locale.US, "%.2f", fvolt);

                    TextView result = (TextView) findViewById(R.id.volt_result);
                    result.setText(svolt + " Volt");

                } catch (Exception e) {
                    Toast exceptionToast = Toast.makeText(getApplicationContext(), "Exception: " + e.getMessage(), Toast.LENGTH_SHORT);
                    exceptionToast.show();
                }
            }
        }
        );
    }


    public void Ampere() {
        setContentView(R.layout.main_ampere_layout);

        Button btn_ixr = (Button) findViewById(R.id.button_squaredpdivr);
        btn_ixr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcAmpere1();
            }
        });

        Button btn_pdivi = (Button) findViewById(R.id.button_pdivu);
        btn_pdivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CalcAmpere2();
            }
        });

        Button btn_squaredpxr = (Button) findViewById(R.id.button_udivr);
        btn_squaredpxr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CalcAmpere3();
            }
        });
    }

    public void Modstand() {
        Toast.makeText(getApplicationContext(), "Modstand", Toast.LENGTH_SHORT).show();;
    }

    public void CalcAmpere1() {
        setContentView(R.layout.input_squaredpdivr);
        Button Calc = (Button) findViewById(R.id.btn_result);
        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText effektText = (EditText) findViewById(R.id.effekt_text);
                String effekt = effektText.getText().toString();
                EditText modstandText = (EditText) findViewById(R.id.modstand_text);
                String modstand = modstandText.getText().toString();

                try {
                    float feffekt = Float.parseFloat(effekt);
                    float fmodstand = Float.parseFloat(modstand);
                    float fampere = (float)Math.sqrt(feffekt / fmodstand);

                    String sampere = String.format(Locale.US, "%.2f", fampere);

                    TextView result = (TextView) findViewById(R.id.ampere_result);
                    result.setText(sampere + " Ampere");

                } catch (Exception e) {
                    Toast exceptionToast = Toast.makeText(getApplicationContext(), "Exception: " + e.getMessage(), Toast.LENGTH_SHORT);
                    exceptionToast.show();
                }
            }
        }
        );
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
