package formacao.desenvolvedores.tecnologia.uno.conceitointent;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class RespostaActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 5;
    private static final String DOUBLE_QUEBRA_DE_LINHA = "\n\n";
    private Button btnResposta;
    private EditText edtResposta;
    private TextView tvExibirPergunta;
    private ImageButton imgBtnLimparR;
    private String resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        ActionBar actionbar = getSupportActionBar();

        if(actionbar != null){

            actionbar.setDisplayShowHomeEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setTitle("Activity de Resposta");

        }


        btnResposta       = findViewById(R.id.btnResposta);
        edtResposta       = findViewById(R.id.edtResposta);
        tvExibirPergunta  = findViewById(R.id.tvExibirPergunta);
        imgBtnLimparR     = findViewById(R.id.imgBtnLimparR);


        Bundle extra = getIntent().getExtras();

        String pergunta;
        String perguntaefetuada;

        if(extra != null){

            pergunta = extra.getString("PERGUNTA");


        }  else {

            pergunta = null;

        }

        perguntaefetuada  = "A Pergunta efetuada foi: " + DOUBLE_QUEBRA_DE_LINHA + pergunta;

        tvExibirPergunta.setText(perguntaefetuada);


        btnResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });



        imgBtnLimparR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edtResposta.setText("");

            }
        });




    } //fim do onCreate;



    @Override
    public void finish(){
        Intent data = new Intent();

        resposta = edtResposta.getText().toString();
        data.putExtra("RETURN_DATA", resposta);


        setResult(RESULT_OK, data);
        super.finish();

    }//fim do finish;



    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);

    }//fim do onOptionsItemSelected;




}//fim do MainActivity;