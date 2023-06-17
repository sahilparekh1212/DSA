class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();

        // Make a node & parent HashMap by DFS
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        makeParentMap(root, parentMap);
        Map<TreeNode, Boolean> visitedMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode currNode = target;
        q.offer(currNode);
        visitedMap.put(currNode, true);
        int level = 0;

        // Do DFS in 3 directions from given target until k level is reached
        // Note: Use Visited HashMap to avoid duplicate work
        while (!q.isEmpty()) {
            if (level == k) {
                break;
            }
            level++;
            int qSize = q.size();
            // loop through level-queue for qSize time in 3 directions
            for (int i = 0; i < qSize; i++) {
                currNode = q.poll();
                if (currNode.left != null && visitedMap.get(currNode.left) == null) {
                    q.offer(currNode.left);
                    visitedMap.put(currNode.left, true);
                }
                if (currNode.right != null && visitedMap.get(currNode.right) == null) {
                    q.offer(currNode.right);
                    visitedMap.put(currNode.right, true);
                }
                if (parentMap.get(currNode) != null && visitedMap.get(parentMap.get(currNode)) == null) {
                    q.offer(parentMap.get(currNode));
                    visitedMap.put(parentMap.get(currNode), true);
                }
            }

        }

        // remaining elements in the queue are ans
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }

    private void makeParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode currNode = root;
        while (!q.isEmpty()) {
            currNode = q.poll();
            if (currNode.left != null) {
                parentMap.put(currNode.left, currNode);
                q.offer(currNode.left);
            }
            if (currNode.right != null) {
                parentMap.put(currNode.right, currNode);
                q.offer(currNode.right);
            }
        }
    }
}