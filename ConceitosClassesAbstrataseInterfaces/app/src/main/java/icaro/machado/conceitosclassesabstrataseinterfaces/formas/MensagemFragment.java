package icaro.machado.conceitosclassesabstrataseinterfaces.formas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import icaro.machado.conceitosclassesabstrataseinterfaces.R;


public class MensagemFragment extends Fragment {

    public MensagemFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutFragment = inflater.inflate(R.layout.fragment_mensagem, container, false);


        return layoutFragment;
    }
}