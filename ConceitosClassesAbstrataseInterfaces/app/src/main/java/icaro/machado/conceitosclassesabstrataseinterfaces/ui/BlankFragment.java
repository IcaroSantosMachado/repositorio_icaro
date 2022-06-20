package icaro.machado.conceitosclassesabstrataseinterfaces.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import icaro.machado.conceitosclassesabstrataseinterfaces.R;


public class BlankFragment extends Fragment {

    public BlankFragment() { }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View layoutfragment = inflater.inflate(R.layout.fragment_blank, container, false);

       return layoutfragment;
    }
}