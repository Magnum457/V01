package view;
import java.io.IOException;

import control.Conector;

public class Main {

	public static void main(String[] args) {
		Conector c = Conector.criaConexao();
		String dados = "";
		String entrada = "";
		entrada = "Oi";
		entrada += "\ntd bem";
		
		try {
			c.escreveDados(c.getFile(), entrada);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			dados = c.lerDados(c.getFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(dados);

	}

}
