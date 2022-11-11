package view;

import model.Produto;
import service.IProdutoService;
import service.ProdutoService;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        IProdutoService IPS = getProdutoService();
        String opcao = "";

        do{
            opcao = JOptionPane.showInputDialog("  1 - Inserir Produto \n  " +
                    "2 - Alterar Produto \n  3 - Excluir Produto \n  4 - Pesquisar Produto por Id \n  " +
                    "5 - Listar Produtos \n  6 - Sair \n ");
            Produto p;
            int index;
            switch(opcao){
                case "1":
                    p = getProduto();
                    IPS.inserirProduto(p);
                    break;
                case "2":
                    index = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do produto que será alterado"));
                    p = getProduto();
                    p.setId(index);
                    IPS.alterarProduto(p);
                    break;
                case "3":
                    index = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do produto que será excluido"));
                    p = new Produto();
                    p.setId(index);
                    IPS.excluirProduto(p);
                    break;
                case "4":
                    index = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do produto que será pesquisado"));
                    p = IPS.pesquisarProdutoId(index);
                    JOptionPane.showMessageDialog((Component)null, p);
                    break;
                case "5":
                    String resposta = "";
                    Produto[] produtos;
                    int largura = (produtos = IPS.listarProdutos()).length;

                    for(int i = 0; i < largura; ++i) {
                        Produto cont = produtos[i];
                        if (cont != null) {
                            resposta = resposta + cont + "\n";
                        }
                    }

                    JOptionPane.showMessageDialog((Component)null, resposta);
                    break;
                case "6":
                    break;
                default:
                    JOptionPane.showMessageDialog((Component)null, "Digite uma opção válida ");
            }
        }while(!opcao.equals("6"));
    }

    public static Produto getProduto() {
        Produto produto = new Produto();
        produto.setTitulo(JOptionPane.showInputDialog("Digite o titulo do produto"));
        produto.setDescricao(JOptionPane.showInputDialog("Digite a descrição do produto"));
        produto.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto")));
        return produto;
    }

    public static IProdutoService getProdutoService() {
        return new ProdutoService(100);
    }
}
