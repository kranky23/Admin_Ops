package com.example.admin_ops.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="domain")
public class Domain implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dom_id;

    @Column(nullable = false)
    private String dom_name;

    public Domain(Integer dom_id, String dom_name) {
        this.dom_id = dom_id;
        this.dom_name = dom_name;
    }

    public Domain() {

    }

    public Integer getDom_id() {
        return dom_id;
    }

    public void setDom_id(Integer dom_id) {
        this.dom_id = dom_id;
    }

    public String getDom_name() {
        return dom_name;
    }

    public void setDom_name(String dom_name) {
        this.dom_name = dom_name;
    }
}
