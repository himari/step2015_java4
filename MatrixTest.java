import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixTest {

	@Test

	public void test() {

	double [][] a={{1,0,0},{0,1,0},{0,0,1}};

	double [][] b={{1,0,0},{0,2,0},{0,0,3}};

	double [][] c={{1,0,0},{0,2,0},{0,0,3}};

	double [][] d={{1.00,0.1,10},{0,0,0},{0,0,0}};

	double [][] e={{2147483647,0,0},{0,-2,0},{0,0,-1}};

	double [][] f={{2147483647,-0.2,-10},{0,0,0},{0,0,0}};

	double [][] g={{1}};

	double [][] h={{2}};

	double [][] k={{2}};

	//readmat check

	//assertNotNull();

	//cal check

	assertArrayEquals(c,(Matrix.calc(a,b,3)));

	assertArrayEquals(f,(Matrix.calc(d,e,3)));

	assertArrayEquals(k,(Matrix.calc(g,h,1)));

	//main

	//assertEquals();

	}

	}