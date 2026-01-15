package database.rrDTOs;

public class rrEntomologoDTO {
    public String rrUsuario;
    public String rrNombreCompleto;
    public int rrIntentosLogin;

    public rrEntomologoDTO() {}

    public rrEntomologoDTO(String rrUsuario, String rrNombre) {
        this.rrUsuario = rrUsuario;
        this.rrNombreCompleto = rrNombre;
    }

    public String rrGetUsuario() { return rrUsuario; }
    public void rrSetUsuario(String rrU) { this.rrUsuario = rrU; }
    public String rrGetNombreCompleto() { return rrNombreCompleto; }
    public void rrSetNombreCompleto(String rrN) { this.rrNombreCompleto = rrN; }
}
