package com.holybell.algorithm.binarysearch;

public class BinarySearchDesc {

    // ------------------------------------- 精确查找数字二分查找 -------------------------------------

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
                // 由于mid已在if(nums[mid]==target)处理过，因此left取值mid+1，新的查询区间为[mid+1,right],mid不参与下一轮比较
                left = mid + 1;                 // 注意
            } else if (nums[mid] > target) {
                // 由于mid已在if(nums[mid]==target)处理过，因此right取值mid-1，新的查询区间为[left,mid-1],mid不参与下一轮比较
                right = mid - 1;                // 注意
            }
        }
        return -1;
    }

    /**
     * 针对上一个标准写法while终止条件的讨论
     */
    public static int binarySearchV2(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right]  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0;
        int right = nums.length - 1; // 注意


        // 终止条件为left == right, 区间[left,left]存在未被二分查找遍历的值
        while (left < right) {
            // 循环体内left和right的取值同binarySearchV1()，不再赘述
            int mid = left + (right - left) / 2;
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

    // ------------------------------------- 二分查找重复数字的左边界 -------------------------------------

    public static int leftBoundV1(int[] nums, int target) {

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
                right = mid;
            } else if (nums[mid] < target) {
                // 由于nums[mid]已经在if (nums[mid] == target)比较过，left取值mid+1，新的查找区间为[mid+1,right),mid不参与下一轮比较
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 由于nums[mid]已经在if (nums[mid] == target)比较过，right取值mid，新的查找区间为[left,mid),mid不参与下一轮比较
                right = mid;                                                                            // 注意
            }
        }

        // 这里返回的left表示nums[]中有多少个元素小于target
        return left;
    }

    public static int leftBoundV2(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right]  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0;
        int right = nums.length - 1;                                                                    // 注意

        // 终止条件left == right+1，此时[right,right+1]为一个空区间，无二分查找未遍历值
        while (left <= right) {                                                                          // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;                  // 循环终止条件 left = right+1，此时right赋值mid-1，因此而num[mid]==target, mid =right+1 = left,因此left表示有多少元素小于target
            } else if (nums[mid] < target) {
                // 由于nums[mid]已经在if (nums[mid] == target)比较过，left取值mid+1，新的查找区间为[mid+1,right],mid不参与下一轮比较
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 由于nums[mid]已经在if (nums[mid] == target)比较过，right取值mid，新的查找区间为[left,mid-1],mid不参与下一轮比较
                right = mid - 1;                                                                        // 注意
            }
        }
        // 这里返回的left表示nums[]中有多少个元素小于target
        return left;
    }

    public static int leftBoundV3(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right)  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0;
        int right = nums.length - 1;                                                                    // 注意

        // 终止条件left == right，此时[left,left)为一个空区间，无二分查找未遍历值
        while (left < right) {                                                                          // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;                        // 循环终止条件 left == right，此时right赋值mid，因此而num[mid]==target,因此left=right=有多少个元素小于target!!!!!!!
            } else if (nums[mid] < target) {
                // 由于nums[mid]已经在if (nums[mid] == target)比较过，left取值mid+1，新的查找区间为[mid+1,right],mid不参与下一轮比较
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 由于nums[mid]已经在if (nums[mid] == target)比较过，right取值mid，新的查找区间为[left,mid-1],mid不参与下一轮比较
                right = mid;                                                                            // 注意
            }
        }

        // left表示有多少个元素小于target，因此选择范围为[0,nums.length]，需要避免右边边界溢出
        if (left == nums.length) {
            return -1;
        }

        // 再进一步判断虽然有指定个数元素小于target，但是nums中不存在target的情形，比如: {1, 2, 2, 2, 3, 7}  查找5， left = 5,nums[5]==7不是目标值
        return nums[left] == target ? left : -1;
    }

    public static int leftBoundV4(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        // 二分查找遍历区间: [left,right]  决定两个条件: ① while终止条件  ② left\right对mid的重新取值
        int left = 0, right = nums.length - 1;

        // 终止条件: left = right + 1
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {  // 收缩右侧边界
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    // ------------------------------------- 二分查找重复数字的右边界 -------------------------------------

    public static int rightBoundV1(int[] nums, int target) {

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
                // 循环终止条件 left = right, 此时a[mid]=target,left=right=mid+1时终止循环，则left-1和right-1表示右边界！！！！！！！！！！！！！！
            } else if (nums[mid] < target) {
                // nums[mid]上面比较过，不是目标值，缩小左边界，在[mid+1,right)继续查找target，此时nums[mid]不再参与
                left = mid + 1;
            } else if (nums[mid] > target) {
                // nums[mid]上面比较过，不是目标值，缩小右边界，在[left,mid)继续查找target，此时nums[mid]不再参与
                right = mid;
            }
        }
        return left - 1; // 注意
    }

    public static int rightBoundV2(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        // 终止条件  left = right+1
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) { // 这⾥改成收缩左侧边界即可
                left = mid + 1;
                // 循环终止条件 left = right+1, 此时a[mid]=target,left=mid+1时终止循环，则left-1=right=mid表示右边界
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        // 这⾥改为检查 right 越界的情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 2, 3, 7};
        int[] nums2 = new int[]{1, 2, 3, 4, 5};
//        System.out.println(leftBoundV3(nums1, 3));
//        System.out.println(leftBoundV4(nums1, 3));

        System.out.println(rightBoundV1(nums1, 7));
        System.out.println(rightBoundV2(nums1, 7));
    }
}
