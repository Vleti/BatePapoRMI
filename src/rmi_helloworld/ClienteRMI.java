/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_helloworld;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author felip
 */
public class ClienteRMI {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        
        RMIClientMSG cliente=new RMIClientMSG();
        ServerMSG mensg = new ServerMSG("");
        //ServerMSG_Interface a = new ServerMSG_Interface();
        cliente.conectar();
        
        /*cliente.getMensagemBuffer().incluir(0, "Joao");
        cliente.getMensagemBuffer().incluir(1, "Jose");
        
        cliente.getMensagemBuffer().alterar(0,"Joaquim");
        
        cliente.getMensagemBuffer().excluir(1);
        
        List<String> listagem=cliente.getMensagemBuffer().consultarPorNome("Joaquim");
        */
        //for(String linha:listagem)
        
        Scanner scanner;
        String nome;
        String mensagem;
        String msgGeral;
        try{
               
               scanner= new Scanner(System.in);
               System.out.println("Informe seu Nome:");
               nome=scanner.nextLine();
               
               System.out.println("Insira a mesagem que deseja enviar ao Servidor:");
               mensagem=scanner.nextLine();
               
               msgGeral="Olá meu nome é "+nome+", "+mensagem;
               cliente.getMensagemBuffer().enviarMensagemServidor(msgGeral);
               
               while(true){
                   System.out.print("Mensagem: ");
                   msgGeral=scanner.nextLine();
                   cliente.getMensagemBuffer().enviarMensagemServidor(msgGeral);
                   System.out.println("Mensagem do servidor:"+cliente.getMensagemBuffer().getMsg());
               }
           }catch(Exception e){
               e.printStackTrace();
           }
        
        
    }
    
    
}
