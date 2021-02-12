package designpattern.facade;

public class MessageFacade implements ImessageManager{

    private ImessageManager dingdingMsgManager = new DingDingMessageManager();

    private ImessageManager mailMsgManager = new MailMessageManager();

    private SmsMessageManager smsMessageManager = new SmsMessageManager();


    @Override
    public void pushMessage() {
        dingdingMsgManager.pushMessage();
        mailMsgManager.pushMessage();
        smsMessageManager.pushMessage();
    }
}
