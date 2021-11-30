/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_helloworld;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Windows 7
 */
public class RMIServerMSG {
    
    ServerMSG msgBuffer;

    public RMIServerMSG(ServerMSG msgBuffer) throws AlreadyBoundException, MalformedURLException{
        this.msgBuffer=msgBuffer;
        System.setProperty("java.security.policy","file:./politicas.policy");
       // if (System.getSecurityManager() == null)
        //    System.setSecurityManager(new RMISecurityManager());
        
        try{
           System.setProperty("java.rmi.server.hostname", "127.0.0.1");
           //MensagemBuffer mensagem=new MensagemBuffer(10);           //serializar
           ServerMSG_Interface stub=(ServerMSG_Interface) UnicastRemoteObject.exportObject(msgBuffer, 0);
           Registry registry=LocateRegistry.createRegistry(5003);
           registry.rebind("MensagemService", stub);
           System.out.println("Servidor pronto!");
        }catch(RemoteException re){
            re.getStackTrace();
        }
    }
}
