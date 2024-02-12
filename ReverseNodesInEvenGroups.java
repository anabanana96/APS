// https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/

// You are given the head of a linked list.
// The nodes in the linked list are sequentially assigned to non-empty groups whose lengths form the sequence of the natural numbers (1, 2, 3, 4, ...). The length of a group is the number of nodes assigned to it. In other words,
// The 1st node is assigned to the first group.
// The 2nd and the 3rd nodes are assigned to the second group.
// The 4th, 5th, and 6th nodes are assigned to the third group, and so on.
// Note that the length of the last group may be less than or equal to 1 + the length of the second to last group.
// Reverse the nodes in each group with an even length, and return the head of the modified linked list.
// Input: head = [5,2,6,3,9,1,7,3,8,4]
// Output: [5,6,2,3,9,1,4,8,3,7]

import java.util.Scanner;

public class Zadaca36 {
    public static void mirrorSubInterval(SLL<Integer> list, int x, int y){
        //3 -> indeks 3,    1 -> indeks 5
        int count = 0;
        SLLNode<Integer> start = null;
        SLLNode<Integer> end = null;
        SLLNode<Integer> node1 = null;
        SLLNode<Integer> tmp1 = null;
        SLLNode<Integer> node = list.getFirst();
        while (node!=null){
            if(x==0){
                start = null;
                node1 = list.getFirst();
            }
            else if(count==x-1){
                start = node;
                node1 = node.succ;
            }
            if(count==y){
                end = node;
                tmp1 = node.succ;
            }
            count++;
            node = node.succ;
        }
        boolean flag = false;
        while (node1!=null){
            if(node1==end){
                flag = true;
                if(start==null){
                    list.first = node1;
                }else start.succ = node1;
            }
            SLLNode<Integer> tmp2 = node1.succ;
            node1.succ = tmp1;
            tmp1 = node1;
            node1 = tmp2;
            if(flag) break;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i=0; i<n; i++)
            list.insertLast(input.nextInt());

        int seed = 1;
        int count = 0;
        int i = 0;
        boolean flag = false;
        int tmpInd1 = 0;
        int tmpInd2 = 0;
        SLLNode<Integer> node = list.getFirst();
        while (node!=null){
            count++;
            if(!flag){
                tmpInd1 = i;
                flag = true;
            }
            if(count==seed){
                System.out.println("count: " + count + " seed: " + seed);
                tmpInd2 = i;
                count = 0;
                if(seed%2==0) mirrorSubInterval(list, tmpInd1, tmpInd2);
                flag = false;
                seed++;
            }
            i++;
            node = node.succ;
        }
        if(count<seed && (count%2!=0 || count==0)){
            mirrorSubInterval(list, tmpInd1, list.size()-1);
        }
        System.out.println(list);
    }
}
