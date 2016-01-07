package com.manuel.peixoto.pkg;

import java.util.ArrayList; 


import com.manuel.peixoto.Permutation.GetAllArrayPermutation;


/**
* Main class for test program 1
*
* @author  Manuel Peixoto
*/

public class Main {

	public static void main(String[] args) {

		ArrayList<int[]> testList = new ArrayList<>();
		
		testList.add(new int[]{});
		testList.add(new int[]{1,2,3,5});
		testList.add(new int[]{3,1,2});
		testList.add(new int[]{3,3,3});
		testList.add(new int[]{-1,5,3,14,5});
		testList.add(new int[]{-1,5,5,14,5});
		
		GetAllArrayPermutation getAllPerm = new GetAllArrayPermutation();
		
		System.out.println("BATCH TEST 1");
		int iTarget = 0;

		for(int[] arr : testList){
			System.out.println("Result for array "+ printArray(arr) + ". Target "+ iTarget);
			getAllPerm.permutation(arr, iTarget);
			System.out.println("");
		}
		System.out.println("------");
		
		System.out.println("BATCH TEST 2");
		iTarget = 6;
		
		for(int[] arr : testList){
			System.out.println("Result for array "+ printArray(arr) + ". Target "+ iTarget);
			getAllPerm.permutation(arr, iTarget);
			System.out.println("");
		}
		System.out.println("------");
		
		System.out.println("BATCH TEST 3");
		iTarget = 9;
		
		for(int[] arr : testList){
			System.out.println("Result for array "+ printArray(arr) + ". Target "+ iTarget);
			getAllPerm.permutation(arr, iTarget);
			System.out.println("");
		}
		System.out.println("------");
	}

	private static String printArray(int[] arr) {
		String result = "[";
		
		for(int iVal : arr){
			result += iVal + " ";
		}
		
		result += "]";
		
		return result;
		
	}
	

	

}
