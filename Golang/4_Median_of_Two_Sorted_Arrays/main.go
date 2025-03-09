package main

import "slices"

func main() {
	println("Hello, World!")
}

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {

	// 1. validate arrays are not empty
	if len(nums1)+len(nums2) == 0 {
		return 0
	}

	// 2. Merge the arrays
	mergedArrays := append(nums1, nums2...)
	slices.Sort[[]int](mergedArrays)

	// 3. Return the Median

	half := len(mergedArrays) / 2
	if len(mergedArrays)%2 != 0 { // 3.1 Odd case
		return float64(mergedArrays[half])
	}

	// 3.2 Even case
	medianSlice := mergedArrays[half-1 : half+1]

	return float64(medianSlice[0]+medianSlice[1]) / 2.0
}
