package cn.itbcat.boot.entity.socket;

/**
 * Created by 岸芷汀翎 on 2017/1/26.
 */
public enum MessageType {
    FRIEND(0), // 列表聊天
    GROUP(1); // 群组聊天
    private final int type;

    private MessageType(int type) {
        this.type = type;
    }

	public int getType() {
		return type;
	}
    
}
