package edu.hit.yh.mine.module;

import java.util.Date;

import lombok.Data;

@Data
public class RelativeTimeBehavior {

	// 动作发起者
	private String actor;

	// 动作接收者
	private String target;

	// 动作类型
	private String eventType;
	
	//动作发起时间
	private Date createAt;

}
