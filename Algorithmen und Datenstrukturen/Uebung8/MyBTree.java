package Uebung8;

import aud.BTree;
import aud.KTreeNode;
import aud.util.DotViewer;
import aud.util.SingleStepper;

public class MyBTree<Key extends Comparable<Key>> extends BTree<Key> {
	
	public MyBTree(int m) { super(m); }
	
	public int getHeight() { // Nutze Fakt, dass alle Blätter auf gleicher Ebene liegen → einheitliche Höhe
		int counter = 0;
		
		if (this.root() != null) {
			KTreeNode<Key> current = this.root();
			
			while (current != null) {
				counter++;
				current = current.getChild(1); // "The 0-th key always equals null by definition.", siehe KTreeNode
			}
		}
		return counter;
	}
	
	public static void main(String[] args) {
		MyBTree<Integer> example = new MyBTree<>(2);
		MyBTree<Integer> minTest = new MyBTree<>(2);

		SingleStepper stepper = new SingleStepper("Stepper for BTree");
		DotViewer viewer = DotViewer.displayWindow(example, "BTree visualization");
		viewer.setExitOnClose();

		int[] nums = {6, 18, 22, 3, 11, 16, 7, 10, 1, 8, 12};

		stepper.halt("Begin insertion");
		for (Integer num : nums) {
			example.insert(num);
			viewer.display(example);
			stepper.halt("Next integer");
		}
		stepper.halt("End of insertion");

		stepper.halt("Begin minTest");
		for (int i = 1; i < 18; i++) {
			minTest.insert(i);
			viewer.display(minTest);
			stepper.halt("Next integer");
		}
		stepper.halt("End of minTest");
		
		int randomHeight = (int) (1 + Math.random() * 10);
		MyBTree<Integer> testHeight = new MyBTree<>(randomHeight);
		for (int i = 0; i < 1e6; i++) testHeight.insert((int)(1 + Math.random() * 1e9));
		System.out.println(testHeight.getHeight());
	}
}
