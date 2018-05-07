package com.p2.linkedlist;

/**
 * Created by I335831 on 4/9/2018.
 */
public class SinglyLinkedList {
    private ListNode head;

    //To create few Nodes at End position
    private SinglyLinkedList insertAtEnd(Object obj){
        if(head == null) {//Then insert 1st element
            ListNode nodeToInsert = new ListNode().withNodeValue(obj).withNodeNext(null);
            head = nodeToInsert;
        } else {//Insert Element at End
            ListNode listNode = head;
            while (listNode.getNodeNext() != null){//Till null found at nodeNext
                listNode = listNode.getNodeNext();
            }
            //End Node reached
            ListNode nodeToInsert = new ListNode().withNodeValue(obj).withNodeNext(null);
            listNode.setNodeNext(nodeToInsert);
        }

        return this;
    }

    //Assuming position not at start or end
    private Object deleteIntermediateNode(final int position){
       Object returnedObj = null;

        if(head == null){
            returnedObj = "Linked list is Empty";
        }
        int nodeCount = 0;
        ListNode currentNode = head;
        ListNode previousNode = null;

        while (currentNode.getNodeNext() != null){
            nodeCount ++;
            if(nodeCount == position){//Position found
                //TODO
                ListNode temp = currentNode;
                ListNode nextNode = currentNode.getNodeNext();
                previousNode.setNodeNext(nextNode);
                temp.setNodeNext(null);
                Object deletedValue = temp.getNodeValue();
                temp.setNodeValue(null);

                returnedObj = "Printing Deleted node Value :" + deletedValue;
            } else {
                ListNode temp = currentNode;
                currentNode = currentNode.getNodeNext();
                previousNode = temp;
            }
        }

        //If input position > list size
        if(position > nodeCount){
            returnedObj = "Invalid position , greater than list size";
        }

        return returnedObj;
    }

    //Reverse Single Linked list using iteration
    private SinglyLinkedList reverse() throws Exception {
        if(head == null){//Empty Linked list
            throw new Exception("Linked list id empty");
        }

        ListNode previousNode = null;
        ListNode currentNode = null;
        ListNode nextNode = head;

        while (nextNode != null) {
            currentNode = nextNode;
            nextNode = nextNode.getNodeNext();
            currentNode.setNodeNext(previousNode);
            previousNode = currentNode;
        }

        head = previousNode;

        return this;
    }

    //Reverse Single Linked list using recursion
    private SinglyLinkedList reverseV2() throws Exception {
        if(head == null){//Empty Linked list
            throw new Exception("Linked list id empty");
        }


        if(head.getNodeNext() == null){
            return this;
        }

        ListNode temp = head;
        head = head.getNodeNext();
        temp.setNodeNext(null);

        reverseV2();

        return this.insertAtEnd(temp.getNodeValue());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode listNode = head;
        while (listNode.getNodeNext() != null){//Till null found at nodeNext
            sb.append(listNode.toString());
            listNode = listNode.getNodeNext();
        }
        sb.append(listNode.toString());
        return  sb.toString();
    }

    public static void main(String[] args) throws Exception {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList()
                .insertAtEnd("1").insertAtEnd("2")
                .insertAtEnd("3").insertAtEnd("4")
                .insertAtEnd("5").insertAtEnd("6");
        System.out.println("Printing linked list : " + singlyLinkedList);

        System.out.println(singlyLinkedList.deleteIntermediateNode(5));
        System.out.println("Printing linked list after Node Deletion : " + singlyLinkedList);

        System.out.println("Printing Reversed linked list using Iteration : " + singlyLinkedList.reverse());
        System.out.println("Printing Reversed V2 linked list using Recursion: " + singlyLinkedList.reverseV2());
    }
}
