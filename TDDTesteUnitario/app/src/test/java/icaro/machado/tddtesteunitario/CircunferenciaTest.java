package icaro.machado.tddtesteunitario;

import org.junit.Assert;
import org.junit.Test;

import icaro.machado.tddtesteunitario.formas.Circunferencia;

public class CircunferenciaTest {

    @Test
    public void deveriaTerUmaMedidaDeRaioMaiorDoQueZeroNoArrayDeMedidas(){

        Circunferencia circunferencia = new Circunferencia(2);

        circunferencia.setMedidas(0, 4);

        double  valor        = circunferencia.getMedida(3);
        boolean maiorQueZero = (valor > 0);

        Assert.assertTrue(maiorQueZero);
    }
}