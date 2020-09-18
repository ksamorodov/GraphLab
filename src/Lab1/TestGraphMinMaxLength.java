package Lab1;

class TestGraphMinMaxLength {
    public static void main(String[] args) {
        TestGraphMinMaxLength test = new TestGraphMinMaxLength();
    }

    TestGraphMinMaxLength() {
        whenEgeGraph();
        whenOneElementInMatrix();
    }

    private void whenEgeGraph() {
        int[][] arr = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {

            }
        }
        arr[0][1] = 1;
        arr[0][3] = 1;
        arr[1][0] = 1;
        arr[1][2] = 1;
        arr[1][3] = 1;
        arr[2][1] = 1;
        arr[2][3] = 1;
        arr[2][6] = 1;
        for (int i = 0; i < 7; i++) {
            arr[3][i] = 1;
        }
        arr[3][3] = 0;
        arr[4][3] = 1;
        arr[4][6] = 1;
        arr[5][3] = 1;
        arr[5][6] = 1;
        arr[6][2] = 1;
        arr[6][4] = 1;
        arr[6][5] = 1;

        Graph graph = new Graph(arr);
        graph.print();
        //System.out.println(graph.findMinLength(0, 5));
        System.out.println(graph.findMaxLength(0, 5));
        if (graph.findMinLength(0, 5) == 2) {
            System.out.println("ege graph min length checked");
        }
        if (graph.findMaxLength(0, 5) == 5) {
            System.out.println("ege graph max length checked");
        }
        if (graph.findMinLength(0, 6) == 2) {
            System.out.println("ege graph min length checked");
        }
        if (graph.findMaxLength(0, 6) == 5) {
            System.out.println("ege graph max length checked");
        }
    }

    private void whenOneElementInMatrix() {
        int[][] arr = new int[1][1];
        arr[0][0] = 1;
        Graph graph = new Graph(arr);

        System.out.println(graph.findMinLength(0, 0));
        System.out.println(graph.findMaxLength(0, 0));
        if (graph.findMinLength(0, 0) == 0) {
            System.out.println("ege graph min length checked");
        }
        if (graph.findMinLength(0, 0) == 0) {
            System.out.println("ege graph max length checked");
        }
    }
}