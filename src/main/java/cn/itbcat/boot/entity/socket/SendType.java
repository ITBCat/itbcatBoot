package cn.itbcat.boot.entity.socket;

/**
 * Created by 岸芷汀翎 on 2017/1/26.
 */
public enum SendType {
    UNSENT(0), // 未发送
    SENT(1),// 已发送
    LEAVE(2); // 提掉线
    private final int type;
    private SendType(int type){
        this.type = type;
    }
	public int getType() {
		return type;
	}
    
}
