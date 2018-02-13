/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Check;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paulo
 */
public class ModelProduto {
    private String nome;
    private double preco;
    private String unMedida;
    private ArrayList<String> saboTipo = new ArrayList<String>();
    private boolean ok = true;
    
    public static ArrayList<ModelProduto> lista = new ArrayList<ModelProduto>();
    
    public ModelProduto(String nome, double preco, String unMedida){
        setNome(nome);
        setPreco(preco);
        setUnMedida(unMedida); 
        setSaboTipo(saboTipo);
        
        if(ok){
            lista.add(this);
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Produto não foi criado!");
        }
    }
    
    public ModelProduto(String nome, double preco, String unMedida, ArrayList<String> saboTipo){
        setNome(nome);
        setPreco(preco);
        setUnMedida(unMedida); 
        setSaboTipo(saboTipo);
        
        if(ok){
            lista.add(this);
            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Produto não foi criado!");
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try{
            this.nome = Check.checkNome(nome);
        }catch(Exception e){
            ok = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        try{
            this.preco = Check.checkPreco(preco);
        }catch(Exception e){
            ok = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String getUnMedida() {
        return unMedida;
    }

    public void setUnMedida(String unMedida) {
        try{
            this.unMedida = Check.checkUnidade(unMedida);
        }catch(Exception e){
            ok = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ArrayList<String> getSaboTipo() {
        return saboTipo;
    }

    public void setSaboTipo(ArrayList<String> saboTipo) {
        try{
            this.saboTipo = Check.checkSaboTipo(saboTipo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
