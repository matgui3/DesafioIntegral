/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * 
 * @author guilh
 */
public class Cozinheiro {
    private String nome;
    private ArrayList<Prato> especialidades;
    
    public Cozinheiro(){
        super();
        especialidades = new ArrayList<>();
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
    
}