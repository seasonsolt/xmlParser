
public class XmlTree {
	private Node root = null;
	
	/**
	 * 内部类:节点
	 */
	private class Node{
		private String name;
		private String value;
		private Node nextNode = null;
		private Node childNode = null; 
		private Node parentNode = null; 
	
		/*构造方法*/
		public Node(Node node){
			this.name = node.name;
			this.value = node.value;
			this.nextNode = node.nextNode;
			this.childNode = node.childNode;
			this.parentNode = node.parentNode;
		}
		
		/*构造方法*/
		public Node(String name){
			this.name = name;
		}
		
		public Node findNode(String nodeName){
			if(this.name.equals(nodeName)){
				return this;
			}
			else{
				if(null != this.nextNode){
					return this.nextNode.findNode(nodeName);
				}
				if(null != this.childNode){
					return this.childNode.findNode(nodeName);
				}
			}

			return null;
		}
	
		public String toString(){
			if(null != this.nextNode && null != this.childNode ){
				if(null != this.parentNode){
					return "\r\n    <" + name + ">" + value + childNode.toString() + nextNode.toString();
				}
				else{
					return "<" + name + ">" + value + childNode.toString() + nextNode.toString();
				}
			}
			else if(null == this.nextNode && null == this.childNode){
				return "\r\n    <" + name + ">" + value + "</" + name + ">" + "\r\n</" + this.parentNode.name + ">";
			}
			else if(null == this.nextNode){
				if(null != this.parentNode){
					if( null == this.parentNode.parentNode){
						return "\r\n    <" + name + ">" + this.childNode.toString();
					}
					else{
						return "\r\n    <" + name + ">" + value +  this.childNode.toString() + "\r\n    </" + this.name + ">";
					}
				}
				else{
					return "<" + name + ">" + value + this.childNode.toString() + "\r\n</" + this.name + ">";
				}
			}
			else if(null == this.childNode){
				if(null != this.parentNode){
					return "\r\n    <" + name + ">" + value + "</" + name + ">" + this.nextNode.toString();
				}
				else{
					return "<" + name + ">" + value + "</" + name + ">" + this.nextNode.toString();
				}

			}
			else{
				return null;
			}
		}
		
		public void addNode(Node node){
			Node currNode = this;
			if(null == currNode.childNode){
				currNode.childNode = node;
				node.parentNode = currNode;
			}
			else{
				currNode = currNode.childNode;
				do{
						if(null == currNode.nextNode){
							currNode.setNextNode(node);
							node.parentNode = currNode.parentNode;
							break;
						}
						else{
							currNode = currNode.nextNode;
						}
				
				}while(null != currNode);
			}
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public Node getChildNode() {
			return childNode;
		}

		public void setChildNode(Node childNode) {
			this.childNode = childNode;
		}
	}
	
	/**
	 * XML解析 
	 */
	public XmlTree parseXml(String XMLBuf){
		Node root = new Node("");
	
		String nodeName = null;
		XMLBuf.indexOf(">", XMLBuf.indexOf("<"));//找到根节点的name
		nodeName = XMLBuf.substring(XMLBuf.indexOf("<") + 1, XMLBuf.indexOf(">"));
		
		System.out.println(nodeName);
		System.out.println(XMLBuf);
		System.out.println(XMLBuf.indexOf(">"));

		return null;
		
	}

	/**
	 * XML初始化
	 */
	public Node XmlInit(String nodeName){
		this.root = new Node(nodeName);
		root.setValue("");
		return root;
	}
	
	/**
	 * XML创建节点
	 */
	public Node XmlCreateNode(String nodeName){
		Node node = new Node(nodeName);
		return node;
	}
	
	public Node XmlAddNode(String tarNodeName, String newNodeName, String nodeValue){
		Node newNode = new Node(newNodeName);
		newNode.setValue(nodeValue);
		Node tarNode = this.root.findNode(tarNodeName);
		if(null == tarNode){
			return null;
		}
		else{
			tarNode.addNode(newNode);
		}
		return newNode;
	}
	
	/**
	 * 广度优先策略
	 */
	public Node XmlFindNode(String nodeName){
		Node currNode =  this.root;
		return currNode.findNode(nodeName);
	}
	
	/**
	 * toString() 重载
	 */
	public String toString(){
		Node currNode = this.root;
		return currNode.toString();
	}
}
