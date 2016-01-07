package com.manuel.peixoto.path.List;

public class ListNode {
	public int iNode;
	public int[] arrIntNeighbors;
	
	/**
	   * Constructor, shouldn't be done like this very unsafe, time constraints
	   * @param mapPaths HashMap containing all the groups to form the path
	   * @return ListPath  
	   */
	public ListNode(int node, int[] neighbors){
		iNode = node;
		arrIntNeighbors = neighbors;
	}
}
