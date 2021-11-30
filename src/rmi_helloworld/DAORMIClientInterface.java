/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_helloworld;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author felip
 */
public interface DAORMIClientInterface extends Remote {    
    
    void incluir(int id, String nome) throws RemoteException;
    void alterar(int id, String nome) throws RemoteException;
    void excluir(int id) throws RemoteException;
    void enviarMensagemServidor(String msg) throws RemoteException;
    List<String> consultarPorNome(String dados) throws RemoteException;
}
