package main

import (
	"testing"
)

func TestFindMedianSortedArrays(t *testing.T) {

	cases := []struct {
		Expected float64
		M        []int
		N        []int
	}{
		{Expected: 2.00000, M: []int{1, 3}, N: []int{2}},
		{Expected: 2.50000, M: []int{1, 2}, N: []int{3, 4}},
	}

	for _, x := range cases {
		actual := findMedianSortedArrays(x.M, x.N)

		t.Logf("Testing findMedianSortedArrays(%v, %v)", x.M, x.N)
		if actual != x.Expected {
			t.Errorf("m=%v; n=%v; expected=%f; actual=%f", x.M, x.N, x.Expected, actual)
		}
	}

}
