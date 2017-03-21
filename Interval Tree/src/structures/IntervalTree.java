package structures;

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
		//mapIntervalsToTree(intervalsLeft, intervalsRight);
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

        boolean atEndOfLeft = false;
        boolean atEndOfRight = false;

		while (!(atEndOfLeft && atEndOfRight)) {
			leftInterval = leftSortedIntervals.get(leftIndex);
			left = leftInterval.leftEndPoint;
			System.out.println("left in first while loop: " + left);
			rightInterval = rightSortedIntervals.get(rightIndex);
			right = rightInterval.rightEndPoint;
			System.out.println("right in first while loop: " + right);

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
		Queue<IntervalTreeNode> Q = new Queue<IntervalTreeNode>();

		for (int i = 0; i < endPoints.size(); i++) {
			p = endPoints.get(i);

			IntervalTreeNode node = new IntervalTreeNode(p, p, p);
			node.leftIntervals = new ArrayList<Interval>();
			node.rightIntervals = new ArrayList<Interval>();
			Q.enqueue(node);
		}

		int s = Q.size();
		System.out.println("Size:" + s);
		IntervalTreeNode root;
		while (s > 0) {
			if (s == 1) {
				root = Q.dequeue();
				System.out.println("Root in s==1: " + root.toString());
				return root;
			} else {
				int temps = s;
				System.out.println("Temp Size: " + temps);
				while (temps > 1) {
					IntervalTreeNode T1 = Q.dequeue();
					IntervalTreeNode T2 = Q.dequeue();

					float v1 = T1.maxSplitValue;
					float v2 = T2.minSplitValue;

					IntervalTreeNode N = new IntervalTreeNode((v1 + v2) / 2, T1.minSplitValue, T2.maxSplitValue);
					System.out.println("Node N: " + N.toString());
					N.leftChild = T1;
					N.rightChild = T2;
					Q.enqueue(N);
					temps = temps - 2;
				}
				if (temps == 1) {
					Q.enqueue(Q.dequeue());
				}
				s = Q.size();
				System.out.println("Updated Size: " + s);
			}
		}
		root = Q.dequeue();
		System.out.println("Root: " + root.toString());
		return root;
	}
	
	/**
	 * Maps a set of intervals to the nodes of this interval tree. 
	 * 
	 * @param leftSortedIntervals Array list of intervals sorted according to left endpoints
	 * @param rightSortedIntervals Array list of intervals sorted according to right endpoints
	 */
	public void mapIntervalsToTree(ArrayList<Interval> leftSortedIntervals, ArrayList<Interval> rightSortedIntervals) {
		
	}
	
	/**
	 * Gets all intervals in this interval tree that intersect with a given interval.
	 * 
	 * @param q The query interval for which intersections are to be found
	 * @return Array list of all intersecting intervals; size is 0 if there are no intersections
	 */
	public ArrayList<Interval> findIntersectingIntervals(Interval q) {
		// COMPLETE THIS METHOD
		// THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE PROGRAM COMPILE
		return null;
	}

}

