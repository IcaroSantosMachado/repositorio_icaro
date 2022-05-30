package machado.santos.dos.icaro.conceitofragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private static int textsize = 10;
    private Button btnAlterarTexto;
    private EditText edtInformarTexto;
    private SeekBar skbFormatarTexto;
    private ToolbarListener toolbarListener;

    public interface ToolbarListener {

        public void onButtonClick(int position, String texto);

    }

    public ToolbarFragment(){}

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


        try{

            toolbarListener = (ToolbarListener) context;

        } catch (ClassCastException s){

            throw new ClassCastException(context.toString()
                    + "Obrigatório implementar a interface ToolbarFragment");

        }
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View toolBarLayoutInflated =  inflater.inflate(R.layout.fragment_toolbar, container, false);

        edtInformarTexto = toolBarLayoutInflated.findViewById(R.id.edtInformarTexto);
        btnAlterarTexto  = toolBarLayoutInflated.findViewById(R.id.btnAlterarTexto);
        skbFormatarTexto = toolBarLayoutInflated.findViewById(R.id.skbFormatarTexto);

        
        btnAlterarTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buttonClicked(view);


            }
        });


        return toolBarLayoutInflated;
    }

    private void buttonClicked(View view){

        toolbarListener.onButtonClick(textsize, edtInformarTexto.getText().toString());

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        textsize = i;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


}