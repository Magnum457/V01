package view;

import java.io.PrintStream;
import java.util.Scanner;

import model.ListaUsuario;


public class Main {

	public static void main(String[] args) {
		ListaUsuario u = new ListaUsuario();
		Menu m = new Menu();
		Scanner in = new Scanner(System.in);
		PrintStream out = new PrintStream(System.out);
		
		m.telaInicial(out, in, u);

	}

}
