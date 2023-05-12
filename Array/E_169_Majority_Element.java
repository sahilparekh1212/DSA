class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                hm.put(nums[i], 1);
            }
        }
        int ansKey = 0;
        int ansValue = 0;
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getValue() > ansValue) {
                ansKey = (int) e.getKey();
                ansValue = e.getValue();
            }
        }
        return ansKey;
    }
}