/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DesafioIntegral.DesafioIntegral.cozinheiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.DesafioIntegral.DesafioIntegral.prato.Prato;

/**
 * 
 * @author guilh
 */

@Entity
@Table(name = "cozinheiro")
public class Cozinheiro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9193664758018367078L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id_cozinheiro;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "cozinheiro_prato",
			joinColumns = {@JoinColumn(name = "id_cozinheiro")},
			inverseJoinColumns = {@JoinColumn(name = "id_prato")})
	private List<Prato> especialidades = new ArrayList<Prato>();

	public Cozinheiro() {
		super();
	}

	public Cozinheiro(String nome) {
		super();
		this.nome = nome;
	}

	public void addEspecialidade(Prato prato) {
		especialidades.add(prato);
	}

	public List<Prato> getEspecialidades() {
		return especialidades;
	}

	public boolean removeEspecialidade(Prato prato) {
		for (Prato especialidade : especialidades) {
			if (especialidade == prato) {
				especialidades.remove(especialidade);
				return true;
			}
		}

		return false;
	}

	public Long getId_cozinheiro() {
		return id_cozinheiro;
	}

	public void setId_cozinheiro(Long id) {
		this.id_cozinheiro = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}