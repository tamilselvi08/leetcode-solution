class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2; i < nums.length; i++){
            int val1 = arr1.get(arr1.size() - 1);
            int val2 = arr2.get(arr2.size() - 1);

            if(val1 > val2) arr1.add(nums[i]);
            else arr2.add(nums[i]);
        }

        int m = arr1.size() + arr2.size();
        int[] arr = new int[m];
        int idx = 0;

        for(int i = 0; i < arr1.size(); i++)
            arr[idx++] = arr1.get(i);

        for(int i = 0; i < arr2.size(); i++)
            arr[idx++] = arr2.get(i);

        return arr;
    }
}