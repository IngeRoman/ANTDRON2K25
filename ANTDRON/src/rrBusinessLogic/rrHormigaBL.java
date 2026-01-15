package rrBusinessLogic;

import rrDataAccess.rrDAOs.rrHLarvaDAO;
import rrDataAccess.rrDAOs.rrHormigaDAO;
import rrDataAccess.rrDTOs.rrHormigaDTO;

public class rrHormigaBL {
    private rrHormigaDAO rrHormigaDAO = new rrHormigaDAO();
    private rrHLarvaDAO rrHLarvaDAO = new rrHLarvaDAO();

    public boolean rrAlimentarGlandula(rrHormigaDTO rrHormiga, String rrTipoAlimento, String rrGenoma) throws Exception {
        if (rrHormiga == null || rrTipoAlimento == null || rrGenoma == null) {
            return false;
        }

        if (rrHormiga.rrGetIdTipoHormiga() == 1) {
            int rrNuevoTipo = rrObtenerTipoPorAlimento(rrTipoAlimento);
            int rrNuevoSexo = rrObtenerSexoPorGenoma(rrGenoma);
            
            if (rrNuevoTipo > 0) {
                return rrHLarvaDAO.rrEvolucionar(rrHormiga.rrGetIdHormiga(), rrNuevoTipo);
            }
        }
        return true;
    }

    private int rrObtenerTipoPorAlimento(String rrAlimento) {
        switch (rrAlimento.toUpperCase()) {
            case "NECTARIVOROS": return 4;
            case "CARNIVOROS":   return 2;
            case "HERBIVOROS":   return 5;
            case "OMNIVOROS":    return 3;
            default: return 0;
        }
    }

    private int rrObtenerSexoPorGenoma(String rrGenoma) {
        if (rrGenoma.equalsIgnoreCase("XX")) {
            return 2;
        } else if (rrGenoma.equalsIgnoreCase("XY")) {
            return 1;
        }
        return 3;
    }

    public boolean rrVerificarSuperHabilidad(rrHormigaDTO rrHormiga) throws Exception {
        if (rrHormiga.rrGetIdTipoHormiga() != 1 && rrHormiga.rrGetIdEstado() == 1) {
            return true;
        }
        return false;
    }
}