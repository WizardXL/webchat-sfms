package org.xli.sfms.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "root_department")
@AllArgsConstructor
@NoArgsConstructor
public class RootDepartmentDO {
    @Id
    private Integer id;

    private String name;

    private Integer parentid;

    private Long order;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return parentid
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * @return order
     */
    public Long getOrder() {
        return order;
    }

    /**
     * @param order
     */
    public void setOrder(Long order) {
        this.order = order;
    }
}
