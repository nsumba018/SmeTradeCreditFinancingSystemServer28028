/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.rab.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.rab.model.Sector;

/**
 *
 * @author nsumba
 */
public interface SectorService extends Remote{
    public String createSector(Sector sector) throws RemoteException;
    public String updateSector(Sector sector) throws RemoteException;
    public String deleteSector(Sector sector) throws RemoteException;
    public List<Sector> getAllSectors() throws RemoteException;
    public Sector getSectorById(Sector sector) throws RemoteException;
}
