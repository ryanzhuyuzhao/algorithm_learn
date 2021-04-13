package org.ryan.chapter6;

import java.util.HashMap;
import java.util.Map;

public class GraphData {
    /**
     * 简单的图结构
     */
    private String name;
    private Map<String,GraphData> friends;
    private boolean isValidate;

    public GraphData(String name) {
        this.name = name;
        friends = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, GraphData> getFriends() {
        return friends;
    }

    public void setFriends(Map<String, GraphData> friends) {
        this.friends = friends;
    }

    public boolean isValidate() {
        return isValidate;
    }

    public void setValidate(boolean validate) {
        isValidate = validate;
    }
}
