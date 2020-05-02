package metodos;


import org.nfunk.jep.JEP;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Darwin
 */
public class Simpson1 {

   public String simpson1_3(String funcion1, String a1, String b1, int n1) {
        String mensaje = null;
        
        
          try{
            String expresion=funcion1;
       // 
             JEP a2= new JEP(); 
              a2.addStandardFunctions(); // adiciona las funciones matem´aticas
             a2.addStandardConstants();
              a2.parseExpression(a1); // paso de la expresi´on a evaluar
            double   a = a2.getValue();
 
  
        
            JEP b2= new JEP(); 
            b2.addStandardFunctions(); // adiciona las funciones matem´aticas
             b2.addStandardConstants();
              b2.parseExpression(b1); // paso de la expresi´on a evaluar
            double   b = b2.getValue();
 //
            
        
        double n=n1;// numero de particiones
        if (n%2==0) {
            double h=(b-a)/n;
             int m=(int)n;
        
                double x[]=new double [m+1];
                 x[0]=a;
                for (int i = 1; i < x.length; i++) {
            
                      x[i]=x[0]+(i*h);// calcula el termino Xi
                 }
        
         JEP funcion= new JEP(); 
       funcion.addStandardFunctions(); // adiciona las funciones matem´aticas
        funcion.addStandardConstants(); // adiciona las constantes matem´aticas
         funcion.setImplicitMul(true);
     
        
        
        double fi[]= new double [m+1];
        /**
         * calcula el valor de el polinomio en el punto Xi
         */
        for (int i = m; i >=0; i--) {
            
            for (int j = fi.length-1; j >0 ; j--) {
              fi[i]=funcion.addVariable("x", x[i]);
              funcion.parseExpression(expresion); // paso de la expresi´on a evaluar
              fi[i] = funcion.getValue();
            }
            
        }
        
        
        double integral1=0;
        double integral2=0;
        double integral;
        
        for (int i = 1; i < n; i++) {
             if (i%2!=0) {
                integral1=integral1+(4*fi[i]);
            }
            if (i%2==0) {
                integral2=integral2+(2*fi[i]);
            }
            
            
        }
        integral=integral1+integral2+fi[0]+fi[m];
        integral=integral*(h/3);
        mensaje=Double.toString(integral);
              }// fin if
              
           if(n%2!=0) {
                  mensaje="numero de particiones impar ";
              }// fin else 
          
       }// fin try
        catch(NumberFormatException e){
            mensaje="error ingreso de datos";
        }
         
       
        
        
        
        
      
      
        
        
        
        
        
        
        return mensaje;
        
    }
    
}
