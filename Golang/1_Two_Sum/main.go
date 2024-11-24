package main

import "fmt"

func main() {

	nums := []int{2, 7, 11, 15}
	target := 9
	format := "nums=%v, target=%v, return=%v\n"

	// fmt.Printf(format, nums, target, twoSum(nums, target))

	// nums = []int{3,2,4}
	// target = 6
	// fmt.Printf(format, nums, target, twoSum(nums, target))

	// nums = []int{3,3}
	// target = 6
	// fmt.Printf(format, nums, target, twoSum(nums, target))

	// nums = []int{-1,-2,-3,-4,-5}
	// target = -8

	nums = []int{3, 3}
	target = 6
	fmt.Printf(format, nums, target, twoSum(nums, target))
}

func twoSum(nums []int, target int) []int {

	var indexes []int

	for i := 0; i < len(nums); i++ {
		sum := 0

		for j := 1; j <= len(nums)-1; j++ {
			// same element cannot be used twice
			if i == j {
				continue
			}

			sum = nums[i] + nums[j]

			if sum == target {
				indexes = []int{i, j}
				break
			}
		}
	}

	return indexes
}
