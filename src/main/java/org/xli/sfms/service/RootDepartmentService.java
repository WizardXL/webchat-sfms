package org.xli.sfms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xli.sfms.dao.RootDepartmentDOMapper;
import org.xli.sfms.pojo.entity.RootDepartmentDO;

import java.util.List;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/5/5 1:12
 */
@Service
public class RootDepartmentService {
    @Autowired
    private RootDepartmentDOMapper rootDepartmentDOMapper;

    public List<RootDepartmentDO> getAll() {
        return rootDepartmentDOMapper.getAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void batchInsert(List<RootDepartmentDO> list) {
        rootDepartmentDOMapper.batchInsert(list);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAll() {
        rootDepartmentDOMapper.deleteAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateRootDepartment(List<RootDepartmentDO> list) {
        this.deleteAll();
        if (list.size() > 0) {
            this.batchInsert(list);
        }
    }
}
