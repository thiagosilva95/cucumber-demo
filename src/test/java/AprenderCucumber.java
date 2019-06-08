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
}
