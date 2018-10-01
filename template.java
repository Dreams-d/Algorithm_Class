
public class Solution {
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
    public List<Integer> commonI(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<Integer>();
        if (A.size() < B.size()) {
            getCommon(A, B, result);
        } else {
            getCommon(B, A, result);
        }
        return result;
    }

    private void getCommon(List<Integer> small, List<Integer> large, List<Integer> result) {
        for (Integer num : small) {
            int i = 0;
            int j = large.size() - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (num < large.get(mid)) {
                    j = mid - 1;
                } else if (num > large.get(mid)) {
                    i = mid + 1;
                } else {
                    result.add(num);
                    break;
                }
            }
        }
    }
}