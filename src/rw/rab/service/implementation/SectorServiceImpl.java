/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.rab.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.rab.dao.SectorDao;
import rw.rab.model.Sector;
import rw.rab.service.SectorService;

/**
 *
 * @author nsumba
 */
public class SectorServiceImpl extends UnicastRemoteObject implements SectorService{
    
    SectorDao dao = new SectorDao();
    
    public SectorServiceImpl() throws RemoteException{
        super();
    }

    @Override
    public String createSector(Sector sector) throws RemoteException {
        return dao.createSector(sector); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String updateSector(Sector sector) throws RemoteException {
        return dao.updateSector(sector); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteSector(Sector sector) throws RemoteException {
        return dao.deleteSector(sector); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sector> getAllSectors() throws RemoteException {
        return dao.getAllSectors(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sector getSectorById(Sector sector) throws RemoteException {
        return dao.getSectorById(sector); //To change body of generated methods, choose Tools | Templates.
    }
    
}
