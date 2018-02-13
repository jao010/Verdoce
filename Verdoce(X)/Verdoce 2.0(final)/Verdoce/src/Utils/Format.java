/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author João Paulo
 */
public class Format {

    /**
     * Formata o numero de CPF
     *
     * @return String
     * @author João Paulo
     */
    public static String formatCpf(String cpf) {
            if(!cpf.isEmpty() || !cpf.equals(null)){
                String CPFF = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
                return CPFF;
            }else return cpf;
        }

    }
