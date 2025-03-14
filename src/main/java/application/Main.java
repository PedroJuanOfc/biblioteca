package application;

import entities.Autor;
import entities.Livro;
import service.Biblioteca;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Autor");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Listar livros disponíveis");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("Digite o ID do autor: ");
                    int idAutorEscolhido = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o nome do autor: ");
                    String nomeAutor = sc.nextLine();
                    System.out.print("Digite a data de nascimento do autor (AAAA-MM-DD): ");
                    LocalDate dataNascimento = LocalDate.parse(sc.nextLine());

                    Autor autor = new Autor(idAutorEscolhido, nomeAutor, dataNascimento);
                    biblioteca.adicionarAutor(autor);
                    break;

                case 2:
                    if (biblioteca.getAutores().isEmpty()) {
                        System.out.println("Não há autores cadastrados. Cadastre um autor antes de adicionar um livro.");
                        break;
                    }

                    System.out.print("Digite um ID para o livro: ");
                    String idLivro = sc.nextLine();
                    System.out.print("Digite o título do livro: ");
                    String tituloLivro = sc.nextLine();

                    biblioteca.listarAutores();
                    System.out.print("Digite o ID do autor para o livro: ");
                    int idAutor = sc.nextInt();
                    sc.nextLine();

                    Autor autorEscolhido = biblioteca.buscarAutorPorId(idAutor);

                    if (autorEscolhido == null) {
                        System.out.println("Autor não encontrado. Cadastre um autor antes de adicionar um livro.");
                        break;
                    }

                    Livro livro = new Livro(idLivro, tituloLivro, autorEscolhido);
                    biblioteca.adicionarLivro(livro);
                    break;

                case 3:
                    biblioteca.listarLivrosDisponiveis();
                    break;

                case 0:
                    System.out.println("Volte sempre!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while(opcao != 0);

        sc.close();
    }
}