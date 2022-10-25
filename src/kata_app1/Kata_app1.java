/*
Having a list of n numbers with digits in range [0, S], where n <= 100, switch all list positions in O(n) time.
If the input number contains a digit greater or equal than S, you will delete the digit from the number, for example with S=6,
61 becomes 1, and 6 will be deleted from the array. The result should be printed in console/terminal. 

S = 7 
*/
package kata_app1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kata_app1 {
    
    public static Integer[] Eliminar(Integer[] arrayNum, Integer item) {
        List<Integer> list = new ArrayList<>(Arrays.asList(arrayNum));
        list.remove(item);
        return list.toArray(Integer[]::new);
    }

   
    public static void main(String[] args) {
        
        Scanner entrada1 = new Scanner(System.in); 
        int entradaNumero, extraNum, Num2;
        Integer arrayNum[];
        boolean ciclo = true;
        
        do{
            System.out.println("Digite número elementos del arreglo entre 0 y 7.");
            entradaNumero = entrada1.nextInt();
            
            if(entradaNumero >=7 || entradaNumero <=0){
                System.out.println("Tamaño incorrecto, inténtelo de nuevo.");
                ciclo = false;
            } else{
                arrayNum = new Integer[entradaNumero];
            
                for(int i=0;i<entradaNumero;i++){
                    System.out.println("Digite elemento ["+i+"] de la lista: ");
                    arrayNum[i] = entrada1.nextInt();
                }

                for(int j=0;j<arrayNum.length;j++){
                    if(arrayNum[j] == 7){
                      arrayNum = Eliminar(arrayNum,7);
                      //System.out.println(arrayNum);
                    } else if(arrayNum[j] >= 10){
                        extraNum = arrayNum[j]/10;                        
                        
                        if(extraNum == 7){
                            Num2 = arrayNum[j]-(extraNum*10);
                            arrayNum[j] = Num2;
                            //arrayNum = Eliminar(arrayNum,arrayNum[j]);
                            if(Num2 == 7){
                               arrayNum = Eliminar(arrayNum,7);
                            }
                        } else{
                            Num2 = arrayNum[j]-(extraNum*10);
                            if(Num2 == 7){
                               arrayNum[j] = extraNum;
                            }
                        }  
                    }
                }
                
                System.out.print("La lista corregida es: {");
                for(int j=arrayNum.length-1;j>=0;j--){
                    System.out.print(arrayNum[j]+",");  
                }
                System.out.print("}");
                //System.out.println("la longitud es: "+arrayNum.length);
                ciclo = true;
            }
        }while(ciclo == false);
    }
    
}
