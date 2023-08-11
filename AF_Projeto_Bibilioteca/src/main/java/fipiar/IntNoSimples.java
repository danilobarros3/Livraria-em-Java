/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fipiar;

/**
 *
 * @author marco
 */
public class IntNoSimples {
    
    int valor;
    int quantidade;
    String nome;
    IntNoSimples prox;
    
    public IntNoSimples(int ValorNo, int quant){
        valor = ValorNo;
        prox = null;
        this.quantidade = quant;
    }

    public IntNoSimples(int ValorNo, String nome, int quant){
        valor = ValorNo;
        prox = null;
        this.quantidade = quant;
        this.nome = nome;
    }
    
 }
