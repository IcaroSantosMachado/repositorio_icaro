package icaro.machado.conceitosclassesabstrataseinterfaces.formas;/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.27
 */

// Java - Guia do Programador - 3a Edição https://github.com/pjandl/jgp3

public class Retangulo extends Forma {
	public Retangulo(double altura, double largura) {
		super(2); // uso obrigatório do construtor da superclasse
		setMedida(0, altura); // ajuste da medida da altura
		setMedida(1, largura); // ajuste da medida da largura
	}

	// implementação do método abstrato area()
	@Override
	public double area() {
		return getMedida(0) * getMedida(1);
	}

	// implementação de operação especefica extra
	public double perimetro() {
		return 2 * (getMedida(0) + getMedida(1));
	}
}
