package _10_dsa_list.exercise.implement_the_methods_of_linkedlist;

public class TestMyLinkedList {
     public static void main(String[] args) {
         System.out.println("/=/=/=/= TESTING /=/=/=/=");
         MyLinkedList ll = new MyLinkedList(11);
         ll.addLast(22);
         ll.addLast(33);
         ll.addLast(44);
         ll.addLast(55);
         ll.addLast(66);
         ll.addLast(77);
         ll.printList();

         MyLinkedList newLL = ll.clone();
         newLL.printList();
     }
 }
