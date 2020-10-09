package com.example.kafka.demo.designPattern;

/**
 * 职责链模式：核心是构造链表结构，并逐个调用
 */
public class ChainOfResponsibility {
}


abstract class Handler{
    private Handler nextHandler;

    public abstract void handleRequest(String request);

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

class Handler1 extends Handler{

    @Override
    public void handleRequest(String request) {
        System.out.println("filter1"+request);
        if(getNextHandler() != null){
            getNextHandler().handleRequest(request);
        }
    }
}

class Handler2 extends Handler{

    @Override
    public void handleRequest(String request) {
        System.out.println("filter2"+request);
        if(getNextHandler() != null){
            getNextHandler().handleRequest(request);
        }
    }
}

class Test{
    public static void main(String[] args) {
        Handler handler1 = new Handler1();
        Handler2 handler2 = new Handler2();
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(new Handler1());
        handler1.handleRequest("1111");
    }
}
