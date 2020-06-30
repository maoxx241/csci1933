public class HeatGrid {
    private int x;
    private int y;
    private String icon;
    private int[][] Arrays = new int[0][0];

    public HeatGrid(int width, int height) {
        x = height;
        y = width;
        Arrays = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Arrays[i][j] = 0;
            }
        }

    }

    public int getHeight() {
        return Arrays.length;
    }

    public int getWidth() {
        return Arrays[1].length;
    }



    public boolean placeSource(String src, int x_value, int y_value) {
        y = x_value;
        x = y_value;
        boolean result = true;
        if (x_value < 0 || y_value < 0 || y > getWidth()-1 || x> getHeight()-1) {
            return false;
        } else {
            if (Arrays[x][y] == 1 || Arrays[x][y] == 4 || Arrays[x][y] == 10 || Arrays[x][y] == -2 || Arrays[x][y] == -8
                    || Arrays[x][y] == -20) {
                result = false;


            } else {

                if (src.equals("l")) {
                    Arrays[x][y] = 1;
                    result = true;

                } else if (src.equals("c")) {
                    Arrays[x][y] = 4;
                    int a;
                    int b;
                    int c;
                    int d;

                    if (x - 2 < 0) {
                        a = 0;
                    } else {
                        a = x - 2;
                    }

                    if (x + 3 > getWidth() - 1) {
                        c = getHeight() - 1;
                    } else {
                        c = x + 3;
                    }


                    if (y - 2 <= 0) {
                        b = 0;
                    } else {
                        b = y - 2;
                    }

                    if (y + 3 >= getHeight() - 1) {
                        d = getWidth() - 1;
                    } else {
                        d = y + 3;
                    }


                    for (int i = a; i < c; i++) {
                        for (int j = b; j < d; j++) {
                            if (i == x && j == y) {
                                Arrays[i][j] = 4;
                            } else if (Math.abs(x - i) == 2 || Math.abs(y - j) == 2) {
                                Arrays[i][j] = Arrays[i][j] + 1;
                            } else if (Math.abs(x - i) == 1 || Math.abs(y - j) == 1) {
                                Arrays[i][j] = Arrays[i][j] + 2;
                            }
                        }
                    }
                    result = true;

                } else if (src.equals("f")) {
                    Arrays[x][y] = 10;
                    int a;
                    int b;
                    int c;
                    int d;

                    if (x - 4 <= 0) {
                        a = 0;
                    } else {
                        a = x - 4;
                    }

                    if (x + 5 > getWidth() - 1) {
                        c = getHeight();
                    } else {
                        c = x + 5;
                    }


                    if (y - 4 <= 0) {
                        b = 0;
                    } else {
                        b = y - 4;
                    }

                    if (y + 5 > getHeight() - 1) {
                        d = getWidth();
                    } else {
                        d = y + 5;
                    }
                    for (int i = a; i < c; i++) {
                        for (int j = b; j < d; j++) {
                            if (i == x && j == y) {
                                Arrays[i][j] = 10;
                            } else if (Math.abs(x - i) == 4 || Math.abs(y - j) == 4) {
                                Arrays[i][j] = Arrays[i][j] + 2;
                            } else if (Math.abs(x - i) == 3 || Math.abs(y - j) == 3) {
                                Arrays[i][j] = Arrays[i][j] + 3;
                            } else if (Math.abs(x - i) == 2 || Math.abs(y - j) == 2) {
                                Arrays[i][j] = Arrays[i][j] + 4;
                            } else if (Math.abs(x - i) == 1 || Math.abs(y - j) == 1) {
                                Arrays[i][j] = Arrays[i][j] + 7;
                            }
                        }
                    }
                    result = true;

                } else if (src.equals("i")) {
                    Arrays[x][y] = -2;
                    int a;
                    int b;
                    int c;
                    int d;

                    if (x - 1 <= 0) {
                        a = 0;
                    } else {
                        a = x - 1;
                    }

                    if (x + 2 > getWidth()) {
                        c = getHeight();
                    } else {
                        c = x + 2;
                    }


                    if (y - 1 <= 0) {
                        b = 0;
                    } else {
                        b = y - 1;
                    }

                    if (y + 2 > getHeight()) {
                        d = getWidth();
                    } else {
                        d = y + 2;
                    }
                    for (int i = a; i < c; i++) {
                        for (int j = b; j < d; j++) {
                            if (i == x && j == y) {
                                Arrays[i][j] = -2;
                            } else if (Math.abs(x - i) == 1 || Math.abs(y - j) == 1) {
                                Arrays[i][j] = Arrays[i][j] - 1;
                            }
                            result = true;
                        }
                    }
                } else if (src.equals("r")) {
                    Arrays[x][y] = -8;
                    int a;
                    int b;
                    int c;
                    int d;

                    if (x - 3 <= 0) {
                        a = 0;
                    } else {
                        a = x - 3;
                    }

                    if (x + 3 > getWidth()) {
                        c = getHeight();
                    } else {
                        c = x + 4;
                    }


                    if (y - 3 <= 0) {
                        b = 0;
                    } else {
                        b = y - 3;
                    }

                    if (y + 3 > getHeight()) {
                        d = getWidth();
                    } else {
                        d = y + 4;
                    }

                    for (int i = a; i < c; i++) {
                        for (int j = b; j < d; j++) {
                            if (i == x && j == y) {
                                Arrays[i][j] = -8;
                            } else if (Math.abs(x - i) == 3 || Math.abs(y - j) == 3) {
                                Arrays[i][j] = Arrays[i][j] - 4;
                            } else if (Math.abs(x - i) == 2 || Math.abs(y - j) == 2) {
                                Arrays[i][j] = Arrays[i][j] - 5;
                            } else if (Math.abs(x - i) == 1 || Math.abs(y - j) == 1) {
                                Arrays[i][j] = Arrays[i][j] - 6;
                            }
                            result = true;
                        }
                    }
                } else if (src.equals("g")) {
                    Arrays[x][y] = -20;
                    int a;
                    int b;
                    int c;
                    int d;

                    if (x - 5 <= 0) {
                        a = 0;
                    } else {
                        a = x - 5;
                    }

                    if (x + 6 >= getWidth()) {
                        c = getHeight();
                    } else {
                        c = x + 6;
                    }


                    if (y - 5 <= 0) {
                        b = 0;
                    } else {
                        b = y - 5;
                    }

                    if (y + 6 >= getHeight()) {
                        d = getWidth();
                    } else {
                        d = y + 6;
                    }
                    for (int i = a; i < c; i++) {
                        for (int j = b; j < d; j++) {
                            if (i == x && j == y) {
                                Arrays[i][j] = -20;
                            } else if (Math.abs(x - i) == 5 || Math.abs(y - j) == 5) {
                                Arrays[i][j] = Arrays[i][j] - 9;
                            } else if (Math.abs(x - i) == 4 || Math.abs(y - j) == 4) {
                                Arrays[i][j] = Arrays[i][j] - 10;
                            } else if (Math.abs(x - i) == 3 || Math.abs(y - j) == 3) {
                                Arrays[i][j] = Arrays[i][j] - 12;
                            } else if (Math.abs(x - i) == 2 || Math.abs(y - j) == 2) {
                                Arrays[i][j] = Arrays[i][j] - 14;
                            } else if (Math.abs(x - i) == 1 || Math.abs(y - j) == 1) {
                                Arrays[i][j] = Arrays[i][j] - 17;
                            }
                        }
                    }

                    result = true;

                }
            }
        }
        return result;


    }

    public int[][] getHeats() {
        return Arrays;

    }

    public int getHeat(int x_value, int y_value) {
        return Arrays[y_value][x_value];

    }

    public int getNetHeat() {
        int sum = 0;
        for (int i = 0; i < Arrays.length; i++) {
            for (int j = 0; j < Arrays[i].length; sum += Arrays[i][j], j++) {

            }
        }
        return sum;
    }


}
