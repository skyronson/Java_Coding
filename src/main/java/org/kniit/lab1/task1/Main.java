package lab1.task1;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + (i < 100 ? (i < 10 ? ",  " : (i % 10 == 0 ? ",\n" : ", ")) : ""));
        }
    }
}
