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