package rrDataAccess.rrDTOs;

public class rrHormigaDTO {
    public int rrIdHormiga;
    public int rrIdTipoHormiga;
    public int rrIdSexo;
    public int rrIdEstado;
    public String rrNombre;

    public rrHormigaDTO() {}

    public rrHormigaDTO(String rrNombre, int rrIdTipoHormiga, int rrIdSexo, int rrIdEstado) {
        this.rrNombre = rrNombre;
        this.rrIdTipoHormiga = rrIdTipoHormiga;
        this.rrIdSexo = rrIdSexo;
        this.rrIdEstado = rrIdEstado;
    }

    public int rrGetIdHormiga() { return rrIdHormiga; }
    public void rrSetIdHormiga(int rrId) { this.rrIdHormiga = rrId; }
    public String rrGetNombre() { return rrNombre; }
    public void rrSetNombre(String rrNom) { this.rrNombre = rrNom; }
    public int rrGetIdTipoHormiga() { return rrIdTipoHormiga; }
    public void rrSetIdTipoHormiga(int rrT) { this.rrIdTipoHormiga = rrT; }
    public int rrGetIdSexo() { return rrIdSexo; }
    public void rrSetIdSexo(int rrS) { this.rrIdSexo = rrS; }
    public int rrGetIdEstado() { return rrIdEstado; }
    public void rrSetIdEstado(int rrE) { this.rrIdEstado = rrE; }
}