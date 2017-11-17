
package tarea.ada;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class TareaADA {
    //private static char caracterInicial,caracterPostOperacion,caracterPostResultado;
  public static int evaluar(String q) {
    int val = 0;
    StringTokenizer st = new StringTokenizer(q,"+*",true);
    while(st.hasMoreTokens()){
        String sig = st.nextToken().trim();
        if(sig.equals("+")){
            //caracterPostOperacion = q.charAt(getPosicion(q,'+'));
            val+= Integer.parseInt(st.nextToken().trim());
        }else if(sig.equals("*")){
            //caracterPostOperacion = q.charAt(getPosicion(q,'*'));
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
  public static String resolver(String operando1,String operador,String operando2,String resultado){
      String query = operando1+operador+operando2+"="+resultado;
      return resolver(query);
  }
 public static String resolver(String q) {
    char c = 0;
    //caracteres que no pueden ser cero:
    //caracterInicial = q.charAt(getPosicion(q,'0'));
    //caracterPostResultado = q.charAt(getPosicion(q,'='));

    
    
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
      if (operandos == resultado) 
          return q;
      else 
          return "";
    }else{
      char[] combinaciones = new char[10]; 
      for (int i = 0; i < q.length(); ++i){
              if (Character.isDigit(q.charAt(i))){
                combinaciones[q.charAt(i)-'0'] = 1;
              }
      }
        
      for (int i = 0; i < 10; ++i) {
        if (combinaciones[i] == 0) {
          String r = resolver(q.replaceAll(String.valueOf(c), String.valueOf(i)));
          if (!r.isEmpty())
              return r;
        }
      }
    } 
    
    return "";
  }
  public static void main(String[] args) {
      XReader xr= new XReader();
      Lista l = xr.lister(xr.read());
      StringTokenizer st = new StringTokenizer(l.toString(),"> ",false);
      try{
          while(st.hasMoreTokens()){
                System.out.println(resolver(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken()));
          }
      }catch(StringIndexOutOfBoundsException e){
          System.err.println(e.getMessage());
      }
          
  }
}
