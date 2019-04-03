/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Classe Prato, contendo os atributos e comportamentos dos objetos de tipo Prato. 
 * @author Guilherme Rafael Deschamps
 * @since 01/04/2018.
 */
public class Prato {
    
    private String nome;
    private String descricao;
    private float preco;
    
    public Prato(){
        super();
    }
    
    /**
     * Métodos Getters e Setters dos atributos dos objetos de tipo Prato.
     */

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }
        
    public String getDescricao() {
        return descricao;
    }

    public float getPreco() {
        return preco;
    }
        
    
}
