package com.udea.controller;

import com.udea.ejb.DriverFacadeLocal;
import com.udea.modelo.Driver;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class DriverBean implements Serializable {

    @EJB
    private DriverFacadeLocal driverFacade;
    private UIComponent myButton;
    private String cedula;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String vehiculo;
    private String placaVehiculo;
    private int conductorActivado;
    public boolean disable = true;
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    private List<Driver> driversList;

    public DriverBean() {
    }

    public UIComponent getMyButton() {
        return myButton;
    }

    public void setMyButton(UIComponent myButton) {
        this.myButton = myButton;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public List<Driver> getDrivers() {
        if ((this.driversList == null) || (this.driversList.isEmpty())) {
            this.refresh();
        }
        return this.driversList;
    }

    public void refresh() {
        this.driversList = this.driverFacade.getAllDrivers();
    }

    public int getConductorActivado() {
        return conductorActivado;
    }

    public void setConductorActivado(int conductorActivado) {
        this.conductorActivado = conductorActivado;
    }

    public String saveDriver() {
        if (this.cedula.length() == 0 || this.cedula == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(myButton.getClientId(), new FacesMessage("El nombre es obligatorio"));
            return null;
        }
        Driver driver = new Driver();
        driver.setCedula(cedula);
        driver.setNombre(nombre);
        driver.setApellidos(apellidos);
        driver.setCorreo(correo);
        driver.setTelefono(telefono);
        driver.setVehiculo(vehiculo);
        driver.setPlacaVehiculo(placaVehiculo);
        driver.setConductorActivado(conductorActivado);
        this.driverFacade.create(driver);
        return "Driver Created";

    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getLanguage() {
        return this.locale.getLanguage();
    }

    public void changeLanguage(String language) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }
}
