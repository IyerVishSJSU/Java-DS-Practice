package linkedlist;
/*
 * Name: LinkListDemo.java
 * Author: Vishwanath Iyer
 * Description: This linked list program demonstrates all the methods involving Insertion, 
 * 				Deletion, Find the length.
*/
class LinkListDemo
{
	Node head;
	
	//Node Class
	static class Node{
		int data;
		Node next;
		
		Node(int d)
		{
			data=d;
			next= null;
		}
	}
	//Displaying the elements in Linked List
	public void printlist()
	{
		Node current; 
		current= head;
		while(current!= null)
		{
			System.out.print(current.data+ " ");
			current= current.next;
		}
		System.out.println();
	}
	//Insert element at start of Linked List
	public void push(int newData)
	{
		Node new_node= new Node(newData);
		new_node.next=head;
		head= new_node;
	}
	//Insert element in between of Linked List
	public void insertAfter(Node prevNode,int newData)
	{
		Node new_node= new Node(newData);
		if(prevNode==null)
		{
			System.out.println("The previous node cannot be null");
			return;
		}
		new_node.next=prevNode.next;
		prevNode.next=new_node;
	}
	//Insert element at last position
	public void insertLast(int newData)
	{
		Node new_node = new Node(newData);
		if(head==null)
		{
			head= new Node(newData);
			return;
		}
		new_node.next=null;
		
		Node last= head;
		while(last.next!=null)
		{
			last=last.next;
		}
		last.next=new_node;
		return;
	}
	 /* Given a key, deletes the first occurrence of key in linked list */
    public void deleteNode(int key)
    {
        // Store head node
        Node temp = head, prev = null;
 
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key)
        {
            head = temp.next; // Changed head
            return;
        }
 
        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key)
        {
            prev = temp;
            temp = temp.next;
        }    
 
        // If key was not present in linked list
        if (temp == null) return;
 
        // Unlink the node from linked list
        prev.next = temp.next;
    }
    //delete an element at the given position
    public void deleteAt(int position)
    {
    	if(head==null)
    		return;
    	Node temp= head;
    	if(position==0)
    	{
    		head=temp.next;
    		return;
    	}
    	for(int i=0;i<position-1;i++)
    	{
    		temp=temp.next;
    	}
    	if(temp==null||temp.next==null)
    	{
    		return;
    	}
    	Node next=temp.next.next;
    	temp.next=next;
    }
    //Return size of the L List in Iterative Manner
    public int getSize()
    {
    	Node temp=head;
    	int count=0;
    	if(temp==null)
    		return 0;
    	else
    		while(temp!=null)
    		{
    			temp=temp.next;
    			count++;
    		}
		return count;
    }
    //Return the size of the Link List in Recursive fashion
    public int getCountRec(Node node)
    {
        // Base case
        if (node == null)
            return 0;
 
        // Count is this node plus rest of the list
        return 1 + getCountRec(node.next);
    }
	//Main Method
	public static void main(String []args)
	{
		LinkListDemo llist= new LinkListDemo();
		System.out.println("Size before creation of Link List:"+llist.getSize());
		llist.head= new Node(1);
		Node second= new Node(2);
		Node third = new Node(3);
		
		llist.head.next=second;
		second.next= third;
		System.out.println("The elements using printlist method:");
		llist.printlist();
		System.out.println("Elements after inserting 0 at beginning:");
		llist.push(0);
		llist.printlist();
		System.out.println("Inserting after second position:");
		llist.insertAfter(second, 4);
		llist.printlist();
		System.out.println("Inserting 5 at last loaction:");
		llist.insertLast(5);
		llist.printlist();
		System.out.println("Delete first occurence of 3:");
		llist.deleteNode(3);
		llist.printlist();
		System.out.println("Delete element at loaction 4:");
		llist.deleteAt(4);
		llist.printlist();
		System.out.println("The size found using Recursion is:"+llist.getCountRec(llist.head));
	}
}
