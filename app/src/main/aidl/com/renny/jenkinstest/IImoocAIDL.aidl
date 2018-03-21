// IImoocAIDL.aidl
package com.renny.jenkinstest;
import com.renny.jenkinstest.Book;
// Declare any non-default types here with import statements

interface IImoocAIDL {
    //计算num1 + num2
    int add(int num1,int num2);
    String  getData();

         List<Book> getBookList();

        void addBookInOut(inout Book book);
}
