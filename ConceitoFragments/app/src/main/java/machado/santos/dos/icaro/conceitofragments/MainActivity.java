package machado.santos.dos.icaro.conceitofragments;





import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}




// skbFormatarTexto.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//@Override
//public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//        tvExibirTexto.setTextSize(seekBar.getProgress());
//        }
//
//@Override
//public void onStartTrackingTouch(SeekBar seekBar) {
//
//        }
//
//@Override
//public void onStopTrackingTouch(SeekBar seekBar) {
//
//        }
//        });
//
//        btnAlterarTexto.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//
//        if(!edtInformarTexto.getText().toString().isEmpty()){
//
//        tvExibirTexto.setText(edtInformarTexto.getText().toString());
//
//
//        } else {
//
//        Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
//
//        }
//
//        }
//        });