package edu.hit.yh.mine.algorithm;

import java.util.ArrayList;
import java.util.List;

import edu.hit.yh.mine.module.BehaviorPattern;
import edu.hit.yh.mine.module.SimpleBehavior;

/**
 * 挖掘最简单的
 * @author emmerich.yh
 *
 */
public class SimpleGspMiningAlgorithm extends AbstractGspMiningAlgorithm<BehaviorPattern<SimpleBehavior>> {

	/**
	 * 算法中的行为类型：
	 * 1、实际的开发者、简单类型——SimpleBehavior
	 * 2、实际的开发者、带有相对时间类型——RelativeTimeBehavior
	 * 3、抽象的开发者、简单类型
	 * 4、抽象的开发者、带有相对时间类型
	 * 
	 */
	
	
	/**
	 * 构造函数，用来规定算法的最小支持度
	 * @param behaviorType
	 * @param surpport
	 */
	public SimpleGspMiningAlgorithm(int minSurpport,String programName,String artifactType){
		
		super.setMinSurpport(minSurpport);
		super.setProgramName(programName);
		super.setArtifactType(artifactType);
	
	}
	
	@Override
	public void execute(Object... args) {
		// TODO 简单的GSP执行，扫描数据库->筛选出长度为K的序列模式->连接长度为K的序列模式生成K+1的候选序列模式->再次扫描数据库->...
		List<List<BehaviorPattern<SimpleBehavior>>> rawData = this.getRawData();
		int nowSupport = Integer.MAX_VALUE;

		//当patternList中的所有pattern的支持度都大于这个最小支持度时，则继续扫描
		while(nowSupport>getMinSurpport()){
			rawData.get(0);
		}
		//遍历每一个artifactList,找到
		
	}

	
	@Override
	public List<BehaviorPattern<SimpleBehavior>> scanForPattern(List<BehaviorPattern<SimpleBehavior>> patternlist) {
		// TODO 传入长度为K的候选序列模式，筛选出支持度满足支持度大于等于K的模式，作为序列模式
		if(patternlist.size()==0){//如果初始时pattern个数为0，则扫描数据库，只要大于支持度的项全取出来
			
		}else{//同样扫描数据库，通过时间可以位移的方法来判断我们序列模式的计数
			
		}
		
		return null;
	}

	@Override
	public List<BehaviorPattern<SimpleBehavior>> joinOperation(List<BehaviorPattern<SimpleBehavior>> patternlist) {
		// TODO 对现有的pattern做连接操作
		return null;
	}

	/**
	 * 准备原始数据，最里层的list是一个artifact，其中由先后顺序排列好
	 * 1、连接数据库，查询所有在同一个program下的、同种artifactType的操作
	 * 2、将这些操作通过给定的artifactID分类并挑选出来，同一个artifactId下的操作都放在一个list中
	 * @param programName
	 * @param artifactType
	 * @return
	 */
	private List<List<BehaviorPattern<SimpleBehavior>>> getRawData(){
		if(getProgramName().isEmpty()||getArtifactType().isEmpty()){
			System.out.println("programName或者artifactType为空，请检查参数");
			return null;
		}
		
		List<List<BehaviorPattern<SimpleBehavior>>> rawData = new ArrayList<List<BehaviorPattern<SimpleBehavior>>>();
		
		//获取session
		
		//查询数据库
		
		//转换结果
		return rawData;
	}

}
