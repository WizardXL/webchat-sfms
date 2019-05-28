package org.xli.sfms.pojo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/4/28 22:16
 */
@Getter
@Setter
@NoArgsConstructor
public class MessageModel {
    private String touser;
    private String msgtype;
    private long agentid;
    private Text text;
    private int safe;

    public static class Text {
        private String content;

        public Text() {}

        public Text(String c) {
            this.content = c;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
