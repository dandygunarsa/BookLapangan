package com.example.booklapangan.ui.notifications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.booklapangan.LoginActivity;
import com.example.booklapangan.MainActivity;
import com.example.booklapangan.Preferences;
import com.example.booklapangan.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class NotificationsFragment extends Fragment implements View.OnClickListener {

//    private NotificationsViewModel notificationsViewModel;
    TextView nama;
    TextView email;
    TextView id;
    ImageView foto;

    Button btnLogout;
    Preferences sharedPrefManager;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        sharedPrefManager = new Preferences(getActivity().getApplicationContext());

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        View myView = inflater.inflate(R.layout.fragment_notifications, container, false);
        btnLogout = myView.findViewById(R.id.btnLogout);
        nama = myView.findViewById(R.id.name);
        email = myView.findViewById(R.id.email);
        id = myView.findViewById(R.id.id);
        foto = myView.findViewById(R.id.photo);

        btnLogout.setOnClickListener(this);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            nama.setText("Name: "+personName);
            email.setText("Email: "+personEmail);
            id.setText("ID: "+personId);
            Glide.with(this).load(personPhoto).into(foto);
        }

        return myView;
    }

    @Override
    public void onClick(View v) {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getContext(),"SIGN OUT SUKSES",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                    }
                });

        sharedPrefManager.saveSPBoolean(Preferences.SP_SUDAH_LOGIN, false);
        startActivity(new Intent(getActivity(), LoginActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}