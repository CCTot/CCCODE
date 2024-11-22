import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class Goods<T>{
    private T info;

    public Goods(T info){
        this.info = info;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public T getInfo(){
        return this.info;
    }
}

public class Main{
    public static void main(String[] args) {

        Goods goods = new Goods<Integer>(666);
        System.out.println(goods.getInfo()+"..."+goods.getInfo().getClass());
        goods.setInfo("热卖商品");
        System.out.println(goods.getInfo()+"..."+goods.getInfo().getClass());

        String s =" 456";
        "4646".length();

    }
}
