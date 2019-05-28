package org.xli.sfms.dao;

import org.xli.sfms.config.MyMapper;
import org.xli.sfms.pojo.entity.RootDepartmentDO;
import org.xli.sfms.pojo.entity.StudentFileInfoDO;

import java.util.List;

public interface StudentFileInfoDOMapper extends MyMapper<StudentFileInfoDO> {
    void batchInsert(List<StudentFileInfoDO> list);
}
