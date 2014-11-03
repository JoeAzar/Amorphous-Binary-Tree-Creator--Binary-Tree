/**
 * @author Joe A-W
 * 
 * @param <T>
 */
public class AmorphousBTreeCreator<T>
{
	ArrayList<TreeNode<T>> unassignedTrees = new ArrayList<TreeNode<T>>();
	boolean fNode = true;
	private TreeNode<T> head;

	public void addLR(T headE, T leftE, T rightE)
	{
		if (fNode)
		{
			head = new TreeNode<T>(headE);
			fNode = false;
		}
		TreeNode<T> h = head.get(headE);
		if (h == null)
		{
			h = new TreeNode<T>(headE);
			unassignedTrees.add(h);
		}
		TreeNode<T> lc = new TreeNode<T>(leftE);
		lc.setParent(h);
		h.setLeftChild(lc);
		TreeNode<T> rc = new TreeNode<T>(rightE);
		rc.setParent(h);
		h.setRightChild(rc);
	}

	public void addL(T headE, T leftE)
	{
		if (fNode)
		{
			head = new TreeNode<T>(headE);
			fNode = false;
		}
		TreeNode<T> h = head.get(headE);
		if (h == null)
		{
			h = new TreeNode<T>(headE);
			unassignedTrees.add(h);
		}
		TreeNode<T> lc = new TreeNode<T>(leftE);
		lc.setParent(h);
		h.setLeftChild(lc);
	}

	public void addR(T headE, T rightE)
	{
		if (fNode)
		{
			head = new TreeNode<T>(headE);
			fNode = false;
		}
		TreeNode<T> h = head.get(headE);
		if (h == null)
		{
			h = new TreeNode<T>(headE);
			unassignedTrees.add(h);
		}
		TreeNode<T> rc = new TreeNode<T>(rightE);
		rc.setParent(h);
		h.setRightChild(rc);
	}

	/**
	 * * @return BTree
	 * 
	 *  Big O on this is (by my rough estimation): 
	 *               Worst Case: O(n^2) - no subtrees are connected to head
	 *               Best Case: O(n) - All subtrees were in natural order and connected.
	 *                      where n is `unassignedTrees.size()`
	 *  Returns a Tree constructed from all isolated sub-trees, using node values as keys.
	 */
	public BTree<T> createTree()
	{
		int x = unassignedTrees.size();
		for (int i = 0; i < x && unassignedTrees.size() > 0; i++)
		{
			for (int j = 0; j < unassignedTrees.size(); j++)
			{
				TreeNode<T> n = unassignedTrees.get(j);
				TreeNode<T> link = head.get(n.self);
				if (link != null)
				{
					TreeNode<T> lc = n.getLeftChild();
					if (lc != null)
						lc.setParent(link);
					link.setLeftChild(lc);
					TreeNode<T> rc = n.getRightChild();
					if (rc != null)
						rc.setParent(link);
					link.setRightChild(rc);

					unassignedTrees.remove(n);
				}
				link = n.get(head.self);
				if (link != null)
				{
					TreeNode<T> lc = head.getLeftChild();
					if (lc != null)
						lc.setParent(link);
					link.setLeftChild(lc);

					TreeNode<T> rc = head.getRightChild();
					if (rc != null)
						rc.setParent(link);
					link.setRightChild(rc);
					head = n;
					unassignedTrees.remove(n);
				}
			}
		}
		return new BTree<T>(head);
	}
}
