package view;

import model.ListaUsuario;


public class Main {

	public static void main(String[] args) {
		ListaUsuario u = new ListaUsuario();
		System.out.println(u.listaUsuarios());
		u.addUsuario("magno", "ma", "gno");
		System.out.println("Adicionando o usuario magno");
		System.out.println(u.listaUsuarios());
		u.editaUsuario("magno", "ma", "maguilove@lipe");
		System.out.println("Editando o usuario magno");
		System.out.println(u.listaUsuarios());
		u.excluiUsuario("magno");
		System.out.println("Excluindo o usuario magno");
		System.out.println(u.listaUsuarios());

	}

}
