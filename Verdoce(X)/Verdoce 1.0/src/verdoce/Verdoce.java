/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verdoce;

import DAO.DaoVerdoce;
import View.ViewIndex;

/**
 *
 * @author João Paulo
 */
public class Verdoce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DaoVerdoce.carregar();
        DaoVerdoce.carregarProduto();
        ViewIndex vi = new ViewIndex();
        vi.setVisible(true);
        vi.setLocationRelativeTo(null);
    }
    
}
