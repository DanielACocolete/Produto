package service;

import model.Produto;

public class ProdutoService implements IProdutoService{
    private Produto[] produtos;
    private int idAux = 0;

    public ProdutoService(int tamanho){
        this.produtos = new Produto[tamanho];
    }

    @Override
    public void inserirProduto(Produto produto) {
        produto.setId(this.idAux);
        this.produtos[this.idAux] = produto;
        ++this.idAux;
    }

    @Override
    public void alterarProduto(Produto produto) {
        this.produtos[produto.getId()] = produto;
    }

    @Override
    public void excluirProduto(Produto produto) {
        int i = 0;
        for(i = produto.getId(); i < this.idAux - 1; ++i) {
            this.produtos[i] = this.produtos[i + 1];
            this.produtos[i].setId(i);
        }

        this.produtos[this.idAux - 1] = null;
        --this.idAux;
    }

    @Override
    public Produto pesquisarProdutoId(int id) {
        return this.produtos[id];
    }

    @Override
    public Produto[] listarProdutos() {
        return this.produtos;
    }
}
