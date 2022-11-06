package com.cmedinaa.permissions.server.entities;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
public class Hierarchy<T>  {

    @OneToMany(mappedBy = "father", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<T> children;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "father_id", referencedColumnName = "id")
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
