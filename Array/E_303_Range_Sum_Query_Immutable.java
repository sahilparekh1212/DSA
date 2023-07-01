class NumArray {
    int[] sumNums;
    public NumArray(int[] nums) {
        this.sumNums = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            this.sumNums[i+1] += this.sumNums[i] + nums[i];
        }
    }
    
    public int sumRange(int l, int r) {
        return this.sumNums[r+1] - this.sumNums[l];
    }
}
