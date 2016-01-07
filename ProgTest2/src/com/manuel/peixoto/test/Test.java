package com.manuel.peixoto.test;

import java.util.HashMap;


import com.manuel.peixoto.path.List.ConstructListPath;
import com.manuel.peixoto.path.List.ListPath;


/**
* Main class for test program 2
*
* @author  Manuel Peixoto
*/
public class Test {

	public static void main(String[] args) {
		ConstructListPath lstCons = new ConstructListPath();
		ListPath lstPath;
		
		HashMap<Integer, int[]> testMap;
		
		testMap = new HashMap<>();
		
		testMap.put(1, new int[]{2, 3});
		testMap.put(2, new int[]{4});
		testMap.put(3, new int[]{5});	
		
		
		//TESTE 1
		System.out.println("TESTE 1");
		lstPath = lstCons.insertPaths(testMap);
		lstPath.getRoute(1,4);
		System.out.println("-----");
		
		//TESTE 2
		System.out.println("TESTE 2");
		testMap = new HashMap<>();
		lstPath = lstCons.insertPaths(testMap);
		lstPath.getRoute(3,4);
		System.out.println("-----");
		
		//TESTE 3
		System.out.println("TESTE 3");
		testMap = new HashMap<>();
		testMap.put(1, new int[]{2, 3});
		testMap.put(2, new int[]{4});
		testMap.put(3, new int[]{5});
		
		lstPath = lstCons.insertPaths(testMap);
		lstPath.getRoute(3,5);
		System.out.println("-----");
		
		
		//TESTE 4
		System.out.println("TESTE 4");
		testMap = new HashMap<>();
		testMap.put(1, new int[]{2, 3});
		testMap.put(2, new int[]{4,6,7});
		testMap.put(3, new int[]{5,6,1});
		testMap.put(4, new int[]{6});
		
		lstPath = lstCons.insertPaths(testMap);
		lstPath.getRoute(1,6);
		System.out.println("-----");
		
	}

}
