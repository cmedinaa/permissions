package com.cmedinaa.permissions.server.conversion.dto;

import java.util.List;

public class HierarchyDTO<T>  {

    private List<T> children;

    private T father;

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public T getFather() {
        return father;
    }

    public void setFather(T father) {
        this.father = father;
    }
}
