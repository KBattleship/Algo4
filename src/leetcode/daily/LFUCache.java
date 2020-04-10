package leetcode.daily;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @ClassName: LFUCache
 * @Description: LFU缓存
 * @Author: CheneyIn
 * @Date: 2020-04-05
 */
public class LFUCache {

    /*
        设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。

        get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
        put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。
        在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。

        一个项目的使用次数就是该项目被插入后对其调用 get 和 put 函数的次数之和。使用次数会在对应项目被移除后置为 0。

        进阶：
        你是否可以在 O(1) 时间复杂度内执行两项操作？

     */


    // 存放结果
    HashMap<Integer, Node> cacheMap;
    // 存放每次结果执行的频率
    Map<Integer, LinkedHashSet<Node>> freqMap;
    int size;
    int capacity;
    int min; // 存储当前最小频次


    public LFUCache(int capacity) {
        cacheMap = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    private int get(int key) {
        Node node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    // 调用频率增加
    private void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    private void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cacheMap.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cacheMap.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(2,0);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回 4
    }
}

class Node {
    int key;
    int value;
    int freq = 1;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}