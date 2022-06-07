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

                        double valor  = Integer.valueOf(edtOperando1.getText().toString());
                        double valor2 = Integer.valueOf(edtOperando2.getText().toString());

                        if ((operadorselecionado.equals(DIVISAO)) && (valor > 0) && (valor2 > 0) ){

                            tvResultado.setText(divisao(valor, valor2));


                        } else if (operadorselecionado.equals(MULTIPLICACAO)){

                            tvResultado.setText(multiplicar(valor, valor2));

                        } else if (operadorselecionado.equals(SOMA)){

                            tvResultado.setText(somar(valor, valor2));

                        } else if (operadorselecionado.equals(SUBTRACAO)){

                            tvResultado.setText(subtrair(valor, valor2));

                        } else {

                            Toast.makeText(MainActivity.this, "Escolha um operador", Toast.LENGTH_SHORT).show();

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
            case 0: {

                imgOperacao.setImageDrawable(null);
                break;

            }

            case 1: {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.divisao));
                break;
            }

            case 2: {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.multiplica));
                break;
            }

            case 3: {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.soma));
                break;
            }

            case 4: {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.subtracao));
                break;
            }

            default: {

                i = 0;
                break;

            }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public String divisao(double a, double b){
        String resultado;

        double c = a / b;

        if(c == Math.rint(c)){

            resultado = "" + (int) (c);

        } else {

            resultado = "" + c;
        }

        return resultado;
    }

    public String multiplicar(double a, double b){
        String resultado;

        double c = a * b;

        if(c == Math.rint(c)) {

            resultado = "" + (int)(c);

        } else {

            resultado = "" + c;

        }

        return resultado;
    }

    public String somar(double a, double b){
        String resultado;
        double c = a + b;

        if(c == Math.rint(c)) {

            resultado = "" + (int)(c);

        } else {

            resultado = "" + c;

        }

        return resultado;
    }

    public String subtrair(double a, double b){
        String resultado;
        double c =  a - b;

        if(c == Math.rint(c)) {

            resultado = "" + (int)(c);

        } else {

            resultado = "" + c;

        }

        return resultado;
    }
}