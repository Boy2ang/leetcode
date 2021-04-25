package life.yangbo.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * @author yangbo
 */
public class TowSumSolution {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 15, 100, 200};
        int target = 2;
        int[] result = new TowSumSolution().towSum(nums, target);
        System.out.println(result);
    }

    /**
     * 1.新建个key value 的 空map 用于保存未匹配时的nums值和索引
     * 2.如果target与遍历的项之差存在于map中，则返回两个数的索引
     * 3.否则将这个数存到map中
     * @param nums
     * @param target
     * @return
     */
    private int[] towSum(int[] nums, int target) {

        /**
         * 利用map key不能相同，value可以相同这个特性
         * key存nums的值，而value存索引
         */
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            /**
             * map.put(nums[i], i);不能放这里，比如想下面这种情况，就会返回[0,0],那么就不正确了。
             * int[] nums = {1, 5, 11, 15, 100, 200};
             * int target = 2;
             */
            // map.put(nums[i], i);
            int n1 = target - nums[i];
            if (map.containsKey(n1)) {
                result[0] = map.get(n1);
                result[1] = i;
                return result;
            }
            // 只能放这里
            map.put(nums[i], i);

        }

        return null;

    }
}
