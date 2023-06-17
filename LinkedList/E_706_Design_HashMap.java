class MyHashMap {
    int[] ref;

    public MyHashMap() {
        ref = new int[(int) Math.pow(10, 6) + 1];
    }

    public void put(int key, int value) {
        ref[key] = value;
        if (value == 0) {
            ref[key] = -2;
        }

    }

    public int get(int key) {
        if (ref[key] > 0) {
            return ref[key];
        }
        return (ref[key] == 0 ? -1 : 0);
    }

    public void remove(int key) {
        ref[key] = 0;
    }
}