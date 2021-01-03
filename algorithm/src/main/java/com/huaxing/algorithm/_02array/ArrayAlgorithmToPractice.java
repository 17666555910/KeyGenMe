package com.huaxing.algorithm._02array;

/**
 * @Description
 * @author: 姚广星
 * @time: 2020/12/20 16:35
 */
public class ArrayAlgorithmToPractice {


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

        //---------------- 习题2:买卖股票的最佳时机（贪心算法） begin ---------------------------
        /**
         * 买卖股票的最佳时机
         * 示例 1: 输入: [7,1,5,3,6,4]      输出: 7
         * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
         *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3
         *
         * 示例 2:输入: [1,2,3,4,5]     输出: 4
         * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
         *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
         *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
         *
         * 示例 3:输入: [7,6,4,3,1]     输出: 0
         * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
         */
        int[] nums2 = {7,6,4,3,1};
        int profit = ArrayAlgorithmToPractice.maxProfit(nums2);
        System.out.println("profit = " + profit);
        //---------------- 习题2:买卖股票的最佳时机（贪心算法） end -----------------------------
    }

    /**
     * TODO 删除排序数组中的重复项
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
     * TODO 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 作者：华星详谈
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        //解题思路：使用双指针，a为当前指针，b为下一个指针。
        //当b>a 时，买入股票
        //当b<a时，卖出股票，利润=arr[a]-买入时的价格
        //下一个指针
        int b = 1;
        //利润
        int profit = 0;
        //买入时的价格
        int buying = 0;
        //是否有买入
        boolean isBuying = false;
        for(int a=0;a<prices.length;a++){
            if(a == prices.length-1){
                if(isBuying){
                    profit += prices[a]-buying;
                    //清空数据
                    buying = 0;
                    isBuying = false;
                }
                break;
            }
            //买入
            if(!isBuying && prices[b] > prices[a]){
                buying = prices[a];
                isBuying = true;
            }
            //卖出
            if(isBuying && prices[b] < prices[a]){
                profit += prices[a]-buying;
                //清空数据
                buying = 0;
                isBuying = false;
            }
            b++;
        }
        return profit;
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
