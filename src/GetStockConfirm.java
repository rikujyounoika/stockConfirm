import Bean.InforSet;
import logic.GetPageInfo;

import java.util.ArrayList;
import java.util.List;

public class GetStockConfirm {

    public static void main(String[] args) {
        InforSet inforSet = new InforSet();
        inforSet.setGoodsList("https://www.yodobashi.com/product/100000001003017004/");
        inforSet.setGoodsList("https://www.yodobashi.com/product/100000001004734494/");


        for(int i = 0 ; i < inforSet.getGoodsList().size(); i++){
            GetPageInfo getPageInfo = new GetPageInfo(inforSet.getGoodsList().get(i));
            getPageInfo.getElement();
        }

    }
}
