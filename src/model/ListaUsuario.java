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
		// busca usuario
		public Usuario buscaUsuario (String login) {
			for (Usuario u : this.lista) {
				if(u.getLogin().equals(login)) {
					return u;
				}
			}
			return null;
		}
		
		// lista usuarios
		public String listaUsuarios () {
			String listaUsuarios = "";
			for (Usuario u : this.lista) {
				listaUsuarios += "login: " + u.getLogin() + ";";
				listaUsuarios += "nome: " + u.getNome() + ";";
				listaUsuarios += "email: " + u.getEmail() + ";";
				listaUsuarios += "\n";
			}
				return listaUsuarios;
		}
		
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
		
		// exclui usuario
		public void excluiUsuario (String login) {
			for (Usuario u : this.lista) {
				if(u.getLogin().equals(login)) {
					this.lista.remove(u);
				}
			}
		}
		
		// editar usuario
		public void editaUsuario (String login, String nome, String email) {
			if (this.buscaUsuario(login) != null) {
				for (Usuario u : this.lista) {
					if (u.getLogin().equals(login)) {
						u.setNome(nome);
						u.setEmail(email);
					}
				}
			} else {
				System.out.println("Login não existente");
			}			
		}
}
