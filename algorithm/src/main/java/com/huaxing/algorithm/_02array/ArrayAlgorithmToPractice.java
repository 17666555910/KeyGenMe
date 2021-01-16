package com.huaxing.algorithm._02array;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description
 * @author: 姚广星
 * @time: 2020/12/20 16:35
 */
@Slf4j
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
        nums = new int[]{7, 1, 5, 3, 6, 4};
        int profit = ArrayAlgorithmToPractice.maxProfit2(nums);
        System.out.println("profit = " + profit);
        //---------------- 习题2:买卖股票的最佳时机（贪心算法） end -----------------------------


        //---------------- 习题3:旋转数组（三种方式） begin ---------------------
        //方式1：直接旋转
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayAlgorithmToPractice.rotate1(nums, 3);
        //方式2：
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayAlgorithmToPractice.rotate2(nums, 3);
        //---------------- 习题3:旋转数组（三种方式） end -----------------------


        //---------------- 习题4:存在重复元素 begin ---------------------
        /**
         * 示例 1:    输入: [1,2,3,1]   输出: true
         * 示例 2:    输入: [1,2,3,4]   输出: false
         * 示例 3:    输入: [1,1,1,3,3,4,3,2,4,2]   输出: true
         */
        nums = new int[]{1, 2, 3, 1};
        System.out.println("习题4:存在重复元素 方式一: " + ArrayAlgorithmToPractice.containsDuplicate(nums));
        System.out.println("习题4:存在重复元素 方式二: " + ArrayAlgorithmToPractice.containsDuplicate2(nums));
        System.out.println("习题4:存在重复元素 方式二（优化版）: " + ArrayAlgorithmToPractice.containsDuplicate3(nums));
        //---------------- 习题4:存在重复元素 end -----------------------

        //---------------- 习题5:只出现一次的数字 begin ------------------
        /**
         * 示例 1:    输入: [2,2,1]         输出: 1
         * 示例 2:    输入: [4,1,2,1,2]     输出: 4
         */
        nums = new int[]{2, 2, 1};
        System.out.println("习题5:只出现一次的数字 方式一: " + ArrayAlgorithmToPractice.singleNumber(nums));
        System.out.println("习题5:只出现一次的数字 方式二: " + ArrayAlgorithmToPractice.singleNumber2(nums));
        //---------------- 习题5:只出现一次的数字 end --------------------

        //---------------- 习题6:两个数组的交集 begin ------------------
        /**
         * 示例 1： 输入：nums1 = [1,2,2,1], nums2 = [2,2] 输出：[2,2]
         * 示例 2： 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出：[4,9]
         */
        nums = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println("习题6:两个数组的交集 方式一: " + JSONObject.toJSONString(ArrayAlgorithmToPractice.intersect(nums, nums2)));
        System.out.println("习题6:两个数组的交集 方式二: " + JSONObject.toJSONString(ArrayAlgorithmToPractice.intersect2(nums, nums2)));
        System.out.println("习题6:两个数组的交集 方式二: " + JSONObject.toJSONString(ArrayAlgorithmToPractice.intersect3(nums, nums2)));
        System.out.println("习题6:两个数组的交集 方式四: " + JSONObject.toJSONString(ArrayAlgorithmToPractice.intersect4(nums, nums2)));
        //---------------- 习题6:两个数组的交集 end --------------------

        //---------------- 习题7:加一 begin ------------------
        /**
         * 示例 1：输入：digits = [1,2,3] 输出：[1,2,4] 解释：输入数组表示数字 123。
         * 示例 2：输入：digits = [4,3,2,1]输出：[4,3,2,2] 解释：输入数组表示数字 4321。
         * 示例 3：输入：digits = [0,0]输出：[0,1]
         * 示例 4：输入：digits = [9,8,7,6,5,4,3,2,1,0]输出：[9,8,7,6,5,4,3,2,1,1]
         */
        nums = new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6};
        System.out.println("习题7:加一 方式一: " + JSONObject.toJSONString(ArrayAlgorithmToPractice.plusOne(nums)));
        System.out.println("习题7:加一 方式二: " + JSONObject.toJSONString(ArrayAlgorithmToPractice.plusOne2(nums)));
        //---------------- 习题7:加一 end --------------------

        //---------------- 习题8 移动零 begin ------------------
        //示例: 输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
        nums = new int[]{0, 1, 0, 3, 12};
        ArrayAlgorithmToPractice.moveZeroes(nums);
        //---------------- 习题8 移动零 end ------------------

        //---------------- 习题9 两数之和 begin ------------------
        /**
         * 示例 1：输入：nums = [2,7,11,15], target = 9 输出：[0,1] 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
         * 示例 2：输入：nums = [3,2,4], target = 6 输出：[1,2]
         * 示例 3：输入：nums = [3,3], target = 6 输出：[0,1]
         */
        nums = new int[]{3, 3};
        System.out.println("习题9:两数之和 方式一: " + JSONObject.toJSONString(ArrayAlgorithmToPractice.twoSum(nums, 6)));
        System.out.println("习题9:两数之和 方式二: " + JSONObject.toJSONString(ArrayAlgorithmToPractice.twoSum2(nums, 6)));
        //---------------- 习题9 两数之和 begin ------------------
    }

    /**
     * TODO 两数之和：方式一：解题思路：数组转list，判断target-当前元素的值在list中是否存在，若存在返回对应的下标，若不存在，进入下一个循环
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 你可以按任意顺序返回答案。
     * <p>
     * 作者：华星详谈
     *
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        //解题思路：数组转list，判断target-当前元素的值在list中是否存在，若存在返回对应的下标，若不存在，进入下一个循环
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int i1 = target - nums[i];
            if (list.contains(i1)) {
                if (list.indexOf(nums[i]) != list.lastIndexOf(i1)) {
                    result[0] = list.indexOf(nums[i]);
                    result[1] = list.lastIndexOf(i1);
                    index++;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index + 1);
    }

    /**
     * TODO 两数之和：方式二(推荐使用)：解题思路：使用hash表的方式。定义一个map，存放元素和对应的下标，如果map中包含（target-当前元素），则返回他们的下标
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 你可以按任意顺序返回答案。
     * <p>
     * 作者：华星详谈
     *
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        //使用hash表的方式。定义一个map，存放元素和对应的下标，如果map中包含（target-当前元素），则返回他们的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


    /**
     * TODO 移动零：使用双指针
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * <p>
     * 作者：华星详谈
     *
     * @return
     */
    public static void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (left < nums.length) {
            if (nums[left] != 0) {
                if (left > right) {
                    nums[right] = nums[left];
                    nums[left] = 0;
                }
                right++;
            }
            left++;
        }
        System.out.println("习题8 移动零：使用双指针：" + JSONObject.toJSONString(nums));
    }

    /**
     * TODO 加一  解题思路：判断digits.length 是否为9 如果为9就改为1，继续循环digits.length-1，若为不等于9，则+1。最后处理特殊情况 99。
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * <p>
     * 作者：华星详谈
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        //解题思路：判断digits.length 是否为9 如果为9就改为1，继续循环digits.length-1，若为不等于9，则+1。最后处理特殊情况 99。
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        //处理最高位为9的情况
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    /**
     * TODO 加一  解题思路：digits[i]++ ,然后 digits[i] 取余 10，如果能够被整除，说明进一位，如果不能够被整除则直接返回
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * <p>
     * 作者：华星详谈
     *
     * @param digits
     * @return
     */
    public static int[] plusOne2(int[] digits) {
        //解题思路：digits[i]++ ,然后 digits[i] 取余 10，如果能够被整除，说明进一位，如果不能够被整除则直接返回
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                //说明不能够整除
                return digits;
            }
        }
        //处理特殊情况：最高位为9时
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }


    /**
     * TODO 两个数组的交集     方式一：使用Java8新特性
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * <p>
     * 作者：华星详谈
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        List<Integer> collect = list1.stream().filter(num -> list2.contains(num)).collect(Collectors.toList());
        return collect.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * TODO 两个数组的交集     方式二：使用hash表的方式
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * <p>
     * 作者：华星详谈
     *
     * @param nums1 长度较短的数组
     * @param nums2 长度较长的数组
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        //为了使算法最优化，在最外层迭代数组长度较长的那个
        if (nums1.length > nums2.length) {
            return intersect2(nums2, nums1);
        }
        Set<Integer> set = new HashSet();
        for (int num : nums2) {
            for (int i : nums1) {
                if (num == i) {
                    set.add(i);
                }
            }
        }
        return set.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * TODO 两个数组的交集     方式二：使用hash表的方式(优化版)
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * <p>
     * 作者：华星详谈
     *
     * @param nums1 长度较短的数组
     * @param nums2 长度较长的数组
     * @return
     */
    public static int[] intersect3(int[] nums1, int[] nums2) {
        //为了使算法最优化，在最外层迭代数组长度较长的那个
        if (nums1.length > nums2.length) {
            return intersect3(nums2, nums1);
        }
        //定义一个map，存放每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        int index = 0;
        int[] result = new int[nums1.length];
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                //说明该元素存在于num1、num2中
                result[index++] = num;
                //该元素已经放入result，自身减一
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        //返回index长度的排序集合
        return Arrays.copyOfRange(result, 0, index);
    }

    /**
     * TODO 两个数组的交集     方式三：使用排序后双指针的方式，(当num2长度过大，内存放不下是不适用) ps:执行时间耗时最少
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * <p>
     * 作者：华星详谈
     *
     * @param nums1 长度较短的数组
     * @param nums2 长度较长的数组
     * @return
     */
    public static int[] intersect4(int[] nums1, int[] nums2) {
        //为了使算法最优化，在最外层迭代数组长度较长的那个
        if (nums1.length > nums2.length) {
            return intersect4(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int index = 0, index1 = 0, index2 = 0;
        int[] result = new int[Math.min(length1, length2)];
        //当两个索引都比长度小时，才进入循环
        while (index1 < length1 && index2 < length2) {
            //元素较小的右移一位
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                result[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    /**
     * TODO 只出现一次的数字   方式一：使用hashSet集合方式
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * <p>
     * 作者：华星详谈
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                //添加不成功，则说明是重复的数据，则删除对应的元素
                set.remove(num);
            }
        }
        return set.isEmpty() ? -1 : set.iterator().next();
    }

    /**
     * TODO 只出现一次的数字   方式二：分组取list长度为1
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * <p>
     * 作者：华星详谈
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list = list.stream()
                .collect(Collectors.groupingBy(value -> value))
                .entrySet()
                .stream()
                .filter(i -> i.getValue().size() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return list.isEmpty() ? -1 : list.get(0);
    }

    /**
     * TODO 存在重复元素  方式1：使用set集合的方式
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * <p>
     * 作者：华星详谈
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * TODO 存在重复元素  方式2：排序之后判断相邻元素的是否相等
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * <p>
     * 作者：华星详谈
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * TODO 存在重复元素  方式2：排序之后判断相邻元素的是否相等(优化版-使用IntStream)
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * <p>
     * 作者：华星详谈
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate3(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }

    /**
     * TODO 旋转数组    方式1：直接旋转
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 说明:
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     * 复杂度分析：
     * 时间复杂度：O(k*n)。n为数组的元素，k为旋转次数
     * 空间复杂度：O(1)。常数位的空间复杂度，没有额外的空间被使用
     * <p>
     * 作者：华星详谈
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        //temp:临时存储，previous：之前的值
        int temp, previous;
        for (int i = 0; i < k; i++) {
            //保存数组最后一个元素
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                //把当前位的值先暂时放入temp中
                temp = nums[j];
                //当前位的值替换为最后位的值
                nums[j] = previous;
                //把当前位的值最为下一次循环的最后位值
                previous = temp;
            }
        }
        System.out.println("方式一 直接旋转：nums = " + JSON.toJSONString(nums));
    }

    /**
     * TODO 旋转数组    方式2：反转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 说明:
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     * 复杂度分析：
     * 时间复杂度：O(n)。n为数组的元素。n 个元素被反转了总共 3 次。
     * 空间复杂度：O(1)。常数位的空间复杂度，没有额外的空间被使用
     * <p>
     * 作者：华星详谈
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        // k = k%数组的长度，eg k=3%7=3；
        k %= nums.length;
        //反转所有数字
        reversal(nums, 0, nums.length - 1);
        //反转前 k 个数字
        reversal(nums, 0, k - 1);
        //反转后 n-k 个数字
        reversal(nums, k, nums.length - 1);
        System.out.println("方式二 使用反转：nums = " + JSON.toJSONString(nums));
    }

    /**
     * 反转数组
     *
     * @param nums
     * @param start 数组开始下标
     * @param end   数组结束下标
     */
    private static void reversal(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * TODO 删除排序数组中的重复项
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 作者：华星详谈
     */
    private static int deleteArrayDuplicates(int[] nums) {
        //思路：使用双指针的方式
        //定义一个慢指针
        int k = 0;
        //迭代循环快指针
        for (int i = 1; i < nums.length; i++) {
            //如果快指针的值和慢指针的值不相等则说明为不重复的,则把值写入慢指针对应的数组元素中去
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];
            }
        }
        //移动慢指针
        return k + 1;
    }

    /**
     * TODO 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 作者：华星详谈
     *
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
        for (int a = 0; a < prices.length; a++) {
            if (a == prices.length - 1) {
                if (isBuying) {
                    profit += prices[a] - buying;
                }
                break;
            }
            //买入
            if (!isBuying && prices[b] > prices[a]) {
                buying = prices[a];
                isBuying = true;
            }
            //卖出
            if (isBuying && prices[b] < prices[a]) {
                profit += prices[a] - buying;
                //清空数据
                buying = 0;
                isBuying = false;
            }
            b++;
        }
        return profit;
    }

    /**
     * TODO 买卖股票的最佳时机---> 优化之后的算法
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 作者：华星详谈
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        //利润
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            //获取利润，当prices[i] - prices[i-1] > 0  时，说明有利可图
            profit += Math.max(0, prices[i] - prices[i - 1]);
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
