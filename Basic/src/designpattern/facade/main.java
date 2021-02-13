package designpattern.facade;

/**
 * 外观设计模式
 */
public class main {
    public static void main(String[] args){
        ImessageManager imessageManager = new MessageFacade();
        imessageManager.pushMessage();
    }

}
