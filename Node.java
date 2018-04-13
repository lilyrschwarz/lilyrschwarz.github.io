package Homework2;

class Node

{

   protected String data;

   protected Node next, prev;

//constructor
   public Node()

   {

       next = null;

       prev = null;

       data = null;

   }

//constructor
   public Node(String d, Node n, Node p)

   {

       data = d;

       next = n;

       prev = p;

   }

   //Function to set link to next node

   public void setLinkNext(Node n)

   {

       next = n;

   }

   //Function to set link to previous node 

   public void setLinkPrev(Node p)

   {

       prev = p;

   }

//function used to get link to next node
   public Node getLinkNext()

   {

       return next;

   }

   //Function to get link to previous node 

   public Node getLinkPrev()

   {

       return prev;

   }

   //Function to set data to node 

   public void setData(String d)

   {

       data = d;

   }

   /* Function to get data from node */

   public String getData()

   {

       return data;

   }

}

