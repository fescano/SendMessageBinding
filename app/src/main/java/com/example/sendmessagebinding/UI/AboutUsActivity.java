package com.example.sendmessagebinding.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sendmessagebinding.R;
import com.example.sendmessagebinding.SendMessageApplication;
import com.example.sendmessagebinding.data.Message;
import com.example.sendmessagebinding.databinding.ActivitySendMessageBinding;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {
    private ActivitySendMessageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_about_us);
        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.ic_launcher)
                .setName(((SendMessageApplication)getApplication()).getUser().getName())
                .setSubTitle(getResources().getString(R.string.aboutUsSubTittle))
                .setBrief("E-mail: " + ((SendMessageApplication)getApplication()).getUser().getEmail())
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGitHubLink(((SendMessageApplication)getApplication()).getUser().getName())
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();
        setContentView(view);
    }
}