package CV.vo;

/**
 * Tree entity. @author MyEclipse Persistence Tools
 */

public class Tree {

	// Fields

	private int treeId;//树节点编号
	private String treeName;//树节点名字
	private int parentId;//树节点上级节点编号
	private int level;//树节点等级
	private int order;//树节点统一父亲下的排序
	

	public int getTreeId() {
		return treeId;
	}
	public void setTreeId(int treeId) {
		this.treeId = treeId;
	}
	public String getTreeName() {
		return treeName;
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}



}