package com.zichen.synchronizedpack.keywords;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock extends ReentrantLock {

    @Override
    public void lock() {
        super.lock();
    }

    @Override
    public void unlock() {
        super.unlock();
    }
}
