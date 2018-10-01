public class CommonNumbers {
    // Assumption: there could be duplicate in arrays.
    // Method1: two pointers
    public List<Integer> commonI(List<Integer> A, List<Integer> B) {
        // Assumption: a and b is not null
        List<Integer> result = new ArrayList<Integer>();
        int aIdx = 0;
        int bIdx = 0;
        while (aIdx < A.size() && bIdx < B.size()) {
            if (A.get(aIdx) < B.get(bIdx)) {
                aIdx++;
            } else if (A.get(aIdx) > B.get(bIdx)) {
                bIdx++;
            } else {
                result.add(A.get(aIdx));
                aIdx++;
                bIdx++;
            }
        }
        return result;
    }

    // Method2: use a hash map
    public List<Integer> commonII(List<Integer> A, List<Integer> B) {
        if (A == null || B == null) {
            return null;
        }

        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (A.size() < B.size()) {
            getMap(A, map);
            getCommon(B, map, result);
        } else {
            getMap(B, map);
            getCommon(A, map, result);
        }
        return result;
    }

    private void getMap(List<Integer> A, HashMap<Integer, Integer> map) {
        for (Integer num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    private void getCommon(List<Integer> B, HashMap<Integer, Integer> map, List<Integer> result) {
        for (Integer num : B) {
            Integer tmp = map.get(num);
            if (tmp != null && tmp != 0) {
                result.add(num);
                map.put(num, --tmp);
            }
        }
    }
}
