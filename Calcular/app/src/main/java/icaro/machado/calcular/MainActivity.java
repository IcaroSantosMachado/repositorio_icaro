package icaro.machado.calcular;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;

import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
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
    public static final double DEZ = 10;
    private Button    btnCalcular;
    private EditText  edtOperando1, edtOperando2;
    private ImageView imgOperacao, imgResultado;
    private ImageButton imgBtnLimpar;
    private TextView  tvOpcao, tvResultado;
    private Spinner   spiOpcoes;
    private String    operadorselecionado;
    private double    quociente, produto, soma, diferença, potencia, raiz;

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

                if (operadorVazio() != true) {

                    String textresultado = String.format("O Resultado da %s é:   ", operadorselecionado);

                    if (operadorselecionado.equals(LOGARITMO)){

                        tvResultado.setText(textresultado + logaritmo());

                    } else if (operadorselecionado.equals(RAIZ_QUADRADA)) {

                        tvResultado.setText(textresultado + radicalString(radical()));

                    } else if (operadorselecionado.equals(POTENCIA_DE_DEZ)){

                        tvResultado.setText(textresultado + potenciaNaDezString(potenciarNaDez()));

                    } else if (operandoVazio() != true) {

                        if (operadorselecionado.equals(DIVISAO)) {
                            if (diferenteDeZero() == true) {

                                tvResultado.setText(textresultado + divisaoString(dividir()));

                            } else {

                                Toast.makeText(MainActivity.this, "O Divisor não pode ser '0'.", Toast.LENGTH_SHORT).show();

                            }

                        } else if (operadorselecionado.equals(MULTIPLICACAO)) {

                            tvResultado.setText(textresultado + multiplicarString(multiplicar()));

                        } else if (operadorselecionado.equals(SOMA)) {

                            tvResultado.setText(textresultado + somarString(somar()));

                        } else if (operadorselecionado.equals(SUBTRACAO)) {

                            tvResultado.setText(textresultado + subtrairString(subtrair()));

                        } else if (operadorselecionado.equals(POTENCIACAO)){

                            tvResultado.setText(textresultado + potenciaString(potenciar()));

                        } else {

                            Toast.makeText(MainActivity.this, "Escolha um operador", Toast.LENGTH_SHORT).show();

                        }


                    } else {

                        Toast.makeText(MainActivity.this, "Insira um operando.", Toast.LENGTH_SHORT).show();

                    }

                } else {

                    Toast.makeText(MainActivity.this, "Insira um operador.", Toast.LENGTH_SHORT).show();

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


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        operadorselecionado = adapterView.getSelectedItem().toString();
        edtOperando2.setEnabled(true);

        switch(operadorselecionado) {


            case (DIVISAO) : {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.divisao));
                imgOperacao.setColorFilter(getColor(R.color.purple_200));
                edtOperando1.setHint("Divisor");
                edtOperando2.setHint("Dividendo");

                break;
            }

            case (MULTIPLICACAO) : {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.multiplica));
                imgOperacao.setColorFilter(getColor(R.color.purple_200));
                edtOperando1.setHint("Multiplicando");
                edtOperando2.setHint("Multiplicador");

                break;
            }

            case (SOMA) : {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.soma));
                imgOperacao.setColorFilter(getColor(R.color.purple_200));
                edtOperando1.setHint("Parcela");
                edtOperando2.setHint("Parcela");

                break;
            }

            case (SUBTRACAO) : {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.subtracao));
                imgOperacao.setColorFilter(getColor(R.color.purple_200));
                edtOperando1.setHint("Minuendo");
                edtOperando2.setHint("Subtraendo");

                break;
            }

            case (LOGARITMO) : {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.math_log));
                imgOperacao.setColorFilter(getColor(R.color.purple_200));
                edtOperando1.setHint("");
                edtOperando2.setHint("");

                break;
            }

            case (POTENCIACAO) : {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.exponent_box));
                imgOperacao.setColorFilter(getColor(R.color.purple_200));
                edtOperando1.setHint("Base");
                edtOperando2.setHint("Expoente");

                break;
            }

            case (POTENCIA_DE_DEZ) : {

                imgOperacao.setImageDrawable(null);
                imgOperacao.setColorFilter(getColor(R.color.purple_200));
                edtOperando1.setHint("Base");
                edtOperando2.setHint("10");
                edtOperando2.setHintTextColor(getColor(R.color.black));
                edtOperando2.setBackgroundColor(getColor(R.color.purple_200));
                editavel();

                break;
            }

            case (RAIZ_QUADRADA) : {

                imgOperacao.setImageDrawable(getDrawable(R.drawable.raiz_quadrada));
                imgOperacao.setColorFilter(getColor(R.color.purple_200));
                edtOperando1.setHint("Radicando");
                edtOperando2.setHint("");
                editavel();

                break;
            }


            default: {

                edtOperando1.setHint("valor");
                edtOperando2.setHint("valor");
                edtOperando2.setEnabled(true);

            }

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

    private boolean diferenteDeZero(){

        double divisor = Double.valueOf(edtOperando1.getText().toString());

        if (divisor != 0){

            return true;

        } else {

            return false;

        }

    }

    private double dividir(){

        double divisor = Double.valueOf(edtOperando1.getText().toString());
        double dividendo= Double.valueOf(edtOperando2.getText().toString());

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

    private double multiplicar(){

        double multiplicando = Double.valueOf(edtOperando1.getText().toString());
        double multiplicador = Double.valueOf(edtOperando2.getText().toString());

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

    private double somar(){

        double parcela = Double.valueOf(edtOperando1.getText().toString());
        double parcela2 = Double.valueOf(edtOperando2.getText().toString());

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

    private double subtrair(){

        double minuendo = Double.valueOf(edtOperando1.getText().toString());
        double subtraendo = Double.valueOf(edtOperando2.getText().toString());

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

    private String logaritmo(){

        double valor = Double.valueOf(edtOperando1.getText().toString());

        String resultado = String.valueOf(Math.log(valor));

        return resultado;
    }

    private double potenciar(){
        double base = Double.valueOf(edtOperando1.getText().toString());
        double expoente = Double.valueOf(edtOperando2.getText().toString());

        double potencia = Math.pow(base, expoente);

        return potencia;
    }

    private String potenciaString(double potencia){
        String resultado;

        if(potencia == Math.rint(potencia)){

            resultado = "" + (int)(potencia);

        } else {

            resultado = "" + potencia;

        }


        return resultado;
    }

    private double potenciarNaDez(){
        double base = Double.valueOf(edtOperando1.getText().toString());

        double potencia = Math.pow(base, DEZ);

        return potencia;
    }

    private String potenciaNaDezString(double potencia){
        String resultado;

        if(potencia == Math.rint(potencia)){

            resultado = "" + (int)(potencia);

        } else {

            resultado = "" + potencia;

        }


        return resultado;
    }

    private double radical(){

        double radicando = Double.valueOf(edtOperando1.getText().toString());

        raiz = Math.sqrt(radicando);

        return raiz;
    }

    private String radicalString(double raiz){
        String resultado;

        if(raiz == Math.rint(raiz)){

            resultado = "" + (int)(raiz);

        } else {

            resultado = "" + raiz;

        }

        return resultado;
    }

    private void editavel(){

        edtOperando2.setEnabled(false);

    }

}