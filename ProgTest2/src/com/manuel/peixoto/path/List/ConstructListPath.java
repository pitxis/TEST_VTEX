package com.manuel.peixoto.path.List;

import java.util.HashMap;
import java.util.Map.Entry;


public class ConstructListPath {
	/**
   * This method add all HashMap entries to the ListPath 
   * @param mapPaths HashMap containing all the groups to form the path
   * @return ListPath  
   */
	public ListPath insertPaths(HashMap<Integer, int[]> mapPaths){
		ListPath path = new ListPath();
		
		for (Entry<Integer, int[]> entry : mapPaths.entrySet())
		{
			path.add(entry.getKey(), entry.getValue());
		}
		
		return path;
	}
}
