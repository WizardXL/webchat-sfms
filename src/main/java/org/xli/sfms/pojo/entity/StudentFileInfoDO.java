package org.xli.sfms.pojo.entity;

import javax.persistence.*;

@Table(name = "student_file_info")
public class StudentFileInfoDO {
    @Id
    private String id;

    @Override
    public String toString() {
        return "StudentFileInfoDO{" +
                "id='" + id + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    private String data;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
