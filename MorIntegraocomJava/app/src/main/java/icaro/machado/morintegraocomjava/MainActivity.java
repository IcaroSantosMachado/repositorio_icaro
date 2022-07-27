package icaro.machado.morintegraocomjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nambimobile.widgets.efab.ExpandableFab;
import com.nambimobile.widgets.efab.FabOption;

import icaro.machado.morintegraocomjava.database_app.tabelas.Aluno;
import icaro.machado.morintegraocomjava.ui.CadastroAlunoActivity;

public class MainActivity extends AppCompatActivity {
    private ExpandableFab expandableFab;
    private FabOption fabOptionAluno, fabOptionAlunoProva,
            fabOptionProva, fabOptionPergunta, fabOptionResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableFab       = findViewById(R.id.expandable_fab);
        fabOptionAluno      = findViewById(R.id.fabOptionAluno);
        fabOptionAlunoProva = findViewById(R.id.fabOptionAlunoProva);
        fabOptionProva      = findViewById(R.id.fabOptionProva);
        fabOptionPergunta   = findViewById(R.id.fabOptionPergunta);
        fabOptionResposta   = findViewById(R.id.fabOptionResposta);

        fabOptionAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CadastroAlunoActivity.class);
                startActivity(intent);
            }
        });

        fabOptionAlunoProva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Está funcionando", Toast.LENGTH_SHORT).show();
            }
        });

        fabOptionProva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Está funcionando", Toast.LENGTH_SHORT).show();
            }
        });

        fabOptionPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Está funcionando", Toast.LENGTH_SHORT).show();
            }
        });

        fabOptionResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Está funcionando", Toast.LENGTH_SHORT).show();
            }
        });

        
    }
}