package com.ben.aoc;


import java.util.List;

public class Parcel {
    boolean [][] parcel = new boolean[3][3];
    int countSet = 0;

    public Parcel(List<String> layout){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                parcel[i][j] = layout.get(i).charAt(j) == '#';
                if(parcel[i][j]){
                    countSet++;
                }
            }
        }
    }

    public boolean[][] apply(boolean[][] grid, int row, int col, int rotation, boolean flipEW, boolean flipNS){
        boolean[][] out = new boolean[grid.length][grid[0].length];
        for(int i =0; i<grid.length; i++){
            System.arraycopy(grid[i], 0, out[i], 0, grid[i].length);
        }

        for(int rot = 0 ; rot < rotation; rot++){
            parcel = Util.rotateMatrix(parcel);
        }

        if(flipEW) parcel = Util.flipMatrixEW(parcel);
        if(flipNS) parcel = Util.flipMatrixNS(parcel);

        boolean fits = true;
        outer:
        for(int r = 0; row < 3; row++) {
            for(int c = 0; col < 3; col++) {
                if(!this.parcel[r][c]) continue;
                if(!out[row+r][col+c]) {
                    out[row+r][col+c] = true;
                }else {
                    fits = false;
                    break outer;
                }
            }
        }
        if(flipNS) parcel = Util.flipMatrixNS(parcel);;
        if(flipEW) parcel = Util.flipMatrixEW(parcel);
        for(int i = 4-rotation; i < 4; i++) {
            parcel = Util.rotateMatrix(parcel);
        }

        return fits? out : null;
    }

}
