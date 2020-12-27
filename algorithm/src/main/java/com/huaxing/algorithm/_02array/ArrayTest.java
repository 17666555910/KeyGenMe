package com.huaxing.algorithm._02array;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @author: 姚广星
 * @time: 2020/12/20 16:35
 */
public class ArrayTest {


    public static void main(String[] args) {
        arrayCrossTheBorder();
    }

    /**
     * 会出现数组越界异常    原因：因为arr数组的长度为3，即拥有arr[0],arr[1],arr[2]三个元素。
     *                        而for循环的条件为i<=3,当i==3时，arr[3]是不存在数组的内存空间中，则会出现数组越界异常。
     */
    private static void arrayCrossTheBorder() {
        int i = 0;
        int[] arr = new int[3];
        for(; i<=3; i++){
            arr[i] = 0;
            System.out.println("hello word huaXing");
        }
    }
}
