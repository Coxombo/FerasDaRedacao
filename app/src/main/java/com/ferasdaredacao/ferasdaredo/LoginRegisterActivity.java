package com.ferasdaredacao.ferasdaredo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class LoginRegisterActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                        Arrays.asList(
                                new AuthUI.IdpConfig.GoogleBuilder().build(),
                                new AuthUI.IdpConfig.FacebookBuilder().build()
                        )
                ).setTosAndPrivacyPolicyUrls(
                        "https://firebasestorage.googleapis.com/v0/b/feras-da-redacao.appspot.com/o/docs%2FTermos%20de%20Servi%C3%A7o.docx?alt=media&token=683ab1d5-0ab8-482a-9055-fc46a8eb4ce1",
                        "https://firebasestorage.googleapis.com/v0/b/feras-da-redacao.appspot.com/o/docs%2Fcontrato-politica-privacidade.pdf?alt=media&token=7943394d-45c0-44dc-8be8-d980486204f2"
                ).setLogo(R.mipmap.ic_launcher).build(), RC_SIGN_IN
        );
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            // Successfully signed in
            if (resultCode == RESULT_OK) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button
                    Toast.makeText(this, R.string.sign_in_cancelled, Toast.LENGTH_LONG).show();
                    return;
                }

                if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    Toast.makeText(this, R.string.no_internet_connection, Toast.LENGTH_LONG).show();
                    return;
                }

                Toast.makeText(this, R.string.unknown_error, Toast.LENGTH_LONG).show();
                Log.e("<Error>", "Sign-in error: ", response.getError());
            }
        }
    }
}
