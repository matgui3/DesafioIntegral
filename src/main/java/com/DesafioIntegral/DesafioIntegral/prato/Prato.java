/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DesafioIntegral.DesafioIntegral.prato;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Prato, contendo os atributos e comportamentos dos objetos de tipo Prato. 
 * @author Guilherme Rafael Deschamps
 * @since 01/04/2018.
 */

@Entity
@Table(name="prato")
public class Prato {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_prato;
	
	@Column(name = "nome", length = 100, nullable=false)
    private String nome;
	
	@Column(name = "descricao", length = 100)
    private String descricao;
	
	@Column(name = "preco", precision = 10, scale=2, nullable=false)
    private float preco;
    
    public Prato(String nome, String descricao, float preco){
        super();
        this.nome = nome;
        this.descricao = descricao;
        this.preco= preco;
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
