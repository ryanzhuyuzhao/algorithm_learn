package org.ryan.chapter5;

import java.util.HashMap;

public class HashDataStrcut {

    private final static HashMap<String,String> voteMap = new HashMap<>();

    public static void main(String[] args) {
        vote("Joe");
        vote("Joe");
    }

    /**
     * 投票函数，使用HashMap散列表存储投票人的姓名，每次投票先到散列表中查询数据
     * （1）如已有记录则不允许投票
     * （2）没有记录则允许投票
     * 散列表的查询时间复杂度为：O(1)
     *
     * 一个好的散列表最重要的两个因素
     * （1）较低的填装因子（一般小于0.7）
     * （2）良好的散列函数
     * @param name
     * @return
     */
    public static boolean vote(String name) {
        if (voteMap.get(name) != null) {
            System.out.println("kick them out!");
            return false;
        }else {
            System.out.println("let them vote!");
            voteMap.put(name,"exist");
            return true;
        }
    }
}
