package tarea.ada;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class TareaADA {
  public static int evaluar(String q) {
    int val = 0;
    StringTokenizer st = new StringTokenizer(q,"+*",true);
    while(st.hasMoreTokens()){
        String sig = st.nextToken().trim();
        if(sig.equals("+")){
            val+= Integer.parseInt(st.nextToken().trim());
        }else if(sig.equals("*")){
            val*= Integer.parseInt(st.nextToken().trim());
        }else{
            val = Integer.parseInt(sig);
        }
    }
        return val;
  }
  public static int getPosicion(String q, char p){
    char[] consulta = q.toCharArray();
    for(int i=0;i<q.length();i++){
        if(consulta[i] == p){
            return i+1;
        }
    }
    return 0;
  }
 public static String resolver(String q) {
    char c = 0;
    for (int i = 0; i < q.length(); ++i) {
      if (Character.isAlphabetic(q.charAt(i))) {
        c = q.charAt(i);
        break;
      }
    }
    if (c == 0) {
      String[] operaciones = q.split("=");
      int operandos = evaluar(operaciones[0]);
      int resultado = evaluar(operaciones[1]);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
      if (operandos == resultado) return q;
      else return "";
    } else {
      char[] dset = new char[10]; //tamaño maximo de combinaciones (0-9)
      for (int i = 0; i < q.length(); ++i){
          if(i!=getPosicion(q,'0') || i!=getPosicion(q,'+') || i!=getPosicion(q,'*') || i!=getPosicion(q,'=')){
              if (Character.isDigit(q.charAt(i))){
                dset[q.charAt(i)-'0'] = 1;
              }
          }else{
            /*  if (Character.isDigit(q.charAt(i))){
                dset[q.charAt(i)-'0'] = 0;
              }*/
          }
          
      }
        
      for (int i = 0; i < 10; ++i) {
        if (dset[i] == 0) {
          String r = resolver(q.replaceAll(String.valueOf(c), String.valueOf(i)));
          if (!r.isEmpty())
              return r;
        }
      }
    }
    return "";
  }
  public static void main(String[] args) {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String query = "";
      //String query = "acepta + elreto = mental";
      try{
            System.out.println("operando1:");
            query+= br.readLine();
            System.out.println("operador:");
            query+= br.readLine();
            System.out.println("operando2:");
            query+= br.readLine();
            System.out.println("resultado:");
            query+= "="+br.readLine();

      }catch(IOException ioe){
      }try{
           System.out.println(query+"\n\n");
           //System.out.println("Posición: "+getPosicion(query,'0')+" caracter: "+ query.charAt(getPosicion(query,'0')));
           //System.out.println("Posición: "+getPosicion(query,'+')+" caracter: "+ query.charAt(getPosicion(query,'+')));
           //System.out.println("Posición: "+getPosicion(query,'=')+" caracter: "+ query.charAt(getPosicion(query,'=')));
           System.out.println(resolver(query));

      }catch(NumberFormatException nfe){
      }catch(StringIndexOutOfBoundsException e){}

  }
}