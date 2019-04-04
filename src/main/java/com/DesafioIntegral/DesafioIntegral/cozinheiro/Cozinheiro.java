/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DesafioIntegral.DesafioIntegral.cozinheiro;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.DesafioIntegral.DesafioIntegral.prato.Prato;


/**
 * 
 * @author guilh
 */

@Entity
@Table(name="cozinheiro")
public class Cozinheiro implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_cozinheiro;
	
	@Column(name = "nome", length = 100, nullable=false)
    private String nome;
	
    private ArrayList<Prato> especialidades;
    
    public Cozinheiro(){
        super();
        especialidades = new ArrayList<>();
    }
           
    public Cozinheiro(String nome, ArrayList<Prato> especialidades) {
		super();
		this.nome = nome;
		this.especialidades = especialidades;
	}



	public void addEspecialidade(Prato prato){
        especialidades.add(prato);
    }
    
    public ArrayList<Prato> getEspecialidades(){
        return especialidades;
    }
    
    public boolean removeEspecialidade(Prato prato){
        for(Prato especialidade : especialidades){
            if(especialidade == prato){
                especialidades.remove(especialidade);
                return true;
            }
        }
        
        return false;
    }

	public long getId_cozinheiro() {
		return id_cozinheiro;
	}

	public void setId_cozinheiro(long id_cozinheiro) {
		this.id_cozinheiro = id_cozinheiro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEspecialidades(ArrayList<Prato> especialidades) {
		this.especialidades = especialidades;
	}
    
    
    
}