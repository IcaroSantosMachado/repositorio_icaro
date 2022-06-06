package icaro.machado.calcular;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String DIVISAO       = "Divisão";
    public static final String MULTIPLICACAO = "Multiplicação";
    public static final String SOMA          = "Soma";
    public static final String SUBTRACAO     = "Subtração";
    private Button    btnCalcular;
    private EditText  edtOperando1, edtOperando2;
    private ImageView imgOperacao, imgResultado;
    private TextView  tvOpcao, tvOperacao, tvResultado;
    private Spinner   spiOpcoes;
    private String    operadorselecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular  = findViewById(R.id.btnCalcular);
        edtOperando1 = findViewById(R.id.edtOperando1);
        edtOperando2 = findViewById(R.id.edtOperando2);
        imgOperacao  = findViewById(R.id.imgOperacao);
        imgResultado = findViewById(R.id.imgResultado);
        tvOpcao      = findViewById(R.id.tvOpcao);
        tvOperacao   = findViewById(R.id.tvOperacao);
        tvResultado  = findViewById(R.id.tvResultado);
        spiOpcoes    = findViewById(R.id.spiOpcoes);

        ArrayAdapter<String> adapteroperacoes = new ArrayAdapter<String>(MainActivity.this
                , android.R.layout.simple_spinner_item
                , getResources().getStringArray(R.array.operacoes_matematica));
        adapteroperacoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spiOpcoes.setAdapter(adapteroperacoes);
        spiOpcoes.setOnItemSelectedListener(this);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtOperando1.getText().toString().isEmpty()){
                    if (!edtOperando2.getText().toString().isEmpty()){

                        int valor  = Integer.valueOf(edtOperando1.getText().toString());
                        int valor2 = Integer.valueOf(edtOperando2.getText().toString());

                        if (operadorselecionado == DIVISAO){

                        }


                    } else {

                        Toast.makeText(MainActivity.this, "Insira um número.", Toast.LENGTH_SHORT).show();

                    }

                } else {

                    Toast.makeText(MainActivity.this, "Insira um número.", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        operadorselecionado = adapterView.getSelectedItem().toString();
        tvOperacao.setText(operadorselecionado);

        switch (i){

            case 1: {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.ic_outline_remove_24));
                imgOperacao.setVisibility(View.VISIBLE);
                break;
            }

            case 2: {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.ic_baseline_clear_24));
                imgOperacao.setVisibility(View.VISIBLE);
                break;
            }

            case 3: {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.ic_baseline_add_24));
                imgOperacao.setVisibility(View.VISIBLE);
                break;
            }

            case 4: {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.ic_outline_remove_24));
                imgOperacao.setVisibility(View.VISIBLE);
                break;
            }

            default:{

                imgOperacao.setVisibility(View.INVISIBLE);
                break;

            }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}