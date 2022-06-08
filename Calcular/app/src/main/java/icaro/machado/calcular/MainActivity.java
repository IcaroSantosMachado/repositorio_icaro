package icaro.machado.calcular;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String DIVISAO       = "Divisão";
    public static final String MULTIPLICACAO = "Multiplicação";
    public static final String SOMA          = "Soma";
    public static final String SUBTRACAO     = "Subtração";
    private Button    btnCalcular;
    private EditText  edtOperando1, edtOperando2;
    private ImageView imgOperacao, imgResultado;
    private TextView  tvOpcao, tvResultado;
    private Spinner   spiOpcoes;
    private String    operadorselecionado;
    private double    quociente, produto, soma, diferença;

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
        tvResultado  = findViewById(R.id.tvResultado);
        spiOpcoes    = findViewById(R.id.spiOpcoes);


        ArrayAdapter<String> adapteroperacoes = new ArrayAdapter<String>(MainActivity.this
                , android.R.layout.simple_spinner_item
                , getResources().getStringArray(R.array.operacoes_matematica));
        adapteroperacoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spiOpcoes.setAdapter(adapteroperacoes);
        spiOpcoes.setOnItemSelectedListener(this);
        imgOperacao.setImageDrawable(null);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtOperando1.getText().toString().isEmpty()){
                    if (!edtOperando2.getText().toString().isEmpty()){
//                        double valor = Integer.valueOf(edtOperando1.getText().toString());
//                        double valor2 = Integer.valueOf(edtOperando2.getText().toString());

                        double valor = Integer.valueOf(edtOperando1.getInputType());
                        double valor2 = Integer.valueOf(edtOperando2.getInputType());
//
//
//                        if(InputType.TYPE_NUMBER_FLAG_DECIMAL != 0){
//                            valor = Integer.valueOf(edtOperando1.getInputType());
//                            valor2 = Integer.valueOf(edtOperando2.getInputType());
//                        } else {
//                            valor  = Integer.valueOf(edtOperando1.getText().toString());
//                            valor2  = Integer.valueOf(edtOperando2.getText().toString());
//
//                        }


                        String textresultado = String.format("O Resultado da %s é:   ", operadorselecionado);

                        if (operadorselecionado.equals(DIVISAO)){
                            if(valor != 0) {

                                tvResultado.setText(textresultado + divisaoString(dividir(valor, valor2)));

                            } else {

                                Toast.makeText(MainActivity.this, "O Divisor não pode ser '0'.", Toast.LENGTH_SHORT).show();

                            }

                        } else if (operadorselecionado.equals(MULTIPLICACAO)){

                            tvResultado.setText(textresultado + multiplicar(valor, valor2));

                        } else if (operadorselecionado.equals(SOMA)){

                            tvResultado.setText(textresultado + somar(valor, valor2));

                        } else if (operadorselecionado.equals(SUBTRACAO)){

                            tvResultado.setText(textresultado + subtrair(valor, valor2));

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

        if(operadorselecionado.equals(DIVISAO)){

            imgOperacao.setImageDrawable(getDrawable(R.drawable.divisao));
            edtOperando1.setHint("Divisor");
            edtOperando2.setHint("Dividendo");

        } else if (operadorselecionado.equals(MULTIPLICACAO)){

            imgOperacao.setImageDrawable(getDrawable(R.drawable.multiplica));
            edtOperando1.setHint("Multiplicando");
            edtOperando2.setHint("Multiplicador");

        } else if (operadorselecionado.equals(SOMA)){

            imgOperacao.setImageDrawable(getDrawable(R.drawable.soma));
            edtOperando1.setHint("Parcela");
            edtOperando2.setHint("Parcela");

        } else if (operadorselecionado.equals(SUBTRACAO)){

            imgOperacao.setImageDrawable(getDrawable(R.drawable.subtracao));
            edtOperando1.setHint("Minuendo");
            edtOperando2.setHint("Subtraendo");

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private double dividir(double divisor, double dividendo){

        double quociente = divisor / dividendo;// foi Usado o tipo 'double' para termos um resultado mais preciso.

        return quociente;
    }

    private String divisaoString(double quociente){
        String resultado;

        this.quociente = quociente;

        if (quociente == Math.rint(quociente)) {

            resultado = "" + (int) (quociente);// Casting para retirar o ponto zero do 'double'.

        } else {

            resultado = "" + quociente;
        }

        return resultado;
    }

    private double multiplicar(double multiplicando, double multiplicador){

        double produto = multiplicando * multiplicador;// foi Usado o tipo 'double' para termos um resultado mais preciso.

        return produto;
    }

    private String multiplicarString(double produto){
        String resultado;

        this.produto = produto;

        if(produto == Math.rint(produto)){

            resultado =  "" + (int)(produto);

        } else {

            resultado = "" + produto;

        }

        return resultado;
    }

    private double somar(double parcela, double parcela2){

        double soma = parcela + parcela2;// foi Usado o tipo 'double' para termos um resultado mais preciso.

        return soma;
    }

    private String somarString(double soma){
        String resultado;

        this.soma = soma;

        if(soma == Math.rint(soma)){

            resultado = "" + (int)(soma);

        } else {

            resultado = "" + soma;
        }

        return resultado;
    }

    private double subtrair(double minuendo, double subtraendo){

        double diferença =  minuendo - subtraendo;// foi Usado o tipo 'double' para termos um resultado mais preciso..

        return diferença;

    }

    private String subtrairString(double diferença){
        String resultado;

        this.diferença = diferença;

        if(diferença == Math.rint(diferença)){

            resultado = "" + (int)(diferença);

        } else {

            resultado = "" + diferença;

        }

        return resultado;
    }
}