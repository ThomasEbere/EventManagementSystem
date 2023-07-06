package app;

import com.stripe.Stripe;

import com.stripe.exception.*;
import com.stripe.model.Charge;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

//@Configuration
@Service
@PropertySource(value = {"classpath:application.properties"})
public class StripeService {

    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey;

    
    @PostConstruct
    public void init(){
        Stripe.apiKey=secretKey;
    }    

    public Charge charge(ChargeRequest chargeRequest)
            throws AuthenticationException, StripeException {
    	System.out.println("This is the secret key" + secretKey);
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency",chargeRequest.getCurrency());
        chargeParams.put("description",chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        return Charge.create(chargeParams);
    }
}
