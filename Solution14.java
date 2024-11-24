import java.util.*;

class Solution {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, new StringBuilder());
        return ans;
    }

    private void dfs(String s, int segId, int segStart, StringBuilder ipAddr) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            if (segId < SEG_COUNT - 1) { // 除了最后一段，其他段不能为0
                dfs(s, segId + 1, segStart + 1, ipAddr.append("0.").append(segId == SEG_COUNT - 2 ? "" : ""));
            } else {
                dfs(s, segId + 1, segStart + 1, ipAddr.append("0"));
            }
            return;
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length() && segEnd - segStart < 4; ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr <= 255) {
                dfs(s, segId + 1, segEnd + 1,
                        ipAddr.append(segEnd == segStart ? "" : ".").append(s.substring(segStart, segEnd + 1)));
            } else {
                break;
            }
        }
    }
}
