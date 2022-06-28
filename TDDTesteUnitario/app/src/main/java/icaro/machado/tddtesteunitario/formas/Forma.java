package icaro.machado.tddtesteunitario.formas;

public abstract class Forma {

    private double[] numeroDeMedidas;
    private int      maximoTamanho = 3;

    public abstract double area();

    public double getMedida(int numMedidas){

        if(numMedidas >= 0 && numMedidas <= maximoTamanho){

            return numeroDeMedidas[numMedidas];

        } else {

            throw new RuntimeException("A medida deve ser maior que zero");

        }

    }

    public void setMedidas(int posicao, double numMedidas){

        numeroDeMedidas[posicao] = numMedidas;

    }

    public Forma(int numMedidas){

        numeroDeMedidas = new double[numMedidas];

    }

}
