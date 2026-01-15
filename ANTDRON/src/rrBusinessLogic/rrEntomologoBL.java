package rrBusinessLogic;

import rrDataAccess.rrDAOs.rrEntomologoDAO;

public class rrEntomologoBL implements rrIEntomologo {
    private rrEntomologoDAO rrEntomologoDAO = new rrEntomologoDAO();
    private rrEtlBL rrEtl = new rrEtlBL();

    public boolean rrLogin(String rrUsuario, String rrPassword) throws Exception {
        return rrEntomologoDAO.rrLogin(rrUsuario, rrPassword);
    }

    @Override
    public boolean rrEtlHormigas() throws Exception {
        rrEtl.rrProcesarHormigas("AntNest.txt");
        return true;
    }

    @Override
    public void rrAlimentarHormigas() throws Exception {
    }
}