package tarea.ada;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author que kusu?
 */

public class XReader {
    
    String read (){
     String readed = "";  
        FilenameFilter wololo= (File dir, String fileName) -> fileName.equals("puzzle.xml");
        
        File irchivi =new File("puzzle.xml");
        
        try {
            Scanner sc =new Scanner(irchivi);
            while (sc.hasNext()){
               readed= readed.concat(sc.nextLine()+"\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return readed;
    }
    Lista lister(String xml){
        Lista lista = new Lista();
        
        
        return lista;
    }
    
}

class Nodo{
	public int elemento;
	public Nodo sig;
	
	public Nodo(int x){
		elemento = x;
		sig = null;
	}
	
        @Override
	public String toString(){
		return elemento+"--->";
	}
	
        @Override
	public boolean equals(Object o){
		if(o instanceof Nodo){
			return elemento == ((Nodo)o).elemento;
		}
		else return false;
	}
}

class Lista{
	public Nodo inicio;
	
	public Lista(){
		inicio = null;
	}
	
	public void insert(int x){
		Nodo nuevo = new Nodo(x);
		if(inicio == null)
			inicio = nuevo;
		else{
			Nodo paso = inicio;
			while(paso.sig!=null){
				paso = paso.sig;
			}
			paso.sig = nuevo;
		}
	}
	
	
	@Override
	public String toString(){
		String salida = "";
		Nodo paso = inicio;
		while(paso!=null){
			salida += paso;
			paso = paso.sig;
		}
		return salida;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Lista){
			Nodo paso1 = inicio;
			Nodo paso2 = ((Lista)o).inicio;
			while(paso1!=null && paso2!=null){
				if(!paso1.equals(paso2)) return false;
				paso1 = paso1.sig;
				paso2 = paso2.sig;
			}
			return paso1==null && paso2==null;
		}
		else return false;
	}
}
