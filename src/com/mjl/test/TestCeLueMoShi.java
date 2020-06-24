package com.mjl.test;




import java.util.Arrays;

/**
 * @Auther: mjl
 * @Date: 2020/6/23 - 17:58
 * @Description: com.mjl.test
 * @version: 1.0
 */
public class TestCeLueMoShi {

    public static void main(String[] args) {
        int[] arr ={9,2,3,5,7,1,4};
        MySorter sorter = new MySorter();
        sorter.Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
