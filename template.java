public class Solution {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
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