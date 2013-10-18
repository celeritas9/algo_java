package com.practice;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author dshah
 * @since
 */
public class TestTreeNode {
	
	static int countSteps = 0;
	
	public static void main(String[] args) throws Exception {
		TestTreeNode test = new TestTreeNode();
		int[] valueArray = {11,12,13,14,15,16,17};
		
		TreeNode root = test.createCompleteBinaryTreeFromArray(valueArray);
		
		infixTraversal(root);
		System.out.print("null\n");
		System.out.println("O(n)="+countSteps);
	}
	
	private static void infixTraversal(TreeNode root) {
		if(root != null)
		{
			infixTraversal(root.leftNode);
			{
				countSteps++;
				System.out.print(root.value+"->");
			}
			infixTraversal(root.rightNode);
		}
	}

	private TreeNode createCompleteBinaryTreeFromArray(int[] valueArray) throws Exception {
		
		if(valueArray == null || valueArray.length <= 0) {
			return null;
		}
		
		TreeNode root = this.new TreeNode();
		TreeNode node = root;
		root.value = valueArray[0];
		Queue<TreeNode> q = new LinkedBlockingQueue<TreeNode>();
		q.add(root);
		for(int i = 0; i < valueArray.length; i++) {
			
			if(q.isEmpty()) {
				throw new Exception("No parent element found to add value " +valueArray[i]+ " at " +i);
			}
			node = q.remove();
			
			if((2 * i + 1) < valueArray.length) {
				node.leftNode = new TreeNode();
				node.leftNode.value = valueArray[2 * i + 1];
				q.add(node.leftNode);
			}
			if((2 * i + 2) < valueArray.length) {
				node.rightNode = new TreeNode();
				node.rightNode.value = valueArray[2 * i + 2];
				q.add(node.rightNode);
			}
		}
		
		return root;
	}
	
	class TreeNode {
		int value;
		TreeNode leftNode;
		TreeNode rightNode;
	}
}
