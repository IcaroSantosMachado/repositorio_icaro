package formacao.desenvolvedores.tecnologia.uno.conceitointent;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 5;
    private static final String DOUBLE_QUEBRA_DE_LINHA = "\n\n";
    private Button btnPergunta;
    private TextView tvExibirResposta, tvAnterior;
    private EditText edtPergunta;
    private ImageButton imgBtnLimpar;
    private String pergunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();

        if(actionbar != null){

            actionbar.setTitle("Activity de Pergunta");

        }



        btnPergunta      = findViewById(R.id.btnPergunta);
        edtPergunta      = findViewById(R.id.edtPergunta);
        tvExibirResposta = findViewById(R.id.tvExibirResposta);
        tvAnterior       = findViewById(R.id.tvAnterior);// Text View utilizado para exibir a pergunta e reposta efetuada;
        imgBtnLimpar     = findViewById(R.id.imgBtnLimpar);



        tvExibirResposta.setVisibility(View.INVISIBLE);
        tvAnterior.setVisibility(View.INVISIBLE);



        btnPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!edtPergunta.getText().toString().isEmpty()){

                    Intent irresposta = new Intent(MainActivity.this, RespostaActivity.class);

                    pergunta = edtPergunta.getText().toString();
                    irresposta.putExtra("PERGUNTA", pergunta);


                    startActivityForResult(irresposta, REQUEST_CODE);

                } else {

                    Toast.makeText(MainActivity.this, "Insira uma pergunta.", Toast.LENGTH_SHORT).show();

                }

            }
        });




        imgBtnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edtPergunta.setText("");
                tvExibirResposta.setText("");

            }
        });



    }//fim do onCreate;



    @Override
    protected void onActivityResult(int requestedCode, int resultCode, Intent data){
        super.onActivityResult(requestedCode, resultCode, data);

        if((requestedCode == REQUEST_CODE) && (resultCode == RESULT_OK)){

            String returnString    = data.getExtras().getString("RETURN_DATA");

            if(returnString != null){
                if(!returnString.isEmpty()){

                    String respostaefetuada = "Resposta:  " + returnString;
                    tvExibirResposta.setVisibility(View.VISIBLE);
                    tvExibirResposta.setText(respostaefetuada);

                    String perguntaefetuada = "Pergunta: " + pergunta;
                    tvAnterior.setVisibility(View.VISIBLE);
                    tvAnterior.setText(perguntaefetuada + DOUBLE_QUEBRA_DE_LINHA + respostaefetuada);

                }
            }
        }
    }



} //fim MainActivity







/*com Bundle:
* Bundle extramain = getIntent().getExtras();



        String resposta;
        String perguntar;



        if(extramain != null){

            resposta = extramain.getString("RESPOSTA");
            perguntar = extramain.getString("PERGUNTAR");

            tvExibirResposta.setText("A resposta é: " + DOUBLE_QUEBRA_DE_LINHA + resposta);
            tvAnterior.setText("Pergunta: " + perguntar + DOUBLE_QUEBRA_DE_LINHA +"Resposta: " + resposta);

        } else {

            resposta = null;

            tvExibirResposta.setVisibility(View.INVISIBLE);
            tvAnterior.setVisibility(View.INVISIBLE);

        }
*
*
*
*
*
* */