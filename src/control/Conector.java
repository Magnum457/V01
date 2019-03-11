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
		this.f = new File("");
	}
	
	public static Conector criaConexao() {
		Conector c = new Conector();
		return c;
	}
	
	public void escreveDados (File f) throws IOException {
		try {
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
//			código a ser inserido
			bw.close();
			fw.close();
		} catch (Exception e) {
			
		}
		
	}
	
	public void lerDados (File f) throws IOException {
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
//			código a ser inserido
			br.close();
			fr.close();
		} catch (Exception e) {
			
		}
	}
}
