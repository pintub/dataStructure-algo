package com.p2.linkedlist;

/**
 * Created by I335831 on 4/9/2018.
 */
public class SinglyLinkedList {
    private ListNode head;

    //To create few Nodes at End position
    private void insertAtEnd(Object obj){
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
    }

    //Assuming position not at start or end
    private Object deleteIntermediateNode(int position){
       Object retunedObj = null;

        if(head == null){
            retunedObj = "Linked list is Empty";
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

                retunedObj = "Deleted node " + deletedValue;
            } else {
                ListNode temp = currentNode;
                currentNode = currentNode.getNodeNext();
                previousNode = temp;
            }
        }

        //If input position > list size
        if(position > nodeCount){
            retunedObj = "Invalid position , greater than list size";
        }

        return retunedObj;
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

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertAtEnd("1");
        singlyLinkedList.insertAtEnd("2");
        singlyLinkedList.insertAtEnd("3");
        singlyLinkedList.insertAtEnd("4");
        singlyLinkedList.insertAtEnd("5");
        singlyLinkedList.insertAtEnd("6");
        System.out.println(singlyLinkedList);

        System.out.println(singlyLinkedList.deleteIntermediateNode(5));
        System.out.println(singlyLinkedList);
    }
}
