/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModelCliente;
import Model.ModelNota;
import Model.ModelProduto;
import Model.ModelVerdoce;
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

    private static final String urlNotas = "src\\Dados\\Notas.json";
    private static final String urlProdutos = "src\\Dados\\Produtos.json";
    private static final String urlClientes = "src\\Dados\\Clientes.json";

    public static void gravar() {
        JSONArray ja = new JSONArray();
        int cont = 1;

        for (ModelNota a : ModelNota.getListaNota()) {
            
            JSONObject jb = new JSONObject();
            jb.put("Cliente: ", a.getCliente());

            ArrayList<String> aux = new ArrayList<String>();

            jb.put("Produto: ", a.getProduto());
            jb.put("Unidade: ", a.getUni());
            jb.put("Sabor: ", a.getSabor());
            jb.put("qtd: ", a.getQtd());
            jb.put("Total: ", a.getTotal());
            ja.add(jb);
        }

        FileWriter fw;
        try {
            fw = new FileWriter(urlNotas);
            fw.write(ja.toJSONString());
            fw.close();
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public static void carregar() {
        File arq = new File(urlNotas);
        boolean arqOk = (arq.exists() && arq.canRead());
        if (arqOk) {
            JSONParser jParse = new JSONParser();
            try {
                JSONArray jArray = (JSONArray) jParse.parse(new FileReader(urlNotas));

                for (Object o : jArray) {
                    JSONObject a = (JSONObject) o;

                    String cliente = a.get("Cliente: ").toString();

                    ArrayList<String> produto = new ArrayList<String>();
                    produto = (ArrayList<String>) a.get("Produto: ");
                    
                    ArrayList<String> uni = new ArrayList<String>();
                    uni = (ArrayList<String>) a.get("Unidade: ");

                    ArrayList<String> sabor = new ArrayList<String>();
                    sabor = (ArrayList<String>) a.get("Sabor: ");

                    ArrayList<Integer> qtd = new ArrayList<Integer>();
                    qtd = (ArrayList<Integer>) a.get("qtd: ");

                    String total = a.get("Total: ").toString();

                    new ModelNota(cliente, produto, uni, qtd, sabor, Double.parseDouble(total));
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
    }

    public static void gravarProduto() {
        JSONArray ja = new JSONArray();

        for (ModelProduto a : ModelProduto.lista) {
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

    public static void carregarProduto() {
        File arq = new File(urlProdutos);
        boolean arqOk = arq.exists() && arq.canRead();

        if (arqOk) {
            JSONParser par = new JSONParser();

            try {
                JSONArray ja = (JSONArray) par.parse(new FileReader(urlProdutos));

                for (Object o : ja) {
                    JSONObject a = (JSONObject) o;

                    String nome = a.get("Nome: ").toString();
                    double preco = Double.parseDouble(a.get("Preço: ").toString());
                    String un = a.get("Unidade: ").toString();
                    ArrayList<String> st = new ArrayList<String>();

                    st = (ArrayList<String>) a.get("SaboTipo: ");

                    new ModelProduto(nome, preco, un, st);
                }
            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public static void gravarCliente() {
        JSONArray ja = new JSONArray();

        for (ModelCliente a : ModelCliente.getListaClilente()) {
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
            o.put("TelCell: ", a.getTelCelular());
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

    public static void carregarCliente() {
        File arq = new File(urlClientes);
        boolean arqOk = arq.exists() && arq.canRead();

        if (arqOk) {
            JSONParser par = new JSONParser();

            try {
                JSONArray ja = (JSONArray) par.parse(new FileReader(urlClientes));

                for (Object o : ja) {
                    JSONObject a = (JSONObject) o;

                    String nome = a.get("Nome: ").toString();
                    String sobreNome = a.get("Sobrenome: ").toString();
                    String sexo = a.get("Sexo: ").toString();
                    String cpf = a.get("CPF: ").toString();
                    int dia = Integer.parseInt(a.get("Dia: ").toString());
                    int mes = Integer.parseInt(a.get("Mes: ").toString());
                    int ano = Integer.parseInt(a.get("Ano: ").toString());
                    String endereco = a.get("Endereco: ").toString();
                    int NumeroResi = Integer.parseInt(a.get("NumeroResi: ").toString());
                    int telFixo = Integer.parseInt(a.get("TelFixo: ").toString());
                    int telCelular = Integer.parseInt(a.get("TelCell: ").toString());
                    String email = a.get("Email: ").toString();
                    String PJF = a.get("TipoPessoa: ").toString();

                    new ModelCliente(
                            nome,
                            sobreNome,
                            sexo,
                            cpf,
                            dia,
                            mes,
                            ano,
                            endereco,
                            NumeroResi,
                            telFixo,
                            telCelular,
                            email,
                            PJF
                    );
                }
            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

    }

}
