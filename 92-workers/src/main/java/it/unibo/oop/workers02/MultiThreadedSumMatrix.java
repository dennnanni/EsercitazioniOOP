package it.unibo.oop.workers02;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.IvParameterSpec;

public final class MultiThreadedSumMatrix implements SumMatrix {

    private final int nthread;

    public MultiThreadedSumMatrix(final int nthread) {
        this.nthread = nthread;
    }

    private static class Worker extends Thread {
        private final double[][] matrix;
        private final int startRow, startCol;
        private double result;
        private final int nelem;

        Worker(final double[][] matrix, final int startX, final int startY, final int nelem) {
            this.matrix = matrix;
            this.startRow = startX;
            this.startCol = startY;
            this.nelem = nelem;
        }

        @Override
        public void run() {

            System.out.println("Working from [" + this.startRow + ", " + this.startCol + "]"); // NOPMD

            int row = this.startRow, col = this.startCol;

            for (int n = 0; n < this.nelem; n++) {
                if (!isWithinBoundary(col, this.matrix[0].length)) {
                    row += 1;
                    col = 0;
                }

                if (isWithinBoundary(row, this.matrix.length)) {
                    this.result += this.matrix[row][col];
                }

                col++;
            }
        }

        private boolean isWithinBoundary(final int value, final int boundary) {
            if (value >= boundary) {
                return false;
            }

            return true;
        }

        private double getResult() {
            return this.result;
        }
    }

    @Override
    public double sum(final double[][] matrix) {
        final int rows = matrix.length, columns = matrix[0].length;
        final int size = matrix.length * matrix[0].length;
        final int nelem = size % this.nthread + size / nthread;
       
        final List<Worker> workers = new ArrayList<>();
        for (int i = 0; i <= size; i += nelem) {
            workers.add(new Worker(matrix, i / rows, i % columns, nelem));
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