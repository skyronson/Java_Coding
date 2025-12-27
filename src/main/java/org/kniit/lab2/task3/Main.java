// package lab2.task3;

// import java.util.Scanner;

// public class Main {

//     public static void main(String[] args) {
//         Scanner scan = new Scanner(System.in);
//         Calculator calc = new Calculator();  
    
//         while (true) {
//             try {
//                 // ВВОД ПЕРВОГО ЧИСЛА
//                 System.out.print("\nВведите первое число: ");
//                 String inp1 = scan.nextLine();
                
//                 if (inp1.equals("exit")) {
//                     break;
//                 }

//                 double num1 = Double.parseDouble(inp1);
                
//                 // ВВОД ОПЕРАТОРА
//                 System.out.print("Введите оператор (+, -, *, /): ");
//                 String oper = scan.nextLine();
            
//                 if (oper == "exit") {
//                     break;
//                 }

//                 // ВВОД ВТОРОГО ЧИСЛА
//                 System.out.print("Введите второе число: ");
//                 String inp2 = scan.nextLine();

//                 if (inp2 == "exit") {
//                     break;
//                 }
                
//                 double num2 = Double.parseDouble(inp2);
                
//                 // ВЫПОЛНЕНИЕ ОПЕРАЦИИ
//                 double result;
//                 switch (oper) {
//                     case "+":
//                         result = calc.add(num1, num2);
//                         System.out.printf("Результат: %.2f + %.2f = %.2f\n", num1, num2, result);
//                         break;
//                     case "-":
//                         result = calc.subtract(num1, num2);
//                         System.out.printf("Результат: %.2f - %.2f = %.2f\n", num1, num2, result);
//                         break;
//                     case "*":
//                         result = calc.multiply(num1, num2);
//                         System.out.printf("Результат: %.2f * %.2f = %.2f\n", num1, num2, result);
//                         break;
//                     case "/":
//                         result = calc.divide(num1, num2);
//                         System.out.printf("Результат: %.2f / %.2f = %.2f\n", num1, num2, result);
//                         break;
//                     default:
//                         System.out.println("Ошибка: Неизвестный оператор! Используйте +, -, *, /");
//                         continue;
//                 }
//             } catch (NumberFormatException e) {
//                 System.out.println("Ошибка: Введите корректное число!");
//             } catch (ArithmeticException e) {
//                 System.out.println(e.getMessage());
//             } catch (Exception e) {
//                 System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
//             }
//         }
//         scan.close();
//     }
    
// }
