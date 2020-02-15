package TreesAndGraphs;

public class CourseSchedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (validateInput(numCourses, prerequisites)) {
                return true;
            }
            List[] edges = new ArrayList[numCourses];
            int[] inDegree = new int[numCourses];

            // Initialize
            for (int i = 0; i < numCourses; i++) {
                edges[i] = new ArrayList<>();
                inDegree[0] = 0;// though, 0 by default
            }

            // Build graph edges
            for (int[] prerequisite : prerequisites) {
                edges[prerequisite[1]].add(prerequisite[0]);
                inDegree[prerequisite[0]]++;
            }

            // BFS to build the final sorted list
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int startNode = (int)queue.poll();
                count++;
                for (int i = 0; i < edges[startNode].size(); i++) {
                    int childNode = (int) edges[startNode].get(i);
                    inDegree[childNode]--;
                    if (inDegree[childNode] == 0) {
                        queue.add(childNode);
                    }
                }
            }

            // BFS will always end. But count should == # of unique course.
            // If not (likely less than), then there is cycle
            return count == numCourses;
        }

        private boolean validateInput(int numCourses, int[][] prerequisites) {
            return numCourses == 0 || prerequisites == null || prerequisites.length == 0
                    || prerequisites[0] == null || prerequisites[0].length == 0;
        }
    }
}
