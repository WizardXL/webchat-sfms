package org.xli.sfms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xli.sfms.constant.ErrorType;
import org.xli.sfms.dao.TalkInfoDOMapper;
import org.xli.sfms.exception.ResourceAlreadyExistException;
import org.xli.sfms.pojo.entity.TalkInfoDO;

import java.util.List;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/5/25 1:05
 */
@Service
public class TalkInfoService {
    @Autowired
    private TalkInfoDOMapper talkInfoDOMapper;

    @Transactional(rollbackFor = Exception.class)
    public void insert(TalkInfoDO talkInfoDO) throws ResourceAlreadyExistException {
        TalkInfoDO t = new TalkInfoDO();
        t.setUserId(talkInfoDO.getUserId());
        t.setTalkTime(talkInfoDO.getTalkTime());

        System.out.println(this.talkInfoDOMapper.selectOne(t));
        if (this.talkInfoDOMapper.selectOne(t) != null) {
            throw new ResourceAlreadyExistException(ErrorType.ResourceAlreadyExist.message, ErrorType.ResourceAlreadyExist.code);
        } else {
            this.talkInfoDOMapper.insert(talkInfoDO);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(TalkInfoDO talkInfoDO) {
        this.talkInfoDOMapper.updateByPrimaryKeySelective(talkInfoDO);
    }

    public List<TalkInfoDO> getTalkInfoByCondition(TalkInfoDO talkInfoDO) {
        return this.talkInfoDOMapper.select(talkInfoDO);
    }
}
