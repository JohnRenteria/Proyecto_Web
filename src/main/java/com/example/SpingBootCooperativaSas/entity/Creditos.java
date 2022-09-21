package com.example.SpingBootCooperativaSas.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="creditosos")
public class Creditos  implements Serializable {

   @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name="fecha_desembolso")
    @Temporal(TemporalType.DATE)
    private Date fechaDesembolso;
    @PrePersist
    public void PrePersist(){
        this.fechaDesembolso=new Date();
    }
    @Column(name="monto_prestado", nullable = false)
    private int montoPrestado;
    @Column(name = "plazo_prestado",nullable = false)
    private int plazoPrestado;

    @ManyToOne (fetch = FetchType.LAZY,optional = false)

    @JoinColumn(name="documentocliente",nullable = false)
    private Cliente cliente;


  /*@ManyToOne (fetch = FetchType.LAZY,optional = false)
  @JoinColumn(name="codigo_linea", nullable = false)
  @JsonIgnore*/


    //private LineasDeCredito lc;

    public Creditos(int codigo, int montoPrestado, int plazoPrestado, Date fechaDesembolso, Cliente cliente) {
        this.codigo = codigo;
        this.montoPrestado = montoPrestado;
        this.plazoPrestado = plazoPrestado;
        this.fechaDesembolso = fechaDesembolso;
        this.cliente= cliente;
       // this.lc = lc;

    }

    public Creditos() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMontoPrestado() {
        return montoPrestado;
    }

    public void setMontoPrestado(int montoPrestado) {
        this.montoPrestado = montoPrestado;
    }

    public int getPlazoPrestado() {
        return plazoPrestado;
    }

    public void setPlazoPrestado(int plazoPrestado) {
        this.plazoPrestado = plazoPrestado;
    }

    public Date getFechaDesembolso() {
        return fechaDesembolso;
    }

    public void setFechaDesembolso(Date fechaDesembolso) {
        this.fechaDesembolso = fechaDesembolso;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cli) {
        this.cliente = cliente;
    }

   /* public LineasDeCredito getLc() {
        return lc;
    }

    public void setLc(LineasDeCredito lc) {
        this.lc = lc;
    }*/
}
