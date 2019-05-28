package org.xli.sfms.pojo.entity.dto;

import lombok.Data;
import org.xli.sfms.pojo.entity.MessageModel;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/4/29 13:10
 */
@Data
public class SendMessageDTO {
    // 企业id
    private long agentid;

    // 文本类型
    private String msgtype;

    // 用户列表
    private String[] touser;

    // 消息
    private String content;
}
