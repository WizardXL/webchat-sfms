package org.xli.sfms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xli.sfms.dao.HonorInfoDOMapper;
import org.xli.sfms.pojo.entity.HonorInfoDO;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/5/26 19:48
 */
@Service
public class HonorInfoService {
    @Autowired
    private HonorInfoDOMapper honorInfoDOMapper;

    @Transactional(rollbackFor = Exception.class)
    public void importData(List<HonorInfoDO> list) {
        List<HonorInfoDO> list1 = this.getAll();
        List<HonorInfoDO> list2 = new LinkedList<>();

        for (HonorInfoDO v1: list) {
            boolean exist = false;
            for (HonorInfoDO v2: list1) {
                if (v1.getUserId().equals(v2.getUserId()) && v1.getHonorName().equals(v2.getHonorName())
                        && v1.getItemName().equals(v2.getItemName())
                ) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                list2.add(v1);
            }
        }
        if (list2.size() > 0) {
            this.honorInfoDOMapper.batchInsert(list2);
        }
    }

    public List<HonorInfoDO> getAll() {
        return this.honorInfoDOMapper.selectAll();
    }

    public List<HonorInfoDO> getHonorInfoByCondition(HonorInfoDO honorInfoDO) {
        return this.honorInfoDOMapper.select(honorInfoDO);
    }
}
