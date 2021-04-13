package org.ryan.chapter6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Dijkstra {
    /**
     * 此类是实现狄克斯特拉算法
     */
    public static void main(String[] args) {
        //存储图路径数据
        Map<String, Map<String,Integer>> graph = new HashMap<>();
        Map<String, Integer> start = new HashMap<String, Integer>();
        start.put("A",6);
        start.put("B",2);
        graph.put("start",start);
        Map<String, Integer> a = new HashMap<String, Integer>();
        a.put("fin",1);
        graph.put("A",a);
        Map<String, Integer> b = new HashMap<String, Integer>();
        b.put("A",3);
        b.put("fin",3);
        graph.put("B",b);
        getMinStep("start","fin",graph);

    }

    public static void getMinStep(String start,String end,Map<String, Map<String,Integer>> graph) {
        //各节点的最优路径，这里先从start开始
        Map<String,Integer> costs = graph.get(start);
        //各节点最优节点的父节点
        Map<String,String> parents = new HashMap<>();
        //已处理的节点
        HashSet<String> processed = new HashSet<>();
        //在未处理的节点中找出最优的节点
        String node = findLowestCostNode(costs,processed);
        while (node != null && graph.get(node) != null) {
            //获取到node节点的消费
            int cost = costs.get(node);
            //获取node节点的所有邻居节点
            Map<String,Integer> neighbors = graph.get(node);
            String finalNode = node;
            //遍历node节点的所有邻居节点
            neighbors.forEach((k,v) -> {
                //当node节点到邻居的消费
                int newCost = cost + v;
                if (!costs.containsKey(k) || costs.get(k) > newCost) {
                    costs.put(k,newCost);
                    parents.put(k,finalNode);
                }
            });
            //将node节点加入已处理Set中
            processed.add(node);
            //找出当前节点的最优节点
            node = findLowestCostNode(costs,processed);

        }
        parents.forEach((k,v) -> {
            System.out.println(k + ":" +v);
        });

        costs.forEach((k,v) -> {
            System.out.println(k + ":" + v);
        });

    }

    /**
     * 找出未处理节点中消耗最小的节点
     * @param costs
     * @param processed
     * @return
     */
    public static String findLowestCostNode(Map<String,Integer> costs, HashSet<String> processed) {
        AtomicReference<Integer> lowestCost = new AtomicReference<>(Integer.MAX_VALUE);
        AtomicReference<String> lowestCostNode = new AtomicReference<>();
        costs.forEach((k,v) -> {
            if (!processed.contains(k) && v < lowestCost.get()) {
                lowestCost.set(v);
                lowestCostNode.set(k);
            }
        });
        return lowestCostNode.get();
    }
}
