package cn.itbcat.boot.utils;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.socket.Chat;
import cn.itbcat.boot.entity.socket.SendType;
import cn.itbcat.boot.entity.socket.SocketUser;
import cn.itbcat.boot.entity.socket.UserStatus;
import com.alibaba.fastjson.JSON;

import org.apache.commons.lang3.StringUtils;

import javax.websocket.Session;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 岸芷汀翎 on 2017/1/26.
 * Description:
 */
public class IMManager {
    private final static List<SocketUser> list = new ArrayList<SocketUser>();
    //SynchronizedMap类是定义在Collections中的一个静态内部类。它实现了Map接口，并对其中的每一个方法实现，通过synchronized 关键字进行了同步控制
 // Collections.synchronizedMap 返回的是一个线程安全的hashMap(原hashMap为线程不安全的，需要手动在线程中处理，synchronizedMap省去这一步骤)
    private final static Map<String, SocketUser> map = Collections.synchronizedMap(new HashMap<String, SocketUser>());
    private final static Map<String, SocketUser> sessionMap = Collections.synchronizedMap(new HashMap<String, SocketUser>());
    private final static Chat exitMessage = new Chat(SendType.LEAVE);

    /**
     * 用于将用户信息及session保存到缓存中
     * @param user 用户信息
     * @param session 
     */
    public synchronized static void addUser(User user, Session session) {
        if (user != null && session != null && StringUtils.isNotEmpty(user.getUserId())) {
            SocketUser exist = map.get(user.getUserId());
            if (exist != null) {
            	if(!session.getId().equals(exist.getSession().getId()) && 
            			exist.getSession() != null && exist.getSession().isOpen()){
            		try {
            			// 此处操作是发送消息通知客户端，你已经被挤掉线了
						exist.getSession().getBasicRemote().sendText(JSON.toJSONString(exitMessage));
					} catch (IOException e) {
						e.printStackTrace();
					}
            		sessionMap.remove(exist.getSession().getId());
            	}
                exist.setSession(session);
                exist.setUser(user);
                sessionMap.put(session.getId(), exist);
            } else {
                SocketUser su = new SocketUser();
                su.setUser(user);
                su.setSession(session);
                list.add(su);
                map.put(user.getUserId(), su);
                sessionMap.put(session.getId(), su);
            }
        }
    }

    /**
     * 根据用户id获取缓存信息
     * @param userId 用户id
     * @return
     */
    public static SocketUser getSocketUserByUserId(String userId) {
        return map.get(userId);
    }
    /**
     * 根据sessonId获取缓存信息
     * @param sessionId
     * @return
     */
    public static SocketUser getSocketUserBySeesionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    /**
     * 获取在线人数
     * @return
     */
    public static long getOnlineNum() {
        return list.stream().
                filter(us->us.getUser().getChatStatus()== UserStatus.Hide||us.getUser().getChatStatus()==UserStatus.Online).count();
    }

    /**
     * 获取缓存数量
     * @return
     */
    public static int getCashNum() {
        return map.keySet().size();
    }


    /**
     * 清除离线时间超过{timeoutHour}小时的缓存
     * @param timeoutHour
     */
    public static void cleanCashData(int timeoutHour){
    	if(timeoutHour > 0){
    		long now = new Date().getTime();
    		List<SocketUser> removeCash = list.stream().filter((sc)->{
    			if(!sc.getSession().isOpen()){
    				Date date = sc.getUser().getLeaveTime();
    				if(date == null){
    					return true; // 问题数据直接删
    				}else{
    					long diff= now - date.getTime();
    					int hour = (int) (diff/(60*60*1000));
    					if(hour > timeoutHour){
    						return true;
    					}
    				}
    			}
    			return false;
    		}).collect(Collectors.toList());;
    		if(removeCash.size() > 0){
    			removeCash.stream().forEach((sc)->{
    				list.remove(sc);
    				map.remove(sc.getUser().getUserId());
    				sessionMap.remove(sc.getSession().getId());
    			});
    			removeCash = null;
    			System.gc();
    		}
    	}
    }
}
