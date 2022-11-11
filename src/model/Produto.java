package model;

import java.util.Objects;

public class Produto {
    private int Id;
    private String Titulo;
    private String Descricao;
    private double preco;

    public Produto(){
        this.Titulo = "";
        this.Descricao = "";
        this.preco = 0;
    }

    public Produto(int id, String titulo, String descricao, double preco) {
        Id = id;
        Titulo = titulo;
        Descricao = descricao;
        this.preco = preco;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Id == produto.Id && Double.compare(produto.preco, preco) == 0 && Objects.equals(Titulo, produto.Titulo) && Objects.equals(Descricao, produto.Descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Titulo, Descricao, preco);
    }

    @Override
    public String toString() {
        return "Produto"+ "\n" +
                "Id = " + Id + "\n" +
                "Titulo = " + Titulo + "\n" +
                "Descricao = " + Descricao + "\n" +
                "Preço = " + preco;
    }
}
