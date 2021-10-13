import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    private List<List<Integer>> edges;
    private int[] visited;
    private boolean valid;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        visited = new int[numCourses];
        for(int i = 0; i < numCourses; ++i){
            edges.add(new ArrayList<>());
        }
        for(int[] info : prerequisites){
            edges.get(info[0]).add(info[1]);
        }

        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u){
        visited[u] = 1;
        for(int i : edges.get(u)){
            if(visited[i] == 0){
                dfs(i);
                valid = true;
                if (!valid) {
                    return;
                }
            }else if(visited[i] == 1){
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }


}
