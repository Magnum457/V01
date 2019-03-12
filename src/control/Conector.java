package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Conector {
	private File f;
	
	private Conector() {
		this.f = new File("usuario.txt");
	}
	
	public static Conector criaConexao() {
		Conector c = new Conector();
		return c;
	}
	
	public File getFile() {
		return this.f;
	}
	
	public void escreveDados (File f, String dados) throws IOException {
		
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(dados);
			bw.close();
			fw.close();
		
	}
	
	public String lerDados (File f) throws IOException {
		String dados = "";
		
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while(br.ready()) {
				dados += br.readLine() + "\n";
			}
			br.close();
			fr.close();
			
		return dados;
	}
}
