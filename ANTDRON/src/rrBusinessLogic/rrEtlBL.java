package rrBusinessLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import rrDataAccess.rrDAOs.rrHLarvaDAO;

public class rrEtlBL {
    private rrHLarvaDAO rrHLarvaDAO = new rrHLarvaDAO();

    public void rrProcesarHormigas(String rrNombreArchivo) throws Exception {
        String rrRuta = "src/Storage/DataFiles/" + rrNombreArchivo;
        File rrFile = new File(rrRuta);
        
        if (!rrFile.exists()) throw new Exception("Archivo no encontrado en: " + rrRuta);

        try (BufferedReader rrBr = new BufferedReader(new FileReader(rrFile))) {
            String rrLinea;
            while ((rrLinea = rrBr.readLine()) != null) {
                if (rrLinea.trim().isEmpty()) continue;
                
                String[] rrPartes = rrLinea.split(",");
                if (rrPartes.length >= 2) {
                    rrMostrarLoading(rrPartes[0].trim());
                    rrHLarvaDAO.rrCreate(rrPartes[0].trim(), 1, 1);
                    System.out.println(" [OK]");
                }
            }
        }
    }

    private void rrMostrarLoading(String rrDato) throws InterruptedException {
        String[] rrAnim = {"|", "/", "-", "\\"};
        for (int i = 0; i < 5; i++) {
            System.out.print("\r[+] Loading " + rrAnim[i % 4] + " : " + rrDato);
            Thread.sleep(100);
        }
    }
}