package com.dongnao.alvin.wraprecyclerview;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;

import com.dongnao.alvin.wraprecyclerview.horizontal.HorizontalRecyclerViewActivity;
import com.dongnao.alvin.wraprecyclerview.multi.MultRecycleViewInpageAct;
import com.dongnao.alvin.wraprecyclerview.normal.NormalRecyclerViewActivity;
import com.dongnao.alvin.wraprecyclerview.normal.RecyclerViewTypeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSpannableStrClickEvent2();
    }


    public void testNormalRecyclerView(View view) {
        startActivity(new Intent(getApplicationContext(), NormalRecyclerViewActivity.class));
    }

    public void testMultitypeView(View view) {
        startActivity(new Intent(getApplicationContext(), RecyclerViewTypeActivity.class));
    }

    public void testMultitypeViewInpage(View view) {
        startActivity(new Intent(getApplicationContext(), MultRecycleViewInpageAct.class));
    }


    public void testHorizontalRecyclerViewActivity(View view) {
        startActivity(new Intent(getApplicationContext(), HorizontalRecyclerViewActivity.class));
    }



    private void setSpannableString() {
        TextView viewById = (TextView)findViewById(R.id.tv);
        String string = "￥434";
        int target = string.indexOf('￥') + 1;
        SpannableString styledText = new SpannableString(string);
        styledText.setSpan(new TextAppearanceSpan(getApplicationContext(), R.style.style1), 0, target, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        styledText.setSpan(new TextAppearanceSpan(getApplicationContext(), R.style.style2), target, string.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        viewById.setText(styledText);
    }

    private void setSpannableString2() {
        TextView viewById = (TextView)findViewById(R.id.tv);
        String string = "￥434-￥1000";
        int first = string.indexOf('￥');
        int second = string.lastIndexOf('￥');
        SpannableString styledText = new SpannableString(string);
        styledText.setSpan(new TextAppearanceSpan(getApplicationContext(), R.style.style1), 0, first+1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        styledText.setSpan(new TextAppearanceSpan(getApplicationContext(), R.style.style2), first+1, second, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        styledText.setSpan(new TextAppearanceSpan(getApplicationContext(), R.style.style1), second, second+1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        styledText.setSpan(new TextAppearanceSpan(getApplicationContext(), R.style.style2), second+1, string.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        viewById.setText(styledText);
    }

    private void setSpannableStrClickEvent() {
        TextView viewById = (TextView)findViewById(R.id.tv);
        SpannableString spannableString = new SpannableString("为文字设置点击事件");
        MyClickableSpan clickableSpan = new MyClickableSpan("http://www.jianshu.com/users/dbae9ac95c78");
        spannableString.setSpan(clickableSpan, 5, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new TextAppearanceSpan(getApplicationContext(), R.style.style1),5, spannableString.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        viewById.setMovementMethod(LinkMovementMethod.getInstance());
        viewById.setHighlightColor(Color.parseColor("#36969696"));
        viewById.setText(spannableString);
    }

    private void setSpannableStrClickEvent2() {
        TextView viewById = findViewById(R.id.tv_content);
        String content = viewById.getText().toString();
        SpannableString spannableString = new SpannableString(content);
        String userProtocol = "《用户服务协议》";
        int oneIndex = content.indexOf(userProtocol);
        String userAuthorization = "《用户授权协议》";
        int secondIndex = content.indexOf(userAuthorization);
        String userPrivacy = "《隐私政策》";
        int thirdIndex = content.indexOf(userPrivacy);

        MyClickableSpan clickableSpan = new MyClickableSpan("http://www.jianshu.com/users/dbae9ac95c78");
        spannableString.setSpan(clickableSpan, oneIndex, oneIndex + userProtocol.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new TextAppearanceSpan(getApplicationContext(), R.style.style1),oneIndex, oneIndex + userProtocol.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new TextAppearanceSpan(getApplicationContext(), R.style.style1),secondIndex, secondIndex + userAuthorization.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new TextAppearanceSpan(getApplicationContext(), R.style.style1),thirdIndex, thirdIndex + userPrivacy.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        viewById.setMovementMethod(LinkMovementMethod.getInstance());
        viewById.setHighlightColor(Color.parseColor("#36969696"));
        viewById.setText(spannableString);
    }

    class MyClickableSpan extends ClickableSpan {

        private String content;

        public MyClickableSpan(String content) {
            this.content = content;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(View widget) {
            startActivity(new Intent(getApplicationContext(), MultRecycleViewInpageAct.class));

//            Intent intent = new Intent(MainActivity.this, OtherActivity.class);
//            Bundle bundle = new Bundle();
//            bundle.putString("content", content);
//            intent.putExtra("bundle", bundle);
//            startActivity(intent);
        }
    }

}
