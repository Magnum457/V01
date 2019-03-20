package model;

import java.io.IOException;
import java.util.ArrayList;
import control.Conector;

public class ListaUsuario {
	//	atributos
		private ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Conector c = Conector.criaConexao();
		
	// construtor
		public ListaUsuario () {
			String dados;
			try {
				dados = c.lerDados(c.getFile());
				if (dados.equals("") || dados.equals("\n")) {
					System.out.println("Base de dados vazia");
				} else {
					this.recuperaLista(dados);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	// getter
		public ArrayList<Usuario> getLista (){
			return this.lista;
		}
		
	// metodos
		
		// transforma String em usuario
		private void recuperaLista (String dados) {
			String[] objetos = null;
			for(int i = 0; i < dados.length();i++) {
				objetos = dados.split("\n");
			}
				for(String o : objetos) {
					String[] objeto = o.split(";");
					this.addUsuario(objeto[0], objeto[1], objeto[2]);
				}
			
		}
		
		// atualiza o arquivo
		private void atualizaDados(Conector c, String dados) {
			try {
				c.escreveDados(c.getFile(), dados);
			} catch (IOException e) {
				e.printStackTrace();
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
		
		// lista usuarios
		public String listaUsuarios () {
			String listaUsuarios = "";
			for (Usuario u : this.lista) {
				listaUsuarios += "login do usuario: " + u.getLogin() + ";  ";
				listaUsuarios += "nome do usuario: " + u.getNome() + ";  ";
				listaUsuarios += "email do usuario: " + u.getEmail() + ";  ";
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
			this.atualizaDados(this.c, this.toString());
		}
		
		// exclui usuario
		public void excluiUsuario (String login) {
			if (this.buscaUsuario(login) != null) {
				Usuario u = this.buscaUsuario(login);
				this.lista.remove(u);
				this.atualizaDados(this.c, this.toString());
			} else {
				System.out.println("Login não existente");
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
				this.atualizaDados(this.c, this.toString());
			} else {
				System.out.println("Login não existente");
			}			
		}
		
		@Override
		public String toString() {
			String dados = "";
			for(Usuario u : this.lista) {
				dados += u.getLogin() + ";";
				dados += u.getEmail() + ";";
				dados += u.getNome() + ";";
				dados += "\n";
			}
			return dados;
		}
}
