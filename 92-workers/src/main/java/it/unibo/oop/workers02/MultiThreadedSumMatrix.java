package it.unibo.oop.workers02;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class MultiThreadedSumMatrix implements SumMatrix {

    private final int nthread;

    /**
     * 
     * @param nthread number of threads which will perform the sum
     */
    public MultiThreadedSumMatrix(final int nthread) {
        this.nthread = nthread;
    }

    private static class Worker extends Thread {

        private final double[][] matrix;
        private final int startRow, startCol, nElem;
        private double res;

        Worker(final double[][] matrix, final int startRow, final int startCol, final int nElem) {
            this.matrix = matrix;
            this.startRow = startRow;
            this.startCol = startCol;
            this.nElem = nElem;
        }

        @Override
        public void run() {

            System.out.println("Starting from [" + this.startRow + ", " + 
                this.startCol + "] summing " + this.nElem);

            int row = this.startRow, col = this.startCol;
            //System.out.println("AO " + startCol + " BABY " + startRow + " ROBE " + matrix[startRow][startCol]);

            for (int n = 0; n < this.nElem; n++) {
                if (!isWithinBoundary(col, this.matrix[0].length)) {
                    row += 1;
                    col = 0;
                }

                if (isWithinBoundary(row, this.matrix.length)) {
                    this.res += this.matrix[row][col];
                }

                col++;
            }
        }

        private boolean isWithinBoundary(final int index, final int threshold) {
            if (index >= threshold) {
                return false;
            }

            return true;
        }

        public double getResult() {
            return this.res;
        }
    }

    @Override
    public double sum(final double[][] matrix) {
        final int rows = matrix.length, columns = matrix[0].length;
        final int size = rows * columns;
        final int parts = size % nthread + size / nthread;

        final List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < size; i += parts) {
            workers.add(new Worker(matrix, i != 0 ? i / rows - 1 : i / rows, i % columns, parts));
        }

        for (final Worker w : workers) {
            w.start();
        }

        double result = 0;
        for (final Worker w : workers) {
            try {
                w.join();
                result += w.getResult();
            } catch (final InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        }

        return result;
    }
}
