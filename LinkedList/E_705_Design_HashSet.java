class MyHashSet {
    int size = (int) Math.pow(10, 6) + 1;
    boolean[] refArr;

    public MyHashSet() {
        refArr = new boolean[size];
    }

    public void add(int key) {
        refArr[key] = true;
    }

    public void remove(int key) {
        refArr[key] = false;
    }

    public boolean contains(int key) {
        return refArr[key] == true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */