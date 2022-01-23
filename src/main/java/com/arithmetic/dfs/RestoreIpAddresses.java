package com.arithmetic.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author: Administrator
 * create: 2022-01-14 23:23
 * description:
 */
public class RestoreIpAddresses {
    static List<String> res = new ArrayList<>();


    public static List<String> restoreIpAddresses(String s) {
        LinkedList<Integer> track = new LinkedList<>();
        dfs(track, s, 0);
        return res;
    }

    private static void dfs(LinkedList<Integer> track, String s, int startIndex) {
        if (track.size() == 4) {
            if (startIndex == s.length()) {
                StringBuilder segments = new StringBuilder();
                for (int i = 0; i < track.size(); i++) {
                    segments.append(track.get(i));
                    if (i != track.size() - 1) {
                        segments.append(".");
                    }
                }
                res.add(segments.toString());
            }
            return;
        }

        // 如果用完了所有字符直接返回
        if (startIndex == s.length()) {
            return;
        }

        if (s.charAt(startIndex) == '0') {
            track.add(0);
            dfs(track, s, startIndex + 1);
            track.removeLast();
        }

        int addr = 0;
        for (int j = startIndex; j < s.length(); j++) {
            addr = addr * 10 + (s.charAt(j) - '0');
            if (addr > 0 && addr <= 255) {
                track.add(addr);
                dfs(track, s, j + 1);
                track.removeLast();
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = restoreIpAddresses(s);
        System.out.println(res);
    }
}
