package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observerList = new ArrayList<>();

    /**
     * 新增观察者
     */
    public void addObserver(Observer observer){
        this.observerList.add(observer);
    }

    /**
     * 删除观察者
     * @param observer
     */
    public void removeObserver(Observer observer){
        this.observerList.remove(observer);
    }

    /**
     * 通知所有的观察者
     */
    public void notifyAllObserver(){
        for(Observer observer: this.observerList){
            observer.update();
        }
    }

}
