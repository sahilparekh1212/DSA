class ValueTimestamp {
    String val;
    int timestamp;

    public ValueTimestamp(String val, int timestamp) {
        this.val = val;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    Map<String, List<ValueTimestamp>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        ValueTimestamp vt = new ValueTimestamp(value, timestamp);
        if (map.containsKey(key)) {
            List<ValueTimestamp> li = map.get(key);
            li.add(vt);
            map.put(key, li);
        } else {
            List<ValueTimestamp> newList = new ArrayList<ValueTimestamp>();
            newList.add(vt);
            map.put(key, newList);
        }
    }

    public String get(String key, int timestamp) {
        String ans = "";
        if (map.containsKey(key)) {
            int l = 0;
            int r = map.get(key).size() - 1;
            int mid = 0;
            while (l <= r) {
                mid = ((l + r) / 2);
                if (map.get(key).get(mid).timestamp <= timestamp) {
                    ans = map.get(key).get(mid).val;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return ans;
    }
}