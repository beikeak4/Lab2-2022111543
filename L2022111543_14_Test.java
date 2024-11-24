public class TestSolution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result1 = solution.restoreIpAddresses("25525511135");
        System.out.println("Example 1:");
        for (String ip : result1) {
            System.out.println(ip);
        }

        List<String> result2 = solution.restoreIpAddresses("0000");
        System.out.println("\nExample 2:");
        for (String ip : result2) {
            System.out.println(ip);
        }

        List<String> result3 = solution.restoreIpAddresses("101023");
        System.out.println("\nExample 3:");
        for (String ip : result3) {
            System.out.println(ip);
        }
    }
}