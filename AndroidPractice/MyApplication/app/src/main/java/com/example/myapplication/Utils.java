package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.ContentHandler;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;

public class Utils {

    private static final String ALL_BOOKS_KEY_ = "all_books";
    private static final String ALREADY_READ_BOOKS_KEY_ = "already_read_books";
    private static final String CURRENTLY_READING_BOOKS_KEY_ = "currently_reading_books";
    private static final String WANT_TO_READ_BOOKS_KEY_ = "want_to_read_books";
    private static final String FAVORITE_BOOKS_KEY_ = "favorite_books";
    private static Utils instance;
    private SharedPreferences sharedPreferences;

//    private static ArrayList<Book> AllBooks;
//
//    private static ArrayList<Book> AlreadyRead;
//
//    private static ArrayList<Book> WantToRead;
//
//    private static ArrayList<Book> CurrentlyReading;
//
//    private static ArrayList<Book> FavoriteBook;

    private Utils(Context context) {


        sharedPreferences = context.getSharedPreferences("Alternate DB" ,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (null==getAllBooks()){
            initData();
        }

        if (null == getAlreadyRead()){
            editor.putString(ALREADY_READ_BOOKS_KEY_ , gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getWantToRead()){
            editor.putString(WANT_TO_READ_BOOKS_KEY_ , gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getCurrentlyReading()){
            editor.putString(CURRENTLY_READING_BOOKS_KEY_ , gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getFavoriteBook()){
            editor.putString(FAVORITE_BOOKS_KEY_ , gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }

    }

    private void initData() {
        //TODO Add Initial Data
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1 , "1Q84" , "Haruki Murakami" , 1350 , "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1483103331l/10357575.jpg"
                ,"A work of maddening Brilliance" , "Long Description"));
        books.add(new Book(2 , "The Myth of Sysphius" , "Albert Camus" , 250 , "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9781/5169/9781516923182.jpg",
                "The Myth of Sisyphus is a 1942 philosophical essay by Albert Camus. Influenced by philosophers such as Søren Kierkegaard, Arthur Schopenhauer, and Friedrich Nietzsche, Camus introduces his philosophy of the absurd. ",
                "Long Description"));
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS_KEY_ , gson.toJson(books));
        editor.commit();
    }

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY_ , null) , type);
        return books;
    }

    public ArrayList<Book> getAlreadyRead() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS_KEY_ , null) , type);
        return books;
    }

    public ArrayList<Book> getWantToRead() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> book = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS_KEY_ , null) , type);
        return book;
    }

    public ArrayList<Book> getCurrentlyReading() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS_KEY_ , null) , type);
        return books;
    }

    public ArrayList<Book> getFavoriteBook() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> book = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS_KEY_ , null) , type);
        return book;
    }

    public static Utils getInstance(Context context) {
        if(null!=instance){
            return instance;
        }else{
            instance = new Utils(context);
            return instance;
        }
    }

    public Book getBookById(int Id){
        ArrayList<Book> books = getAllBooks();
        if (null != books){
            for (Book book :
                    books) {
                if (book.getId() == Id) {
                    return book;
                }
            }
        }

        return null;
    }

    public boolean removeFromAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyRead();
        if(null!= books){
            for (Book b:
                   books ) {
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS_KEY_);
                        editor.putString(ALREADY_READ_BOOKS_KEY_ , gson.toJson(books));
                        editor.commit();
                        return true;

                    }
                }

            }

        }

        return false;
    }
    public boolean removeFromCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyReading();
        if(null!= books){
            for (Book b:
                 books) {
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS_KEY_);
                        editor.putString(CURRENTLY_READING_BOOKS_KEY_ , gson.toJson(books));
                        editor.commit();
                        return true;

                    }

            }
            }

        }

        return false;

    }
    public boolean removeFromWantToRead(Book book){
        ArrayList<Book> books = getWantToRead();
        if(null!= books){
            for (Book b:
                    books ) {
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS_KEY_);
                        editor.putString(WANT_TO_READ_BOOKS_KEY_ , gson.toJson(books));
                        editor.commit();
                        return true;

                    }
                }

            }

        }

        return false;
    }
    public boolean removeFromFavorite(Book book){
        ArrayList<Book> books = getFavoriteBook();
        if(null!= books){
            for (Book b:
                    books ) {
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS_KEY_);
                        editor.putString(FAVORITE_BOOKS_KEY_ , gson.toJson(books));
                        editor.commit();
                        return true;

                    }
                }

            }

        }

        return false;
    }

    public boolean AddToAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyRead();
        if(null!=books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor   = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS_KEY_);
                editor.putString(ALREADY_READ_BOOKS_KEY_ , gson.toJson(books));
                editor.commit();
                return true;

            }
        }
        return false;
    }
    public boolean AddTowantoToRead(Book book){
        ArrayList<Book> books = getWantToRead();
        if(null!=books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor   = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS_KEY_);
                editor.putString(WANT_TO_READ_BOOKS_KEY_ , gson.toJson(books));
                editor.commit();
                return true;

            }
        }
        return false;
    }
    public boolean AddToFavorite(Book book){
        ArrayList<Book> books = getFavoriteBook();
        if(null!=books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor   = sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS_KEY_);
                editor.putString(FAVORITE_BOOKS_KEY_ , gson.toJson(books));
                editor.commit();
                return true;

            }
        }
        return false;
    }
    public boolean AddToCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyReading();
        if(null!=books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor   = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS_KEY_);
                editor.putString(CURRENTLY_READING_BOOKS_KEY_ , gson.toJson(books));
                editor.commit();
                return true;

            }
        }
        return false;
    }
}
