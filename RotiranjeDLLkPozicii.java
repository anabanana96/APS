//da ne se koristat dopolnitelni strukturiimport java.util.Scanner;

public class Zadaca {
    public static void main(String[] args) {
        //rotiranje DLL za k pozicii
        DLL<Integer> list = new DLL<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i=0; i<n; i++)
            list.insertLast(input.nextInt());

        int k = input.nextInt();

        for (int i=0; i<k; i++) {
            DLLNode<Integer> node3 = list.getFirst();
            DLLNode<Integer> node1 = list.getFirst();
            DLLNode<Integer> node2 = null;
            while (node3.succ != null) {
                node2 = node3;
                node3 = node3.succ;
            }
            node1.pred = node3;
            node3.pred = null;
            node3.succ = node1;
            node2.succ = null;
            list.first = node3;
            list.last = node2;
        }

        System.out.println(list.toString());
        System.out.println(list.toStringR());
    }
}
