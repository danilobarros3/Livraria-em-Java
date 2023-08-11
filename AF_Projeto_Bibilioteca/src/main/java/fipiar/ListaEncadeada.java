/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fipiar;

import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */

public class ListaEncadeada {
    IntNoSimples primeiro, ultimo;
    int numero_nos = 0;

    public ListaEncadeada() {
        primeiro = ultimo = null;
    }

    public void insereNo_fim(IntNoSimples novoNo) {
        novoNo.prox = null;
        if (primeiro == null)
            primeiro = novoNo;
        if (ultimo != null)
            ultimo.prox = novoNo;
        ultimo = novoNo;
        numero_nos++;
    }

    public void insereNo_inicio(IntNoSimples novoNo) {
        novoNo.prox = primeiro;
        if (primeiro == null && ultimo == null) //Só tem um elemento na lista
        {
            ultimo = novoNo;
        }
        primeiro = novoNo;
        numero_nos++;
    }

    public int ContarNos() {
        int tamanho = 0;
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            tamanho++;
            temp_no = temp_no.prox;
        }
        return tamanho;
    }

    public void insereNo_posicao(IntNoSimples novoNo, int posicao) {
        IntNoSimples temp_no = primeiro;
        int numero_nos = ContarNos();
        int pos_aux;
        if (posicao == 0) {
            novoNo.prox = primeiro;
            if (primeiro == ultimo) {
                ultimo = novoNo;
            }
            primeiro = novoNo;
        } else {
            if (posicao <= numero_nos) {
                pos_aux = 1;
                while (temp_no != null && posicao > pos_aux) {
                    temp_no = temp_no.prox;
                    pos_aux++;
                }
                novoNo.prox = temp_no.prox;
                temp_no.prox = novoNo;
            } else {
                if (posicao > numero_nos) {
                    ultimo.prox = novoNo;
                    ultimo = novoNo;
                }
            }
        }
    }


    public int buscaNo(int buscaValor) {
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            if (temp_no.valor == buscaValor) {
                return temp_no.quantidade; // Retorna a quantidade para o nó encontrado
            }
            temp_no = temp_no.prox;
        }
        return -1; // Valor não encontrado na lista
    }

    public String buscaNome(int buscaValor) {
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            if (temp_no.valor == buscaValor) {
                return temp_no.nome; // Retorna a quantidade para o nó encontrado
            }
            temp_no = temp_no.prox;
        }
        return ""; // Valor não encontrado na lista
    }

    public void alteraNo(int buscaValor, int quantidade) {
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            if (temp_no.valor == buscaValor) {
                temp_no.quantidade = quantidade; // Muda o valor
            }
            temp_no = temp_no.prox;
        }

    }


    public void excluiNo (int valor){
        IntNoSimples temp_no = primeiro;
        IntNoSimples anterior_no=null;
        while (temp_no != null && temp_no.valor != valor){
            anterior_no = temp_no;
            temp_no = temp_no.prox;
        }
        if (temp_no == primeiro){
            if (temp_no.prox !=null)
                primeiro = temp_no.prox;
            else
                primeiro = null;
        }
        else{
            anterior_no.prox =temp_no.prox;
        }
        
        if (ultimo == temp_no)
            ultimo = anterior_no;
    }
    public String exibeLista() {
        IntNoSimples temp_no = primeiro;
        int i = 0;

        if (temp_no != null) {
            String intermed = "";
            while (temp_no != null) {
                intermed+= "Livro: "+ temp_no.nome + ", quantidade de livros: " + String.valueOf(temp_no.quantidade)+"\n";
                temp_no = temp_no.prox;
                i++;
            }
            return intermed;
        }
        return "";
    }
    public void atualizarQuantidade(int id, int novaQuantidade) {
    IntNoSimples tempNo = primeiro;
    while (tempNo != null) {
        if (tempNo.valor == id) {
            tempNo.quantidade = novaQuantidade; // Atualiza a quantidade
            return;
        }
        tempNo = tempNo.prox;
    }
}

}
