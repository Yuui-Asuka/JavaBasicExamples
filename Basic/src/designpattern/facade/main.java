package designpattern.facade;

public class main {
    public static void main(String[] args){
        ImessageManager imessageManager = new MessageFacade();
        imessageManager.pushMessage();
    }

}
