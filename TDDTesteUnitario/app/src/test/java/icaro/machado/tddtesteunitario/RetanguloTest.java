package icaro.machado.tddtesteunitario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import icaro.machado.tddtesteunitario.formas.Retangulo;


public class RetanguloTest {
    private static final int BASE   = 0;
    private static final int ALTURA = 1;

    private Retangulo retangulo;

    @Before
    public void instanciarObjeto(){

        retangulo = new Retangulo();

    }

    @Test
    public void deveriaTerUmaMedidaDeRaioMaiorDoQueZeroNoArrayDeMedidas(){



        retangulo.setMedidas(BASE, 2);
        retangulo.setMedidas(ALTURA, 3);

        double base = retangulo.getMedidas(0);
        double altura = retangulo.getMedidas(1);

        boolean maiorQueZero = (base > 0);
        boolean alturaMaiorQueZero = (altura > 0);

        Assert.assertTrue(maiorQueZero);
        Assert.assertTrue(alturaMaiorQueZero);

    }

    @Test
    public void deveriaCalcularAreaDoRetangulo(){
        double resultado, resultadoEsperado;
        boolean comparacao;

        double areaRetangulo4x6 = 24;
        double areaRetangulo5x7 = 35;

        retangulo = new Retangulo();

        retangulo.setMedidas(BASE, 4);
        retangulo.setMedidas(ALTURA, 6);

        resultado = retangulo.area();
        resultadoEsperado = areaRetangulo4x6;

        comparacao = (resultado == resultadoEsperado);

        Assert.assertTrue("O resultado não possuí o mesmo valor do resultado esperado.", comparacao);
    }

}
