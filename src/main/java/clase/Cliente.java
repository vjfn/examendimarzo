package clase;

public class Cliente {

    private Integer id;
    private String nombre;
    private String sexo;
    private Double peso;
    private Integer edad;
    private Double talla;
    private String tipoactividad;
    private String observaciones;
    private Double GER;
    private Double GET;


    public Cliente() {}

    public Cliente(Integer id, String nombre, String sexo, Double peso, Integer edad, Double talla, String tipoactividad, String observaciones, Double GER, Double GET) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.peso = peso;
        this.edad = edad;
        this.talla = talla;
        this.tipoactividad = tipoactividad;
        this.observaciones = observaciones;
        this.GER = GER;
        this.GET = GET;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getTalla() {
        return talla;
    }

    public void setTalla(Double talla) {
        this.talla = talla;
    }

    public String getTipoactividad() {
        return tipoactividad;
    }

    public void setTipoactividad(String tipoactividad) {
        this.tipoactividad = tipoactividad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Double getGER() {
        return GER;
    }

    public void setGER(Double GER) {
        this.GER = GER;
    }

    public Double getGET() {
        return GET;
    }

    public void setGET(Double GET) {
        this.GET = GET;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", peso=" + peso +
                ", edad=" + edad +
                ", talla=" + talla +
                ", tipoactividad='" + tipoactividad + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", GER=" + GER +
                ", GET=" + GET +
                '}';
    }
}
