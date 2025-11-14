package optprog.desafios.estructuras_de_datos;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class TreeNode {

    protected int val;
    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public void setLeft(TreeNode nodo) {
        left = nodo;
    }
    public void setRight(TreeNode nodo) {
        right = nodo;
    }

    
    public TreeNode getLeft() {
        return left;
    }
    public TreeNode getRight() {
        return right;
    }

}


public class AlturaArbolBinario {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<casos; i++) {
            
            String linea = sc.nextLine();
            char charNodo = linea.charAt(0);
            TreeNode nodoAnt = new TreeNode(charNodo);
            Deque<TreeNode> pila = new ArrayDeque<>();

            int alturaMayor = 0;
            int altura = 0;
            if (charNodo == '*') {
                altura++;
                alturaMayor = altura;
            }
            for (int j=1; j<linea.length(); j++) {
                charNodo = linea.charAt(j);
                TreeNode nodo = new TreeNode(charNodo);
                boolean colocado = false;
                while (!colocado) {
                    if (nodoAnt.getLeft() == null) {
                        nodoAnt.setLeft(nodo);
                        colocado = true;

                    } else if (nodoAnt.getRight() == null) {
                        nodoAnt.setRight(nodo);
                        colocado = true;
                        
                    } else {
                        nodoAnt = pila.poll();
                        altura--;
                    }
                }
                                
                if (charNodo == '*') {
                    pila.push(nodoAnt);
                    nodoAnt = nodo;
                    altura++;
                    if (altura > alturaMayor)
                        alturaMayor = altura;
                }

            }
    
            System.out.println(alturaMayor);

        }
    }
}

