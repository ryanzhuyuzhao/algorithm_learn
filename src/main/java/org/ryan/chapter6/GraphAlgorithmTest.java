package org.ryan.chapter6;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GraphAlgorithmTest {


    public static void main(String[] args) {

        /**
         * 广度优先搜索算法时间复杂度O(V+E),其中V为顶点数，E为边数
         */
        GraphData me = new GraphData("me");

        GraphData Bob = new GraphData("Bob");
        GraphData Alice = new GraphData("Alice");
        GraphData Claire = new GraphData("Claire");
        me.getFriends().put("Bob",Bob);
        me.getFriends().put("Alice",Alice);
        me.getFriends().put("Claire",Claire);
        GraphData Anuj = new GraphData("Anuj");
        GraphData Peggy = new GraphData("Peggy");
        GraphData Jonny = new GraphData("Jonny");
        GraphData Thon = new GraphData("Thon");
        GraphData MongoSeller = new GraphData("MongoSellerM");
        Bob.getFriends().put("MongoSeller",MongoSeller);
        Bob.getFriends().put("Anuj",Anuj);
        Bob.getFriends().put("Peggy",Peggy);
        Alice.getFriends().put("Peggy",Peggy);
        Claire.getFriends().put("Jonny",Jonny);
        Claire.getFriends().put("Thon",Thon);

        Queue<GraphData> data = new LinkedList<>();
        data.offer(me);
        //先把自己的好友都加入队列中
        Map<String, GraphData> myFriends = me.getFriends();
        Map<String, GraphData> friends;
        myFriends.forEach((k,v) -> {
            data.offer(v);
        });
        GraphData person = null;
        //因为队列是先进先出所以符合图数据的遍历，先第一层再第二层再往后
        while (!data.isEmpty()) {
            person = data.poll();
            System.out.println("check data " + person.getName());
            if (personIsSeller(person)) {
                System.out.println(person.getName() + " is a mongo seller");
                return;
            }else {
                friends = person.getFriends();
                friends.forEach((k,v) -> {
                    if (!v.isValidate()) {
                        data.offer(v);
                    }
                });
            }
        }
        System.out.println("There isn't a mongo seller");
    }


    public static boolean personIsSeller(GraphData graphData) {
        String name = graphData.getName();
        graphData.setValidate(true);
        name = name.toLowerCase();
        return "m".equals(name.substring(name.length() - 1));
    }
}
