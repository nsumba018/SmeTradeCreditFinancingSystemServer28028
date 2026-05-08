/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.rab.controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rw.rab.service.implementation.FundingServiceImpl;
import rw.rab.service.implementation.InvestorServiceImpl;
import rw.rab.service.implementation.InvoiceServiceImpl;
import rw.rab.service.implementation.SectorServiceImpl;
import rw.rab.service.implementation.SmeServiceImpl;
import rw.rab.service.implementation.UserServiceImpl;

/**
 *
 * @author nsumba
 */
public class Server {
    private UserServiceImpl userServiceImpl;
    private SmeServiceImpl smeServiceImpl;
    private SectorServiceImpl sectorServiceImpl;
    private InvoiceServiceImpl invoiceServiceImpl;
    private InvestorServiceImpl investorServiceImpl;
    private FundingServiceImpl fundingServiveImpl;
    
    public Server() throws RemoteException{
        this.fundingServiveImpl = new FundingServiceImpl();
        this.investorServiceImpl = new InvestorServiceImpl();
        this.invoiceServiceImpl = new InvoiceServiceImpl();
        this.sectorServiceImpl = new SectorServiceImpl();
        this.smeServiceImpl = new SmeServiceImpl();
        this.userServiceImpl = new UserServiceImpl();
    }
    
    public static void main(String[] args) {
        try{
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            Registry registry = LocateRegistry.createRegistry(3000);
            Server server = new Server();
            registry.rebind("user",     server.userServiceImpl);
            registry.rebind("sme",      server.smeServiceImpl);
            registry.rebind("sector",   server.sectorServiceImpl);
            registry.rebind("invoice",  server.invoiceServiceImpl);
            registry.rebind("investor", server.investorServiceImpl);
            registry.rebind("funding",  server.fundingServiveImpl);
            System.out.println("Server is running on port 3000");
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
