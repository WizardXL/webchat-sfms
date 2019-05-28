package org.xli.sfms.pojo.entity;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "talk_info")
public class TalkInfoDO {
    @Id
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "talk_time")
    private String talkTime;

    private String data;

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
     * @return talk_time
     */
    public String getTalkTime() {
        return talkTime;
    }

    /**
     * @param talkTime
     */
    public void setTalkTime(String talkTime) {
        this.talkTime = talkTime == null ? null : talkTime.trim();
    }

    /**
     * @return data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }
}
