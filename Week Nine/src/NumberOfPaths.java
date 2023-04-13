import java.util.HashMap;

public class NumberOfPaths {
    public static int NumberOfPaths(int sizeX, int sizeY){
        HashMap<Grid, Integer> memo = new HashMap<Grid, Integer>();
        HashMap<Integer, Grid> grids = new HashMap<Integer, Grid>();
        if (sizeX ==1 | sizeY ==1)
            return 1;
        if(sizeX ==0 | sizeY ==0)
            return 0;
        grids.put(0, new Grid(sizeX,sizeY));
        memo.put(grids.get(0), (NumberOfPaths(sizeX-1, sizeY, memo, grids)+NumberOfPaths(sizeX,sizeY-1, memo, grids)));
        return(memo.get(grids.get(0)));
    }
    public static int NumberOfPaths(int sizeX, int sizeY, HashMap<Grid, Integer> memo, HashMap<Integer, Grid> grids){
        if(memo.get(getGridBySize(sizeX, sizeY, grids)) != null){
            return memo.get(getGridBySize(sizeX, sizeY, grids));
        }
        if (sizeX ==1 | sizeY ==1)
            return 1;
        grids.put(grids.size()+1,new Grid(sizeX, sizeY));
        memo.put(getGridBySize(sizeX, sizeY, grids), (NumberOfPaths(sizeX-1, sizeY)+NumberOfPaths(sizeX,sizeY-1)));
        return(memo.get(getGridBySize(sizeX, sizeY, grids)));
    }
    static Grid getGridBySize(int sizeX, int sizeY, HashMap<Integer, Grid> grids){
        for (Grid i : grids.values()){
            if ((i.sizeX==sizeX | i.sizeX==sizeY ) & (i.sizeY==sizeY | i.sizeY==sizeX)){
                return i;
            }
        }
        return null;
    }
    static class Grid{
        int sizeX;
        int sizeY;
        public Grid(int sizeX, int sizeY){
            this.sizeX = sizeX;
            this.sizeY = sizeY;
        }
    }

}

