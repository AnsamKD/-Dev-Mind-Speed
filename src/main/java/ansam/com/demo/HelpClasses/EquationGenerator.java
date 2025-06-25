package ansam.com.demo.HelpClasses;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.Random;

public class EquationGenerator {

    public String generateEquation(int difficulty) {
        Character[] operations = {'+', '-', '*', '/'};
        int Operands;//#numbers in equ
        int Length;//length numbers in equ
        Random random = new Random();
        String equ = "";


        if (difficulty == 1) {
            Operands = 2;
            Length = 1;
            int number1 = random.nextInt(9); // 0-8
            int number2 = random.nextInt(9) + 1;//1-9
            char operation1 = operations[random.nextInt(4)];//0-3
            equ = number1 + " " + operation1 + " " + number2;

        } else if (difficulty == 2) {
            Operands = 3;
            Length = 2;
            int number1 = random.nextInt(70) + 10; // 10-79
            int number2 = random.nextInt(80) + 10;//10-89
            int number3 = random.nextInt(90) + 10;//10-99

            char operation1 = operations[random.nextInt(4)];//0-3
            char operation2 = operations[random.nextInt(4)];//0-3

            equ = number1 + " " + operation1 + " " + number2 + " " + operation2 + " " + number3;

        } else if (difficulty == 3) {
            Operands = 4;
            Length = 3;
            int number1 = random.nextInt(100) + 100; //100-199
            int number2 = random.nextInt(200) + 100;//100-299
            int number3 = random.nextInt(300) + 100;//100-399
            int number4 = random.nextInt(400) + 100; // 100-499

            char operation1 = operations[random.nextInt(4)];//0-3
            char operation2 = operations[random.nextInt(4)];//0-3
            char operation3 = operations[random.nextInt(4)];//0-3

            equ = number1 + " " + operation1 + " " + number2 + " " + operation2 + " " + number3 + " " + operation3 + " " + number4;
        } else if (difficulty == 4) {
            Operands = 5;
            Length = 4;
            int number1 = random.nextInt(1000) + 1000; // 1000 - 1999
            int number2 = random.nextInt(2000) + 1000; //  1000 - 2999
            int number3 = random.nextInt(3000) + 1000; //  1000 - 3999
            int number4 = random.nextInt(4000) + 1000; //  1000 - 4999
            int number5 = random.nextInt(5000) + 1000; //  1000 - 5999

            char operation1 = operations[random.nextInt(4)];//0-3
            char operation2 = operations[random.nextInt(4)];//0-3
            char operation3 = operations[random.nextInt(4)];//0-3
            char operation4 = operations[random.nextInt(4)];//0-3

            equ = number1 + " " + operation1 + " " + number2 + " " + operation2 + " " + number3 + " " + operation3 + " " + number4 + " " + operation4 + " " + number5;
        } else {
            System.out.println("Invalid");
        }

        return equ;
    }

    public float EquationSolution(String equation)
    {
        Expression expression = new ExpressionBuilder(equation).build();
        double result = expression.evaluate();
        return (float) result;
    }


}







