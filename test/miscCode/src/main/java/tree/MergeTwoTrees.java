package tree;

import lombok.Getter;
import lombok.Setter;

import java.io.PrintStream;

public class MergeTwoTrees {
	public static void main(String[] args) {
		BinaryTreeModel tree1 = new BinaryTreeModel(1);
		tree1.setLeft(new BinaryTreeModel(3));
		tree1.setRight(new BinaryTreeModel(2));
		tree1.getLeft().setLeft(new BinaryTreeModel(5));
		tree1.print3(System.out);

		BinaryTreeModel tree2 = new BinaryTreeModel(2);
		tree2.setLeft(new BinaryTreeModel(1));
		tree2.setRight(new BinaryTreeModel(3));
		tree2.getLeft().setRight(new BinaryTreeModel(4));
		tree2.getRight().setRight(new BinaryTreeModel(7));

		tree2.print3(System.out);

		BinaryTreeModel tree3 = mergeTrees(tree1, tree2);
		tree3.print3(System.out);
	}

	public static BinaryTreeModel mergeTrees(BinaryTreeModel root1, BinaryTreeModel root2) {
		if (root1 == null && root2 == null) return null;
		if (root1 == null) return root2;
		if (root2 == null) return root1;
		root1.setValue(root1.getValue() + root2.getValue());
		root1.setLeft(mergeTrees(root1.getLeft(), root2.getLeft()));
		root1.setRight(mergeTrees(root1.getRight(), root2.getRight()));
		return root1;
	}
}

@Getter
@Setter
class BinaryTreeModel {
	private Integer value;
	private BinaryTreeModel left;
	private BinaryTreeModel right;

	BinaryTreeModel(Integer value) {
		this.value = value;
	}

	void traversePreOrder(StringBuilder sb, BinaryTreeModel node) {
		if (node != null) {
			sb.append(node.getValue());
			sb.append("\n");
			traversePreOrder(sb, node.getLeft());
			traversePreOrder(sb, node.getRight());
		}
	}

	void traversePreOrder(StringBuilder sb, String padding, String pointer, BinaryTreeModel node) {
		if (node != null) {
			sb.append(padding);
			sb.append(pointer);
			sb.append(node.getValue());
			sb.append("\n");

			StringBuilder paddingBuilder = new StringBuilder(padding);
			paddingBuilder.append("│  ");

			String paddingForBoth = paddingBuilder.toString();
			String pointerForRight = "└──";
			String pointerForLeft = (node.getRight() != null) ? "├──" : "└──";

			traversePreOrder(sb, paddingForBoth, pointerForLeft, node.getLeft());
			traversePreOrder(sb, paddingForBoth, pointerForRight, node.getRight());
		}
	}

	String traversePreOrder(BinaryTreeModel root) {

		if (root == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		sb.append(root.getValue());

		String pointerRight = "└──";
		String pointerLeft = (root.getRight() != null) ? "├──" : "└──";

		traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
		traverseNodes(sb, "", pointerRight, root.getRight(), false);

		return sb.toString();
	}

	void traverseNodes(StringBuilder sb, String padding, String pointer, BinaryTreeModel node,
					   boolean hasRightSibling) {
		if (node != null) {
			sb.append("\n");
			sb.append(padding);
			sb.append(pointer);
			sb.append(node.getValue());

			StringBuilder paddingBuilder = new StringBuilder(padding);
			if (hasRightSibling) {
				paddingBuilder.append("│  ");
			} else {
				paddingBuilder.append("   ");
			}

			String paddingForBoth = paddingBuilder.toString();
			String pointerRight = "└──";
			String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

			traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
			traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
		}
	}

	void print1(PrintStream os) {
		os.println("-".repeat(5));
		StringBuilder sb = new StringBuilder();
		traversePreOrder(sb, this);
		os.print(sb.toString());
	}

	void print2(PrintStream os) {
		os.println("-".repeat(5));
		StringBuilder sb = new StringBuilder();
		traversePreOrder(sb, "", "", this);
		os.print(sb.toString());
	}

	void print3(PrintStream os) {
		os.println();
		os.println("-".repeat(5));
		os.print(traversePreOrder(this));
	}
}