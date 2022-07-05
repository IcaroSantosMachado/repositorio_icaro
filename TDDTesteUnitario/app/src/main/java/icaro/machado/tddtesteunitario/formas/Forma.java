package icaro.machado.tddtesteunitario.formas;

public abstract class Forma {

    private double[] numeroDeMedidas;
    private int      maximoTamanho = 3;

    public abstract double area();

    public double getMedidas(int medida){

        if(medida >= 0 && medida <= maximoTamanho){

            return numeroDeMedidas[medida];

        } else {

            throw new RuntimeException("A medida deve ser maior que zero");

        }

    }

    public void setMedidas(int medida, double valorMedidas){

        numeroDeMedidas[medida] = valorMedidas;

    }

    public Forma(int medida){

        numeroDeMedidas = new double[medida];

    }


}
