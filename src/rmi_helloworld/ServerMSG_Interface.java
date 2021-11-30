/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_helloworld;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Windows 7
 */
public interface ServerMSG_Interface extends Remote {
    
    void enviarMensagemCliente(String msg) throws RemoteException;
    void enviarMensagemServidor(String msg) throws RemoteException;
    public String getMsg() throws RemoteException;
    public void setMsg(String msg)throws RemoteException;
// 
}
