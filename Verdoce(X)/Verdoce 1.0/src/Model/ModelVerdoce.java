/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.DaoVerdoce;
import Utils.Check;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paulo
 */
public class ModelVerdoce {
    
    private String nomeP;
    private double preco;
    private int qtd;
    private String data;
    private boolean ok = true;
    public static ArrayList<ModelVerdoce> produto = new ArrayList<ModelVerdoce>();
    
    public ModelVerdoce(String nome, double preco, int qtd){
        this.setNomeP(nome);
        this.setPreco(preco);
        this.setQtd(qtd);
        this.setData();
        
        if(ok){
            produto.add(this);
            ok = true; 
        }else throw new IllegalArgumentException("O produto não pode ser comprado.");
    }
    
    public ModelVerdoce(String nome, double preco, int qtd, String d){
        this.setNomeP(nome);
        this.setPreco(preco);
        this.setQtd(qtd);
        this.setDataFixe(d);
        
        if(ok){
            produto.add(this);
            ok = true; 
        }else throw new IllegalArgumentException("O produto não pode ser comprado.");
    }
    
    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        
        try{
            this.nomeP = Check.checkNome(nomeP);
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
        }catch(Exception e) {
            ok = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        try{
            this.qtd = Check.checkQtd(qtd);
        }catch(Exception e){
            ok = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public String getData() {
        return this.data;
    }

    public void setData() {
         
            Date dt = new Date(); 
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            this.data = sdf.format(dt).toString();
    }
    
    public void setDataFixe(String data) {
            this.data = data;
    }
    
    
    public static void gravar(){
        DaoVerdoce.gravar(produto);
    }
    
    public static ArrayList<ModelVerdoce> getProduto(){
        return produto;
    }
}
