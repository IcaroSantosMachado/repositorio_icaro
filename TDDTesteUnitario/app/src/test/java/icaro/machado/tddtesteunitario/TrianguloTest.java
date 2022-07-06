package icaro.machado.tddtesteunitario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import icaro.machado.tddtesteunitario.formas.Triangulo;

public class TrianguloTest {
    private static final int BASE              = 0;
    private static final int ALTURA            = 1;
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
    public void deveriaCalcularAreaDoTrianguloComAFormulaArestaMaisArestaDivididoPorDois(){
        double resultado, resultadoEsperado;
        boolean comparacao;

        double areaTriangulo2x5 = 5;// base(2) * altura(5) / 2 <=> alturaBase(10) / 2 <=> area(5).
        double areaTriangulo3x4 = 6;// base(3) * altura(4) / 2 <=> alturaBase(12) / 2 <=> area(6).


        triangulo.setMedidas(BASE, 3);// base(a)
        triangulo.setMedidas(ALTURA, 4);// * altura(b)
        triangulo.setMedidas(DIVIDIDO_POR_DOIS, DIVIDIDO_POR_DOIS);// divididopordois(2).

        resultado = triangulo.area();
        resultadoEsperado = areaTriangulo3x4;

        comparacao = (resultado == resultadoEsperado);

        Assert.assertTrue(String.format("O resultado(= %f) não possuí o mesmo valor que o resultado esperado(= %f).", resultado, resultadoEsperado), comparacao);

    }

    @Test
    public void deveriaCalcularAreaDoTrianguloComAFormulaHeron(){

        double resultado, resultadoEsperado;
        boolean comparacao;

        triangulo.setMedidas(0, 3);// Primeira Aresta;
        triangulo.setMedidas(1, 4);// Segunda  Aresta;
        triangulo.setMedidas(2, 5);// Terceira Aresta;

        resultado = triangulo.area();
        resultadoEsperado = 5;

        comparacao = (resultado == resultadoEsperado);

        Assert.assertTrue(String.format("O resultado(= %f) não possuí o mesmo valor que o resultado esperado(= %f).", resultado, resultadoEsperado), comparacao);

    }
}
