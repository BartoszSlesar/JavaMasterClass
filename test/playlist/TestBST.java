package playlist;

import codingExercise49AbstrackClass.MyLinkedList;
import codingExercise49AbstrackClass.Node;
import codingExercise49AbstrackClass.SearchTree;

public class TestBST {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());
        // Create a string data array to avoid typing loads of addItem instructions:
        String stringData = "5 7 3 9 8 2 1 0 4 6";

        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addItem(new Node(s));
        }
        boolean a = false;
        list.traverse(list.getRoot());
        System.out.println("**********************************1*************************************");
       a = list.removeItem(new Node("3"));
        list.traverse(list.getRoot());
        System.out.println("*********************************2**************************************");
        a = list.removeItem(new Node("5"));
        list.traverse(list.getRoot());
        System.out.println("**********************************3*************************************");
        a =list.removeItem(new Node("0"));
        a =list.removeItem(new Node("4"));
        a =list.removeItem(new Node("2"));
        list.traverse(list.getRoot());
        System.out.println("***********************************4************************************");
        a =list.removeItem(new Node("9"));
        list.traverse(list.getRoot());
        System.out.println("************************************5***********************************");
        a =list.removeItem(new Node("8"));
        list.traverse(list.getRoot());
        System.out.println("************************************6***********************************");
        a =list.removeItem(new Node("6"));
        list.traverse(list.getRoot());
        System.out.println("**************************************7*********************************");
        a =list.removeItem(list.getRoot());
        list.traverse(list.getRoot());
        System.out.println("*************************************8**********************************");
        a =list.removeItem(list.getRoot());
        list.traverse(list.getRoot());
    }
}
