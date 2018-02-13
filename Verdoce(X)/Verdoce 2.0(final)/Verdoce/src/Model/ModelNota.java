/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Check;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.GregorianCalendar;

/**
 *
 * @author aluno
 */
public class ModelNota {

    private String cliente;
    private String CPF;
    private String NF;
    private ArrayList<String> produto = new ArrayList<String>();
    private ArrayList<Double> preco = new ArrayList<Double>();
    private ArrayList<String> uni = new ArrayList<String>();
    private ArrayList<String> sabor = new ArrayList<String>();
    private ArrayList<Integer> qtd = new ArrayList<Integer>();
    private double total;
    private boolean ok = true;

    private static ArrayList<ModelNota> listaNota = new ArrayList<ModelNota>();

    public ModelNota(String cliente, ArrayList<Double> preco, String CPF, ArrayList<String> produto, ArrayList<String> uni, ArrayList<Integer> qtd, ArrayList<String> sabor, double total) {
        setCliente(cliente);
        setPreco(preco);
        setCPF(CPF);
        setProduto(produto);
        setUni(uni);
        setSabor(sabor);
        setQtd(qtd);
        setTotal(total);
        setNF();

        if (ok) {
            listaNota.add(this);
        } else {
            throw new IllegalArgumentException("Nota não gerada.");
        }
    }

    public ModelNota(String cliente, ArrayList<Double> preco, String CPF, ArrayList<String> produto, ArrayList<String> uni, ArrayList<Integer> qtd, ArrayList<String> sabor, double total, String NF) {
        setCliente(cliente);
        setPreco(preco);
        setCPF(CPF);
        setProduto(produto);
        setUni(uni);
        setSabor(sabor);
        setQtd(qtd);
        setTotal(total);
        setNF(NF);
        
        if (ok) {
            listaNota.add(this);
        } else {
            throw new IllegalArgumentException("Nota não gerada.");
        }
    }

    public ModelNota(ArrayList<Double> preco, ArrayList<String> produto, ArrayList<String> uni, ArrayList<Integer> qtd, ArrayList<String> sabor, double total) {
        setPreco(preco);
        setProduto(produto);
        setUni(uni);
        setSabor(sabor);
        setQtd(qtd);
        setTotal(total);
        setNF();
        
        if (ok) {
            listaNota.add(this);
        } else {
            throw new IllegalArgumentException("Nota não gerada.");
        }
    }

    public ModelNota(ArrayList<Double> preco, ArrayList<String> produto, ArrayList<String> uni, ArrayList<Integer> qtd, ArrayList<String> sabor, double total, String NF) {
        setPreco(preco);
        setProduto(produto);
        setUni(uni);
        setSabor(sabor);
        setQtd(qtd);
        setTotal(total);
        setNF(NF);
        
        if (ok) {
            listaNota.add(this);
        } else {
            throw new IllegalArgumentException("Nota não gerada.");
        }
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        try {
            this.cliente = Check.checkNome(cliente);
        } catch (Exception e) {
            ok = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        try {
            this.CPF = Check.checkCpf(CPF);
        } catch (Exception e) {
            ok = false;
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<String> getProduto() {
        return produto;
    }

    public void setProduto(ArrayList<String> produto) {
        try {
            this.produto = produto;
        } catch (Exception e) {
            ok = false;
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Double> getPreco() {
        return preco;
    }

    public void setPreco(ArrayList<Double> preco) {
        this.preco = preco;
    }

    public String getNF() {
        return NF;
    }

    public void setNF() {
        try {
            GregorianCalendar cal = new GregorianCalendar();
            String dia = Integer.toString(cal.get(GregorianCalendar.DAY_OF_MONTH));
            String mes = Integer.toString(cal.get(GregorianCalendar.MONTH));
            String ano = Integer.toString(cal.get(GregorianCalendar.YEAR));
            String numNota = Integer.toString(getListaNota().size() + 1);
            String NF = dia + mes + ano + numNota;
            this.NF = NF;
        }catch(Exception e){
            ok = false;
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void setNF(String NF) {
        this.NF = NF;
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
        try {
            this.total = Check.checkPreco(total);
        } catch (Exception e) {
            ok = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
