import java.util.*;

public class Main {
    public static void main(String[] args) {
        case18();
    }

    private static void case18() {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int m = 9, n = 9;
        long[][] dp = new long[m][n];
        int[][] ds = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, 2}, {1, -2}, {2, -1}, {2, 1}};
        dp[0][0] = 1;
        while (k-- > 0){
            long[][] tmp = new long[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d: ds) {
                        if (i + d[0] >= 0 && i + d[0] < m && j + d[1] >= 0 && j + d[1] < n) {
                            tmp[i][j] += dp[i + d[0]][j + d[1]] % 1000000007;
                        }
                    }
                }
            }
            dp = tmp;
        }
        System.out.println(dp[x][y] % 1000000007);
    }

    private static void case17() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            if ((n & 1) == 1) {
                System.out.println("No");
            } else {
                long x = n >> 1, y = 2;
                while ((x & 1) == 0) {
                    x = x >> 1;
                    y = y << 1;
                }
                System.out.println(x + " " + y);
            }
        }
    }

    private static void case16() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] strs = in.nextLine().split(" ");
        int res = 0;
        for (String s: strs) {
            char[] chs = s.toCharArray();
            if ((chs[0] == chs[3] && chs[1] == chs[4])
                    || (chs[0] == chs[1] && chs[3] == chs[4])
                    || (chs[0] == chs[4] && chs[1] == chs[3])
                    ) {
                res++;
            }
        }
        System.out.println(res);
    }

    private static void case15() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int res = 0, a = 0, b = 0;
            for (int i = n; i >= 1; i--) {
                for (int j = i; j >= 1; j--) {
                    int tmp = fab(i, j);
                    if (tmp > res) {
                        res = tmp;
                        a = i;
                        b = j;
                    }
                }
            }
            System.out.printf("%d %d %d\n", res, a, b);
        }
    }

    private static int fab(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return fab(b % a, a) + 1;
    }

    private static void case14() {
//        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
//        in.nextLine();
        long m = (long)Math.pow(10, 9) + 7;
        char[] t = {'b', 'u', 'p', 't'};
//        while (T-- > 0) {
//            char[] s = in.nextLine().toCharArray();
//            System.out.println(numDistinct(s, t, m));
//        }
        Random random = new Random();
        char[] s = new char[10000000];
        for (int i = 0; i < s.length; i++) {
            s[i] = (char) (random.nextInt(26) + 'a');
        }
        System.out.println(numDistinct(s, t, m));
    }

    public static long numDistinct(char[] s, char[] t, long m) {
        long[][] dp = new long[s.length + 1][t.length + 1];
        for (int i = 0; i <= s.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length; i++) {
            for (int j = 1; j <= t.length; j++) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % m;
                } else {
                    dp[i][j] = dp[i - 1][j] % m;
                }
            }
        }
        return dp[s.length][t.length];
    }

    private static void case13() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        in.nextLine();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c == 'Y') grid[i][j] = 1;
                else if (c == 'B') grid[i][j] = 2;
                else if (c == 'G') grid[i][j] = 3;
            }
        }

//        int[][] grid = {{1,0,0,2},{0,1,3,0},{0,2,1,1},{2,0,0,1}};
//        printMatrix(grid);
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                res += clear(grid, i, j);
//                printMatrix(grid);
            }
        }
        System.out.println(res);

    }

    private static int clear(int[][] grid, int x, int y) {

        int r = x + 1, c = y + 1;
        int res1 = 0;
        while (isValid(grid, r, c) && (grid[r][c] == 1 || grid[r][c] == 3)) {
            res1 = 1;
            grid[r++][c++] -= 1;
        }

        r = x + 1;c = y - 1;
        int res2 = 0;
        while (isValid(grid, r, c) && (grid[r][c] == 2 || grid[r][c] == 3)) {
            res2 = 1;
            grid[r++][c--] -= 2;
        }

        grid[x][y] = 0;
        return res1 + res2;
    }

    private static boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    private static void printMatrix(int[][] grid) {
        for (int[] aGrid : grid) {
            System.out.println(Arrays.toString(aGrid));
        }
        System.out.println();
    }

    private static void case12() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] card = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = in.nextInt();
        }
        Arrays.sort(card);
        int l = 0, r = n - 1, res = 0;
        while (l < r) {
            res += card[r--] - card[l++];
        }
        System.out.println(res);
    }

    private static void case11() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                String line = in.nextLine();
                for (int j = 0; j < 3; j++) {
                    if (line.charAt(j) == '.') {
                        list.add(new int[]{i, j});
                    }
                }
            }
        }
    }

    private static void case10() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int[][] abi = new int[n][2];
            for (int i = 0; i < n; i++) {
                abi[i][0] = in.nextInt();
                abi[i][1] = in.nextInt();
            }
            System.out.println(case10(abi, x, y));
        }
