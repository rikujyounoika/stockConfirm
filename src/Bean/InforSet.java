package Bean;

import java.util.ArrayList;
import java.util.List;

public class InforSet {
    public List<String> goodsList = new ArrayList<String>();
    String url = "";
    public void setGoodsList(String url) {
        this.goodsList.add(url);
    }

    public List<String> getGoodsList() {
        return goodsList;
    }
}
