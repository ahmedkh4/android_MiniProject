package com.khadraoui.Ahmed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
            return;
        }

        if (TextUtils.isEmpty(mPrenom.getText().toString())) {
            Toast.makeText(this, "Mettez votre Prenom", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(mTelephone.getText().toString())) {
            Toast.makeText(this, "Mettez votre numero de Telephone", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(mEtablissement.getText().toString())) {
            Toast.makeText(this, "Mettez votre Etablissement", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(mEmail.getText().toString())) {
            Toast.makeText(this, "Mettez votre Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(mMdp.getText().toString())) {
            Toast.makeText(this, "Mettez votre Mot De Passe", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(mCmdp.getText().toString())) {
            Toast.makeText(this, "Mettez votre Confirmation de Mot de Passe", Toast.LENGTH_SHORT).show();
            return;
        }

        if (  !mCmdp.getText().toString().equalsIgnoreCase(mMdp.getText().toString())  ) {
            Toast.makeText(this, "Les deux Mots de passe sont incompatible", Toast.LENGTH_SHORT).show();
            return;
        }

        if (  !validEmail(mEmail.getText().toString() )  ) {
            Toast.makeText(this, "invalid Email", Toast.LENGTH_SHORT).show();
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

        }


    }


    private boolean validEmail ( String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() ;


    }


}
