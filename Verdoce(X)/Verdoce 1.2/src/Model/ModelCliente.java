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
public class ModelCliente {
    private String nomePessoa;
    private String sobrenomePessoa;
    private String sexo;
    private String cpf;
    private int dia,mes,ano;
    private String dateNascimento;
    private String endereco;
    private int NumeroResi;
    private int telFixo;
    private int telCelular;
    private String email;
    private String PJF;
    private boolean ok = true;
    private ArrayList<ModelNota> listaNota = new ArrayList<ModelNota>();
    
    private static ArrayList<ModelCliente> listaCliente = new ArrayList<ModelCliente>();
    
    public ModelCliente(
            String nome,
            String sobreNome,
            String sexo,
            String cpf, 
            int dia, 
            int mes, 
            int ano,
            String endereco, 
            int NumeroResi, 
            int telFixo, 
            int telCelular,
            String email,
            String PJF) {
        
        this.setNomePessoa(nome);
        this.setSexo(sexo);
        this.setCpf(cpf);
        this.setDia(dia);
        this.setMes(mes);
        this.setAno(ano);
        this.setEndereco(endereco);
        this.setNumeroResi(NumeroResi);
        this.setTelFixo(telFixo);
        this.setTelCelular(telCelular);
        this.setEmail(email);
        this.setPJF(PJF);
        
        if(ok){
            listaCliente.add(this);
        }else throw new IllegalArgumentException("Cadastro Não foi efetuado.");
       
    }
    
    
    
    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        try{
            this.nomePessoa = Check.checkNome(nomePessoa);
        }catch(Exception e){
            ok = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public String getSobrenomePessoa() {
        return sobrenomePessoa;
    }

    public void setSobrenomePessoa(String sobrenomePessoa) {
        try{
            this.sobrenomePessoa = Check.checkNome(sobrenomePessoa);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try{
            this.email = Check.checkEmail(email);
        }catch(Exception e){
            ok = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        try{
            this.cpf = Check.checkCpf(cpf);
        }catch(Exception e){
            ok = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDateNascimento() {
        return dateNascimento;
    }

    public void setDateNascimento(String dateNascimento) {
        this.dateNascimento = Integer.toString(getDia()) + "/" + Integer.toString(getMes())+ "/" + Integer.toString(getAno());
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public int getNumeroResi() {
        return NumeroResi;
    }

    public void setNumeroResi(int NumeroResi) {
        try{
            this.NumeroResi = Check.checkNumResi(NumeroResi);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(int telefone) {
        try{
        this.telFixo = Check.checkFoneFixo(telefone);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public int getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(int cell) {
        try{
            this.telCelular = Check.checkCelular(cell);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String getPJF() {
        return PJF;
    }

    public void setPJF(String PJF) {
        this.PJF = PJF;
    }
    
    public static ArrayList<ModelCliente> getListaClilente(){
        return listaCliente;
    }
    
    public ArrayList<ModelNota> getListaNota() {
        return listaNota;
    }

    public void setListaNota(ModelNota listaVer) {
        this.listaNota.add(listaVer);
    }
}
