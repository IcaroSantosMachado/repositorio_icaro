package icaro.machado.tddtesteunitario.formas;



public class Circunferencia extends Forma {
    private static final int ARRAY_MEDIDA_NECESSARIA = 0;
    private static final int TAMANHO_MAXIMO          = 1;
    private static final int EXPOENTE_DOIS           = 2;

    public Circunferencia(){
        super(TAMANHO_MAXIMO);
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(getMedidas(ARRAY_MEDIDA_NECESSARIA), EXPOENTE_DOIS);
    }

}
