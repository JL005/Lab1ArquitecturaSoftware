/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.udea.ejb;

import com.udea.modelo.Driver;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JuanFer
 */
@Local
public interface DriverFacadeLocal {

    void create(Driver driver);

    void edit(Driver driver);

    void remove(Driver driver);

    Driver find(Object id);

    List<Driver> findAll();

    List<Driver> findRange(int[] range);

    int count();

    List<Driver> getAllDrivers();

    boolean cedulaExists(String cedula);

    boolean telefonoExists(String telefono);

    boolean correoExists(String correo);

    boolean placaVehiculoExists(String placaVehiculos);
}
