import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Анна
 * Date: 19.02.13
 * Time: 10:05
 * To change this template use File | Settings | File Templates.
 */
public class PercolationTest {
    @Test
    public void testOpen() {
        final Percolation p = new Percolation(4);
        p.open(1, 1);
        assertTrue(p.isOpen(1, 1));
        p.open(1, 2);
        assertTrue(p.isOpen(1, 2));
        assertFalse(p.isOpen(1, 3));
    }


    @Test
    public void testIsFull() throws Exception {
        final Percolation p = new Percolation(4);
        p.open(1, 1);
        assertFalse(p.isFull(1, 2));
        p.open(1, 2);
        assertTrue(p.isFull(1, 2));
    }

    @Test
    public void testIsFullFirstLine() throws Exception {
        final Percolation p = new Percolation(4);
        assertFalse(p.isFull(1, 1));
        p.open(1, 1);
        assertTrue(p.isFull(1, 1));
    }

    @Test
    public void testIsFullConnection3() throws Exception {
        final Percolation p = new Percolation(4);
        p.open(1, 1);
        p.open(2, 1);
        p.open(4, 3);
        p.open(3, 3);
        p.open(3, 4);
        p.open(3, 2);
        p.open(3, 1);
        assertTrue(p.isFull(3, 4));
    }

    @Test
    public void testIsFullConnection2() throws Exception {
        final Percolation p = new Percolation(4);
        p.open(2, 2);
        p.open(3, 2);
        p.open(4, 2);
        assertFalse(p.isFull(4, 2));

    }

    @Test
    public void testIsFullConnection1() throws Exception {
        final Percolation p = new Percolation(4);
        p.open(1, 2);
        p.open(3, 2);
        p.open(2, 2);
        assertTrue(p.isFull(3, 2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionIzero() {
        final Percolation p = new Percolation(4);
        p.open(0, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionJzero() {
        final Percolation p = new Percolation(4);
        p.open(3, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionIbig() {
        final Percolation p = new Percolation(4);
        p.open(10, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionJbig() {
        final Percolation p = new Percolation(4);
        p.open(2, 16);
    }

    @Test
    public void testPercolates1() throws Exception {
        final Percolation p = new Percolation(4);
        assertFalse(p.percolates());
    }

    @Test
    public void testPercolates2() throws Exception {
        final Percolation p = new Percolation(4);
        p.open(1, 2);
        p.open(2, 2);
        p.open(3, 2);
        p.open(4, 2);
        assertTrue(p.percolates());
    }

    @Test
    public void testPercolates3() throws Exception {
        final Percolation p = new Percolation(4);
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                p.open(i, j);
            }
        }
        assertTrue(p.percolates());
    }

    @Test
    public void testPercolates4() throws Exception {
        final Percolation p = new Percolation(4);
        int i = 1;
        for (int j = 1; j <= 4; j++) {
            p.open(i, j);
        }
        assertFalse(p.percolates());
    }

    @Test
    public void testPercolates5() throws Exception {
        final Percolation p = new Percolation(4);
        int i = 4;
        for (int j = 1; j <= 4; j++) {
            p.open(i, j);
        }
        assertFalse(p.percolates());
    }

    @Test
    public void testPercolates6() throws Exception {
        final Percolation p = new Percolation(4);
        p.open(1, 1);
        p.open(2, 1);
        p.open(4, 1);
        p.open(4, 3);
        p.open(3, 3);
        p.open(4, 4);
        assertFalse(p.percolates());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsFullexeption1() {
        final Percolation p = new Percolation(4);
        p.isFull(0, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsFuLLexception2() {
        final Percolation p = new Percolation(4);
        p.isFull(2, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsFuLLexception3() {
        final Percolation p = new Percolation(4);
        p.isFull(10, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsFuLLexception4() {
        final Percolation p = new Percolation(4);
        p.isFull(3, 15);
    }
}
