package org.xli.sfms.pojo.entity;

import javax.persistence.*;

@Table(name = "honor_info")
public class HonorInfoDO {
    @Id
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "honor_name")
    private String honorName;

    @Column(name = "item_name")
    private String itemName;

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
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return honor_name
     */
    public String getHonorName() {
        return honorName;
    }

    /**
     * @param honorName
     */
    public void setHonorName(String honorName) {
        this.honorName = honorName == null ? null : honorName.trim();
    }

    /**
     * @return item_name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }
}