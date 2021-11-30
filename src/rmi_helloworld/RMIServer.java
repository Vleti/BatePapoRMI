/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi_helloworld;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmi_helloworld.DAORMIClientInterface;


public class RMIServer {
    
    DAORMIClient msgBuffer;

    public RMIServer(DAORMIClient msgBuffer) throws AlreadyBoundException, MalformedURLException{
        this.msgBuffer=msgBuffer;
        System.setProperty("java.security.policy","file:./politicas.policy");
       // if (System.getSecurityManager() == null)
        //    System.setSecurityManager(new RMISecurityManager());
        
        try{
           System.setProperty("java.rmi.server.hostname", "127.0.0.1");
           //MensagemBuffer mensagem=new MensagemBuffer(10);           //serializar
           DAORMIClientInterface stub=(DAORMIClientInterface) UnicastRemoteObject.exportObject(msgBuffer, 0);
           Registry registry=LocateRegistry.createRegistry(5003);
           registry.rebind("MensagemService", stub);
           System.out.println("Servidor pronto!");
        }catch(RemoteException re){
            re.getStackTrace();
        }
    }  
    

}
