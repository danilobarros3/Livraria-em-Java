/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testando.ac2_projeto_bibilioteca;

import fipiar.*;
import javax.swing.JOptionPane;
import java.util.List;


/**
 *
 * @author marco
 */
public class NewClass {
    public static void main(String[] args) {
        ListaEncadeada listaEn = new ListaEncadeada();
        ListaEncadeada carrinho = new ListaEncadeada();
        ArvBi arv = new ArvBi();

        int saida = 1;
        int id = 0;
        
        String[] opcoes = {"Saida","Cadastro de Livro","Livros cadastrados","Selecionar o Livro","Carrinho","Remove Livro","Comprar Livro", "Atualizar Livro"};
        String[] genOpcoes = {"Drama","Ficção","Romance","Terror","Ação","Comédia","Suspense","Outros"};
        
        do{
            saida = JOptionPane.showOptionDialog(null, "Escolha a opção desejada", "Livraria", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, null);
            
            switch (saida){
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigado pela preferencia","Livraria",JOptionPane.PLAIN_MESSAGE);
                    break;

                case 1:

                    String nomeLivro = String.valueOf(JOptionPane.showInputDialog(null,"Nome do livro","Cadastro do Livro",JOptionPane.PLAIN_MESSAGE));
                    int quantidadeLivro = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantidade de exemplares","Cadastro do Livro",JOptionPane.PLAIN_MESSAGE));
                    listaEn.insereNo_fim(new IntNoSimples(id,quantidadeLivro));

                    
                    String priGenero = null;
                    int genero = 1;
                    genero = JOptionPane.showOptionDialog(null, "Escolha o gênero do livro", "Livraria", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, genOpcoes, null);

                    switch (genero){
                        case 0:
                            priGenero = "Drama";
                            break;
                        case 1:
                            priGenero = "Ficção";
                            break;
                        case 2:
                            priGenero = "Romance";
                            break;
                        case 3:
                            priGenero = "Terror";
                            break;
                        case 4:
                            priGenero = "Ação";
                            break;
                        case 5:
                            priGenero = "Comédia";
                               break;
                        case 6:
                            priGenero = "Suspense";
                            break;
                        case 7:
                            priGenero = "Outros";
                            break;
                    }

                    arv.insert(id, nomeLivro,priGenero);
                    id++;

                    break;
                    
                case 2:
                    int ordenaPosicao =0;
                    do {
                        String[] opcoesDeOrdenacao ={"Padrão","Alfabetica","Sair"};
                        ordenaPosicao = JOptionPane.showOptionDialog(null, "Escolha a opção desejada", "Livraria", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoesDeOrdenacao, null);

                        switch (ordenaPosicao){
                            case 0:
                                if(arv.size() != 0){
                                    String var = "";
                                    for(int i = 0; i < arv.size(); i++){var += "ID: " + i + ", NOME: "+ arv.search(i,1) + ", GÊNERO: "+ arv.search(i,2)
                                            + ", QUANTIDADE: " + listaEn.buscaNo(i) +"\n";}

                                    JOptionPane.showMessageDialog(null, var);
                                }else{JOptionPane.showMessageDialog(null,"Livraria Vazia");}

                            break;
                            case 1:
                                if (arv.size() !=0) {
                                    String listaOrd = "";
                                    List<String> listaOrdenada = arv.obterListaOrdenada();
                                    for (String item : listaOrdenada) {
                                        listaOrd += item + "\n";
                                    }
                                    JOptionPane.showMessageDialog(null, listaOrd);
                                }else {JOptionPane.showMessageDialog(null,"Livraria Vazia");}
                            break;
                            case 2:
                            break;
                        }
                    }while (ordenaPosicao != 2);
                    break;
                        
                case 3:
                    int livroSelecionado;
                    if(arv.size() != 0){
                        String var = "";
                        int idCarrinho =0;
                        for(int i = 0; i < arv.size(); i++){var += i + " - "+ arv.search(i,1) + " - "+ arv.search(i,2)
                                + " - quantidade: " +listaEn.buscaNo(i)+"\n";}

                        livroSelecionado = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o ID do Livro \n"+var,"Seleção de livros",JOptionPane.PLAIN_MESSAGE ));

                        int qntDeLivroSelecionado = 0;
                        qntDeLivroSelecionado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade desejada"));
                        if (qntDeLivroSelecionado > listaEn.buscaNo(livroSelecionado)){
                            do {
                                qntDeLivroSelecionado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite novamente" +
                                        " a quantidade desejada"));
                            }while(qntDeLivroSelecionado > listaEn.buscaNo(livroSelecionado));
                        }

                        listaEn.alteraNo(livroSelecionado,(listaEn.buscaNo(livroSelecionado) - qntDeLivroSelecionado));
                        carrinho.insereNo_fim(new IntNoSimples(idCarrinho,arv.search(livroSelecionado,1), qntDeLivroSelecionado));

                    }else{JOptionPane.showMessageDialog(null,"Livraria Vazia");}

                    break;

                case 4:
                    JOptionPane.showMessageDialog(null,carrinho.exibeLista());
                    break;
                case 5:
                    int idParaExclusao = 0;
                    String excluirID = "";
                    for(int i = 0; i < carrinho.ContarNos(); i++){
                        excluirID += "ID: " + i + ", NOME: " + carrinho.buscaNome(i) + ", QUANTIDADE: " + carrinho.buscaNo(i) + "\n" ;
                    }

                    idParaExclusao = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o ID para excluir do carrinho\n" +
                            excluirID));

                    

                    if(carrinho.ContarNos() > idParaExclusao ){
                        carrinho.excluiNo(idParaExclusao);
                    }
                    break;

                case 6:
                    for (int i = 0; i < carrinho.ContarNos(); i++) {
                        carrinho.excluiNo(i);
                    }
                    JOptionPane.showMessageDialog(null,"Livros comprados com sucesso");

                    break;
                case 7:
                    
                 if(arv.size() != 0){
                     String [] opcaoDeAtt = {"Nome", "Genero", "Quantidade"};
                                    String LivrosCadastrados = "";
                                    for(int i = 0; i < arv.size(); i++){LivrosCadastrados += "ID: " + i + ", NOME: "+ arv.search(i,1) + ", GÊNERO: "+ arv.search(i,2)
                                            + ", QUANTIDADE: " + listaEn.buscaNo(i) +"\n";}

                                   int idParaAtt = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione o ID do livro em que você deseja atualizar: \n"+LivrosCadastrados)); 
                                   String lvSelPAtt = "ID: "+ idParaAtt + ", Nome" + arv.search(idParaAtt, 1) + ", Genero" + arv.search(idParaAtt, 2);
                                  
                                   
                                int lvPAtt =  JOptionPane.showOptionDialog(null, "Selecione o que você deseja atualizar do livro: \n" + lvSelPAtt, "Livraria", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE , null, opcaoDeAtt, null);
                                
                                switch (lvPAtt){
                                    case 0:
                                        String mNomeLivro = String.valueOf(JOptionPane.showInputDialog("Digite o novo nome do livro"));
     
                                        arv.updateNome (idParaAtt, mNomeLivro); 
                                        
                                            break;
                                    case 1:
                                        String genSel = "";
                                        int nGenero = 1; 
                    nGenero = JOptionPane.showOptionDialog(null, "Escolha o gênero do livro", "Livraria", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, genOpcoes, null);

                    switch (nGenero){
                        case 0:
                            genSel = "Drama";
                            break;
                        case 1:
                            genSel = "Ficção";
                            break;
                        case 2:
                            genSel = "Romance";
                            break;
                        case 3:
                            genSel = "Terror";
                            break;
                        case 4:
                            genSel = "Ação";
                            break;
                        case 5:
                            genSel = "Comédia";
                               break;
                        case 6:
                            genSel = "Suspense";
                            break;
                        case 7:
                            genSel = "Outros";
                            break;
                    }
                                        arv.updateGenero (idParaAtt, genSel); 
                                            break;
                                    case 2:
                                        
                                        int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade"));
     
                                        listaEn.atualizarQuantidade(idParaAtt, novaQuantidade);
                                        
                                            break;                
                                } 
                                
                                }else{JOptionPane.showMessageDialog(null,"Livraria Vazia");}
                    
                break;
            }

        }while(saida != 0);
    }
}
