/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_helloworld;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author felip
 */
public class ServidorRMI {
        public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException, InterruptedException {
        ServerMSG msg=new ServerMSG("");
        RMIServerMSG sv=new RMIServerMSG(msg);
        
         Thread.sleep(10000);
        
        Scanner scanner;
        String nome;
        String mensagem;
        String msgGeral;
         try{
               
               scanner= new Scanner(System.in);
               System.out.println("Informe seu Nome:");
               nome=scanner.nextLine();
               
               System.out.println("Insira a mesagem que deseja enviar ao Cliente:");
               mensagem=scanner.nextLine();
               
               msgGeral="Olá meu nome é "+nome+", "+mensagem;
               sv.msgBuffer.setMsg(msgGeral);
               
               while(true){
                   System.out.println("Mensagem: ");
                   msgGeral=scanner.nextLine();
                   sv.msgBuffer.setMsg(msgGeral);
               }
           }catch(Exception e){
               e.printStackTrace();
           }
        
        
        //uma espera para poder enviar ao cliente
        
       
        
        //System.out.println(""+msg.get()); //um recebimento
        
    }
    
}
