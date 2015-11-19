package edu.hit.yh.mine.module;

import java.util.List;

import lombok.Data;
/**
 * 行为模式，主要有两种，一种是不带相对时间的模式，另外一种是带有相对时间的模式
 * @author DHAO
 *
 * @param <T>
 */
@Data
public class BehaviorPattern<T> {

	private int surpport;
	
	private List<T> behaviorList;
	
}
