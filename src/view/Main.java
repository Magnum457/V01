package view;
import java.io.IOException;
import java.util.ArrayList;

import control.Conector;
import model.ListaUsuario;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		ListaUsuario u = new ListaUsuario();
		System.out.println(u.listaUsuarios());

	}

}
