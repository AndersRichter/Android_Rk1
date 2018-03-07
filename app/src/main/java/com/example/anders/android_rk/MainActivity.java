package com.example.anders.android_rk;

import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.mail.park.articlelistlib.Article;
import ru.mail.park.articlelistlib.ArticleListFragment;
import ru.mail.park.articlelistlib.OnArticleClickListener;

public class MainActivity extends AppCompatActivity {

    public static final String TEXT = "text";
    public static final String DATE = "date";
    public static final String TITLE = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ArticleListFragment articleListFragment = new ArticleListFragment();
        articleListFragment.setOnArticleClickListener(new ArticleClick());

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragmentTransaction.replace(R.id.top_container, articleListFragment);
        } else {
            fragmentTransaction.replace(R.id.left_container, articleListFragment);
        }

        fragmentTransaction.commit();
    }

    private class ArticleClick implements OnArticleClickListener {
        @Override
        public void onArticleClick(Article article) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            OneArticle oneArticle = new OneArticle();

            final Bundle bundle = new Bundle();
            bundle.putString(TITLE, article.getTitle());
            bundle.putString(DATE, article.getDate().toString());
            bundle.putString(TEXT, article.getContent());

            oneArticle.setArguments(bundle);

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                fragmentTransaction.replace(R.id.top_container, oneArticle);
                fragmentTransaction.addToBackStack(null);
            } else {
                fragmentTransaction.replace(R.id.right_container, oneArticle);
            }

            fragmentTransaction.commit();
        }
    }
}
