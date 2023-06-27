class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        // return dfsImpo(map,id);
        return bfsImpo(map, id);
    }

    private int dfsImpo(Map<Integer, Employee> map, int id) {
        int importanceSum = map.get(id).importance;
        List<Integer> subList = map.get(id).subordinates;
        for (Integer i : subList) {
            importanceSum += dfsImpo(map, i);
        }
        return importanceSum;
    }

    private int bfsImpo(Map<Integer, Employee> map, int id) {
        int importanceSum = 0;
        Queue<Employee> q = new LinkedList<>();
        q.offer(map.get(id));
        while (!q.isEmpty()) {
            Employee e = q.poll();
            importanceSum += e.importance;
            for (Integer i : e.subordinates) {
                q.offer(map.get(i));
            }
        }
        return importanceSum;
    }

    public int getImportance2(List<Employee> employees, int id) {
        HashMap<Integer, Integer> hmII = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        Employee curr = new Employee();
        int index = 0;
        for (Employee e : employees) {
            if (e.id == id) {
                curr = e;
            }
            hmII.put(e.id, e.importance);
            hm2.put(e.id, index);
            index++;
        }
        int totalImportance = curr.importance;
        for (Integer i : curr.subordinates) {
            totalImportance += hmII.get(i);
            if (employees.get(hm2.get(i)).subordinates.size() != 0) {
                for (Integer j : employees.get(hm2.get(i)).subordinates) {
                    totalImportance += getImportance(employees, j);
                }
            }
        }
        return totalImportance;
    }
}