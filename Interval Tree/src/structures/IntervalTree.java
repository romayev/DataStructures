package structures;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Encapsulates an interval tree.
 * 
 * @author runb-cs112
 */
public class IntervalTree {
	
	/**
	 * The root of the interval tree
	 */
	IntervalTreeNode root;
	
	/**
	 * Constructs entire interval tree from set of input intervals. Constructing the tree
	 * means building the interval tree structure and mapping the intervals to the nodes.
	 * 
	 * @param intervals Array list of intervals for which the tree is constructed
	 */
	public IntervalTree(ArrayList<Interval> intervals) {
		
		// make a copy of intervals to use for right sorting
		ArrayList<Interval> intervalsRight = new ArrayList<Interval>(intervals.size());
		for (Interval iv : intervals) {
			intervalsRight.add(iv);
		}
		
		// rename input intervals for left sorting
		ArrayList<Interval> intervalsLeft = intervals;
		
		// sort intervals on left and right end points
		sortIntervals(intervalsLeft, 'l');
		sortIntervals(intervalsRight,'r');
		
		// get sorted list of end points without duplicates
		ArrayList<Integer> sortedEndPoints = 
							getSortedEndPoints(intervalsLeft, intervalsRight);
		
		// build the tree nodes
		root = buildTreeNodes(sortedEndPoints);
		
		// map intervals to the tree nodes
		mapIntervalsToTree(intervalsLeft, intervalsRight);
		System.out.println("Finished mapping intervals");
		//print(root);
	}

