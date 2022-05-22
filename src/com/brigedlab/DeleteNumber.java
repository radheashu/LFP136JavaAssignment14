package com.brigedlab;
import java.io.*;
public class DeleteNumber {
        Node head; // head of list

        // Linked list Node.
        // Node is a static nested class
        // so main() can access it
        static class Node {

            int data;
            Node next;

            // Constructor
            Node(int d) {
                data = d;
                next = null;
            }
        }

        // Method to insert a new node
        public static LinkedList insert(LinkedList list, int data) {
            // Create a new node with given data
            Node new_node = new Node(data);
            new_node.next = null;

            // If the Linked List is empty,
            // then make the new node as head
            if (list.head == null) {
                list.head = new_node;
            } else {
                // Else traverse till the last node
                // and insert the new_node there
                Node last = list.head;
                while (last.next != null) {
                    last = last.next;
                }

                // Insert the new_node at last node
                last.next = new_node;
            }

            // Return the list by head
            return list;
        }

        // Method to print the LinkedList.
        public static void printList(LinkedList list) {
            Node currentNode = list.head;

            System.out.print("LinkedList: ");

            // Traverse through the LinkedList
            while (currentNode != null) {
                // Print the data at current node
                System.out.print(currentNode.data + " ");

                // Go to next node
                currentNode = currentNode.next;
            }

            System.out.println();
        }

        // Method to delete a node in the LinkedList by POSITION
        public static LinkedList deleteAtPosition(LinkedList list, int index) {
            // Store head node
            Node currentNode = list.head, prev = null;

            //
            // CASE 1:
            // If index is 0, then head node itself is to be
            // deleted

            if (index == 0 && currentNode != null) {
                list.head = currentNode.next; // Changed head

                // Display the message
                System.out.println(index + " position element deleted");

                // Return the updated List
                return list;
            }

            //
            // CASE 2:
            // If the index is greater than 0 but less than the
            // size of LinkedList
            //
            // The counter
            int counter = 0;

            // Count for the index to be deleted,
            // keep track of the previous node
            // as it is needed to change currNode.next
            while (currentNode != null) {

                if (counter == index) {
                    // Since the currNode is the required
                    // position Unlink currNode from linked list
                    prev.next = currentNode.next;

                    // Display the message
                    System.out.println(index + " position element deleted");
                    break;
                } else {
                    // If current position is not the index
                    // continue to next node
                    prev = currentNode;
                    currentNode = currentNode.next;
                    counter++;
                }
            }

            // If the position element was found, it should be
            // at currNode Therefore the currNode shall not be
            // null
            //
            // CASE 3: The index is greater than the size of the
            // LinkedList
            //
            // In this case, the currNode should be null
            if (currentNode == null) {
                // Display the message
                System.out.println(index + " position element not found");
            }

            // return the List
            return list;
        }

        // **************MAIN METHOD**************

        // method to create a Singly linked list with n nodes
        public static void main(String[] args) {
            /* Start with the empty list. */
            LinkedList list = new LinkedList();

            //
            // ******INSERTION******
            //

            // Insert the values
            list = insert(list, 56);
            list = insert(list, 30);
            list = insert(list, 70);

            // Print the LinkedList
            printList(list);

            //
            // ******DELETION AT POSITION******
            //

            // Delete node at position 0
            // In this case the key is ***at head***
            deleteAtPosition(list, 0);

            // Print the LinkedList
            printList(list);

            //
        }
    }

