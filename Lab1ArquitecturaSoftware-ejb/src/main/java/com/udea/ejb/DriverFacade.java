/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udea.ejb;

import com.udea.modelo.Driver;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JuanFer
 */
@Stateless
public class DriverFacade extends AbstractFacade<Driver> implements DriverFacadeLocal {

    @PersistenceContext(unitName = "com.udea_Lab1ArquitecturaSoftware-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DriverFacade() {
        super(Driver.class);
    }

    public List<Driver> getAllDrivers() {
        Query query = em.createNamedQuery("Driver.findAll");
        return query.getResultList();
    }

    public boolean cedulaExists(String cedula) {
        String queryString = "SELECT COUNT(d) FROM Driver d WHERE d.cedula = :cedula";
        Query query = em.createQuery(queryString);
        query.setParameter("cedula", cedula);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }

    
    public boolean telefonoExists(String telefono) {
        String queryString = "SELECT COUNT(d) FROM Driver d WHERE d.telefono = :telefono";
        Query query = em.createQuery(queryString);
        query.setParameter("telefono", telefono);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }

    public boolean correoExists(String correo) {
        String queryString = "SELECT COUNT(d) FROM Driver d WHERE d.correo = :correo";
        Query query = em.createQuery(queryString);
        query.setParameter("correo", correo);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }
    
    public boolean placaVehiculoExists(String placaVehiculo) {
        String queryString = "SELECT COUNT(d) FROM Driver d WHERE d.placaVehiculo = :placaVehiculo";
        Query query = em.createQuery(queryString);
        query.setParameter("placaVehiculo", placaVehiculo);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }
}
