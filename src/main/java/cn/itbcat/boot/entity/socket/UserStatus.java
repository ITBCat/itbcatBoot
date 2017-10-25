package cn.itbcat.boot.entity.socket;

/**
 * Created by 岸芷汀翎 on 2017/1/26.
 * Description:
 */
public enum UserStatus {
    NotOnline(0),
    Online(1),
    Hide(2); 

    private final int status;
    private UserStatus(int status){
        this.status = status;
    }
	public int getStatus() {
		return status;
	}
    
}
