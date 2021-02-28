import java.util.Scanner;

public class Main2 {
    public static int[][] graph;
    public static boolean[][] graphBoole;
    public static int[] getLastX;
    public static int[] getLastY;
    public static int[] getFirstX;
    public static int[] getFirstY;
    public static int n;
    public static Scanner sc;
    public static int width;
    public static boolean notFound = true;
    public static int count = 0;

    public static int height;
    public static int[] X = {1, -1, 0, 0};
    public static int[] Y = {0, 0, 1, -1};

    public static void printGraph(int w, int h) {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++)
                System.out.print(graph[i][j] + " ");
            System.out.println();
        }
    }

    public static void solve(int x, int y) {
        System.out.println("bắt đầu đệ quy x : " + x + ", y : " + y + " boole " + graphBoole[x][y] + " " + graph[x][y] +"count "+count);
        for (int i = 0; i < 4; i++) {
            // tạo bước đi mới
            System.out.println("vòng lặp mới i = " + i);
            int u = x + X[i];//tạo một vị trí x mới
            int v = y + Y[i];//tạo một vịi trí y mới
            //Nếu hợp lẹ thì tiến hành di chuyển
            if (u >= 0 && u <= height - 1 && v >= 0 && v <= width - 1) {
                if (graph[u][v] == 0  /*&&!graphBoole[u][v]*/) {
                    System.out.println("dang đi đây u :" + u + " v: " + v );
                    System.out.println(getLastX[count]+" "+getLastY[count]);
                    //đánh dấu không phải giá trị cần tìm
                    //graphBoole[u][v] = true;
                    graph[u][v] = graph[x][y];
                    printGraph(width, height);
                    solve(u, v);
                    System.out.println("matrix is here " + u + " " + v);
                    if (notFound) graph[u][v] = 0;
                    else break;
                    printGraph(width, height);
                } else if (u == getLastX[count] && v == getLastY[count]) {
                    System.out.println("tou day đi please u : " + u + " v : " + v);
                    printGraph(width, height);
                    //graphBoole[u][v] = true;
                    notFound = false;
                    break;
                }
            }
        }
        if(x == getFirstX[count] && y == getFirstY[count] && notFound) System.out.println("khong tim duoc đường.........................");
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
        sc = new Scanner(System.in);
        width = sc.nextInt();
        height = sc.nextInt();
        n = sc.nextInt();
        getFirstX = new int[n];
        getFirstY = new int[n];
        getLastX = new int[n];
        getLastY = new int[n];
        graph = new int[height][width];
        graphBoole = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                graph[i][j] = 0;
                graphBoole[i][j] = false;

            }
        }
        //nhập đề vào
        for (int i = 0; i < n; i++) {
            System.out.println("gia tri :" + (i + 1));
            getFirstX[i] = sc.nextInt();
            getFirstY[i] = sc.nextInt();
            graph[getFirstX[i]][getFirstY[i]] = i + 1;
            graphBoole[getFirstX[i]][getFirstY[i]] = true;
            getLastX[i] = sc.nextInt();
            getLastY[i] = sc.nextInt();
            graph[getLastX[i]][getLastY[i]] = i + 1;
            graphBoole[getLastX[i]][getLastY[i]] = true;
        }
        printGraph(width, height);
        for(int i = 0; i < n; i++){
            //graphBoole[getFirstX[i]][getFirstY[i]] = false;
            count = i;
            solve(getFirstX[i],getFirstY[i]);
            //graphBoole[getLastX[i]][getLastY[i]] = false;
            notFound = true;
        }
        //giải bài toán
        /*for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (graphBoole[i][j] && graph[i][j] != 0) {
                    graphBoole[i][j] = false;
                    solve(i, j);
                    graphBoole[lastX][lastY] = false;
                }
                notFound = true;
            }
        }*/

    }
}
