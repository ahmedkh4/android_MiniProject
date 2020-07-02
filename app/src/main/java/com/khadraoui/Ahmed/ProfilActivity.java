package com.khadraoui.Ahmed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {

    private Boolean mIsMale ;
    private String mNom;
    private String mPrenom;
    private String mTelephone;
    private String mEtablissement;
    private String mEmail;
    private String mMdp;
    private String mCmdp;
    private String mgender ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        mIsMale = getIntent().getBooleanExtra("genderExtra", false);
        mNom = getIntent().getStringExtra("Fname");
        mPrenom = getIntent().getStringExtra("Lname");
        mTelephone = getIntent().getStringExtra("phone");
        mEtablissement = getIntent().getStringExtra("department");
        mEmail = getIntent().getStringExtra("email");
        mMdp = getIntent().getStringExtra("password");
        mCmdp = getIntent().getStringExtra("cpassword");

        mgender = mIsMale ? "Male" : "Female" ;

        TextView nomTextView = findViewById(R.id.nom) ;
        nomTextView.setText(String.valueOf(mNom));

        TextView prenomTextView = findViewById(R.id.prenom) ;
        prenomTextView.setText(String.valueOf(mPrenom));

        TextView telephoneView = findViewById(R.id.telephone) ;
        telephoneView.setText(String.valueOf(mTelephone));

        TextView etablissementTextView = findViewById(R.id.etablissement) ;
        etablissementTextView.setText(String.valueOf(mEtablissement));

        TextView genreTextView = findViewById(R.id.genre) ;
        genreTextView.setText(String.valueOf( mgender) );




    }
}
