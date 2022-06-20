package icaro.machado.conceitosclassesabstrataseinterfaces;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import icaro.machado.conceitosclassesabstrataseinterfaces.formas.MensagemFragment;
import icaro.machado.conceitosclassesabstrataseinterfaces.ui.CircunferenciaFrag;
import icaro.machado.conceitosclassesabstrataseinterfaces.ui.RetanguloFrag;
import icaro.machado.conceitosclassesabstrataseinterfaces.ui.TrianguloFrag;


/*Java - Guia do Programador - 3ª Edição https://github.com/pjandl/jgp3*/

//public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
public class MainActivity extends FragmentActivity implements AdapterView.OnItemSelectedListener{
    static final String TAG                     = "MainActivity";
    private static final String CIRCUNFERENCIA  = "Circunferência";
    private static final String RETANGULO       = "Retângulo";
    private static final String TRIANGULO       = "Triângulo";
    private String opcoesSelecionada;
    private ImageButton imgBtnConfirmar, imbBtnLimpar;
    private Spinner spiOpcoes;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgBtnConfirmar    = findViewById(R.id.imgbCalcular);
        imbBtnLimpar       = findViewById(R.id.imgbLimpar);
        spiOpcoes          = findViewById(R.id.spiOpcoes);

        ArrayAdapter<String> adapterFormas = new ArrayAdapter<>(this
                , android.R.layout.simple_spinner_item
                , getResources().getStringArray(R.array.formas_geometricas));
        adapterFormas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spiOpcoes.setAdapter(adapterFormas);
        spiOpcoes.setOnItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        opcoesSelecionada = adapterView.getSelectedItem().toString();

        if(fragmentManager != null)
            fragmentManager.popBackStack();

//        if(adapterView.getItemAtPosition(i).toString().equals(CIRCUNFERENCIA)){
//            if(fragmentManager != null){
//                fragmentManager.beginTransaction()
//                        .replace(R.id.mainFragment, CircunferenciaFrag.class, null)
//                        .setReorderingAllowed(true)
//                        .addToBackStack("Circunferência")
//                        .commit();
//            }
//
//        } else if(adapterView.getItemAtPosition(i).toString().equals(RETANGULO)){
//            if(fragmentManager != null){
//                fragmentManager.beginTransaction()
//                        .replace(R.id.mainFragment, RetanguloFrag.class, null)
//                        .setReorderingAllowed(true)
//                        .addToBackStack("Retângulo")
//                        .commit();
//            }
//
//        } else if(adapterView.getItemAtPosition(i).toString().equals(TRIANGULO)){
//            if(fragmentManager != null){
//                fragmentManager.beginTransaction()
//                        .replace(R.id.mainFragment, TrianguloFrag.class, null)
//                        .setReorderingAllowed(true)
//                        .addToBackStack("Triângulo")
//                        .commit();
//            }
//
//        } else {
//            fragmentManager.beginTransaction()
//                    .replace(R.id.mainFragment, MensagemFragment.class, null)
//                    .setReorderingAllowed(true)
//                    .addToBackStack("MensagemFrag")
//                    .commit();
//        }

        switch (opcoesSelecionada){

            case (CIRCUNFERENCIA) : {

                fragmentManager.beginTransaction()
                        .replace(R.id.mainFragment, CircunferenciaFrag.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("Circunferência")
                        .commit();

                break;
            }

            case (RETANGULO) : {

                fragmentManager.beginTransaction()
                        .replace(R.id.mainFragment, RetanguloFrag.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("Retângulo")
                        .commit();

                break;
            }

            case (TRIANGULO) : {

                fragmentManager.beginTransaction()
                        .replace(R.id.mainFragment, TrianguloFrag.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("Triângulo")
                        .commit();

                break;
            }

            default: {

                fragmentManager.beginTransaction()
                        .replace(R.id.mainFragment, MensagemFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("MensagemFrag")
                        .commit();

                break;
            }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /*
        Circunferencia c = new Circunferencia(1.5);
        System.out.println("areaCirc = " + c.area());

        Retangulo r = new Retangulo(2.5, 4.0);
        System.out.println("areaRet = " + r.area());

        Forma formas[] = new Forma[3];
        formas[0] = c;
        formas[1] = r;
        formas[2] = new Triangulo(1.0, 2.0, 2.0);
        for (int i = 0; i < formas.length; i++) {
            System.out.println(formas[i]);
            System.out.println("área = " + formas[i].area());
        }
    */
}