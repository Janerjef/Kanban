package model;

public class TicketModel {
    private int id;
    private String titulo;
    private String Texto;
    private int areaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public int getAreaId() { return areaId; }

    public void setAreaId(int areaId) { this.areaId = areaId; }
}

