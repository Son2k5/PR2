package Tut9.problem3;
import java.io.*;


public class Matrix implements Serializable{
    private int cols;
    private int rows;
    double[][] matrix;
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new double[rows][cols];
    }
    public void setValue(int row, int col, double value) {
        matrix[row][col] = value;
    }
    public void setData(double[][] matrix){
        this.matrix = matrix;
    }
    public Matrix sum(Matrix m){
        if(this.rows != m.rows || this.cols != m.cols){
            return null;
        }
        Matrix result = new Matrix(this.rows, this.cols);
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
            }
        }
        return result;
    }
    public double[][] transpose(){
        double[][] result = new double[cols][rows];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[j][i] = this.matrix[i][j];
            }
        }
        return result;
    }
    public Matrix product(Matrix m){
        if(this.cols != m.rows) return null;
        Matrix result = new Matrix(this.rows, m.cols);
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < m.cols; j++) {
                for(int k = 0; k < this.cols; k++) {
                    result.matrix[i][j] += this.matrix[i][k] * m.matrix[k][j];
                }
            }
        }
        return result;
    }
    public static Matrix read(String fileName) throws NotPossibleException{
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Matrix) ois.readObject();
        }catch(Exception e){
            throw new NotPossibleException(("Ivalid matrix file"));
        }
    }
    public void save(String fileName) throws java.io.IOException , NotPossibleException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
              oos.writeObject(this);
        }catch(Exception e){
            throw new NotPossibleException("Invalid matrix file");
        }
    }
    public void print(){
        for(int i = 0; i < this.matrix.length; i++) {
            System.out.print("[");
            for(int j = 0; j < this.matrix[i].length; j++) {
                System.out.print(this.matrix[i][j]);
                if(j < this.matrix[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
