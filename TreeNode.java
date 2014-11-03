public class TreeNode<T>
{
	private TreeNode<T> rightChild;
	private TreeNode<T> leftChild;
	private TreeNode<T> parent;

	T self;

	public TreeNode(T self)
	{
		this.self = self;
	}

	public void deleteNode(T search)
	{
		if (search.equals(self))
		{
			if (leftChild != null && rightChild != null)
			{
				throw new UnsupportedOperationException("Cannot remove a node with two children!");
			}
			else if (rightChild == null)
			{
				if (parent.getLeftChild() == this)
				{
					if (leftChild == null)
						parent.setLeftChild(null);
					else
					{
						leftChild.setParent(parent);
						parent.setLeftChild(leftChild);
					}
				}
				else if (parent.getRightChild() == this)
				{
					if (leftChild == null)
						parent.setRightChild(null);
					else
					{
						leftChild.setParent(parent);
						parent.setRightChild(leftChild);
					}
				}
			}
			else if (leftChild == null)
			{
				if (parent.getLeftChild() == this)
				{
					if (rightChild == null)
						parent.setLeftChild(null);
					else
					{
						rightChild.setParent(parent);
						parent.setLeftChild(rightChild);
					}
				}
				else if (parent.getRightChild() == this)
				{
					if (rightChild == null)
						parent.setRightChild(null);
					else
					{
						rightChild.setParent(parent);
						parent.setRightChild(rightChild);
					}
				}
			}
			return;
		}
		if (leftChild != null)
			leftChild.deleteNode(search);
		if (rightChild != null)
			rightChild.deleteNode(search);
	}
	
	
	public TreeNode<T> get(T search)
	{
		if (self.equals(search))
			return this;

		if (rightChild == null && leftChild == null)
			return null;

		if (rightChild != null && leftChild == null)
			return rightChild.get(search);

		if (leftChild != null && rightChild == null)
			return leftChild.get(search);

		TreeNode<T> rf = rightChild.get(search);
		return (rf != null) ? rf : leftChild.get(search);
	}

	public TreeNode<T> getRightChild()
	{
		return rightChild;
	}

	public void setRightChild(TreeNode<T> rightChild)
	{
		this.rightChild = rightChild;
	}

	public TreeNode<T> getLeftChild()
	{
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild)
	{
		this.leftChild = leftChild;
	}

	public int depth()
	{
		return depth(this);
	}

	public int depth(TreeNode<T> head)
	{
		if (head == null)
			return 0;
		else
			return 1 + Math.max(depth(head.getLeftChild()), depth(head.getRightChild()));
	}

	public int size()
	{
		return size(this);
	}

	private int size(TreeNode<T> head)
	{
		if (head == null)
			return 0;
		else
			return 1 + size(head.getLeftChild()) + size(head.getRightChild());
	}

	public void printPreOrder()
	{
		System.out.print(self + " ");
		if (leftChild != null)
			leftChild.printPreOrder();
		if (rightChild != null)
			rightChild.printPreOrder();
	}

	public void printPostOrder()
	{

		if (leftChild != null)
			leftChild.printPostOrder();
		if (rightChild != null)
			rightChild.printPostOrder();
		System.out.print(self + " ");
	}

	public void printInOrder()
	{

		if (leftChild != null)
			leftChild.printInOrder();
		System.out.print(self + " ");
		if (rightChild != null)
			rightChild.printInOrder();
	}

	public void prettyPrint()
	{
		BTreePrinter.printNode(this);
	}

	public String toString()
	{
		return self.toString();
	}

	public TreeNode<T> getParent()
	{
		return parent;
	}

	public void setParent(TreeNode<T> parent)
	{
		this.parent = parent;
	}
}
