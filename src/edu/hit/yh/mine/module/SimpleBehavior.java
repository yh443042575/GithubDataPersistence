package edu.hit.yh.mine.module;

import lombok.Data;

/**
 * 初始挖掘数据
 * @author DHAO
 *
 * @param <T>
 */
@Data
public class SimpleBehavior {

	//动作发起者
	private String actor;
	
	//动作接收者
	private String target;
	
	//动作类型
	private String eventType;
	
	
}
