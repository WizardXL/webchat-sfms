package org.xli.sfms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xli.sfms.dao.StudentFileInfoDOMapper;
import org.xli.sfms.pojo.entity.StudentFileInfoDO;

import java.io.IOException;
import java.util.*;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/5/25 1:05
 */
@Service
public class StudentFileInfoService {
    @Autowired
    private StudentFileInfoDOMapper studentFileInfoDOMapper;

    @Transactional(rollbackFor = Exception.class)
    public void importData(String dataSet) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List> map = objectMapper.readValue(dataSet, LinkedHashMap.class);
        List<StudentFileInfoDO> list = new LinkedList<>();

        for (String id : map.keySet()) {
            StudentFileInfoDO studentFileInfoDO = new StudentFileInfoDO();
            studentFileInfoDO.setId(id);
            String js = objectMapper.writeValueAsString(map.get(id));
            studentFileInfoDO.setData(js);
            list.add(studentFileInfoDO);
        }

        studentFileInfoDOMapper.batchInsert(list);
    }

    public StudentFileInfoDO getStudentInfoById(String id) {
        return this.studentFileInfoDOMapper.selectByPrimaryKey(id);
    }

    public List<StudentFileInfoDO> getAll() {
        return this.studentFileInfoDOMapper.selectAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateStudentInfoById(StudentFileInfoDO studentFileInfoDO) {
        this.studentFileInfoDOMapper.updateByPrimaryKeySelective(studentFileInfoDO);
    }
}
