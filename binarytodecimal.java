public class binarytodecimal {
    public static int convertToDec (int bin){  
        int dec = 0;  
        int n = 0;  
        while(true){  
          if(bin == 0){  
            break;  
          } else {  
              int temp = bin%10;  
              dec += temp*Math.pow(2, n);  
              bin = bin/10;  
              n++;  
           }  
        }  
        return dec;  
    }  
    public static void main(String args[]){    
    System.out.println("dec of 1010 is: "+convertToDec(1010));  
    System.out.println("dec of 10101 is: "+convertToDec(10101));  
    System.out.println("dec of 11111 is: "+convertToDec(11111));  
    }
}
