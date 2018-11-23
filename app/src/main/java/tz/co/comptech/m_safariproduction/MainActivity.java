package tz.co.comptech.m_safariproduction;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import tz.co.comptech.m_safariproduction.Api.Authentication;
import tz.co.comptech.m_safariproduction.Api.Bus;
import tz.co.comptech.m_safariproduction.Model.Customer;
import tz.co.comptech.m_safariproduction.ViewModel.AuthenticationViewModel;

public class MainActivity extends AppCompatActivity {

    AuthenticationViewModel authenticationViewModel;
    Customer customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customer = new Customer(
                "Hemedi",
                "Mshamu",
                "manyinja",
                "123456",
                "male",
                "killungule",
                "0685639653",
                "120-194-17832-32"
        );
        authenticationViewModel = ViewModelProviders.of(this).get(AuthenticationViewModel.class);
    }

    public void createUserNew(View view) {
        authenticationViewModel.getUsers(customer);
    }
}
