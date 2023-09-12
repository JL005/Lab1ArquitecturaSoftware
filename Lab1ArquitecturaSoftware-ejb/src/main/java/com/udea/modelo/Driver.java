package com.udea.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "driver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d"),
    @NamedQuery(name = "Driver.findByCedula", query = "SELECT d FROM Driver d WHERE d.cedula = :cedula"),
    @NamedQuery(name = "Driver.findByNombre", query = "SELECT d FROM Driver d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Driver.findByApellidos", query = "SELECT d FROM Driver d WHERE d.apellidos = :apellidos"),
    @NamedQuery(name = "Driver.findByCorreo", query = "SELECT d FROM Driver d WHERE d.correo = :correo"),
    @NamedQuery(name = "Driver.findByTelefono", query = "SELECT d FROM Driver d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Driver.findByVehiculo", query = "SELECT d FROM Driver d WHERE d.vehiculo = :vehiculo"),
    @NamedQuery(name = "Driver.findByPlacaVehiculo", query = "SELECT d FROM Driver d WHERE d.placaVehiculo = :placaVehiculo"),
    @NamedQuery(name = "Driver.findByconductorActivado", query = "SELECT d FROM Driver d WHERE d.conductorActivado = :conductorActivado")})
public class Driver implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vehiculo")
    private String vehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "placaVehiculo")
    private String placaVehiculo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "conductorActivado")
    private int conductorActivado;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "cedula")
    private String cedula;

    public Driver() {
    }

    public Driver(String cedula) {
        this.cedula = cedula;
    }

    public Driver(String cedula, String nombre, String apellidos, String correo, String telefono, String vehiculo, String placaVehiculo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.vehiculo = vehiculo;
        this.placaVehiculo = placaVehiculo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "com.udea.entities.Driver[ cedula=" + cedula + " ]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public int getConductorActivado() {
        return conductorActivado;
    }

    public void setConductorActivado(int conductorActivado) {
        this.conductorActivado = conductorActivado;
    }
    
}
