package com.khadraoui.Ahmed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

MediaPlayer sound ;
    Animation frontAnim ;
    ImageView image ;

  // radio button
    private boolean mIsMale = false;

  // textfields

    private EditText mNom;
    private EditText mPrenom;
    private EditText mTelephone;
    private EditText mEtablissement;
    private EditText mEmail;
    private EditText mMdp;
    private EditText mCmdp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set animation
        frontAnim = AnimationUtils.loadAnimation(this, R.anim.front_anime) ;
        // hooks
        image = findViewById(R.id.avatar) ;

        // get view b id

        mNom = findViewById(R.id.nom);
        mPrenom = findViewById(R.id.prenom);
        mTelephone = findViewById(R.id.telephone);
        mEtablissement = findViewById(R.id.etablissement);
        mEmail = findViewById(R.id.email);
        mMdp = findViewById(R.id.mdp);
        mCmdp = findViewById(R.id.cmdp);


        // button
        findViewById(R.id.submit).setOnClickListener(this);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.check(mIsMale ? R.id.maleRadio : R.id.femaleRadio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mIsMale = checkedId == R.id.maleRadio;
            }
        });



    }


    @Override
    public void onClick(View v) {
        if( v.getId() == R.id.submit)
            validate() ;

    }

    private void validate() {
        if (TextUtils.isEmpty(mNom.getText().toString())) {
            Toast.makeText(this, "Mettez votre Nom", Toast.LENGTH_SHORT).show();
            mNom.setError("Mettez votre Nom");


                sound = MediaPlayer.create(this , R.raw.error) ;
                sound.start();

            return;

        }

        if (TextUtils.isEmpty(mPrenom.getText().toString())) {
            Toast.makeText(this, "Mettez votre Prenom", Toast.LENGTH_SHORT).show();
            mPrenom.setError("Mettez votre Prenom");
            return;
        }

        if (TextUtils.isEmpty(mTelephone.getText().toString())) {
            Toast.makeText(this, "Mettez votre numero de Telephone", Toast.LENGTH_SHORT).show();
            mTelephone.setError("Mettez votre numero de Telephone");
            return;
        }

        if (TextUtils.isEmpty(mEtablissement.getText().toString())) {
            Toast.makeText(this, "Mettez votre Etablissement", Toast.LENGTH_SHORT).show();
            mEtablissement.setError("Mettez votre Etablissement");
            return;
        }

        if (TextUtils.isEmpty(mEmail.getText().toString())) {
            Toast.makeText(this, "Mettez votre Email", Toast.LENGTH_SHORT).show();
            mEmail.setError("Mettez votre Email");
            return;
        }

        if (TextUtils.isEmpty(mMdp.getText().toString())) {
            Toast.makeText(this, "Mettez votre Mot De Passe", Toast.LENGTH_SHORT).show();
            mMdp.setError("Mettez votre Mot De Passe");
            return;
        }

        if (TextUtils.isEmpty(mCmdp.getText().toString())) {
            Toast.makeText(this, "Mettez votre Confirmation de Mot de Passe", Toast.LENGTH_SHORT).show();
            mCmdp.setError("Mettez votre Confirmation de Mot de Passe");
            return;

        }


        if (mMdp.getText().toString().length() < 6  ) {
            Toast.makeText(this, "le Mot de Passe doit contient au moins 6 characteres", Toast.LENGTH_SHORT).show();
            mMdp.setError("le Mot de Passe doit contient au moins 6 characteres");
            return;
        }

        if (  !mCmdp.getText().toString().equalsIgnoreCase(mMdp.getText().toString())  ) {
            Toast.makeText(this, "Les deux Mots de passe sont incompatible", Toast.LENGTH_SHORT).show();
            mCmdp.setError("Les deux Mots de passe sont incompatible");
            return;
        }

        if (  !validEmail(mEmail.getText().toString() )  ) {
            Toast.makeText(this, "invalid Email", Toast.LENGTH_SHORT).show();
            mEmail.setError("invalid Email");
            if( sound == null) {
                sound = MediaPlayer.create(this , R.raw.error) ;
                sound.start();
            }
            return;
        }

        else {

            Intent intent = new Intent(this, ProfilActivity.class);

            intent.putExtra("genderExtra", mIsMale );
            intent.putExtra("Fname", mNom.getText().toString());
            intent.putExtra("Lname", mPrenom.getText().toString());
            intent.putExtra("phone", mTelephone.getText().toString());
            intent.putExtra("department", mEtablissement.getText().toString());
            intent.putExtra("email", mEmail.getText().toString());
            intent.putExtra("password", mMdp.getText().toString());
            intent.putExtra("cPassowrd", mCmdp.getText().toString());

            startActivity(intent);
            finish();

        }


    }


    private boolean validEmail ( String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() ;


    }


}
