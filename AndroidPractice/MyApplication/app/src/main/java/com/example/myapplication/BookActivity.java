package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    public static final String BOOK_ID_KEY = "bookId";

    private TextView txtBookName , txtAuthor , txtPages , txtDescription;
    private Button btnAddToWantToRead , btnAddToAlreadyRead , btnAddToCurrentlyReading , btnAddToFavorite;
    private ImageView bookImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);




        initViews();

/*
        String longDescription = "1Q84 (いちきゅうはちよん, Ichi-Kyū-Hachi-Yon, stylized in the Japanese cover as \"ichi-kew-hachi-yon\") is a novel written by Japanese writer Haruki Murakami, first published in three volumes in Japan in 2009–10.[1] It covers a fictionalized year of 1984 in parallel with a \"real\" one. The novel is a story of how a woman named Aomame begins to notice strange changes occurring in the world. She is quickly caught up in a plot involving Sakigake, a religious cult, and her childhood love, Tengo, and embarks on a journey to discover what is \"real\".\n" +
                "\n" +
                "The novel's first printing sold out on the day it was released and sales reached a million within a month.[2] The English-language edition of all three volumes, with the first two volumes translated by Jay Rubin and the third by Philip Gabriel, was released in North America and the United Kingdom on October 25, 2011.[3][4][5][6] An excerpt from the novel appeared in the September 5, 2011 issue of The New Yorker magazine as \"Town of Cats\".[7] The first chapter of 1Q84 had also been read as an excerpt in the Selected Shorts series at Symphony Space in New York.\n" +
                "\n" +
                "While well-received in Japan, 1Q84 was met with mixed to negative reviews from international critics, who condemned the novel's excessive repetition, clichéd writing, clumsy styling and unyielding plot.[8] Literary Review nominated a poorly-written exerpt in the book for its annual Bad Sex in Fiction Award.[9][10]";

        //TODO: Get data from Recycler View in here
        Book book = new Book(1 , "1Q84" , "Haruki Murakami" , 1350 , "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1483103331l/10357575.jpg"
                ,"A work of maddening Brilliance" , longDescription);
*/

        Intent intent = getIntent();
        if (null!= intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY , -1);
            if (bookId != -1){
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if (null != incomingBook){
                    setData(incomingBook);
                    HandleAlreadyRead(incomingBook);
                    handleWantToRead(incomingBook);
                    handleCurrentlyReading(incomingBook);
                    handleFavoriteBook(incomingBook);

                }

            }
        }



    }

    private void handleFavoriteBook(Book book) {
        ArrayList<Book> favoriteBooks = Utils.getInstance(this).getFavoriteBook();


        boolean exist = false;

        for (Book b :
                favoriteBooks) {
            if(b.getId() == book.getId()){
                exist = true;
            }
        }
        if (exist){
            btnAddToFavorite.setEnabled(false);
        }else{
            btnAddToFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).AddToFavorite(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        //TODO Navigate the user
                        Intent intent = new Intent(BookActivity.this , FavoriteBookActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something Went Wrong , Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReading(Book book) {
        ArrayList<Book> CurrentlyReading = Utils.getInstance(this).getCurrentlyReading();


        boolean exist = false;

        for (Book b :
                CurrentlyReading) {
            if(b.getId() == book.getId()){
                exist = true;
            }
        }
        if (exist){
            btnAddToCurrentlyReading.setEnabled(false);
        }else{
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).AddToCurrentlyReading(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        //TODO Navigate the user
                        Intent intent = new Intent(BookActivity.this , CurrentlyReadingBook.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something Went Wrong , Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToRead(final Book book) {
        ArrayList<Book> WantTorReadBooks = Utils.getInstance(this).getWantToRead();

        boolean exist = false;

        for (Book b :
                WantTorReadBooks) {
            if(b.getId() == book.getId()){
                exist = true;
            }
        }
        if (exist){
            btnAddToWantToRead.setEnabled(false);
        }else{
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).AddTowantoToRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        //TODO Navigate the user
                        Intent intent = new Intent(BookActivity.this , WantToReadActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something Went Wrong , Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    /**
     * Enable and Disable Button
     * Add the book to Already Read book ArrayList
     * @param book
     */
    private void HandleAlreadyRead(final Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyRead();

        boolean exist = false;

        for (Book b :
                alreadyReadBooks) {
            if(b.getId() == book.getId()){
                exist = true;
            }
        }
        if (exist){
            btnAddToAlreadyRead.setEnabled(false);
        }else{
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).AddToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        //TODO Navigate the user
                        Intent intent = new Intent(BookActivity.this , AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something Went Wrong , Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtDescription.setText(book.getLongDesc());
        txtPages.setText(String.valueOf(book.getPages()));

        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);

    }

    private void initViews() {
        txtBookName = findViewById(R.id.txtCurrentBookName);
        txtAuthor = findViewById(R.id.txtCurrentBookAuthor);
        txtDescription = findViewById(R.id.txtLongDesc);
        txtPages = findViewById(R.id.txtPages);

        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyRead);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToFavorite = findViewById(R.id.btnAddToFavorites);
        btnAddToWantToRead = findViewById(R.id.btnAddToWishList);

        bookImage = findViewById(R.id.BookImage);
    }
}