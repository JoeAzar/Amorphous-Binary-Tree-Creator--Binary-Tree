public class BTree<T>
{
	private TreeNode<T> head;

	public BTree(T head)
	{
		this.head = new TreeNode<T>(head);
	}

	public BTree(TreeNode<T> head)
	{
		this.head = head;
	}

	public void setLR(T headE, T leftE, T rightE)
	{
		TreeNode<T> h = head.get(headE);
		if (h == null)
			throw new NullPointerException("Parent node does not exist!");
		TreeNode<T> lc = new TreeNode<T>(leftE);
		lc.setParent(h);
		h.setLeftChild(lc);
		TreeNode<T> rc = new TreeNode<T>(rightE);
		rc.setParent(h);
		h.setRightChild(rc);
	}

	public void setL(T headE, T leftE)
	{
		TreeNode<T> h = head.get(headE);
		if (h == null)
			throw new NullPointerException("Parent node does not exist!");
		TreeNode<T> lc = new TreeNode<T>(leftE);
		lc.setParent(h);
		h.setLeftChild(lc);
	}

	public void setR(T headE, T rightE)
	{
		TreeNode<T> h = head.get(headE);
		if (h == null)
			throw new NullPointerException("Parent node does not exist!");
		TreeNode<T> rc = new TreeNode<T>(rightE);
		rc.setParent(h);
		h.setRightChild(rc);
	}
	
	public void insertL(T headE, T leftE)
	{
		TreeNode<T> h = head.get(headE);
		if (h == null)
			throw new NullPointerException("Parent node does not exist!");
		TreeNode<T> lc = new TreeNode<T>(leftE);
		TreeNode<T> plc = h.getLeftChild();
		if(plc == null)
			throw new NullPointerException("Parent node does not have a left child!");
		lc.setParent(h);
		lc.setLeftChild(plc);
		h.setLeftChild(lc);
	}

	public void insertR(T headE, T rightE)
	{
		TreeNode<T> h = head.get(headE);
		if (h == null)
			throw new NullPointerException("Parent node does not exist!");
		TreeNode<T> rc = new TreeNode<T>(rightE);
		TreeNode<T> prc = h.getRightChild();
		if(prc == null)
			throw new NullPointerException("Parent node does not have a left child!");
		rc.setParent(h);
		rc.setRightChild(prc);
		h.setRightChild(rc);
	}

	public void deleteNode(T search)
	{
		head.deleteNode(search);
	}

	public TreeNode<T> get(T headE)
	{
		return head.get(headE);
	}
	
	public int size()
	{
		return head.size();
	}
	
	public int depth()
	{
		return head.depth();
	}
	
	public void prettyPrintTree()
	{
		BTreePrinter.printNode(head);
	}

	public void printPreOrder()
	{
		head.printPreOrder();
		System.out.println();
	}

	public void printPostOrder()
	{
		head.printPostOrder();
		System.out.println();
	}

	public void printInOrder()
	{
		head.printInOrder();
		System.out.println();
	}
}
