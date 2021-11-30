/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi_helloworld;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author felip
 */
public class DAORMIClient implements DAORMIClientInterface {

    private static final long serialVersionUID=1L;
    
    List<Cliente> clientes=new ArrayList<>();

    
    protected DAORMIClient(String mensagem) throws RemoteException{
        super();
    }

    @Override
    public void incluir(int id, String nome) throws RemoteException {
        clientes.add(new Cliente(id, nome));
    }

    @Override
    public void alterar(int id, String nome) throws RemoteException {
        Cliente clienteAlterar=null;
        for(Cliente cliente:clientes){
            if(cliente.getId()==id){
                clienteAlterar=cliente;
            }
        }
        clienteAlterar.setNome(nome);
    }

    @Override
    public void excluir(int id) throws RemoteException {
        Cliente clienteExcluir=null;
        for(Cliente cliente:clientes){
            if(cliente.getId()==id){
                clienteExcluir=cliente;
            }
        }
        clientes.remove(clienteExcluir);
    }

    @Override
    public List<String> consultarPorNome(String dados) throws RemoteException {
        List<String> clientesListaString=new ArrayList<>();
        for(Cliente cliente:clientes){
            if(dados.equals(cliente.getNome()))
            clientesListaString.add("{id:"+cliente.getId()+"; nome:"+cliente.getNome()+";}");
        }
        return clientesListaString;
    }
        
    @Override
    public void enviarMensagemServidor(String msg) throws RemoteException{
       System.out.println("Mensagem do cliente:"+msg); 
    } 
}

