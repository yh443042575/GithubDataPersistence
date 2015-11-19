package edu.hit.yh.mine.algorithm;

import java.util.List;

import edu.hit.yh.mine.module.BehaviorPattern;

public class SimpleGspMiningAlgorithm extends AbstractGspMiningAlgorithm<BehaviorPattern> {

	
	public SimpleGspMiningAlgorithm(int surpport){
		super.setSurpport(surpport);
	}
	
	@Override
	public void execute(Object... args) {
		// TODO 简单的GSP执行，扫描数据库->筛选出长度为K的序列模式->连接长度为K的序列模式生成K+1的候选序列模式->再次扫描数据库->...
		
	}

	
	@Override
	public List<BehaviorPattern> scanDB(List<BehaviorPattern> patternlist) {
		// TODO 穿入长度为K的候选序列模式，筛选出支持度满足支持度大于等于K的模式，作为序列模式
		if(patternlist.size()==0){//如果初始时pattern个数为0，则扫描数据库，只要大于支持度的项全取出来
			
		}else{//同样扫描数据库，通过时间可以位移的方法来判断我们序列模式的计数
			
		}
		
		return null;
	}

	@Override
	public List<BehaviorPattern> joinOperation(List<BehaviorPattern> patternlist) {
		// TODO 对现有的pattern做连接操作
		return null;
	}

	

}
