import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HeatGridTest {

    private HeatGrid heatGrid;
    private final int WIDTH = 9;
    private final int HEIGHT = 8;

    @Before
    public void setUp() throws Exception {
        heatGrid = new HeatGrid(WIDTH, HEIGHT);
    }

    @Test
    public void TestPlaceSourceOutOfBounds() throws Exception {

        // Try negative x's
        for (int i = -5; i < 0; i++) {
            assertFalse(heatGrid.placeSource("g", i, 0));
        }

        // Try negative y's
        for (int i = -5; i < 0; i++) {
            assertFalse(heatGrid.placeSource("g", 0, i));
        }

        // Try high positives for x
        for (int i = 100; i < 110; i++) {
            assertFalse(heatGrid.placeSource("g", i, 0));
        }

        // Try high positives for y
        for (int i = 100; i < 110; i++) {
            assertFalse(heatGrid.placeSource("g", 0, i));
        }
    }

    @Test
    public void TestPlaceSourceOccupied() throws Exception {

        // Place a bunch of lightbulbs along the diagonal
        for (int i = 0; i < WIDTH; i++) {
            heatGrid.placeSource("l", i, i);
        }

        // Now try to place a bunch of glaciers along the diagonal
        for (int i = 0; i < WIDTH; i++) {
            assertFalse(heatGrid.placeSource("g", i, i));
        }
    }

    @Test
    public void TestPlaceSourceSuccess() throws Exception {
        // Place a bunch of furnaces along the diagonal
        for (int i = 0; i < HEIGHT; i++) {
            assertTrue(heatGrid.placeSource("f", i, i));
        }
    }

    @Test
    public void TestPlaceLightBulb() throws Exception {
        heatGrid.placeSource("l", 0, 0);
        int[][] lightbulb = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        checkGrid(lightbulb);
    }

    @Test
    public void TestPlaceCampfire() throws Exception {
        heatGrid.placeSource("c", 3, 2);
        int[][] campfire = {
                {0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 1, 2, 2, 2, 1, 0, 0, 0},
                {0, 1, 2, 4, 2, 1, 0, 0, 0},
                {0, 1, 2, 2, 2, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        checkGrid(campfire);
    }

    @Test
    public void TestPlaceFurnace() throws Exception {
        heatGrid.placeSource("f", 4, 4);
        int[][] furnace = {
                {2, 2, 2, 2, 2,  2, 2, 2, 2},
                {2, 3, 3, 3, 3,  3, 3, 3, 2},
                {2, 3, 4, 4, 4,  4, 4, 3, 2},
                {2, 3, 4, 7, 7,  7, 4, 3, 2},
                {2, 3, 4, 7, 10, 7, 4, 3, 2},
                {2, 3, 4, 7, 7,  7, 4, 3, 2},
                {2, 3, 4, 4, 4,  4, 4, 3, 2},
                {2, 3, 3, 3, 3,  3, 3, 3, 2}
        };
        checkGrid(furnace);
    }

    @Test
    public void TestPlaceIceCube() throws Exception {
        heatGrid.placeSource("i", 3, 2);
        int[][] icecube = {
                {0, 0,  0,  0,  0, 0, 0, 0, 0},
                {0, 0, -1, -1, -1, 0, 0, 0, 0},
                {0, 0, -1, -2, -1, 0, 0, 0, 0},
                {0, 0, -1, -1, -1, 0, 0, 0, 0},
                {0, 0,  0,  0,  0, 0, 0, 0, 0},
                {0, 0,  0,  0,  0, 0, 0, 0, 0},
                {0, 0,  0,  0,  0, 0, 0, 0, 0},
                {0, 0,  0,  0,  0, 0, 0, 0, 0}
        };
        checkGrid(icecube);
    }

    @Test
    public void TestPlaceFridge() throws Exception {
        heatGrid.placeSource("r", 3, 3);
        int[][] fridge = {
                {-4, -4, -4, -4, -4, -4, -4, 0, 0},
                {-4, -5, -5, -5, -5, -5, -4, 0, 0},
                {-4, -5, -6, -6, -6, -5, -4, 0, 0},
                {-4, -5, -6, -8, -6, -5, -4, 0, 0},
                {-4, -5, -6, -6, -6, -5, -4, 0, 0},
                {-4, -5, -5, -5, -5, -5, -4, 0, 0},
                {-4, -4, -4, -4, -4, -4, -4, 0, 0},
                { 0,  0,  0,  0,  0,  0,  0, 0, 0}
        };
        checkGrid(fridge);
    }

    @Test
    public void TestPlaceGlacier() throws Exception {
        heatGrid.placeSource("g", 4, 3);
        int[][] glacier = {
                {-10, -12, -12, -12, -12, -12, -12, -12, -10},
                {-10, -12, -14, -14, -14, -14, -14, -12, -10},
                {-10, -12, -14, -17, -17, -17, -14, -12, -10},
                {-10, -12, -14, -17, -20, -17, -14, -12, -10},
                {-10, -12, -14, -17, -17, -17, -14, -12, -10},
                {-10, -12, -14, -14, -14, -14, -14, -12, -10},
                {-10, -12, -12, -12, -12, -12, -12, -12, -10},
                {-10, -10, -10, -10, -10, -10, -10, -10, -10}
        };
        checkGrid(glacier);
    }


    @Test
    public void TestGetHeatEmpty() throws Exception {
        // Make sure the grid has no heat
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                assertEquals(0, heatGrid.getHeat(j, i));
            }
        }
    }

    @Test
    public void TestGetHeatFig1() throws Exception {
        heatGrid.placeSource("c", 3, 2);
        int[][] fig1 = {
                {0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 1, 2, 2, 2, 1, 0, 0, 0},
                {0, 1, 2, 4, 2, 1, 0, 0, 0},
                {0, 1, 2, 2, 2, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        checkGrid(fig1);
    }

    @Test
    public void TestGetHeatFig2() throws Exception {
        heatGrid.placeSource("c", 3, 2);
        heatGrid.placeSource("i", 6, 2);
        int[][] fig2 = {
                {0, 1, 1, 1, 1, 1,  0,  0, 0},
                {0, 1, 2, 2, 2, 0, -1, -1, 0},
                {0, 1, 2, 4, 2, 0, -2, -1, 0},
                {0, 1, 2, 2, 2, 0, -1, -1, 0},
                {0, 1, 1, 1, 1, 1,  0,  0, 0},
                {0, 0, 0, 0, 0, 0,  0,  0, 0},
                {0, 0, 0, 0, 0, 0,  0,  0, 0},
                {0, 0, 0, 0, 0, 0,  0,  0, 0}
        };
        checkGrid(fig2);
    }

    @Test
    public void TestGetHeatFig3() throws Exception {
        heatGrid.placeSource("c", 3, 2);
        heatGrid.placeSource("i", 6, 2);
        heatGrid.placeSource("r", 8, 7);
        int[][] fig3 = {
                {0, 1, 1, 1, 1,  1,  0,  0,  0},
                {0, 1, 2, 2, 2,  0, -1, -1,  0},
                {0, 1, 2, 4, 2,  0, -2, -1,  0},
                {0, 1, 2, 2, 2,  0, -1, -1,  0},
                {0, 1, 1, 1, 1, -3, -4, -4, -4},
                {0, 0, 0, 0, 0, -4, -5, -5, -5},
                {0, 0, 0, 0, 0, -4, -5, -6, -6},
                {0, 0, 0, 0, 0, -4, -5, -6, -8}
        };
        checkGrid(fig3);
    }

    @Test
    public void TestGetHeatFig3A() throws Exception {
        heatGrid.placeSource("c", 3, 2);
        heatGrid.placeSource("i", 6, 2);
        heatGrid.placeSource("r", 8, 7);
        heatGrid.placeSource("f", 0, 7);
        int[][] fig3a = {
                {0,  1, 1, 1, 1,  1,  0,  0,  0},
                {0,  1, 2, 2, 2,  0, -1, -1,  0},
                {0,  1, 2, 4, 2,  0, -2, -1,  0},
                {2,  3, 4, 4, 4,  0, -1, -1,  0},
                {3,  4, 4, 4, 3, -3, -4, -4, -4},
                {4,  4, 4, 3, 2, -4, -5, -5, -5},
                {7,  7, 4, 3, 2, -4, -5, -6, -6},
                {10, 7, 4, 3, 2, -4, -5, -6, -8}
        };
        checkGrid(fig3a);
    }

    @Test
    public void TestGetHeats() throws Exception {
        heatGrid.placeSource("c", 3, 2);
        heatGrid.placeSource("i", 6, 2);
        heatGrid.placeSource("r", 8, 7);
        heatGrid.placeSource("l", 0, 7);
        int[][] expected = {
                {0, 1, 1, 1, 1,  1,  0,  0,  0},
                {0, 1, 2, 2, 2,  0, -1, -1,  0},
                {0, 1, 2, 4, 2,  0, -2, -1,  0},
                {0, 1, 2, 2, 2,  0, -1, -1,  0},
                {0, 1, 1, 1, 1, -3, -4, -4, -4},
                {0, 0, 0, 0, 0, -4, -5, -5, -5},
                {0, 0, 0, 0, 0, -4, -5, -6, -6},
                {1, 0, 0, 0, 0, -4, -5, -6, -8}
        };

        int[][] heats = heatGrid.getHeats();
        assertArrayEquals(expected, heats);
    }

    @Test
    public void TestGetNetHeat() throws Exception {
        heatGrid.placeSource("c", 3, 2);
        heatGrid.placeSource("i", 6, 2);
        heatGrid.placeSource("r", 8, 7);
        heatGrid.placeSource("l", 0, 7);
        assertEquals(-52, heatGrid.getNetHeat());
    }

    private void checkGrid(int[][] expected) throws Exception {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                boolean match = expected[i][j] == heatGrid.getHeat(j, i);
                if (!match) {
                    System.out.println("Difference at (x, y) = (" + j + ", " + i + ")");
                    printGrid(heatGrid);
                }
                assertEquals(expected[i][j], heatGrid.getHeat(j, i));
            }
        }
    }

    private void printGrid(HeatGrid heatGrid) {
        System.out.println("Your Grid");
        int[][] grid = heatGrid.getHeats();
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}