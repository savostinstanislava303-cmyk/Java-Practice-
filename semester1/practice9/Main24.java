package practice9;

public class Main24 {
    public static void main(String[] args) {
        EquationSystem system = new EquationSystem(3);
        System.out.println(system.addEquation(new LinearEquation(1, 1, 5)));     // x + y = 5
        System.out.println(system.addEquation(new LinearEquation(2, -1, 1)));    // 2x - y = 1
        System.out.println(system.addEquation(new LinearEquation(0.1, 0.2, 0.8)));
        System.out.println(system.addEquation(new LinearEquation(1, 0, 2)));
        System.out.println(system.addEquation(null));
        System.out.println();
        System.out.println(system);
        System.out.println();
        System.out.println("(2; 3): " + system.checkSolution(2, 3));
        System.out.println("(1; 4): " + system.checkSolution(1, 4));
        System.out.println("(3; 2): " + system.checkSolution(3, 2));
        System.out.println("(2.0000001; 3): " + system.checkSolution(2.0000001, 3));
        System.out.println("(2.001; 3): " + system.checkSolution(2.001, 3));
    }
}

