import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumber {
	
	@Dado("que criei o arquivo corretamente")
	public void que_criei_o_arquivo_corretamente() {
		System.out.println("Dado");
	}

	@Quando("executá-lo")
	public void executa_lo() {
	    System.out.println("Quando");
	}

	@Então("a especificação deve finalizar com sucesso")
	public void a_especifica_o_deve_finalizar_com_sucesso() {
		System.out.println("Então");
	}
	
	private Integer contador = 0;
	@Dado("que valor do contador é {int}")
	public void queValorDoContadorÉ(Integer valor) {
		System.out.println(String.format("Valor: %s", valor));
	    contador = valor;
	    
	}

	@Quando("eu incrementar em {int}")
	public void euIncrementarEm(Integer int1) {
		System.out.println(String.format("Incremento: %s", int1));
		contador += int1;
	}

	@Então("o valor do contador será {int}")
	public void oValorDoContadorSerá(Integer int2) {
		Assert.assertEquals(int2, contador);
	}

}
