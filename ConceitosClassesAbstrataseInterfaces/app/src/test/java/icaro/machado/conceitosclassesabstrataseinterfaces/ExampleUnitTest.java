package icaro.machado.conceitosclassesabstrataseinterfaces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


import icaro.machado.conceitosclassesabstrataseinterfaces.formas.Circunferencia;
import icaro.machado.conceitosclassesabstrataseinterfaces.formas.Retangulo;
import icaro.machado.conceitosclassesabstrataseinterfaces.formas.Triangulo;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }



    @Test
    public void retanguloTest(){

        Retangulo retangulo = new Retangulo(3, 2);

        double area = retangulo.area();

        Assert.assertEquals(6, area, 2);

    }

    @Test
    public void  trianguloTest(){

        Triangulo triangulo = new Triangulo(5, 8, 9);

        double area = triangulo.area();
        double areaEsperada = 19.8997;

        boolean comparacao = (area == areaEsperada);

        Assert.assertTrue(String.format("Area Esperada <%f>, Area Atual <%f>", area, areaEsperada)
                        , comparacao);

    }
}

