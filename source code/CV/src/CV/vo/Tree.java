package CV.vo;

/**
 * Tree entity. @author MyEclipse Persistence Tools
 */

public class Tree {

	// Fields

	private int treeId;//���ڵ���
	private String treeName;//���ڵ�����
	private int parentId;//���ڵ��ϼ��ڵ���
	private int level;//���ڵ�ȼ�
	private int order;//���ڵ�ͳһ�����µ�����
	

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