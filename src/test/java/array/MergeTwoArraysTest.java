package array;

import org.junit.Assert;
import org.junit.Test;

public class MergeTwoArraysTest {

    @Test
    public void merge_1() {
        int[] a = {1, 3, 5, 7};
        int[] b = {0, 2, 4, 6, 8};
        int[] result = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Assert.assertArrayEquals(result, MergeTwoArrays.merge(a, b));
    }

    @Test
    public void merge_2() {
        int[] argsA = {1, 3, 4, 10};
        int[] argsB = {2, 11, 12, 13, 14};
        int[] result = {1, 2, 3, 4, 10, 11, 12, 13, 14};
        Assert.assertArrayEquals(result, MergeTwoArrays.merge(argsA, argsB));
    }

    @Test
    public void merge_3() {
        int[] argsA = {2, 11, 12, 13, 14};
        int[] argsB = {1, 3, 4, 10};
        int[] result = {1, 2, 3, 4, 10, 11, 12, 13, 14};
        Assert.assertArrayEquals(result, MergeTwoArrays.merge(argsA, argsB));
    }

    @Test
    public void merge_4() {
        int[] argsA = {};
        int[] argsB = {1};
        int[] result = {1};
        Assert.assertArrayEquals(result, MergeTwoArrays.merge(argsA, argsB));
    }

    @Test
    public void merge_5() {
        int[] argsA = {14};
        int[] argsB = {};
        int[] result = {14};
        Assert.assertArrayEquals(result, MergeTwoArrays.merge(argsA, argsB));
    }

    @Test
    public void merge_6() {
        int[] argsA = {2};
        int[] argsB = {1};
        int[] result = {1, 2};
        Assert.assertArrayEquals(result, MergeTwoArrays.merge(argsA, argsB));
    }

    @Test
    public void merge_7() {
        int[] argsA = {};
        int[] argsB = {1, 3, 4, 10};
        int[] result = {1, 3, 4, 10};
        Assert.assertArrayEquals(result, MergeTwoArrays.merge(argsA, argsB));
    }

    @Test
    public void merge_8() {
        int[] argsA = {2, 11, 12, 13, 14};
        int[] argsB = {};
        int[] result = {2, 11, 12, 13, 14};
        Assert.assertArrayEquals(result, MergeTwoArrays.merge(argsA, argsB));
    }

    @Test
    public void merge_9() {
        int[] argsA = {2, 11};
        int[] argsB = {1, 99};
        int[] result = {1, 2, 11, 99};
        Assert.assertArrayEquals(result, MergeTwoArrays.merge(argsA, argsB));
    }

    @Test
    public void merge_10() {
        int[] argsA = {};
        int[] argsB = {};
        int[] result = {};
        Assert.assertArrayEquals(result, MergeTwoArrays.merge(argsA, argsB));
    }

    @Test
    public void merge_11() {
        int[] argsA = {3};
        int[] argsB = {3};
        int[] result = {3, 3};
        Assert.assertArrayEquals(result, MergeTwoArrays.merge(argsA, argsB));
    }

//    @Test
//    public void merge_12() {
//        int[] argsA = {3, 3};
//        int[] argsB = {3, 3};
//        int[] result = {3, 3, 3, 3};
//        Assert.assertArrayEquals(result, MergeTwoArrays.merge(argsA, argsB));
//    }
//
//    @Test
//    public void merge_13() {
//        int[] argsA = {3, 3};
//        int[] argsB = {1, 2};
//        int[] result = {1, 2, 3, 3};
//        Assert.assertArrayEquals(result, MergeTwoArrays.merge(argsA, argsB));
//    }

}