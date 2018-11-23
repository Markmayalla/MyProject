package tz.co.comptech.m_safariproduction.ViewModel;

import android.arch.lifecycle.ViewModel;

import tz.co.comptech.m_safariproduction.Model.Customer;
import tz.co.comptech.m_safariproduction.Model.OTP;
import tz.co.comptech.m_safariproduction.Model.ResponseModel;
import tz.co.comptech.m_safariproduction.Model.UserLoginModel;
import tz.co.comptech.m_safariproduction.Repository.AuthenticationRepository;

public class AuthenticationViewModel extends ViewModel {
    private ResponseModel responseModel;
    private Customer customer;
    private AuthenticationRepository authenticationRepository;
    public AuthenticationViewModel() {
        authenticationRepository = new AuthenticationRepository();
    }

    public Customer getUsers(Customer userId){
        customer = authenticationRepository.getUsers(userId);
        return customer;
    }

    public ResponseModel createUser(Customer customer){
        responseModel = authenticationRepository.createUser(customer);
        return responseModel;
    }

    public ResponseModel updateUser(Customer Customer){
        responseModel = authenticationRepository.updateUser(Customer);
        return responseModel;
    }

    public Customer loginToSystem(UserLoginModel userLoginModel){
        customer = authenticationRepository.loginToSystem(userLoginModel);
        return customer;
    }

    public ResponseModel validateOtp(OTP otpModel){
        responseModel = authenticationRepository.validateOtp(otpModel);
        return responseModel;
    }
}
