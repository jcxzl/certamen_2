package com.example.jc.certamen2;

import org.json.JSONObject;

public class xmlAdapter extends CardScrollAdapter CardScrollAdapter {
    private List<JSONObject> mCards;
    private LayoutInflater mInflater;

    public xmlAdapter(List<JSONObject> mCards, LayoutInflater inflater)
    {
        this.mCards = mCards;
        this.mInflater = inflater;
    }


    @Override
    public int getCount() {
        return mCards.size();
    }

    @Override
    public Object getItem(int i) {
        return mCards.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View mView = view;

        view = mInflater.inflate(R.layout.xml_test, viewGroup, false);
        TextView text = (TextView) view.findViewById(R.id.test_content);
        text.setText("Test " + mCards.get(i));
        view.setTag(text);
        return view;
    }

    @Override
    public int getPosition(Object o) {
        return this.mCards.indexOf(o);
    }