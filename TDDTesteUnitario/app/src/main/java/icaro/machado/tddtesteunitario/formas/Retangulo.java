package icaro.machado.tddtesteunitario.formas;

public class Retangulo extends Forma {
    private static final int BASE = 0;
    private static final int ALTURA = 1;
    private static final int TAMANHO_MAXIMO = 2;


    public Retangulo(){
        super(TAMANHO_MAXIMO);
    }

    @Override
    public double area() {
        return getMedidas(BASE) * getMedidas(ALTURA);
    }


}