	private void print(IntervalTreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.toString());
		if (node.leftChild != null) {
			System.out.println("Left:");
			print(node.leftChild);
		}
		if (node.rightChild != null) {
			System.out.println("Right:");
			print(node.rightChild);
		}
	}
	/**
	 * Returns the root of this interval tree.
	 * 
	 * @return Root of interval tree.
	 */
	public IntervalTreeNode getRoot() {
		return root;
	}
	
	/**
	 * Sorts a set of intervals in place, according to left or right endpoints.  
	 * At the end of the method, the parameter array list is a sorted list. 
	 * 
	 * @param intervals Array list of intervals to be sorted.
	 * @param lr If 'l', then sort is on left endpoints; if 'r', sort is on right endpoints
	 */
	public static void sortIntervals(ArrayList<Interval> intervals, char lr) {
        for (int i = 0; i < intervals.size(); i++) {
            int index = i;
            for (int j = i + 1; j < intervals.size(); j++) {
                if (lr == 'l') {
                    if (intervals.get(j).leftEndPoint < intervals.get(index).leftEndPoint) {
                        index = j;
                    }
                } else if (lr == 'r') {
                    if (intervals.get(j).rightEndPoint < intervals.get(index).rightEndPoint) {
                        index = j;
                    }
                } else {
                    return;
                }
                Interval lower = intervals.get(index);
                intervals.set(index, intervals.get(i));
                intervals.set(i, lower);
            }
        }
        System.out.println("Sorted Array (" + lr + "): " + intervals);
	}

	/**
	 * Given a set of intervals (left sorted and right sorted), extracts the left and right end points,
	 * and returns a sorted list of the combined end points without duplicates.
	 * 
	 * @param leftSortedIntervals Array list of intervals sorted according to left endpoints
	 * @param rightSortedIntervals Array list of intervals sorted according to right endpoints
	 * @return Sorted array list of all endpoints without duplicates
	 */


	public static ArrayList<Integer> getSortedEndPoints(ArrayList<Interval> leftSortedIntervals, ArrayList<Interval> rightSortedIntervals) {
        ArrayList<Integer> points = new ArrayList<Integer>();
        int rightIndex = 0;
        int leftIndex = 0;
        int left;
        int right;
        Interval leftInterval;
        Interval rightInterval;

        int size = leftSortedIntervals.size();
		if (size == 0) {
			return points;
		}
        boolean atEndOfLeft = false;
        boolean atEndOfRight = false;

		while (!(atEndOfLeft && atEndOfRight)) {
			leftInterval = leftSortedIntervals.get(leftIndex);
			left = leftInterval.leftEndPoint;
			rightInterval = rightSortedIntervals.get(rightIndex);
			right = rightInterval.rightEndPoint;

        	if (atEndOfLeft) {
        		add(right, points);
        		rightIndex++;
			} else if (atEndOfRight) {
				add(left, points);
				leftIndex++;
			} else if (left == right) {
				add(left, points);
				rightIndex++;
				leftIndex++;
			} else if (left > right) {
				add(right, points);
				rightIndex++;
			} else if (left < right) {
				add(left, points);
				leftIndex++;
			}
			if (leftIndex == size) {
        		leftIndex--;
				atEndOfLeft = true;
			}

			if (rightIndex == size) {
        		rightIndex--;
				atEndOfRight = true;
			}
		}
        System.out.println("Points: " + points);
        return points;
	}

	static void add(int value, ArrayList<Integer> array) {
		if (array.isEmpty() || array.get(array.size() -  1) != value) {
			array.add(value);
		}
	}

	static int incrementIndex(int index, int size) {
		return 0;
	}
	/**
	 * Builds the interval tree structure given a sorted array list of end points
	 * without duplicates.
	 * 
	 * @param endPoints Sorted array list of end points
	 * @return Root of the tree structure
	 */
	public static IntervalTreeNode buildTreeNodes(ArrayList<Integer> endPoints) {
		float p;
		Queue<IntervalTreeNode> queue = new Queue<IntervalTreeNode>();

		for (Integer endPoint : endPoints) {
			p = endPoint;

			IntervalTreeNode node = new IntervalTreeNode(p, p, p);
			node.leftIntervals = new ArrayList<Interval>();
			node.rightIntervals = new ArrayList<Interval>();
			queue.enqueue(node);
		}

		int size = queue.size();
		IntervalTreeNode root;
		while (size > 0) {
			if (size == 1) {
				root = queue.dequeue();
				return root;
			} else {
				int tempSize = size;
				while (tempSize > 1) {
					IntervalTreeNode nodeOne = queue.dequeue();
					IntervalTreeNode nodeTwo = queue.dequeue();

					float v1 = nodeOne.maxSplitValue;
					float v2 = nodeTwo.minSplitValue;

					IntervalTreeNode node = new IntervalTreeNode((v1 + v2) / 2, nodeOne.minSplitValue, nodeTwo.maxSplitValue);
					node.leftIntervals = new ArrayList<Interval>();
					node.rightIntervals = new ArrayList<Interval>();
					node.leftChild = nodeOne;
					node.rightChild = nodeTwo;
					queue.enqueue(node);
					tempSize = tempSize - 2;
				}
				if (tempSize == 1) {
					queue.enqueue(queue.dequeue());
				}
				size = queue.size();
			}
		}
		root = queue.dequeue();
		return root;
	}

	/**
	 * Maps a set of intervals to the nodes of this interval tree.
	 * 
	 * @param leftSortedIntervals Array list of intervals sorted according to left endpoints
	 * @param rightSortedIntervals Array list of intervals sorted according to right endpoints
	 */
	public void mapIntervalsToTree(ArrayList<Interval> leftSortedIntervals, ArrayList<Interval> rightSortedIntervals) {
		for (Interval interval: leftSortedIntervals) {
			IntervalTreeNode node = searchTree(interval, root);
			assert node != null;
			node.leftIntervals.add(interval);
		}
		for (Interval interval: rightSortedIntervals) {
			IntervalTreeNode node = searchTree(interval, root);
			assert node != null;
			node.rightIntervals.add(interval);
		}
	}

	 private IntervalTreeNode searchTree(Interval interval, IntervalTreeNode root) {
		if (root == null) {
			return null;
		}
		if (interval.contains(root.splitValue)) {
			return root;
		}
		int maxValue = interval.rightEndPoint;
		if (root.splitValue < maxValue) {
			return searchTree(interval, root.rightChild);
		} else {
			return searchTree(interval, root.leftChild);
		}
	}
	
	/**
	 * Gets all intervals in this interval tree that intersect with a given interval.
	 * 
	 * @param q The query interval for which intersections are to be found
	 * @return Array list of all intersecting intervals; size is 0 if there are no intersections
	 */


	public ArrayList<Interval> findIntersectingIntervals(Interval q) {
		 return queryTree(root, q);
	}

	private ArrayList<Interval> queryTree(IntervalTreeNode node, Interval interval) {
		ArrayList<Interval> resultList = new ArrayList<Interval>();
		float splitVal = node.splitValue;
		ArrayList<Interval> leftSort = node.leftIntervals;
		ArrayList<Interval> rightSort = node.rightIntervals;

		IntervalTreeNode leftSub = node.leftChild;
		IntervalTreeNode rightSub = node.rightChild;

		//if root is leaf return null
		if (node.rightChild == null) {
			//return empty list
			return resultList;
		}

		if (interval.contains(splitVal)) {
			for (Interval inter : leftSort) {
				resultList.add(inter);
			}
			resultList.addAll(queryTree(leftSub, interval));
			resultList.addAll(queryTree(rightSub, interval));
		} else if (splitVal < interval.leftEndPoint) {
			int rSortSize = rightSort.size() - 1;
			while (rSortSize >= 0 && rightSort.get(rSortSize).intersects(interval)) {
				resultList.add(rightSort.get(rSortSize));
				rSortSize--;
			}
			resultList.addAll(queryTree(rightSub, interval));
		} else if (splitVal > interval.rightEndPoint) {
			int i = 0;
			while (i < leftSort.size() && leftSort.get(i).intersects(interval)) {
				resultList.add(leftSort.get(i));
				i++;
			}
			resultList.addAll(queryTree(leftSub, interval));
		}
		 return resultList;
	}

}

