package org.xli.sfms.dao;

import org.xli.sfms.config.MyMapper;
import org.xli.sfms.pojo.entity.HonorInfoDO;

import java.util.List;

public interface HonorInfoDOMapper extends MyMapper<HonorInfoDO> {
    void batchInsert(List<HonorInfoDO> list);
}
