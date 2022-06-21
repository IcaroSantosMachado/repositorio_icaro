package icaro.machado.conceitosclassesabstrataseinterfaces.ui;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import icaro.machado.conceitosclassesabstrataseinterfaces.R;
import icaro.machado.conceitosclassesabstrataseinterfaces.formas.Triangulo;

public class TrianguloFrag extends Fragment {
    private EditText edtLado1, edtLado2, edtLado3;
    private TextView tvAreaTriangulo;
    private ImageButton imgbLimparTriangulo, imgbCalcularTriangulo;
//    private ImageView imgLado, imgLado2, imgLado3;
    public TrianguloFrag() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutFragment = inflater.inflate(R.layout.fragment_triangulo, container, false);

        edtLado1              = layoutFragment.findViewById(R.id.edtLado1);
        edtLado2              = layoutFragment.findViewById(R.id.edtLado2);
        edtLado3              = layoutFragment.findViewById(R.id.edtLado3);
        tvAreaTriangulo       = layoutFragment.findViewById(R.id.tvAreaTriangulo);
        imgbLimparTriangulo   = layoutFragment.findViewById(R.id.imgbLimparTriangulo);
        imgbCalcularTriangulo = layoutFragment.findViewById(R.id.imgbCalcularTriangulo);
//        imgLado               = layoutFragment.findViewById(R.id.imgLado);
//        imgLado2              = layoutFragment.findViewById(R.id.lado2);
//        imgLado3              = layoutFragment.findViewById(R.id.lado3);
//
//        RelativeLayout.LayoutParams lado = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);



        imgbCalcularTriangulo.setOnClickListener(view -> {
            if(edtLado1.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Informe o lado 01 do triângulo!", Toast.LENGTH_SHORT).show();

            } else if(edtLado2.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Informe o lado 02 do triângulo!", Toast.LENGTH_SHORT).show();

            }
            else if(edtLado3.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Informe o lado 03 do triângulo!", Toast.LENGTH_SHORT).show();

            } else{
                Triangulo triangulo = new Triangulo(Double.valueOf(edtLado1.getText().toString())
                        , Double.valueOf(edtLado2.getText().toString())
                        , Double.valueOf(edtLado3.getText().toString()));

                String areaFormatada = new DecimalFormat("#,##0.00").format(triangulo.area());
                tvAreaTriangulo.setText(areaFormatada);


            }
        });

        imgbLimparTriangulo.setOnClickListener(view -> {
            edtLado1.setText("");
            edtLado2.setText("");
            edtLado3.setText("");
            tvAreaTriangulo.setText("");
        });

        return layoutFragment;
    }
}