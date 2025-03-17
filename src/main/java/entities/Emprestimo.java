package entities;

import java.time.LocalDate;

public class Emprestimo {
    private String id;
    private Livro livro;
    private String usuario;
    private LocalDate dataEmprestimo;

    public Emprestimo(String id, Livro livro, LocalDate dataEmprestimo, String usuario) {
        this.id = id;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
}
