package main

import (
	"fmt"
	"math/big"
	"strconv"
	"strings"
)

func main() {
	fmt.Println("running...")
	format := "l1=%+v , l2=%v output=%v"
	l1 := ListNode{Val: 2, Next: &ListNode{
		Val:  4,
		Next: &ListNode{Val: 3, Next: nil},
	}}

	// fmt.Printf("l1=%v l1reversed=%v\n", printListNode(&l1), printListNode(reverseList(&l1)))

	l2 := ListNode{Val: 5, Next: &ListNode{
		Val:  6,
		Next: &ListNode{Val: 4, Next: nil},
	}}

	fmt.Printf(format, listNodeToString(&l1), listNodeToString(&l2), listNodeToString(addTwoNumbers(&l1, &l2)))
	fmt.Println("\nend")
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	l1Reversed := reverseList(l1)
	l2Reversed := reverseList(l2)

	num1 := listNodeToNumber(l1Reversed)
	num2 := listNodeToNumber(l2Reversed)

	fmt.Println("num1=", num1, " num2=", num2)
	finalNum := num1.Add(num1, num2)

	return intToListNode(finalNum)
}

func intToListNode(num *big.Int) *ListNode {

	finalNumStr := num.String()

	var finalList *ListNode
	for _, numStr := range finalNumStr {
		num, _ := strconv.Atoi(string(numStr))
		finalList = &ListNode{
			Val:  num,
			Next: finalList,
		}
	}

	return finalList
}

func listNodeToNumber(l *ListNode) *big.Int {
	numbers := ""

	for l.Next != nil {
		numbers += strconv.Itoa(l.Val)
		l = l.Next
	}

	numbers += strconv.Itoa(l.Val)

	num, _ := new(big.Int).SetString(numbers, 10)
	return num
}

func reverseList(head *ListNode) *ListNode {
	var list *ListNode
	for head != nil {
		list = &ListNode{Val: head.Val, Next: list}
		head = head.Next
	}
	return list
}

func listNodeToString(l *ListNode) string {
	var nums []string

	for l.Next != nil {
		nums = append(nums, fmt.Sprint(l.Val))
		l = l.Next
	}

	nums = append(nums, fmt.Sprint(l.Val))

	return strings.Join(nums, ", ")
}
