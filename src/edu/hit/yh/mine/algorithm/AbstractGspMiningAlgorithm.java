package edu.hit.yh.mine.algorithm;

import java.util.List;


import lombok.Getter;
import lombok.Setter;

/**
 * 算法的一个抽象方法，其中T为行为模式
 * @author DHAO
 *
 * @param <P> 行为模式，里面包含了一组行为的list
 */
public abstract class AbstractGspMiningAlgorithm<P> {

	//算法的支持度
	private int minSurpport;
	
	//算法所要挖掘的项目
	private String programName;
	
	//算法所要挖掘的artifactType
	private String artifactType;
	
	// 算法的总执行
	public abstract void execute(Object... args);

	//数据库的扫描
	public abstract List<P> scanForPattern(List<P> patternlist);
	
	//连接操作
	public abstract List<P> joinOperation(List<P> patternlist);

	public int getMinSurpport() {
		return minSurpport;
	}

	public void setMinSurpport(int minSurpport) {
		this.minSurpport = minSurpport;
	}

	public String getArtifactType() {
		return artifactType;
	}

	public void setArtifactType(String artifactType) {
		this.artifactType = artifactType;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	
	
	
	
	

}
