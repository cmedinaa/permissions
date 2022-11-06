package com.cmedinaa.permissions.server.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group", schema = "auth")
public class Group extends Hierarchy<Group> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    private String name;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "groupusers", schema = "auth",
            joinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") })
    private List<User> users;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "grouproles", schema = "auth",
            joinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private List<Role> roles;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GroupPermission> groupPermissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<GroupPermission> getGroupPermissions() {
        return groupPermissions;
    }

    public void setGroupPermissions(List<GroupPermission> groupPermissions) {
        this.groupPermissions = groupPermissions;
    }
}
