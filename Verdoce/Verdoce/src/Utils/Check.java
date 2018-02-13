/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author João Paulo
 */
public class Check {

    public static String checkLogin(String login) {
        if (login.length() > 5) {
            return login;
        } else {
            throw new IllegalArgumentException("Login inválido.");
        }
    }

    /**
     * Verifica se o nome é compativel para ser gravavel
     *
     * @author João
     * @param nome
     * @return Sring
     */
    public static String checkNome(String nome) {
        if (nome.length() >= 3) {
            return nome;
        } else {
            throw new IllegalArgumentException("Nome Inválido.");
        }
    }

    /**
     * Verifica se o produto é compativel para ser gravavel náo podendo ser
     * repitido
     *
     * @author Mayara
     * @param produto
     * @return
     */
    public static String checkProduto(String produto) {
        if (produto.length() >= 3) {
            for (Model.ModelProduto a : Model.ModelProduto.getLista()) {
                if (produto.equals(a.getNome())) {
                    throw new IllegalArgumentException("O nome já existe");

                }
            }
            return produto;
        } else {
            throw new IllegalArgumentException("Nome Inválido.");
        }

    }

    /**
     * Verifica se o preço é compativel para ser gravavel
     *
     * @author Luiz Rodrigo
     * @param preco
     * @return
     */
    public static double checkPreco(double preco) {
        if (preco > 0) {
            return preco;
        } else {
            throw new IllegalArgumentException("Preço inválido.");
        }
    }

    /**
     * Verifica se o quantidade escolhida pelo usuário é compativel para ser
     * gravavel
     *
     * @param qtd
     * @return
     */
    public static int checkQtd(int qtd) {
        if (qtd > 0) {
            return qtd;
        } else {
            throw new IllegalArgumentException("Quantidade tem que ser maior que 0");
        }
    }

    /**
     * Verifica se a unidade de medida é compativel para ser gravavel
     *
     * @param un
     * @return
     */
    public static String checkUnidade(String un) {
        if (un != null) {
            return un;
        } else {
            throw new IllegalArgumentException("Unidade de medida inválida.");
        }
    }

    /**
     * Passa como parametro um ArrayList de String
     *
     * @param st
     * @return
     */
    public static ArrayList<String> checkSaboTipo(ArrayList<String> st) {
        return st;

    }

    /**
     * Verifica se o e-mail é valido
     *
     * @param email
     * @return
     */
    public static String checkEmail(String email) {
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return email;
            } else {
                throw new IllegalArgumentException("E-mail inválido.");
            }
        }
        throw new IllegalArgumentException("E-mail inválido.");
    }

    /**
     * Verifica se o CPF é valido pela regras oficias da receita federal
     *
     * @param CPF
     * @return
     */
    public static String checkCpf(String CPF) {

        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            throw new IllegalArgumentException("CPF inválido.");
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {

            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {

                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return CPF;
            } else {
                throw new IllegalArgumentException("CPF inválido.");
            }
        } catch (InputMismatchException erro) {
            throw new IllegalArgumentException("CPF inválido.");
        }
    }

    /**
     * Verifica se telefone celular tem exatamente 9 dígitos.
     *
     * @param celular
     * @return
     */
    public static int checkCelular(int celular) {
        String cell = Integer.toString(celular);

        if (cell.length() >= 9 || cell.length() <=11 ) {
            return celular;
        } else {
            throw new IllegalArgumentException("Numero do celular tem que ter 9 digítos.");
        }
    }

    /**
     * Verifica se telefone fixo tem exatamente 8 dígitos.
     *
     * @param num
     * @return
     */
    public static int checkFoneFixo(int num) {
        String fixo = Integer.toString(num);
        if (fixo.length() == 8) {
            return num;
        } else {
            throw new IllegalArgumentException("Numero do telefone fixo tem que ter 8.");
        }
    }

    public static int checkNumResi(int resi) {
        String resid = Integer.toString(resi);
        if (resid.length() > 0) {
            return resi;
        } else {
            throw new IllegalArgumentException("Numero da casa invalído.");
        }
    }

    public static double ValidaNumero(JTextField Numero) {
        double valor;
        if (Numero.getText().length() != 0) {
            try {
                valor = Double.parseDouble(Numero.getText());
                return valor;
            } catch (NumberFormatException ex) {
                Numero.grabFocus();
                throw new IllegalArgumentException("Esse Campo só aceita números");
            }
        }else throw new IllegalArgumentException("Valor Invalído.");
    }
    
}
