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
 * @author aluno
 */
public class ModelNota{
    private String cliente;
    private ArrayList<String> produto = new ArrayList<String>();
    private ArrayList<String> uni = new ArrayList<String>();
    private ArrayList<String> sabor = new ArrayList<String>();
    private ArrayList<Integer> qtd = new ArrayList<Integer>();
    private double total;
        
    private static ArrayList<ModelNota> listaNota = new ArrayList<ModelNota>();
    
    public ModelNota(String cliente, ArrayList<String> produto, ArrayList<String> uni, ArrayList<Integer> qtd, ArrayList<String> sabor, double total){
        setCliente(cliente);
        setProduto(produto);
        setUni(uni);
        setSabor(sabor);
        setQtd(qtd);
        setTotal(total);
        listaNota.add(this);
    }
    
     public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        try{
            this.cliente = Check.checkNome(cliente);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ArrayList<String> getProduto() {
        return produto;
    }

    public void setProduto(ArrayList<String> produto) {
        this.produto = produto;
    }
    
    public ArrayList<Integer> getQtd() {
        return qtd;
    }

    public void setQtd(ArrayList<Integer> qtd) {
        this.qtd = qtd;
    }
    
    public ArrayList<String> getSabor() {
        return sabor;
    }
    
    public ArrayList<String> getUni() {
        return uni;
    }

    public void setUni(ArrayList<String> uni) {
        this.uni = uni;
    }

    public void setSabor(ArrayList<String> sabor) {
        this.sabor = sabor;
    }
    
    public static ArrayList<ModelNota> getListaNota() {
        return listaNota;
    }

    public static void setListaNota(ArrayList<ModelNota> listaNota) {
        ModelNota.listaNota = listaNota;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        try{
            this.total = Check.checkPreco(total);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
