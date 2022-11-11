package service;

import model.Produto;

public interface IProdutoService {
    void inserirProduto(Produto var);

    void alterarProduto(Produto var);

    void excluirProduto(Produto var);

    Produto pesquisarProdutoId(int var);

    Produto[] listarProdutos();
}
