package itp341.yang.chingchuan.a10;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Jin Yang on 4/5/2017.
 */

public class StockManager {
    private static StockManager instance;
    ArrayList<Stock> stockList;
    private int count;

    Context context;

    StockManager(Context context)
    {
        this.context = context;
    }
    protected StockManager(){
        stockList = new ArrayList<Stock>();
    }


    public static StockManager getInstance() {
        if(instance == null)
            instance = new StockManager();
        return instance;
    }

    public void add(Stock s){
        stockList.add(s);
        count++;
    }
    public int getSize(){
        return stockList.size();
    }
    public int getIndex(){
        return count+1;
    }

    public void removeFromRecord(int i){
        stockList.remove(i);
    }

    public void sellStock(int i){
        stockList.get(i).sellStock();
    }

    public void sellAll(int i){
        stockList.get(i).sellAll();
    }

    public void buyStock(int i){
        stockList.get(i).buyStock();
    }

}
