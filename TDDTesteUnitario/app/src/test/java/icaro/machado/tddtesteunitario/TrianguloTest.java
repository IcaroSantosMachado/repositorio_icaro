package icaro.machado.tddtesteunitario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import icaro.machado.tddtesteunitario.formas.Triangulo;

public class TrianguloTest {
    private static final int BASE = 0;
    private static final int ALTURA = 1;
    private static final int DIVIDIDO_POR_DOIS = 2;
    private Triangulo triangulo;

    @Before
    public void instanciaObjeto(){

        triangulo = new Triangulo();

    }

    @Test
    public void deveriaTerUmaMedidaDeRaioMaiorDoQueZeroNoArrayDeMedidas(){

        triangulo.setMedidas(BASE, 3);
        triangulo.setMedidas(ALTURA, 4);


        double base = triangulo.getMedidas(BASE);
        double altura = triangulo.getMedidas(ALTURA);

        boolean maiorQueZero = (base > 0);
        boolean alturaMaiorQueZero = (altura > 0);

        Assert.assertTrue(maiorQueZero);
        Assert.assertTrue(alturaMaiorQueZero);
    }


    @Test
    public void deveriaCalcularAreaDoTriangulo(){
        double resultado, resultadoEsperado;
        boolean comparacao;

        double areaTriangulo2x5 = 5;// base(2) * altura(5) / 2 => alturaBase(10) / 2 => area(5).
        double areaTriangulo3x4 = 6;// base(3) * altura(4) / 2 => alturaBase(12) / 2 => area(6).

        triangulo = new Triangulo();

        triangulo.setMedidas(BASE, 3);// base(?)
        triangulo.setMedidas(ALTURA, 4);// * altura(?)
        triangulo.setMedidas(DIVIDIDO_POR_DOIS, 5);// divididopordois(2).

        resultado = triangulo.area();
        resultadoEsperado = areaTriangulo3x4;

        comparacao = (resultado == resultadoEsperado);

        Assert.assertTrue(String.format("O resultado(= %f) não possuí o mesmo valor que o resultado esperado(= %f).", resultado, resultadoEsperado), comparacao);

    }
}
