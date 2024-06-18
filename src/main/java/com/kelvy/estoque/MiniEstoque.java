package com.kelvy.estoque;

    import java.util.ArrayList;
    import java.util.Scanner;
    
    public class MiniEstoque {
        private ArrayList<Produto> estoque = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);
    
        public void adicionarProduto() {
            System.out.print("Digite o ID do produto: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
    
            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();
    
            System.out.print("Digite o preço do produto: ");
            double preco = scanner.nextDouble();
    
            System.out.print("Digite a quantidade do produto: ");
            int quantidade = scanner.nextInt();
    
            Produto produto = new Produto(id, nome, preco, quantidade);
            estoque.add(produto);
            System.out.println("Produto adicionado com sucesso!");
        }
    
        public void visualizarProdutos() {
            if (estoque.isEmpty()) {
                System.out.println("Nenhum produto no estoque.");
            } else {
                for (Produto produto : estoque) {
                    System.out.println(produto);
                }
            }
        }
    
        public void deletarProduto() {
            System.out.print("Digite o ID do produto a ser deletado: ");
            int id = scanner.nextInt();
    
            Produto produtoParaRemover = null;
            for (Produto produto : estoque) {
                if (produto.getId() == id) {
                    produtoParaRemover = produto;
                    break;
                }
            }
    
            if (produtoParaRemover != null) {
                estoque.remove(produtoParaRemover);
                System.out.println("Produto removido com sucesso!");
            } else {
                System.out.println("Produto não encontrado.");
            }
        }
    
        public static void main(String[] args) {
            MiniEstoque miniEstoque = new MiniEstoque();
            Scanner scanner = new Scanner(System.in);
            int escolha;
    
            do {
                System.out.println("\nSistema de Gerenciamento de Mini Estoque");
                System.out.println("1. Adicionar Produto");
                System.out.println("2. Visualizar Produtos");
                System.out.println("3. Deletar Produto");
                System.out.println("4. Sair");
                System.out.print("Digite sua escolha: ");
                escolha = scanner.nextInt();
    
                switch (escolha) {
                    case 1:
                        miniEstoque.adicionarProduto();
                        break;
                    case 2:
                        miniEstoque.visualizarProdutos();
                        break;
                    case 3:
                        miniEstoque.deletarProduto();
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Escolha inválida. Tente novamente.");
                }
            } while (escolha != 4);
    
            scanner.close();
        }
    }
    

