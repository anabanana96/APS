import java.util.Scanner;

public class Zadaca25 {
    public static void main(String[] args) {
        //rotiranje na lista za k pozicii
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i=0; i<n; i++)
            list.insertLast(input.nextInt());
        int k = input.nextInt();
        for (int i=0; i<k; i++) {
            SLLNode<Integer> node3 = list.getFirst();
            SLLNode<Integer> node1 = list.getFirst();
            SLLNode<Integer> node2 = null;
            while (node3.succ != null) {
                node2 = node3;
                node3 = node3.succ;
            }
            node3.succ = node1;
            node2.succ = null;
            list.first = node3;
        }

        System.out.println(list.toString());
    }
}
