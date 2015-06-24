import java.io.*;	
	class Matrix {
		static double[][] matrixreader(int n){ //reads and returns it
		double[][] an = new double[n][n];
		int i=0;
		BufferedReader stdReader =
		new BufferedReader(new InputStreamReader(System.in)); 
		try { System.out.println("1. input number2: ");
		String line1; 
			while ((line1 = stdReader.readLine()) != null) { 
		String[] strs = line1.split(" "); //inputs here
			if(strs.length != n){ //check's legnth
		System.out.println("error::input"+n+"numbers!! again!");
		continue;
		}
			for (int t = 0; t< n; t++) {
		an[i][t] =Double.parseDouble(strs[t]);
			if(an[i][t]>Double.MAX_VALUE||an[i][t]<Double.MIN_VALUE){ 
		System.out.println("error::input Double.min<x<Double.max");
		System.exit(-1);
		}
		}
		i++;
			if(i>=n)break;//break when done
		System.out.println("2. input number1:");} 
		}catch(NumberFormatException e ){
		System.out.println("input NUMBERS!");
		System.exit(-1);
		}
		catch (Exception e) {
		System.out.println("\nError");
		System.exit(-1);
		}
			for (int k = 0; k < n; k++) {
				for (int j = 0; j < n; j++) { 
		System.out.printf("input[%d][%d]=%f\n", k, j, an[k][j]);
		}
		}
		return an;
		}
		static double[][] calc(double[][] a, double[][] b,int n){
		int i,j,k= 0;
		double[][] c = new double[n][n]; // Matrix C
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					for(k=0;k<n;k++){
		c[i][j] += a[i][k]*b[k][j];
		}
		}
		} 
		return c;
		}
		public static void main(String[] args){
			if (args[0].length() != 1) {
		System.out.println("usage: java Matrix N");
		return;
		}
		try{
		int n = Integer.parseInt(args[0]);
			if(n<1){
		System.out.println("N>0");
		System.exit(-1);
		}
		

		double[][] a = new double[n][n]; // Matrix A
		double[][] b = new double[n][n]; // Matrix B
		double[][] c = new double[n][n]; // Matrix C
		// Initialize the matrices to some values.
		int i, j;
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
		a[i][j] = 0;
		b[i][j] = 0;
		c[i][j] = 0;
		}
		}
		System.out.println("Input mat A");
			a = matrixreader(n);
		System.out.println("\nnext Input mat B");
			b=  matrixreader(n);
		System.out.println("result");
			c =calc(a,b,n);

		// Write code to calculate C = A * B.
			for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
		System.out.printf("c[%d][%d]=%f\n", i, j, c[i][j]);
				}
			}
		}catch(NumberFormatException e){
		System.out.println("insert int N >0");
				}
			}
		}