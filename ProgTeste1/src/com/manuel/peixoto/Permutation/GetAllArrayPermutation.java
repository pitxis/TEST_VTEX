package com.manuel.peixoto.Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllArrayPermutation {
	


	public GetAllArrayPermutation(){}

	/**
	* This method calls all the mehtod needed to permut all values
	* @param arrLstInt contains all integer to sum.
	* @param iTarget target sum
	* @return nothing
	*/
	public void permutation(int[] arrLstInt, int iTarget){
		
		Arrays.sort(arrLstInt);
		List<int[]>  lstResult  =  getGroups(arrLstInt, iTarget);
		printResults(lstResult);
	}
	
	
	/**
	* This method prints all the valid groups
	* @param arrLstResult list that contains all valid groups
	* @return nothing
	*/
	private void printResults(List<int[]> arrLstResult) {
		if(arrLstResult == null || arrLstResult.isEmpty()){
			System.out.println("The result array is empty or null!");
			return;
		}

		for(int[] arrLstTmp : arrLstResult){
			System.out.print("Group: { ");
			
			for(int iNum : arrLstTmp){
				System.out.print(iNum + ",");
			}
			
			System.out.println("} ");
		}
	}

	
	
	/**
   * This method calls the method combinationUtil n times with n = arrInt.length, that way
   * making possible all permutations 
   * @param arrInt array with all integer to be added and tested
   * @param iTarget sum target
   * @return arrLstResult list containing all valid groups 
   */
	private List<int[]> getGroups(int[] arrInt, int iTarget) {
		if(arrInt == null)
			return null;

		
		List<int[]>  arrLstResult = new ArrayList<>();    

		for(int idx = 1; idx < arrInt.length; idx++){
			int[] data = new int[idx];
			
			combinationUtil(arrInt, data, 0, arrInt.length - 1, 0, idx, 0, iTarget, arrLstResult);
		}
		
		
		return arrLstResult;
	}
	
	/**
	* This method makes all combinations between all numbers in arr with size r
	* @param arr contains all number to be added
	* @param data current combination
	* @param start start index
	* @param end end index
	* @param index current index
	* @param r size of array
	* @param iSum current sum
	* @param iTarget target sum
	* @param lstResult list with all numbers added
	* @see http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
	*/
	private void combinationUtil(int arr[], int data[], int start,
            int end, int index, int r, int iSum, int iTarget, List<int[]> lstResult)
	{

		if (index == r)
		{			
			if(iSum == iTarget)
				lstResult.add(data.clone());
			
			return;
		}
		
		if(iSum > iTarget)
			return;
	
		for (int i=start; i<=end && end-i+1 >= r-index; i++)
		{
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, r, iSum +  arr[i], iTarget, lstResult);
		}
	}


}
