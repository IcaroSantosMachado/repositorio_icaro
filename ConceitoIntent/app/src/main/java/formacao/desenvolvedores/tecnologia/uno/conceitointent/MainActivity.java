package formacao.desenvolvedores.tecnologia.uno.conceitointent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 5;
    private static final String DOUBLE_QUEBRA_DE_LINHA = "\n\n"; // Acrescentado por mim(Ícaro).
    private Button btnPergunta;
    private TextView tvExibirResposta, tvAnterior;
    private EditText edtPergunta;
    private ImageButton imgBtnLimpar;
    private ActivityResultLauncher<Intent> activityResultLauncher;

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
        tvAnterior       = findViewById(R.id.tvAnterior);// Esse TextView não está no projeto original(do professor).
        imgBtnLimpar     = findViewById(R.id.imgBtnLimpar);

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            String resposta = "Resposta:   " + data.getExtras().getString("RETURN_DATA");
                            String pergunta = "Pergunta:   " + edtPergunta.getText().toString();

                            tvExibirResposta.setText(resposta);
                            tvAnterior.setText(pergunta + DOUBLE_QUEBRA_DE_LINHA + resposta);

                            tvExibirResposta.setVisibility(View.VISIBLE);
                            tvAnterior.setVisibility(View.VISIBLE);

                        }
                    }
                });

        tvExibirResposta.setVisibility(View.INVISIBLE);
        tvAnterior.setVisibility(View.INVISIBLE);


        btnPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!edtPergunta.getText().toString().isEmpty()){
                    Intent irresposta = new Intent(MainActivity.this, RespostaActivity.class);

                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R){


                        String pergunta = edtPergunta.getText().toString();
                        irresposta.putExtra("PERGUNTA", pergunta);

                        if(!tvExibirResposta.getText().toString().isEmpty()){
                            String myResponse = tvExibirResposta.getText().toString().replace("Resposta:  ", "");
                            irresposta.putExtra("RESPOSTA", myResponse);
                        }

                        startActivityForResult(irresposta, REQUEST_CODE);

                    } else {

                        openActivityForResult();

                    }

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

                    String perguntaefetuada = "Pergunta: " + edtPergunta.getText().toString();
                    tvAnterior.setVisibility(View.VISIBLE);
                    tvAnterior.setText(perguntaefetuada + DOUBLE_QUEBRA_DE_LINHA + respostaefetuada);

                }
            }
        }
    }// fim onActivityResult;


    private void openActivityForResult(){
        Intent irresposta = new Intent(this, RespostaActivity.class);

        String levarpergunta = edtPergunta.getText().toString();
        irresposta.putExtra("PERGUNTA", levarpergunta);

        activityResultLauncher.launch(irresposta);

    }


} //fim MainActivity;







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