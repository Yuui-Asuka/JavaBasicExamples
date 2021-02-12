package designpattern.flyweight;

import designpattern.facade.MailMessageManager;

import java.util.HashMap;
import java.util.Map;

public class WebsiteFactory {

    private Map<String, ConcreteWebsite> map = new HashMap<>();

    public CloudWebSite getWebSiteByKey(String category){
        if (map.containsKey(category)){
            return map.get(category);
        }
        else {
            ConcreteWebsite site = new ConcreteWebsite(category);
            map.put(category, site);
            return site;
        }
    }

    public int getWebsiteCategorySize(){
        return map.size();
    }
}
