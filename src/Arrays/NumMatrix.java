package Arrays;
/**
 * 
 */

/**
 * @author blessonm
 *
 */
public class NumMatrix {

	/**
	 * @param args
	 */
	int[][] matrix;
	int[][] fullSum;
	int[][] leftSum;
	int[][] rightSum;
	Boolean empty;
	
	public static void main(String[] args) {
		NumMatrix numMatrix = new NumMatrix(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
		System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
	}
	
	public NumMatrix(int[][] matrix) {
		this.matrix = matrix;
		if(matrix.length==0) empty = true;
		else empty = false;
		if(!empty){
			fullSum = new int[matrix.length][matrix[0].length];
			fillMatrices();
		}
    }
	
	public int fillMatrices(){
		fullSum[0][0] = matrix[0][0];
		for(int i=0; i<matrix.length; i++){
			if(i>0)
				fullSum[i][0] = matrix[i][0] + fullSum[i-1][matrix[0].length-1];
			for(int j=1; j<matrix[0].length; j++){
				fullSum[i][j] = matrix[i][j] + fullSum[i][j-1];
			}
		}
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				System.out.print(fullSum[i][j]+" ");
			}
			System.out.println();
		}
		return 0;
	}

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if(!empty){
	    	int sum = (fullSum[row2][col2]-fullSum[row1][col1])+matrix[row1][col1];
	    	System.out.println(sum);
	    	for(int i=row1; row1<row2; row1++){
	    		if(col1>0)
	    			sum -= ((fullSum[row1+1][col1]-fullSum[row1][col2])-matrix[row1+1][col1]);
	    		else
	    			sum -= ((fullSum[row1][matrix[0].length-1]-fullSum[row1][col2]));
	    		System.out.println(sum+"-="+fullSum[row1+1][col1]+"-"+fullSum[row1][col2]+"-"+matrix[row1+1][col1]);
	    	}
	        return sum;
    	}
    	else
    		return 0;
    }

}
