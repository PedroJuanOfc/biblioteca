package service;

import entities.Emprestimo;
import entities.Livro;
import entities.Autor;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Autor> autores;
    private ArrayList<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("Autor " + autor.getNome() + " adicionado com sucesso!");
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro " + livro.getTitulo() + " adicionado com sucesso!");
    }

    public void listarAutores() {
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor cadastrado ainda.");
            return;
        }
        System.out.println("\nAutores cadastrados:");
        for (Autor autor : autores) {
            System.out.println("ID: " + autor.getId() + " | Nome: " + autor.getNome());
        }
    }

    public void listarLivrosDisponiveis() {
        System.out.println("\nLivros disponíveis:");

        boolean encontrou = false;
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println("ID: " + livro.getId() + " | Título: " + livro.getTitulo() + " | Autor: " + livro.getAutor().getNome());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum livro disponível no momento.");
        }
    }

    public boolean naoTemLivrosDisponiveis() {
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                return false;
            }
        }
        return true;
    }


    public Autor buscarAutorPorId(int id) {
        for (Autor autor : autores) {
            if (autor.getId() == id) {
                return autor;
            }
        }
        return null;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void realizarEmprestimo(String idLivro, String usuario) {
        Livro livroEscolhido = null;
        for (Livro livro : livros) {
            if (livro.getId().equals(idLivro)) {
                livroEscolhido = livro;
                break;
            }
        }

        if (livroEscolhido == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (!livroEscolhido.isDisponivel()) {
            System.out.println("Este livro já foi emprestado e não está disponível.");
            return;
        }

        Emprestimo novoEmprestimo = new Emprestimo(
                "E" + (emprestimos.size() + 1),
                livroEscolhido,
                LocalDate.now(),
                usuario
        );

        livroEscolhido.setDisponivel(false);

        emprestimos.add(novoEmprestimo);

        System.out.println("Livro '" + livroEscolhido.getTitulo() + "' emprestado para " + usuario + " com sucesso!");
    }

}