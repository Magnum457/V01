package view;

import java.io.PrintStream;
import java.util.Scanner;

import model.ListaUsuario;
import model.Usuario;

public class Menu {
	
	public void telaInicial(PrintStream out, Scanner in, ListaUsuario li) {
		out.println("Bem vindo ao menu principal!\n");
		out.println("Selecione uma opção");
		String opcao = "";
		while(!opcao.equals("q")) {
			out.println("1 - Adicionar um usuario");
			out.println("2 - Alterar um usuario");
			out.println("3 - Excluir um usuario");
			out.println("4 - Listar os usuarios");
			out.println("q - Sair");
			opcao = in.next();
			switch(opcao) {
				case "1":
					this.inserirUsuario(out, in, li);
					break;
				case "2":
					this.alterarUsuario(out, in, li);
					break;
				case "3":
					this.excluirUsuario(out, in, li);
					break;
				case "4":
					this.listaUsuario(out, in, li);
					break;
				case "q":
					out.println("Volte sempre :-D");
					break;
				default:
					out.println("Entrada inválida!");
			}
		}
	}
	
	public void inserirUsuario(PrintStream out, Scanner in, ListaUsuario li) {
		String login;
		String nome;
		String email;
		out.print("Digite o login do usuario: ");
		login = in.next();
		out.print("\n");
		out.print("Digite o nome do usuario: ");
		nome = in.next();
		out.print("\n");
		out.print("Digite o email do usuario: ");
		email = in.next();
		out.print("\n");
		
		li.addUsuario(login, nome, email);
		
		out.println("Usuario inserido com sucesso");
		
		out.println("Aperte qualquer tecla para voltar ao menu principal");
		in.nextLine();
	}
	
	public void alterarUsuario(PrintStream out, Scanner in, ListaUsuario li) {
		String login;
		out.print("Digite o login do usuario que voce deseja editar: ");
		login = in.next();
		Usuario u = li.buscaUsuario(login);
		if (u == null) {
			out.println("Usuario inexistente");
		} else {
			out.print("Voce deseja editar o usuario " + u.getNome() + "? (s/n)");
			String opcao = in.next();
			if (opcao.equals("s")) {
				out.print("Digite o novo nome do usuario: ");
				String nome = in.next();
				out.print("Digite o novo email do usuario: ");
				String email = in.next();
				
				li.editaUsuario(login, nome, email);
				
				out.println("Usuario editado com sucesso");
			}
		}
		out.println("Aperte qualquer tecla para voltar ao menu principal");
		in.nextLine();
	}
	
	public void excluirUsuario(PrintStream out, Scanner in, ListaUsuario li) {
		String login;
		out.print("Digite o login do usuario que voce deseja excluir: ");
		login = in.next();
		Usuario u = li.buscaUsuario(login);
		if (u == null) {
			out.println("Usuario inexistente");
		} else {
			out.print("Voce deseja excluir o usuario " + u.getNome() + "? (s/n)");
			String opcao = in.next();
			if (opcao.equals("s")) {
				
				li.excluiUsuario(login);
				
				out.println("Usuario excluido com sucesso");
			}
		}
		out.println("Aperte qualquer tecla para voltar ao menu principal");
		in.nextLine();
	}
	
	public void listaUsuario(PrintStream out, Scanner in, ListaUsuario li) {
		String dados = li.listaUsuarios();
		out.print(dados);
		out.println();
		in.nextLine();
	}
	
}