//        System.out.println(case10(new int[][]{
//                {100, 0},
//                {0, 99},
//                {95, 95},
//                {96, 0},
//                {0, 97}
//        }, 2, 2)); // 96
//        System.out.println(case10(new int[][]{
//                {99, 99},
//                {100, 0},
//                {100, 100},
//                {100, 0},
//                {100, 0}
//        }, 2, 2)); // 96
//        System.out.println(case10(new int[][]{
//                {100, 0},
//                {0, 100},
//                {100, 0},
//                {100, 0},
//        }, 2, 2)); // 0
    }

    private static int case10(int[][] abi, int x, int y) {
        PriorityQueue<int[]> queue1 = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        PriorityQueue<int[]> queue2 = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int res = Integer.MAX_VALUE;

        for (int[] a: abi) {
            queue1.offer(a);
        }

        while (queue1.size() > 0 && x > 0) {
            int[] a = queue1.poll();
            if (a[0] > 0) {
                x--;
                res = Math.min(res, a[0]);
            }
        }

        while (queue1.size() > 0) {
            queue2.offer(queue1.poll());
        }

        while (queue2.size() > 0 && y > 0) {
            int[] a = queue2.poll();
            if (a[1] > 0) {
                y--;
                res = Math.min(res, a[1]);
            }
        }

        return x == 0 && y == 0 ? res : 0;
    }

    private static void case9() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            char[][] block = new char[n][n];
            for (int i = 0; i < n; i++) {
                String line = in.nextLine();
                for (int j = 0; j < n; j++) {
                    block[i][j] = line.charAt(j);
                }
            }
            case9(block, n, m);
        }
    }

    private static void case9(char[][] block, int n, int m) {
        int size = n;
        while (size < m) {
            size += 2 * n;
        }

        char[][] floor = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                floor[i][j] = block[i % n][j % n];
            }
        }

        int offset = (size - m) / 2;
        for (int i = offset; i < size - offset; i++) {
            for (int j = offset; j < size - offset; j++) {
                System.out.print(floor[i][j]);
            }
            System.out.println();
        }
    }

    private static void case8() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int[] rgb = new int[3];
            for (int j = 0; j < 3; j++) {
                rgb[j] = in.nextInt();
            }
            int res = 0;
            while (true) {
                Arrays.sort(rgb);
                if (rgb[0] == 0) {
                    if (rgb[1] == 0 || rgb[1] + rgb[2] == 2) {
                        break;
                    } else if (rgb[1] >= 3 && rgb[2] >= 3) {
                        res += rgb[1] / 3 * 3;
                        rgb[1] = rgb[1] / 3;

                    } else{
                        res += rgb[1];
                        rgb[1] -= 1;
                        rgb[2] -= 2;
                    }
                }
                else {
                    res += rgb[0];
                    rgb[1] -= rgb[0];
                    rgb[2] -= rgb[0];
                    rgb[0] = 0;
                }
            }
            System.out.println(res);
        }
    }

    private static void case7() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] c = new int[4];
            int res = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    c[k] = in.nextInt();
                }
                res += (c[2] - c[0] + 1) * (c[3] - c[1] + 1);
            }
            System.out.println(res);
        }
    }

    private static void case6() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res;
        if (n == 2) {
            res = 1;
        } else if (n == 3) {
            res = 2;
        } else {
            res = 1;
            while (n > 4) {
                res *= 3;
                n -= 3;
            }
            res *= n;
        };
        System.out.println(res);
    }

    private static void case5() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> res = new ArrayList<>();
        dfs(n, n, "", res);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i < res.size() - 1) System.out.print(",");
        }
    }

    private static void dfs(int left, int right, String tmp, List<String> res) {
        if (right == 0) {
            res.add(tmp);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, tmp + "(", res);
        }
        if (right > left) {
            dfs(left, right - 1, tmp + ")", res);
        }
    }

    private static void case4() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = "";
        int len = str.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i != 0) continue;
            String sub = str.substring(0, i);
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < len / i; j++) {
                builder.append(sub);
            }
            if (str.equals(builder.toString())) {
                res = sub;
            }

        }

        if (res.length() == 0) {
            System.out.println(false);
        } else {
            System.out.println(res);
        }
    }

    private static void case2() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] list = new String[t];
        for (int i = 0; i < t; i++) {
            sc.nextInt();sc.nextLine();
            list[i] = sc.nextLine();
        }

        for (int i = 0; i < t; i++) {
            int count = 0, pos = 0;
            while (pos < list[i].length()) {
                if (list[i].charAt(pos) == '.') {
                    count++;
                    pos += 3;
                } else {
                    pos++;
                }
            }
            System.out.println(count);
        }
    }

    private static void case3() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long w = sc.nextLong();

        Queue<Long> queue = new LinkedList<>();
        queue.offer(0L);
        for (int i = 0; i < n; i++) {
            long size = queue.size();
            long cost = sc.nextLong();
            for (long j = 0; j < size; j++) {
                long weight = queue.poll();
                queue.offer(weight);
                if (weight + cost <= w) {
                    queue.offer(weight + cost);
                }
            }
        }
        System.out.println(queue.size());
    }

    private static void case1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] alarms = new int[n];
        for (int i = 0; i < n; i++) {
            alarms[i] = timeToInt(sc);
        }
        int timeNeed = sc.nextInt();
        int target = timeToInt(sc);

        for (int i = n - 1; i >= 0; i--) {
            if (target - alarms[i] >= timeNeed) {
                System.out.println(alarms[i] / 60 + " " + alarms[i] % 60);
                return;
            }
        }
    }

    private static int timeToInt(Scanner sc) {
        if (sc == null) {
            throw new IllegalArgumentException();
        }
        try {
            int h = sc.nextInt();
            int m = sc.nextInt();
            return h * 60 + m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }
}

