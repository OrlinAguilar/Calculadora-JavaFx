package calculadora;

import static java.lang.Math.sqrt;

public class Model {
    
    public double calculate(double num1, double num2, String operador){
        switch(operador){
        case "+": return (num1 + num2);
        case "-": return (num1 - num2);
        case "x": return (num1 * num2);
        case "/": 
            if(num2 == 0)
            {
                return 0;
            }
            return (num1 / num2);
        case "√":
            return sqrt(num1);
        }
        
        System.out.println("Operador : " + operador);
        return 0;
    }
}
