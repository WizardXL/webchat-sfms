package org.xli.sfms.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/4/28 21:39
 */
@Component
@ConfigurationProperties(prefix = "sys")
@Data
public class SystemConst {
    private String corpId;
    private String appId;
    private String appSecret;
    private String contactSyncSecret;
}
