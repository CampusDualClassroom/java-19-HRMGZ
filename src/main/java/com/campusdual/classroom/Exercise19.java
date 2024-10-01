package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length - 1; i++) {
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length - 1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int depth = intArrayTri.length;
        int rows = intArrayTri[0].length;
        int columns = intArrayTri[0][0].length;

        int[][] array = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int sum = 0;
                for (int k = 0; k < depth; k++) {
                    sum += intArrayTri[k][i][j];
                }
                array[i][j] = sum;
            }
        }

        return array;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder biString = new StringBuilder();
        for(int i = 0;i<intArrayBi.length; i++){
            biString.append( stringFlatMatrixRow(intArrayBi,i) );
           if(i != intArrayBi.length - 1) {
               biString.append("\n");
           }
        }
        return biString.toString();
    }

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder uniString = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            uniString.append(uniArray[i]);
            if (i != uniArray.length - 1) {
                uniString.append(" ");
            }
        }
        return uniString.toString();
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] array = new int[columns];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] array = new int[rows][columns];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i * array[i].length + j + 1;
            }
        }
        return array;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] array = new int[depth][rows][columns];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    array[i][j][k] = i * array[i].length * array[i][j].length + j * array[i][j].length + k + 1;
                }
            }
        }
        return array;


    }

    public static void main(String[] args) {

        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));


    }
}
