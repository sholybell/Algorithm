package com.holybell.algorithm.binarysearch;

import java.util.Arrays;

public class BinarySearchDesc {

    // ------------------------------------- 在不重复的有序数组中二分查找目标值 -------------------------------------

    /**
     * 常规双闭区间[left,right]二分查找解法
     */
    public static int binarySearchV1(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right]  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0;
        int right = nums.length - 1; // 注意

        // while(left <= right) 终止条件 left == right + 1，此时查询区间为[left,left+1]，无剩余元素
        // 使用while(left < right) 参考 binarySearchV2()方法
        while (left <= right) {
            int mid = left + (right - left) / 2;  // 相比(left+right)/2可以避免整型溢出
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 由于nums[mid]已在if(nums[mid]==target)处理过，因此left取值mid+1，新的查询区间为[mid+1,right],nums[mid]不参与下一轮比较
                left = mid + 1;                 // 注意
            } else if (nums[mid] > target) {
                // 由于nums[mid]已在if(nums[mid]==target)处理过，因此right取值mid-1，新的查询区间为[left,mid-1],nums[mid]不参与下一轮比较
                right = mid - 1;                // 注意
            }
        }
        return -1;
    }

    /**
     * 针对上一个标准写法while终止条件的讨论，即双闭区间[left,right]，搭配while(left < right)
     */
    public static int binarySearchV2(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right]  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0;
        int right = nums.length - 1; // 注意


        // 终止条件为left == right, 区间[left,left],最终将会导致left一个元素未被二分查找扫描到
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 本题循环体内和binarySearchV1()一致，不再赘述
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;                 // 注意
            } else if (nums[mid] > target) {
                right = mid - 1;                // 注意
            }
        }

        // 由于while终止条件为left == right, 此时尚有一个元素nums[left]=nums[right]未被二分查找遍历，
        // 最后判断一次是nums[left]==nums[right]==target，是返回left，否则返回-1
        return nums[left] == target ? left : -1;
    }

    /**
     * 本例讨论左闭右开区间标准写法
     */
    public static int binarySearchV3(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right)  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0;
        int right = nums.length; // 注意


        // 终止条件为left == right+1, 区间[right+1,right],此区间并无有效元素剩余
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 由于nums[mid]已在nums[mid] == target判断过，本例为左闭右开区间查找，left=mid+1，新的查找区间为[mid+1,right)，nums[mid]不参与下一轮比较
                left = mid + 1;                 // 注意
            } else if (nums[mid] > target) {
                // 由于nums[mid]已在nums[mid] == target判断过，本例为左闭右开区间查找，right=mid，新的查找区间为[left,mid)，nums[mid]不参与下一轮比较
                right = mid;                // 注意
            }
        }

        return -1;
    }

    // ------------------------------------- 在有重复元素的有序数组中二分查找目标值的左边界 -------------------------------------

    /**
     * 双闭区间查找目标值左边界解法
     */
    public static int leftBoundV1(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right]  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0;
        int right = nums.length - 1;                                                                    // 注意

        // 终止条件left == right+1，此时[right+1,right]为一个空区间，无二分查找未遍历值
        while (left <= right) {                                                                          // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // TODO 这里不同于精确查找唯一值，直接返回mid，而是进一步压缩右边界，right=mid-1见本题下方解释
                // TODO 循环终止条件: left = right+1，此时right赋值mid-1，而num[mid]==target, 此时存在表达式 left=right+1=mid, 即left即为目标值的左边界
                // TODO 或者不应该用左边界来理解，可以将left理解为有多少个元素小于目标值，若在{1,2,3,4,5}中查找7，left将为5，但是目标值7不存在
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 由于nums[mid]已经在if (nums[mid] == target)比较过，left取值mid+1，新的查找区间为[mid+1,right],mid不参与下一轮比较
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 由于nums[mid]已经在if (nums[mid] == target)比较过，right取值mid，新的查找区间为[left,mid-1],mid不参与下一轮比较
                right = mid - 1;                                                                        // 注意
            }
        }
        // TODO 这里返回的left表示nums[]中有多少个元素小于target
        return left;

        // 补充: left 和 right 取值区间的讨论
        // 由于mid 取值区间 [0,nums.length-1]
        // left  初始值0               mid+1取值区间   [1,nums.length]     合并后left 取值区间 [0,nums.length]
        // right 初始值nums.length-1   mid-1取值区间   [-1,nums.length-2]  合并后right取值区间 [-1,nums.length-1]
    }

    /**
     * 左闭右开区间查找目标值左边界解法
     */
    public static int leftBoundV2(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right)  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0;
        int right = nums.length;                                                                        // 注意

        // 终止条件left == right，此时[left,left)为一个空区间，无二分查找未遍历值
        while (left < right) {                                                                          // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // TODO 这里不同于精确查找唯一值，直接返回mid，而是进一步压缩右边界，right=mid见本题下方解释
                // TODO 循环终止条件: left = right，此时right赋值mid，而num[mid]==target, 此时存在表达式 left=right=mid, 即left即为目标值的左边界
                // TODO 或者不应该用左边界来理解，可以将left理解为有多少个元素小于目标值，若在{1,2,3,4,5}中查找7，left将为5，但是目标值7不存在
                right = mid;
            } else if (nums[mid] < target) {
                // 由于nums[mid]已经在if (nums[mid] == target)比较过，left取值mid+1，新的查找区间为[mid+1,right),mid不参与下一轮比较
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 由于nums[mid]已经在if (nums[mid] == target)比较过，right取值mid，新的查找区间为[left,mid),mid不参与下一轮比较
                right = mid;                                                                            // 注意
            }
        }

        // TODO 这里返回的left表示nums[]中有多少个元素小于target
        return left;

        // 补充: left 和 right 取值区间的讨论
        // 由于mid 取值区间 [0,nums.length-1]
        // left  初始值0               mid+1  取值区间   [1,nums.length]     合并后left 取值区间 [0，nums.length]
        // right 初始值nums.length     mid    取值区间   [0,nums.length-1]   合并后right取值区间 [0,nums.length]
    }

    /**
     * 双闭区间求目标值左边界，在目标值不存在的正确解法
     */
    public static int leftBoundV3(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right]  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0, right = nums.length - 1;

        // 终止条件: left = right + 1
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {  // 收缩右侧边界
                // TODO 这里不同于精确查找唯一值，直接返回mid，而是进一步压缩右边界，right=mid见本题下方解释
                // TODO 循环终止条件: left = right，此时right赋值mid-1，而num[mid]==target, 此时存在表达式 left=right+1=mid, 即left即为目标值的左边界
                // TODO 或者不应该用左边界来理解，可以将left理解为有多少个元素小于目标值，若在{1,2,3,4,5}中查找7，left将为5，但是目标值7不存在
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right], nums[mid]不参与下一轮
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]，nums[mid]不参与下一轮
                right = mid - 1;
            }
        }
        // TODO 由于left 表示多少个元素小于目标值，因此取值范围为[0,nums.length], left = nums.length时下标溢出
        // TODO 又存在left表示多少个元素小于目标值，不代表这个目标值在数组中，还需要额外判断nums[left]=target
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    /**
     * 左闭右开区间求目标值左边界，在目标值不存在的正确解法
     */
    public static int leftBoundV4(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right)  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0;
        int right = nums.length;                                                                    // 注意

        // 终止条件left == right，此时[left,left)为一个空区间，无二分查找未遍历值
        while (left < right) {                                                                          // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // TODO 循环终止条件 left == right，此时right赋值mid，因此而num[mid]==target,因此left=right=mid,表示有多少个元素小于target!!!!!!!
                right = mid;
            } else if (nums[mid] < target) {
                // 由于nums[mid]已经在if (nums[mid] == target)比较过，left取值mid+1，新的查找区间为[mid+1,right],mid不参与下一轮比较
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 由于nums[mid]已经在if (nums[mid] == target)比较过，right取值mid，新的查找区间为[left,mid-1],mid不参与下一轮比较
                right = mid;                                                                            // 注意
            }
        }

        // TODO left表示有多少个元素小于target，因此选择范围为[0,nums.length]，需要避免右边边界溢出
        if (left == nums.length) {
            return -1;
        }

        // TODO 再进一步判断虽然有指定个数元素小于target，但是nums中不存在target的情形，
        // TODO 比如: {1, 2, 2, 2, 3, 7}  查找5， left = 5,nums[5]==7不是目标值
        return nums[left] == target ? left : -1;
    }

    // ------------------------------------- 在有重复元素的有序数组中二分查找目标值的右边界 -------------------------------------

    /**
     * 双闭区间查找目标值右边界解法
     */
    public static int rightBoundV1(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right]  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0, right = nums.length - 1;

        // 终止条件left == right+1，此时[right+1,right]为一个空区间，无二分查找未遍历值
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // nums[mid]为目标值，缩小左边界，在[mid+1,right]继续查找target，此时nums[mid]不再参与
                // TODO 循环终止条件 left = right+1, 此时a[mid]=target,left=mid+1 ----> mid = left - 1 时终止循环，则left-1和right表示右边界！！！！！！！！！！！！！！
                left = mid + 1;                                                                     // 注意
            } else if (nums[mid] < target) {
                // nums[mid]上面比较过，不是目标值，缩小左边界，在[mid+1,right)继续查找target，此时nums[mid]不再参与
                left = mid + 1;
            } else if (nums[mid] > target) {
                // nums[mid]上面比较过，不是目标值，缩小右边界，在[left,mid)继续查找target，此时nums[mid]不再参与
                right = mid - 1;
            }
        }
        return left - 1; // 注意

        // 补充: left 和 right 取值区间的讨论
        // 由于mid 取值区间 [0,nums.length-1]
        // left  初始值0                 mid+1  取值区间   [1,nums.length]     合并后left 取值区间 [0,nums.length]
        // right 初始值nums.length-1     mid-1  取值区间   [-1,nums.length-2]  合并后right取值区间 [-1,nums.length-1]
    }

    public static int rightBoundV2(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right)  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0, right = nums.length;

        // 终止条件left == right，此时[left,left)为一个空区间，无二分查找未遍历值
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // nums[mid]为目标值，缩小左边界，在[mid+1,right)继续查找target，此时nums[mid]不再参与
                left = mid + 1;                                                                     // 注意
                // TODO 循环终止条件 left = right, 此时a[mid]=target,left=right=mid+1时终止循环，则left-1和right-1表示右边界！！！！！！！！！！！！！！
            } else if (nums[mid] < target) {
                // nums[mid]上面比较过，不是目标值，缩小左边界，在[mid+1,right)继续查找target，此时nums[mid]不再参与
                left = mid + 1;
            } else if (nums[mid] > target) {
                // nums[mid]上面比较过，不是目标值，缩小右边界，在[left,mid)继续查找target，此时nums[mid]不再参与
                right = mid;
            }
        }
        return left - 1; // 注意

        // 补充: left 和 right 取值区间的讨论
        // 由于mid 取值区间 [0,nums.length-1]
        // left  初始值0                 mid+1  取值区间   [1,nums.length]     合并后left 取值区间 [0,nums.length]
        // right 初始值nums.length       mid    取值区间   [0,nums.length-1]   合并后right取值区间 [0,nums.length]
    }

    /**
     * 双闭区间求目标值右边界，在目标值不存在的正确解法
     */
    public static int rightBoundV3(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 搜索区间 [left,right]
        int left = 0, right = nums.length - 1;

        // 终止条件  left = right+1
        while (left <= right) {

            // left 和 right的重新选择类同上文，不再赘述
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                left = mid + 1;
                // 循环终止条件: left = right+1, 此时nums[mid]=target,又left赋值mid+1，则存在表达式left=right+1=mid+1 ---> left -1 = right = mid
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        // TODO left -1 或者 right 表示有多少个元素小于等于目标值，也要判断nums[right]=target
        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return right;

        // 补充: left 和 right 取值区间的讨论
        // 由于mid 取值区间 [0,nums.length-1]
        // left  初始值0                 mid+1  取值区间   [1,nums.length]     合并后left 取值区间 [0,nums.length]
        // right 初始值nums.length-1     mid-1  取值区间   [-1,nums.length-2]  合并后right取值区间 [-1,nums.length-1]
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 2, 3, 7};
        int[] nums2 = new int[]{1, 2, 3, 4, 5};

        System.out.println("数组 : " + Arrays.toString(nums2) + " 元素3位置 :" + binarySearchV1(nums2, 3));
        System.out.println("数组 : " + Arrays.toString(nums2) + " 元素3位置 :" + binarySearchV2(nums2, 3));
        System.out.println("数组 : " + Arrays.toString(nums2) + " 元素3位置 :" + binarySearchV3(nums2, 3));
        System.out.println("-------------------------------------->");
        System.out.println("数组 : " + Arrays.toString(nums1) + " 元素4左边界 :" + leftBoundV1(nums1, 4) + " 明显错误，4不存在，left表示有多少个元素比4小!");
        System.out.println("数组 : " + Arrays.toString(nums1) + " 元素4左边界 :" + leftBoundV2(nums1, 4) + " 明显错误，4不存在，left表示有多少个元素比4小!");
        System.out.println("数组 : " + Arrays.toString(nums1) + " 元素2左边界 :" + leftBoundV3(nums1, 2));
        System.out.println("数组 : " + Arrays.toString(nums1) + " 元素2左边界 :" + leftBoundV4(nums1, 2));
        System.out.println("-------------------------------------->");
        System.out.println("数组 : " + Arrays.toString(nums1) + " 元素2右边界 :" + rightBoundV1(nums1, 2));
        System.out.println("数组 : " + Arrays.toString(nums1) + " 元素2右边界 :" + rightBoundV2(nums1, 2));
        System.out.println("数组 : " + Arrays.toString(nums1) + " 元素2右边界 :" + rightBoundV3(nums1, 2));
    }
}
