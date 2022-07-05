package icaro.machado.tddtesteunitario;

import android.util.Log;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import icaro.machado.tddtesteunitario.formas.Circunferencia;

public class CircunferenciaTest {
    private static final String TAG = "TesteCircunferencia";
    Circunferencia circunferencia;

    @Before
    public void instaciarObjeto(){

        circunferencia = new Circunferencia();

    }

    @Test
    public void deveriaTerUmaMedidaDeRaioMaiorDoQueZeroNoArrayDeMedidas(){

        circunferencia.setMedidas(0, 10);

        double  valor = circunferencia.getMedidas(0);
        boolean maiorQueZero = (valor > 0);

        Assert.assertTrue(maiorQueZero);
    }

    @Test
    public void deveriaTerUmLimiteDeTamanhoIVetorDeInformacoesDoCalculoDaArea(){}

    @Test
    public void deveriaCalcularAreaDaCircunferencia(){
        boolean comparacaoResultados;
        double  resultado, resultadoEsperado;

        circunferencia = new Circunferencia();
        circunferencia.setMedidas(0, 9);


        resultado = circunferencia.area();
        resultadoEsperado = Math.PI * (circunferencia.getMedidas(0) * circunferencia.getMedidas(0));

        comparacaoResultados = (resultado == resultadoEsperado);

        Assert.assertTrue(comparacaoResultados);
    }
}