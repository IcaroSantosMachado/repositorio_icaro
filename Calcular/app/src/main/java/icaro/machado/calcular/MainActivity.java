package icaro.machado.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button    btnCalcular;
    private EditText  edtOperando1, edtOperando2;
    private ImageView imgOperacao, imgResultado;
    private TextView  tvOpcao, tvOperacao, tvResultado;
    private Spinner   spiOpcoes;
    private int valor1, valor2;
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

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public int somar(int a, int b){
        int c = 0;

        c = a + b;

        return c;
    }
}