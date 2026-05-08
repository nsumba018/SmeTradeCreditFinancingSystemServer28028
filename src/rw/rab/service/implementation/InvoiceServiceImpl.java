/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.rab.service.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rw.rab.dao.InvoiceDao;
import rw.rab.model.Invoice;
import rw.rab.service.InvoiceService;

/**
 *
 * @author nsumba
 */
public class InvoiceServiceImpl extends UnicastRemoteObject implements InvoiceService{
    
    InvoiceDao dao = new InvoiceDao();
    
    public InvoiceServiceImpl() throws RemoteException{
        super();
    }

    @Override
    public String createInvoice(Invoice invoice) throws RemoteException {
        return dao.createInvoice(invoice); 
    }

    @Override
    public String updateInvoice(Invoice invoice) throws RemoteException {
        return dao.updateInvoice(invoice); 
    }

    @Override
    public String deleteInvoice(Invoice invoice) throws RemoteException {
        return dao.deleteInvoice(invoice); 
    }

    @Override
    public List<Invoice> getAllInvoices() throws RemoteException {
        return dao.getAllInvoices(); 
    }

    @Override
    public Invoice getInvoiceById(Invoice invoice) throws RemoteException {
        return dao.getInvoiceById(invoice); 
    }
    
}
