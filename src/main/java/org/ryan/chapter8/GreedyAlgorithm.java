package org.ryan.chapter8;

import java.util.*;
import java.util.function.Consumer;

/**
 * 贪婪算法
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        Set<String> statesNeeded = new HashSet<>(Arrays.asList("id","nv","ut"));//"mt","wa","or","id","nv","ut","ca","az"
        Map<String,Set<String>> stations = new HashMap<>();
        Set<String> kone = new HashSet<>(Arrays.asList("id","nv","ut"));
        Set<String> ktwo = new HashSet<>(Arrays.asList("wa","id","mt"));
        Set<String> kthree = new HashSet<>(Arrays.asList("or","nv","ca"));
        Set<String> kfour = new HashSet<>(Arrays.asList("nv","ut"));
        Set<String> kfive = new HashSet<>(Arrays.asList("ca","az"));
        stations.put("kone",kone);
        stations.put("ktwo",ktwo);
        stations.put("kthree",kthree);
        stations.put("kfour",kfour);
        stations.put("kfive",kfive);
        Map<String,Set<String>> result = collectionCover(statesNeeded,stations);
        result.forEach((k,v) -> {
            System.out.println(k);
        });

    }

    /**
     * 贪婪算法 集合覆盖问题
     * @param statesNeeded
     * @param stations
     * @return
     */
    public static  Map<String,Set<String>> collectionCover(Set<String> statesNeeded, Map<String,Set<String>> stations) {
        Map<String,Set<String>> result = new HashMap<>();
        while (statesNeeded.size() > 0) {
            Map<String,Set<String>> bestStation = new HashMap<>();
            //已经被广播站覆盖的州
            Set<String> statesCovered = new HashSet<>();
            for (Map.Entry entry : stations.entrySet()) {
                Set<String> data = (Set<String>) entry.getValue();
                //获取广播站和需要覆盖的州的数据的交集
                data.retainAll(statesNeeded);
                Set<String> covered = new HashSet<>();
                covered.addAll(data);
                if (covered.size() > statesCovered.size()) {//如果当前广播覆盖的州大于之前已覆盖的州则将当前的广播加入数据中
                    bestStation.put((String) entry.getKey(),data);
                    result.put((String) entry.getKey(),data);
                    statesCovered = covered;
                }
            }
            statesNeeded.removeAll(statesCovered);
        }
        return result;
    }
}
