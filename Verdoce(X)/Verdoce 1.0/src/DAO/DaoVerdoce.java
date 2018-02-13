/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author João Paulo
 */
public class DaoVerdoce {
    private static final String urlVendas = "src\\Dados\\Compras.json";
    private static final String urlProdutos = "src\\Dados\\Produtos.json";
    private static final String urlClientes = "src\\Dados\\Clientes.json";
    
    public static void gravar(ArrayList<ModelVerdoce> produto){
        JSONArray ja = new JSONArray();
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        formatador.format(data);
         
        for(ModelVerdoce a: produto){
            JSONObject jb = new JSONObject();
            jb.put("Nome: ", a.getNomeP());
            jb.put("Preço: ", a.getPreco());
            jb.put("Quantidade: ", a.getQtd());
            jb.put("Data: ", a.getData());
            ja.add(jb);
        }
        
        FileWriter fw;
        try {
            fw = new FileWriter(urlVendas);
            fw.write(ja.toJSONString());
            fw.close();
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
    
    public static void carregar(){
       File arq = new File(urlVendas);
       boolean arqOk = (arq.exists() && arq.canRead());
       if(arqOk){
           JSONParser jParse = new JSONParser();
           try {
               JSONArray jArray = (JSONArray) jParse.parse(new FileReader(urlVendas));
               
               for(Object o: jArray){
                   JSONObject a = (JSONObject) o;
                   
                   String dt = a.get("Data: ").toString();
                   String nome = a.get("Nome: ").toString();
                   double preco = Double.parseDouble(a.get("Preço: ").toString());
                   int qtd = Integer.parseInt(a.get("Quantidade: ").toString());
                   
                   new ModelVerdoce(nome, preco, qtd, dt.toString());
               }
           } catch (IOException ex) {
               JOptionPane.showMessageDialog(null, ex);
           } catch (ParseException ex) {
               JOptionPane.showMessageDialog(null, ex);
           }
           
       }
    }
    
    public static void gravarProduto(){
        JSONArray ja = new JSONArray();
        
        for(ModelProduto a: ModelProduto.lista){
            JSONObject o = new JSONObject();
            o.put("Nome: ", a.getNome());
            o.put("Preço: ", a.getPreco());
            o.put("Unidade: ", a.getUnMedida());
            o.put("SaboTipo: ", a.getSaboTipo());
            ja.add(o);
        }
        
        try {
            FileWriter arq = new FileWriter(urlProdutos);
            arq.write(ja.toString());
            arq.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void carregarProduto(){
        File arq = new File(urlProdutos);
        boolean arqOk = arq.exists() && arq.canRead();
        
        if(arqOk){
            JSONParser par =  new JSONParser();
            
            try{
                JSONArray ja = (JSONArray) par.parse(new FileReader(urlProdutos));
                
                for(Object o: ja){
                    JSONObject a= (JSONObject) o;
                    
                    String nome =  a.get("Nome: ").toString();
                    double preco = Double.parseDouble(a.get("Preço: ").toString());
                    String un = a.get("Unidade: ").toString();
                    ArrayList<String> st = new ArrayList<String>();

                    st = (ArrayList<String>) a.get("SaboTipo: ");
            
                    
                    
                    
                    
                    
                    new ModelProduto(nome,preco,un, st);
                }
            }catch(IOException | ParseException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public static void gravarCliente(){
        JSONArray ja = new JSONArray();
        
        for(ModelAddCliente a: ModelAddCliente.getListaClilente()){
            JSONObject o = new JSONObject();
            o.put("Nome: ", a.getNomePessoa());
            o.put("Sobrenome: ", a.getSobrenomePessoa());
            o.put("Sexo: ", a.getSexo());
            o.put("CPF: ", a.getCpf());
            o.put("Dia: ", a.getDia());
            o.put("Mes: ", a.getMes());
            o.put("Ano: ", a.getAno());
            o.put("Endereco: ", a.getEndereco());
            o.put("NumeroResi: ", a.getNumeroResi());
            o.put("TelFixo: ", a.getTelFixo());
            o.put("TelCell: ", a.getTelFixo());
            o.put("Email: ", a.getEmail());
            o.put("TipoPessoa: ", a.getPJF());
            o.put("DataNascimento: ", a.getDateNascimento());
            ja.add(o);
        }
        
        try {
            FileWriter arq = new FileWriter(urlClientes);
            arq.write(ja.toString());
            arq.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void carregarCliente(){
        File arq = new File(urlClientes);
        boolean arqOk = arq.exists() && arq.canRead();
        
        if(arqOk){
            JSONParser par =  new JSONParser();
            
            try{
                JSONArray ja = (JSONArray) par.parse(new FileReader(urlClientes));
                
                for(Object o: ja){
                    JSONObject a= (JSONObject) o;
                    
                    String nome =  a.get("Nome: ").toString();
                    double preco = Double.parseDouble(a.get("Preço: ").toString());
                    String un = a.get("Unidade: ").toString();
                    ArrayList<String> st = new ArrayList<String>();

                    st = (ArrayList<String>) a.get("SaboTipo: ");
            
                    
                    
                    
                    
                    
                    new ModelProduto(nome,preco,un, st);
                }
            }catch(IOException | ParseException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    
    }
}
