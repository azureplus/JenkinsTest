package com.renny.jenkinstest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyAidlService extends Service {
    private final String TAG = "Server";

    private List<Book> bookList;
    public void onCreate() {
        super.onCreate();
        bookList = new ArrayList<>();
        initData();
    }

    private void initData() {
        Book book1 = new Book("活着");
        Book book2 = new Book("或者");
        Book book3 = new Book("叶应是叶");
        Book book4 = new Book("https://github.com/leavesC");
        Book book5 = new Book("http://www.jianshu.com/u/9df45b87cfdf");
        Book book6 = new Book("http://blog.csdn.net/new_one_object");
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
    }

    //客户端绑定service时会执行
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    private IBinder iBinder = new IImoocAIDL.Stub(){

        @Override
        public int add(int num1, int num2) throws RemoteException {
            Log.e("TAG","收到了来自客户端的请求" + num1 + "+" + num2+"   "+android.os.Process.myPid());
            return num1 + num2;
        }

        @Override
        public String getData() throws RemoteException {
            return "xxx";
        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return bookList;
        }

        @Override
        public void addBookInOut(Book book) throws RemoteException {
            if (book != null) {
                book.setName("服务器改了新书的名字 InOut");
                bookList.add(book);
            } else {
                Log.e(TAG, "接收到了一个空对象 InOut");
            }
        }


    };

}
