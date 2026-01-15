package database.rrDTOs;

public class rrAlimentoTipoDTO {
    public int rrIdAlimentoTipo;
    public String rrNombre;
    public String rrDescripcion;
    public String rrEstado;

    public rrAlimentoTipoDTO() {}

    public rrAlimentoTipoDTO(int rrIdAlimentoTipo, String rrNombre, String rrDescripcion) {
        this.rrIdAlimentoTipo = rrIdAlimentoTipo;
        this.rrNombre = rrNombre;
        this.rrDescripcion = rrDescripcion;
    }

    public int rrGetIdAlimentoTipo() { return rrIdAlimentoTipo; }
    public void rrSetIdAlimentoTipo(int rrIdAlimentoTipo) { this.rrIdAlimentoTipo = rrIdAlimentoTipo; }
    public String rrGetNombre() { return rrNombre; }
    public void rrSetNombre(String rrNombre) { this.rrNombre = rrNombre; }
}