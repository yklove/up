package cn.yklove.reactive;

public interface MyEventListener {
        void onNewEvent(MyEventSource.MyEvent event);
        void onEventStopped();
    }