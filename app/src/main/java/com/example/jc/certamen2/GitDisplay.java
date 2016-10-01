package com.example.jc.certamen2;

/**
 * Created by Jc on 30-09-2016.
 */

public class GitDisplay {
    public onCreate(){
        CreateCards();

        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(new xmlAdapter(numberCards, getLayoutInflater()));

        mCardScroller.setOnItemClickListener(this);
    }
}
