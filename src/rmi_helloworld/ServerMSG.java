/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_helloworld;

import java.rmi.RemoteException;

/**
 *
 * @author Windows 7
 */
public class ServerMSG implements ServerMSG_Interface{
    
    
    protected ServerMSG(String mensagem) throws RemoteException{
        super();
    }
    
    @Override
    public void enviarMensagemCliente(String msg) throws RemoteException{
       System.out.println(msg); 
    }
    
    @Override
    public void enviarMensagemServidor(String msg) throws RemoteException{
       System.out.println("Mensagem do cliente:"+msg); 
    } 
    
   private String msg;
   

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
