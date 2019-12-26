package com.github.hardwjj.leetcode.group6.title3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题：搜索：127. 单词接龙,最短单词路径 （力扣）
 *
 * 题目描述
 *   找出一条从 beginWord 到 endWord 的最短路径，每次移动规定为改变一个字符，并且改变之后的字符串必须在 wordList 中。
 *
 * 示例 1:
 * Input:
 *    beginWord = "hit",
 *    endWord = "cog",
 *    wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 *    Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *    return its length 5.
 *
 * 示例 2:
 *  Input:
 *    beginWord = "hit"
 *    endWord = "cog"
 *    wordList = ["hot","dot","dog","lot","log"]
 *  Output: 0
 *    Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * 解题思路：
 *      广度优先搜索获取最短路径
 *      类似n叉树，将每个整数看成图中的一个节点，如果两个数之前差一个平方数，则就存在一条边，求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径。
 *
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int n = wordList.size();
        // 在构建图后以新加入的beginWord为起点
        int start = n - 1;
        int end = 0;
        // 判断列表是否可以到达endWord

        while (end < n && !wordList.get(end).endsWith(endWord)) {
            end++;
        }

        // 如果列表中没有节点与结束节点匹配则退出
        if (end == n) {
            return 0;
        }

        // 构建图
        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic, start, end);
    }

    // 获取最短路径
    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[graphic.length];
        // 从开始节点开始广度搜索
        marked[start] = true;
        queue.add(start);
        // 开始节点算上默认1
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            // 当前层某个节点获取该节点可达的下一层的节点，直接遍历好当前层所有节点
            while (size-- > 0) {
                int cur = queue.poll();
                for (Integer next : graphic[cur]) {
                    // 达到尾部对应下标，返回路径
                    if(next == end) {
                        return path;
                    }
                    // 不回溯或过滤已重复节点
                    if(marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        // 没有搜索到默认返回0，应对虽然列表存在结束节点但通过逐个字符替换无法达到。
        return 0;
    }

    // 将列表按照列表+链表方式构建成图（矩阵不利于广度优先搜索）
    private List<Integer>[] buildGraphic(List<String> wordList) {
        int n = wordList.size();
        List<Integer>[] graphic = new List[n];
        for (int i = 0; i < n; i++) {
            // 初始化每个节点的列表，每个列表存储的元素都是当前节点只改变一个字符可达元素
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // 判断对应的节点与i节点是否只相差一个字符
                if(isConnection(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    // 判断对应的节点与i节点是否只相差一个字符
    private boolean isConnection(String s, String s1) {
        int diff = 0;
        for (int i = 0;i < s.length() && diff <= 1; i++) {
            if(s.charAt(i) != s1.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}