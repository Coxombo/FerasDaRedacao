package com.ferasdaredacao.ferasdaredo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        Fragment noticiasFragment = NoticiasFragment.newInstance();
        openFragment(noticiasFragment);
        getSupportActionBar().hide();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_artigos: {
                Fragment noticiasFragment = NoticiasFragment.newInstance();
                openFragment(noticiasFragment);
                break;
            }
            case R.id.navigation_aulas: {
                Fragment aulasFragment = AulasFragment.newInstance();
                openFragment(aulasFragment);
                break;
            }
            case R.id.navigation_perfil: {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameActivityMain, new PerfilFragment())
                        .commit();
                break;
            }
        }
        return true;
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameActivityMain, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

