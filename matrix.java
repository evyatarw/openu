/********************************************
* this class organize data of food products *
*                                           *
* @author Evyatar Weinberg                  *
* @version 2020a                            *
*********************************************/

public class Matrix
{
    //declaration:
    public int number;
    private final int MAX_NUMBER = 255;
    int[][] Matrix;
    
    //constructors:
    /**
    * constructs a Matrix from a two-dimensional array;
    * the dimensions as well as the values of this metrix will be the same as the dimensions
    * and values of the two-dimensional array
    */
    public Matrix (int[][]array) {
        Matrix = new int[array.length][array[0].length]; 
        for(int i=0; i<Matrix.length; i++)
        {
            for(int j=0; j<Matrix[0].length; j++)
            {
                Matrix[i][j] = array[i][j];
            }
        }
    }
    
    /**
    * constructs a size1 by size2 Matrix of zeroes
    */
    public Matrix (int size1, int size2) {
        Matrix = new int[size1][size2];
        for(int i=0; i<size1; i++)
        {
            for(int j=0; j<size2; j++)
            {
                Matrix[i][j] = 0;
            }
        }
    }
    //methods:
    /**
     * returns a String that represents the values in Matrix
     * @return String that represents the values in Matrix
     */
    public String toString() {
        String values;
        values = "";
        for(int i=0; i<Matrix.length; i++)
        {
            for(int j=0; j<Matrix[0].length; j++)
            {
                if(j != 0)
                    values += "\t";
                values += Matrix[i][j];
            }
            values += "\n";
        }
        return values;
    }
    
    /**
     * returns a negative Image
     * @return negative Image
     */
    public Matrix makeNegative() {
        int[][] _negative = new int[Matrix.length][Matrix[0].length]; 
        for(int i=0; i<_negative.length; i++)
        {
            for(int j=0; j<_negative[0].length; j++)
            {
                _negative[i][j] = MAX_NUMBER - Matrix[i][j];
            }
        }
        Matrix negative = new Matrix(_negative);
        return negative;
    }
    
    /**
     * returns *******
     * @return ******
     */
    public Matrix imageFilterAverage() {
        int[][] _imageFilterAverage = new int [Matrix.length][Matrix[0].length];
        int imageFilterAveragelength = _imageFilterAverage.length-1;
        int imageFilterAverage0length = _imageFilterAverage[0].length-1;
        for(int i=0; i<Matrix.length; i++)
        {
            for(int j=0; j<Matrix[0].length; j++)
            {
                if(i==0)
                {
                    if(j==0)
                        _imageFilterAverage[i][j] = (Matrix[i][j] + Matrix[i+1][j]
                        + Matrix[i][j+1] + Matrix[i+1][j+1])/4;
                    if(j==imageFilterAverage0length)
                        _imageFilterAverage[i][j] = (Matrix[i][j] + Matrix[i+1][j]
                        + Matrix[i][j-1] + Matrix[i+1][j-1])/4;
                    if(j!=imageFilterAverage0length && j!=0)
                        _imageFilterAverage[i][j] = (Matrix[i][j] + Matrix[i+1][j]
                        + Matrix[i][j+1] + Matrix[i+1][j+1] + Matrix[i][j-1]
                        + Matrix[i+1][j-1])/6;
                }
                if(i==imageFilterAveragelength)
                {
                    if(j==0)
                        _imageFilterAverage[i][j] = (Matrix[i][j] + Matrix[i-1][j]
                        + Matrix[i][j+1] + Matrix[i-1][j+1])/4;
                    if(j==imageFilterAverage0length)
                        _imageFilterAverage[i][j] = (Matrix[i][j] + Matrix[i-1][j]
                        + Matrix[i][j-1] + Matrix[i-1][j-1])/4;
                    if(j!=imageFilterAverage0length && j!=0)
                        _imageFilterAverage[i][j] = (Matrix[i][j] + Matrix[i-1][j]
                        + Matrix[i][j-1] + Matrix[i-1][j-1] + Matrix[i][j+1]
                        + Matrix[i-1][j+1])/6;
                }
                if(i!=0 && i!=imageFilterAveragelength)
                {
                    if(j==0)
                        _imageFilterAverage[i][j] = (Matrix[i][j] + Matrix[i-1][j]
                        + Matrix[i][j+1] + Matrix[i-1][j+1] +Matrix[i+1][j]
                        + Matrix[i+1][j+1])/6;
                    if(j==imageFilterAverage0length)
                        _imageFilterAverage[i][j] = (Matrix[i][j] + Matrix[i-1][j]
                        + Matrix[i][j-1] + Matrix[i-1][j-1] + Matrix[i+1][j]
                        + Matrix[i+1][j-1])/6;
                    if(j!=imageFilterAverage0length && j!=0)
                        _imageFilterAverage[i][j] = (Matrix[i][j] + Matrix[i-1][j]
                        + Matrix[i][j-1] + Matrix[i-1][j-1] + Matrix[i][j+1]
                        + Matrix[i-1][j+1] +Matrix[i+1][j]
                        + Matrix[i+1][j+1] + Matrix[i+1][j-1])/9;
                }
            }
        }
        Matrix imageFilterAverage = new Matrix(_imageFilterAverage);
        return imageFilterAverage;
    }
    
    /**
     * returns *******
     * @return ******
     */
    public Matrix rotateClockwise() {
        int[][] _rotateClockwise = new int [Matrix[0].length][Matrix.length];
        for(int i=0; i<(Matrix.length); i++)
        {
            for(int j=0; j<(Matrix[0].length); j++)
            {
                _rotateClockwise[j][Matrix.length-1-i] = Matrix[i][j];
            }
        }
        Matrix rotateClockwise = new Matrix(_rotateClockwise);
        return rotateClockwise;
    }
    
    /**
     * returns *******
     * @return ******
     */
    public Matrix rotateCounterClockwise() {
        int[][] _rotateCounterClockwise = new int [Matrix[0].length][Matrix.length];
        for(int i=0; i<(Matrix.length); i++)
        {
            for(int j=0; j<(Matrix[0].length); j++)
            {
                _rotateCounterClockwise[Matrix[0].length-1-j][i] = Matrix[i][j];
            }
        }
        Matrix rotateCounterClockwise = new Matrix(_rotateCounterClockwise);
        return rotateCounterClockwise;
    }
}
