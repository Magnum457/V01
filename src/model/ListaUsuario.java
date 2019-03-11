package model;

import java.util.ArrayList;

public class ListaUsuario {
	//	atributos
		private ArrayList<Usuario> lista;
		
	// getter
		public ArrayList<Usuario> getLista (){
			return this.lista;
		}
		
	// metodos
		// adiciona usuario
		public void addUsuario (String login, String nome, String email) {
			// verifica se o usuario já existe
			if (this.buscaUsuario(login) != null) {
				System.out.println("O usuario já existe");
			} else {
				Usuario u = new Usuario();
				u.setNome(nome);
				u.setLogin(login);
				u.setEmail(email);
				
				this.lista.add(u);
			}
			
		}
		
		// busca usuario
		public Usuario buscaUsuario (String login) {
			for (Usuario u : this.lista) {
				if(u.getLogin().equals(login)) {
					return u;
				}
			}
			return null;
		}
		
}
