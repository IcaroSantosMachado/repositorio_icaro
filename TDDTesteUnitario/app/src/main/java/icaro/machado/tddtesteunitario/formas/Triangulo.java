package icaro.machado.tddtesteunitario.formas;

public class Triangulo extends Forma{
    private static final int BASE               = 0;
    private static final int ALTURA             = 1;
    private static final int DIVIDINDO_POR_DOIS = 2;
    private static final int TAMANHO_MAXIMO     = 3;

    public Triangulo(){
        super(TAMANHO_MAXIMO);
    }

    @Override
    public double area() {

        if(getMedidas(2) != DIVIDINDO_POR_DOIS){// Calculo Area com a Formula Heron;

            double semiPerimetro = (getMedidas(BASE) + getMedidas(ALTURA) + getMedidas(2)) / DIVIDINDO_POR_DOIS;
            double aux = (semiPerimetro * (semiPerimetro - getMedidas(BASE))
                                        * (semiPerimetro - getMedidas(ALTURA))
                                        * (semiPerimetro - getMedidas(2)));

            return Math.sqrt(aux);

        } else if (getMedidas(0) == getMedidas(1) && getMedidas(0) == getMedidas(2)){

            return Math.sqrt(3) / 4 * Math.pow(getMedidas(0), 2);

        } else {

            return (getMedidas(BASE) * getMedidas(ALTURA)) / DIVIDINDO_POR_DOIS; //Calculo Area do Triangulo Retangulo;

        }
    }


}
