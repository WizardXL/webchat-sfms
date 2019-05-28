package org.xli.sfms.dao;

import org.xli.sfms.config.MyMapper;
import org.xli.sfms.pojo.entity.RootDepartmentDO;

import java.util.List;

public interface RootDepartmentDOMapper extends MyMapper<RootDepartmentDO> {
    List<RootDepartmentDO> getAll();
    void batchInsert(List<RootDepartmentDO> list);
    void deleteAll();
}
