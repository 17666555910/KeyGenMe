package com.huaxing.algorithm._02array;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * @Description
 * @author: 姚广星
 * @time: 2020/12/20 16:35
 */
public class ArrayTest {


    public static void main(String[] args) {
        //arrayCrossTheBorder();

        //---------------- 习题1:删除排序数组中的重复项 begin -----------------------------
        /**
         * 删除排序数组中的重复项
         * 示例 1:给定数组 nums = [1,1,2],函数应该返回新的长度 2,
         *       并且原数组 nums 的前两个元素被修改为 1, 2。你不需要考虑数组中超出新长度后面的元素。
         * 示例 2:给定 nums = [0,0,1,1,1,2,2,3,3,4],
         *       函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。你不需要考虑数组中超出新长度后面的元素。
         */
        int[] nums = {1, 1, 2};
        int length = deleteArrayDuplicates(nums);
        System.out.println("新的数组长度为 = " + length);
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            System.out.println("num元素 = " + num);
        }
        //----------------- 习题1:删除排序数组中的重复项 end ------------------------------
    }

    /**
     * 删除排序数组中的重复项
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 作者：华星详谈
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static int deleteArrayDuplicates(int[] nums) {
        //思路：使用双指针的方式
        //定义一个慢指针
        int k = 0;
        //迭代循环快指针
        for(int i=1;i<nums.length;i++){
            //如果快指针的值和慢指针的值不相等则说明为不重复的,则把值写入慢指针对应的数组元素中去
            if(nums[i] != nums[k]){
                k++;
                nums[k]=nums[i];
            }
        }
        //移动慢指针
        return k+1;
    }

    /**
     * 会出现数组越界异常    原因：因为arr数组的长度为3，即拥有arr[0],arr[1],arr[2]三个元素。
     * 而for循环的条件为i<=3,当i==3时，arr[3]是不存在数组的内存空间中，则会出现数组越界异常。
     */
    private static void arrayCrossTheBorder() {
        int i = 0;
        int[] arr = new int[3];
        for (; i <= 3; i++) {
            arr[i] = 0;
            System.out.println("hello word huaXing");
        }
    }
}
