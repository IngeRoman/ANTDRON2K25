import java.util.Scanner;
import rrBusinessLogic.rrEntomologoBL;

public class App {
    public static void main(String[] rrArgs) {
        Scanner rrScanner = new Scanner(System.in);
        rrEntomologoBL rrEntBL = new rrEntomologoBL();
        int rrIntentos = 0;
        boolean rrOk = false;

        while (rrIntentos < 3 && !rrOk) {
            System.out.print("User: ");
            String rrU = rrScanner.nextLine();
            System.out.print("Pass: ");
            String rrP = rrScanner.nextLine();

            try {
                if (rrEntBL.rrLogin(rrU, rrP)) {
                    rrOk = true;
                    System.out.println("Bienvenido: Roman Leonardo");
                    rrEntBL.rrEtlHormigas();
                } else {
                    rrIntentos++;
                    System.out.println("Error. Intento " + rrIntentos);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        rrScanner.close();
    }
}