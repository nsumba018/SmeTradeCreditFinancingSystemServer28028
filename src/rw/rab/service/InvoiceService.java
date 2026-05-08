/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.rab.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rw.rab.model.Invoice;

/**
 *
 * @author nsumba
 */
public interface InvoiceService extends Remote{
    public String createInvoice(Invoice invoice) throws RemoteException;
    public String updateInvoice(Invoice invoice) throws RemoteException;
    public String deleteInvoice(Invoice invoice) throws RemoteException;
    public List<Invoice> getAllInvoices() throws RemoteException;
    public Invoice getInvoiceById(Invoice invoice) throws RemoteException;
}
