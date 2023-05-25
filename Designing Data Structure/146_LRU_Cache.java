// https://leetcode.com/problems/lru-cache/solutions/1305346/java-hasmapap-queue-linked-list-easy-approach-with-explanation/

// O(n) O(n)
// class LRUCache {
//     Queue<Integer> q;
//     final int CAPACITY;
//     Map<Integer,Integer> map;
//     public LRUCache(int capacity) {
//         // 
//         q = new LinkedList<>();
//         CAPACITY = capacity;
//         map = new HashMap<>();
//     }

//     public int get(int key) {
//         if(map.containsKey(key)){
//             q.remove(key);
//             q.offer(key);
//             return map.get(key);
//         }
//         return -1;
//     }

//     public void put(int key, int value) {
//         if(map.containsKey(key)){
// q.remove(key);
//         }else if(q.size()==CAPACITY){
//             map.remove(q.poll());
//         }
//         q.offer(key);
//         map.put(key,value);
//     }
// }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// O(1) O(n)
class DLL {
    int key;
    int val;
    DLL prev;
    DLL next;

    public DLL(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Map<Integer, DLL> map;
    DLL head;
    DLL tail;
    final int CAPACITY;

    public LRUCache(int capacity) {
        head = new DLL(-1, -1);
        tail = new DLL(-1, -1);
        head.next = tail;
        tail.prev = head;

        map = new HashMap();
        CAPACITY = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLL refNode = map.get(key);
            deleteNode(refNode);
            addNodeAfterHead(refNode.key, refNode.val);
            return refNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (CAPACITY == 0) {
            return;
        }

        if (map.containsKey(key)) {
            deleteNode(map.get(key));
        }

        if (map.size() == CAPACITY) {
            deleteNode(tail.prev);
        }

        addNodeAfterHead(key, value);
    }

    private void deleteNode(DLL node) {
        map.remove(node.key);
        DLL prev = node.prev;
        DLL next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addNodeAfterHead(int key, int value) {
        DLL newNode = new DLL(key, value);
        DLL oldHeadNext = head.next;
        map.put(key, newNode);

        head.next = newNode;
        newNode.prev = head;
        newNode.next = oldHeadNext;
        oldHeadNext.prev = newNode;
    }
}