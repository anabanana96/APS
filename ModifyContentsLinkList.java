//Given a singly linked list containing n nodes. Modify the value of first half nodes such that 1st node’s new value is equal to the last node’s value minus first node’s current value, 
//2nd node’s new value is equal to the second last node’s value minus 2nd node’s current value, likewise for first half nodes. If n is odd then the value of the middle node remains unchanged. 
//(No extra memory to be used)!

//Examples:  (Listata e od SLL)

//Input : 10 -> 4 -> 5 -> 3 -> 6
//Output : 4 -> 1 -> 5 -> 3 -> 6

//Input : 2 -> 9 -> 8 -> 12 -> 7 -> 10
//Output : -8 -> 2 -> -4 -> 12 -> 7 -> 10

Import java.util.Scanner;

public class Zadaca {
    public static void flipHalfList(SLL<Integer> list){
        int count = 0;
        SLLNode<Integer> node = list.getFirst();
        SLLNode<Integer> mid = null;
        SLLNode<Integer> end = null;
        while (node!=null){
            count++;
            if(count==list.size()/2){
                mid = node;
            }
            if(node.succ==null){
                end = node;
            }
            node = node.succ;
        }
        SLLNode<Integer> node1 = mid.succ;
        SLLNode<Integer> tmp1 = null;
       // node = list.getFirst();
        while (node1!=null){
            SLLNode<Integer> tmp2 = node1.succ;
            node1.succ = tmp1;
            tmp1 = node1;
            if(node1==end){
                mid.succ = node1;
            }
            node1 = tmp2;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i=0; i<n; i++)
            list.insertLast(input.nextInt());

        flipHalfList(list);
        int count = 0;
        SLLNode<Integer> node2 = list.getFirst();
        while (count<list.size()/2){
            count++;
            node2 = node2.succ;
        }
        SLLNode<Integer> node = list.getFirst();
        //1 2 3 4 5 6
        //1 2 3 6 5 4 -> -5 -3 -3 4 5 6
        count = 0;
        int size = list.size();
        while (count<=list.size()/2 && node2!=null){
            count++;
            list.insertBefore((node.element-node2.element), node);
            if(size%2!=0 && count==list.size()/2-1){
                list.delete(node);
                break;
            }
            list.delete(node);
            node = node.succ;
            node2 = node2.succ;
        }
        flipHalfList(list);
        System.out.println(list);
    }
}
