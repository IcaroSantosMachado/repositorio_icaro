package icaro.machado.calcular;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;

import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String DIVISAO         = "Divisão";
    public static final String MULTIPLICACAO   = "Multiplicação";
    public static final String SOMA            = "Soma";
    public static final String SUBTRACAO       = "Subtração";
    public static final String LOGARITMO       = "Logaritmo";
    public static final String POTENCIACAO     = "Potenciação";
    public static final String POTENCIA_DE_DEZ = "Potencia de dez";
    public static final String RAIZ_QUADRADA   = "Raiz Quadrada";
    private Button    btnCalcular;
    private EditText  edtOperando1, edtOperando2;
    private ImageView imgOperacao, imgResultado;
    private ImageButton imgBtnLimpar;
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
        imgBtnLimpar = findViewById(R.id.imgBtnLimpar);
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

                double valor = Double.parseDouble(edtOperando1.getText().toString());
                double valor2 = Double.parseDouble(edtOperando2.getText().toString());

                String textresultado = String.format("O Resultado da %s é:   ", operadorselecionado);

                if (operadorVazio() != true) {

                    if (operadorselecionado.equals(LOGARITMO)) {

                        tvResultado.setText(textresultado + logaritmo(valor));

                    } else if (operadorselecionado.equals(POTENCIACAO)){

                        tvResultado.setText(textresultado + "");

                    } else if (operandoVazio() != true) {

                        if (operadorselecionado.equals(DIVISAO)) {
                            if (valor != 0) {

                                tvResultado.setText(textresultado + divisaoString(dividir(valor, valor2)));

                            } else {

                                Toast.makeText(MainActivity.this, "O Divisor não pode ser '0'.", Toast.LENGTH_SHORT).show();

                            }

                        } else if (operadorselecionado.equals(MULTIPLICACAO)) {

                            tvResultado.setText(textresultado + multiplicarString(multiplicar(valor, valor2)));

                        } else if (operadorselecionado.equals(SOMA)) {

                            tvResultado.setText(textresultado + somarString(somar(valor, valor2)));

                        } else if (operadorselecionado.equals(SUBTRACAO)) {

                            tvResultado.setText(textresultado + subtrairString(subtrair(valor, valor2)));

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


        imgBtnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtOperando1.setText("");
                edtOperando2.setText("");
                tvResultado.setText("");
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        operadorselecionado = adapterView.getSelectedItem().toString();

        if(operadorselecionado.equals(DIVISAO)){

            imgOperacao.setImageDrawable(getDrawable(R.drawable.divisao));
            imgOperacao.setColorFilter(getColor(R.color.purple_200));
            edtOperando1.setHint("Divisor");
            edtOperando2.setHint("Dividendo");

        } else if (operadorselecionado.equals(MULTIPLICACAO)){

            imgOperacao.setImageDrawable(getDrawable(R.drawable.multiplica));
            imgOperacao.setColorFilter(getColor(R.color.purple_200));
            edtOperando1.setHint("Multiplicando");
            edtOperando2.setHint("Multiplicador");

        } else if (operadorselecionado.equals(SOMA)){

            imgOperacao.setImageDrawable(getDrawable(R.drawable.soma));
            imgOperacao.setColorFilter(getColor(R.color.purple_200));
            edtOperando1.setHint("Parcela");
            edtOperando2.setHint("Parcela");

        } else if (operadorselecionado.equals(SUBTRACAO)){

            imgOperacao.setImageDrawable(getDrawable(R.drawable.subtracao));
            imgOperacao.setColorFilter(getColor(R.color.purple_200));
            edtOperando1.setHint("Minuendo");
            edtOperando2.setHint("Subtraendo");

        } else if (operadorselecionado.equals(LOGARITMO)){

            imgOperacao.setImageDrawable(getDrawable(R.drawable.math_log));
            imgOperacao.setColorFilter(getColor(R.color.purple_200));
            edtOperando1.setHint("");
            edtOperando2.setHint("");

        } else if (operadorselecionado.equals(POTENCIACAO)){

            imgOperacao.setImageDrawable(getDrawable(R.drawable.exponent_box));
            imgOperacao.setColorFilter(getColor(R.color.purple_200));

        } else if (operadorselecionado.equals(POTENCIA_DE_DEZ)){

            imgOperacao.setImageDrawable(null);
            imgOperacao.setColorFilter(getColor(R.color.purple_200));

        } else if (operadorselecionado.equals(RAIZ_QUADRADA)){

            imgOperacao.setImageDrawable(getDrawable(R.drawable.raiz_quadrada));
            imgOperacao.setColorFilter(getColor(R.color.purple_200));
            edtOperando1.setHint("");
            edtOperando2.setHint("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private boolean operadorVazio(){

        if (!edtOperando1.getText().toString().isEmpty()){
            return false;

        } else {

            return true;
        }

    }

    private boolean operandoVazio(){

        if (!edtOperando2.getText().toString().isEmpty()){

            return false;

        } else {

            return true;

        }

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

    private String logaritmo(double valor){

        String resultado = String.valueOf(Math.log(valor));

        return resultado;
    }



}