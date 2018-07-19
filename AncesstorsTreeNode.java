/*
 Given a binary search tree's root node, an empty ArrayList and an integer nodeData, write a method that finds a target node - N with data = nodeData and populates the ArrayList with the data of the ancestor nodes of N - added from the bottom - up.

Example:  

       5             
      / \          
     3   7       
    / \ / \        
   2  4 6  8      

Node: 5 ==> [3, 5]
 */

import java.util.ArrayList;
import java.util.Scanner;

public class AncesstorsTreeNode {

	public AncesstorsTreeNode() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter Tree Size");
		int n=reader.nextInt();
		TreeNode root = null;
		int i=1;
		while(n-->0)
		{
			System.out.print("Enter Node "+(i++)+" :- ");
			root = addNode(root,reader.nextInt());
			
		}
		System.out.print("PreOrder Traversal :- ");
		preOrderNode(root);
		System.out.println("\n Enter Node to find ancesstor :- ");
		int nodeData =reader.nextInt();
		printAncestors(root,nodeData);
		System.out.println("Ancestors :-");
		for( Integer data :ancestorsList)
		{
			System.out.print(data+"  ");
		}
	}
	
	public static ArrayList<Integer> ancestorsList = new ArrayList<Integer>();
	public static boolean printAncestors(TreeNode root, int nodeData) {

	boolean dl=false,dr=false;
	if(root==null)
	return false;
	dl=printAncestors(root.left,nodeData);
	dr=printAncestors(root.right,nodeData);

	if(dr==true ||dl==true)
	{
	    ancestorsList.add(root.data);
	    return true;
	}
	if(root.data==nodeData)
	return true;
	else
	return false;

	}

	public static void preOrderNode(TreeNode root)
	{
		if(root!=null)
		{
			System.out.print (root.data+"  ");
			preOrderNode(root.left);
			preOrderNode(root.right);
		}
	}
	public static TreeNode addNode(TreeNode root, int data)
	{
		if(root==null)
		{
			TreeNode node = new TreeNode(data,null,null);
			return node;
		}
		else if(root.data>data)
			root.left=addNode(root.left,data);
		else
			root.right=addNode(root.right,data);
		return root;
	}

}
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
    }
}   