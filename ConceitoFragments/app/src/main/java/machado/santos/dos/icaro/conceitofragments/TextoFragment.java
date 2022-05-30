package machado.santos.dos.icaro.conceitofragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextoFragment extends Fragment {

    private TextView tvExibirTexto;

    public TextoFragment(){}



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View textoLayoutInflated = inflater.inflate(R.layout.fragment_texto, container, false);

        tvExibirTexto = textoLayoutInflated.findViewById(R.id.tvExibirTexto);

        return textoLayoutInflated;
    }
}