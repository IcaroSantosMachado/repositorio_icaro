package icaro.machado.morintegraocomjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import icaro.machado.morintegraocomjava.database_app.tabelas.Aluno;

public class MainActivity extends AppCompatActivity {
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Aluno aluno = new Aluno();
        aluno.setNome("Ícaro");
        aluno.setEmail("icarocurso@uno.com");
        aluno.setGitHubUsuario("IcaroSantosMachado");




    }


    @Override
    protected void onResume() {
        super.onResume();


    }
}