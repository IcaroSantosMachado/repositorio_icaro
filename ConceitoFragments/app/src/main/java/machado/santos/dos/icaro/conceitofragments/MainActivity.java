package machado.santos.dos.icaro.conceitofragments;





import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;


public class MainActivity extends FragmentActivity implements ToolbarFragment.ToolbarListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onButtonClick(int position, String texto) {

        TextoFragment tvExibirTexto = (TextoFragment) getSupportFragmentManager().findFragmentById(R.id.frgTexto);
        tvExibirTexto.alterarTamanhoTexto(position, texto);

    }

    @Override
    public void onSeekbarProgressChanged(int position, String texto) {

        TextoFragment tvExibirTexto = (TextoFragment) getSupportFragmentManager().findFragmentById(R.id.frgTexto);
        tvExibirTexto.alterarTamanhoTexto(position, texto);

    }
}
