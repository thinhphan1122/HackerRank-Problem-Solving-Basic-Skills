package Question2;

import java.util.List;

class Result {

    /*
     * Complete the 'mostBalancedPartition' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY parent
     *  2. INTEGER_ARRAY files_size
     */

    private static int minDifference;

    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
        // Write your code here
        int n = parent.size();
        int[] subtreeSize = new int[n];
        int totalSize = calculateSubtreeSizes(0, parent, files_size, subtreeSize);
        minDifference = Integer.MAX_VALUE;

        dfs(0, parent, subtreeSize, totalSize);

        return minDifference;
    }

    private static int calculateSubtreeSizes(int node, List<Integer> parent, List<Integer> files_size, int[] subtreeSize) {
        int currentSize = files_size.get(node);

        for (int i = 0; i < parent.size(); i++) {
            if (parent.get(i).equals(node)) {
                currentSize += calculateSubtreeSizes(i, parent, files_size, subtreeSize);
            }
        }

        subtreeSize[node] = currentSize;
        return currentSize;
    }

    private static void dfs(int node, List<Integer> parent, int[] subtreeSize, int totalSize) {
        int currentSize = subtreeSize[node];
        int remainingSize = totalSize - currentSize;

        minDifference = Math.min(minDifference, Math.abs(currentSize - remainingSize));

        for (int i = 0; i < parent.size(); i++) {
            if (parent.get(i).equals(node)) {
                dfs(i, parent, subtreeSize, totalSize);
            }
        }
    }
}