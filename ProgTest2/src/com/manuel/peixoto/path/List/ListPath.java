package com.manuel.peixoto.path.List;
import java.util.ArrayList;
import java.util.List;

public class ListPath {
	private List<ListNode> lstNode;
	
	public ListPath(){
		lstNode = new ArrayList<>();
	}

	/**
	   * Add a key and a array of values to the list of ListNode 
	   * @param key integer node key
	   * @param value array of all neighbors 
	   * @return nothing  
	   */
	public void add(Integer key, int[] value) {
		if(value == null)
			return;

		lstNode.add(new ListNode(key, removeCircularReferences(key, value)));
	}
	
	
	/**
	   * Remove all circular references, meaning that a node can't have a neighbors pointing to him
	   * @param key integer node key
	   * @param value array of all neighbors 
	   * @return nothing  
	   */
	private int[] removeCircularReferences(int iCurrNode, int[] value){
		if(value == null || value.length == 0)
			return new int[0];
		
		ListNode nodeTmp;
		List<Integer> redundant = new ArrayList<>();
		
		for(int iTmp : value){
			
			if((nodeTmp = getNodeByiNode(iTmp)) != null){
				for(int iNode : nodeTmp.arrIntNeighbors){
					if(iNode == iCurrNode){
						redundant.add(iTmp);
					}
				}
			}
		}
		
		int[] arrResult;
		if(redundant.size() == 0){
			arrResult = value;
			
		} else {
			arrResult = new int[value.length - redundant.size()];
			int idx = 0;
			
			for(int iNode : redundant){
				
				boolean	bInside = false;
				for(int iTmp : value){
					if(iTmp == iNode){
						bInside = true;
						break;
					}
				}
				if(!bInside)
					arrResult[idx++] = iNode;
			}
		}
		
		return arrResult;
	}
	
	/**
	   * Prints all the node from the starting point to the end
	   * @param iCurr current node key
	   * @param iEnd end node key
	   * @param lstPath list of keys from current path
	   * @return nothing  
	   */
	private void printTraversedPath(int iCurr, int iEnd, List<Integer> lstPath){
		
		lstPath.add(iCurr);
		
		if(iCurr == iEnd){
			System.out.println(lstPath);
			return;
		}

		ListNode nodeTmp = getNodeByiNode(iCurr);
		
		if(nodeTmp == null) {
			return;
		}
		
		for(int iNodeNeighbors : nodeTmp.arrIntNeighbors){
			printTraversedPath(iNodeNeighbors, iEnd, new ArrayList<>(lstPath));
		}
	}
	
	/**
	   * Get route from iStartNode to iEndNode 
	   * @param iStartNode start node key
	   * @param iEndNode end node key
	   * @return nothing  
	   */
	public void getRoute(int iStartNode, int iEndNode) {
		List<Integer> lstPath = new ArrayList<>();
		
		printTraversedPath(iStartNode, iEndNode, lstPath);
	}

	/**
	   * Gets ListNode by node key 
	   * @param iNode node key
	   * @return ListNode  
	   */
	private ListNode getNodeByiNode(int iNode) {
		for(ListNode listNodeTmp : lstNode){
			
			if(listNodeTmp.iNode == iNode)
				return listNodeTmp;
		}
		
		return null;
	}
	
	
}
