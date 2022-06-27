package icaro.machado.conceitosclassesabstrataseinterfaces;

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

        retangulo.area();

    }

    @Test
    public void  trianguloTest(){

        Triangulo triangulo = new Triangulo(5, 8, 9);

        triangulo.area();

    }
}

