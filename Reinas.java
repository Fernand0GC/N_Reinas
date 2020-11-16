import java.util.Arrays;

public class Reinas {

    private int NUM_REINAS;
    private int[] solution;

    public Reinas(int NUM_REINAS) {
        this.NUM_REINAS = NUM_REINAS;
        this.solution = new int[NUM_REINAS];
        //init();
        //String strArray = Arrays.toString(solution);
        //System.out.println(strArray);
    }

    public void init() {
        for (int i = 0; i < solution.length; i++) {
            solution[i] = -1;
        }
    }

    public void searchSolution() {
        init();
        backtracking(solution, 0);
    }

    public boolean backtracking(int[] solucion, int reina) {
        // condicion para evaluar si hemos probado todas las reinas
        boolean success = false;
        if (reina < NUM_REINAS) { // caso base
            do {
                solucion[reina]++;// [0,-1,-1,-1] //[0,0,-1,-1]
                // es para determinar las soluciones parciales
                boolean valid = isValid(solution, reina);
                String strSol = Arrays.toString(solution);
                System.out.println(strSol + " " + (valid ? "sol parcial" : "")
                        + (valid && (reina == NUM_REINAS - 1) ? "solucion" : ""));
                if (valid) {
                    // reina = reina +1;
                    success = backtracking(solucion, reina + 1);
                }
            } while (solution[reina] < (NUM_REINAS - 1) && (!success));
            solucion[reina] = -1;
        } //else {}
        return success;
    }

    // estudiar y explicar la sgte clase como es que se determina
    // si la restriccion se cumple o no (fila y diagonales)
    public boolean isValid(int[] solution, int reina) {
        boolean ok = true;
        for (int i = 0; i < reina; i++) {
            if (solution[i] == solution[reina] || Math.abs(solution[i] - solution[reina]) == Math.abs(i - reina)) {
                ok = false;
                break;
            }
        }
        return ok;
    }

    public static void main(String[] args) {
        Reinas reina = new Reinas(4);
        reina.searchSolution();
    }

}
