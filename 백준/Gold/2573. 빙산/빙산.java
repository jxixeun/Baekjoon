import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int[][] seaCounts = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean flag = false;
		int ans = 0;
		while (true){
			// 섬 갯수 세기
			int islands = 0;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] !=0 && !visited[i][j]){
						dfs(i, j);
						islands++;
					}
				}
			}
			if (islands == 0){
				System.out.println(0);
				break;
			}
			if (islands >= 2){
				System.out.println(ans);
				break;
			}
			// 녹기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0){
						int nearSeaCount = 0;
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny]==0){
								nearSeaCount++;
							}
						}
						seaCounts[i][j] = nearSeaCount;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = Math.max(0, map[i][j] - seaCounts[i][j]);
				}
			}
			ans++;
		}
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i <4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny]!=0 && !visited[nx][ny]){
				dfs(nx, ny);
			}
		}
	}
}