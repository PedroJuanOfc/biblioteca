package service;

import entities.Livro;
import entities.Autor;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Autor> autores;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.autores = new ArrayList<>();
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
}