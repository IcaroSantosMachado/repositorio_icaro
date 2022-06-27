package icaro.machado.conceitosclassesabstrataseinterfaces;

import org.junit.Test;

import icaro.machado.conceitosclassesabstrataseinterfaces.formas.Circunferencia;

public class CircunferenciaTest{

    @Test
    public void circunferenciaTest(){

        Circunferencia circunferencia = new Circunferencia(4);
        circunferencia.area();
    }
}
