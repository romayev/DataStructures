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
		mapIntervalsToTree(intervalsLeft, intervalsRight);
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
        int pointIndex = 0;
        int rightIndex = 0;
        int leftIndex = 0;
        int left = 0;
        int right = 0;
        Interval leftInterval;
        Interval rightInterval;

        while (leftIndex < leftSortedIntervals.size() && rightIndex < rightSortedIntervals.size()) {
            leftInterval = leftSortedIntervals.get(leftIndex);
            left = leftInterval.leftEndPoint;
            rightInterval = rightSortedIntervals.get(rightIndex);
            right = rightInterval.rightEndPoint;

            if (left == right) {
                points.set(pointIndex, left);
                rightIndex++;
                leftIndex++;
            } else if (left > right) {
                points.set(pointIndex, right);
                rightIndex++;
            } else if (left < right) {
                points.set(pointIndex, left);
                leftIndex++;
            }
            pointIndex++;
        }

        System.out.println(points);
        return points;
	}
	
	/**
	 * Builds the interval tree structure given a sorted array list of end points
	 * without duplicates.
	 * 
	 * @param endPoints Sorted array list of end points
	 * @return Root of the tree structure
	 */
	public static IntervalTreeNode buildTreeNodes(ArrayList<Integer> endPoints) {
		// COMPLETE THIS METHOD
		// THE FOLLOWING LINE HAS BEEN ADDED TO MAKE THE PROGRAM COMPILE
		return null;
	}
	
	/**
	 * Maps a set of intervals to the nodes of this interval tree. 
	 * 
	 * @param leftSortedIntervals Array list of intervals sorted according to left endpoints
	 * @param rightSortedIntervals Array list of intervals sorted according to right endpoints
	 */
	public void mapIntervalsToTree(ArrayList<Interval> leftSortedIntervals, ArrayList<Interval> rightSortedIntervals) {
		// COMPLETE THIS METHOD
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

