package tarea.ada;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XReader {
    
    String read (){
     String readed = "";  
        FilenameFilter wololo= (File dir, String fileName) -> fileName.equals("puzzle.xml");
        
        File irchivi =new File("puzzle.xml");
        
       try {
            Scanner sc =new Scanner(irchivi);
         String Trash = sc.nextLine();
            while (sc.hasNext()){
                String xml=sc.nextLine();
                xml=xml.replaceAll("<puzzle>", "").trim();
                xml=xml.replaceAll("</puzzle>", ";").trim();
                xml=xml.replaceAll("<operacion>", "").trim();
                xml=xml.replaceAll("</operacion>", ";").trim();
                xml=xml.replaceAll("<operando>", "").trim();
                xml=xml.replaceAll("</operando>", ";").trim();
                xml=xml.replaceAll("</operador>", ";").trim();
                xml=xml.replaceAll("<operador>", "").trim();
                xml=xml.replaceAll("</resultado>", ";").trim();
                xml=xml.replaceAll("<resultado>", "").trim();
               readed= readed.concat(xml);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return readed;
    }
      void escribir(String nombreArchivo, String frase)
	{
		File f = new File("solucion.xml");
		try{
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.append(frase + "\n"); //concatenamos en el archivo sin borrar lo existente
			pw.close();
			bw.close();
			fw.close();
		}
		catch(IOException e){
			System.out.println("Error: "+e.getMessage());
		}
	}
    Lista lister(String xml){
        Lista lista = new Lista();
        StringTokenizer tk= new StringTokenizer(xml,";", false);
        
        while(tk.hasMoreTokens()){
            String aux =tk.nextToken();
            if(!aux.isEmpty()){
            lista.insert(aux);
            }
        }     
        return lista;
    }
     
}


class Nodo{
	public String elemento;
	public Nodo sig;
	
	public Nodo(String x){
		elemento = x;
		sig = null;
	}
	
        @Override
	public String toString(){
		return elemento+" ";
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
	
	public void insert(String x){
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
