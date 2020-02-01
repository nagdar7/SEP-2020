package com.sep.PayPal.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.sep.PayPal.dto.RedirectDTO;
import com.sep.PayPal.dto.UrlDTO;
import com.sep.PayPal.model.FormField;
import com.sep.PayPal.model.PayPal;
import com.sep.PayPal.service.PayPalService;

import org.springframework.stereotype.Service;

@Service
public class PayPalServiceImpl implements PayPalService {

	public final String clientId = "ARkTCJmYIkNYkrpg1ElYevw83tfm3XLVNSoJuxvg_3IxRZutwkdIasfCIqNfU7owEXynDh9XMhGNrzkc";
	public final String clientSecret = "EBExl_Lf15DaoJoYaVv2UZhFW6DWh9vYsH5L6-SZ0by9nUQJrAmGzGFyWBN9u3yamEH1VlqMkqwpLcPJ";
	
	
	@Override
	public List<PayPal> returnAllAccounts() {
		List<PayPal> accounts = new ArrayList<PayPal>();
		accounts.add(new PayPal(1L, "1234", "1234568789546", 20000.00, "Petar", "Petrovic"));
		accounts.add(new PayPal(1L, "5678", "1567894654984", 30000.00, "Mika", "Mikic"));
		accounts.add(new PayPal(1L, "9012", "8464816886885", 40000.00, "Milan", "Milanovic"));
		accounts.add(new PayPal(1L, "3456", "7486595153266", 50000.00, "Jovan", "Jovanovic"));
		accounts.add(new PayPal(1L, "7890", "8941684168461", 70000.00, "Test", "Test"));
		accounts.add(new PayPal(1L, "1456", "8527419685456", 60000.00, "Dragan", "Vujanovic"));
		accounts.add(new PayPal(1L, "1598", "7418521265478", 90000.00, "Tatjana", "Zdravkovic"));
		return accounts;
	}

	@Override
	public String getPayPalUrl() {
		return "localhost:4200/api/paypal";		
	}

	@Override
	public List<FormField> getFormFieldsForPaypal() {
		List<FormField> formFields = new  ArrayList<FormField>();
		formFields.add(new FormField("total", "Total", "string", false));
		formFields.add(new FormField("currency", "Currency", "string", false));
		return formFields;

	}

	@Override
	public RedirectDTO Pay(Map<String, String> items) {
		System.out.println(items.size());
		RedirectDTO response = new RedirectDTO();
		    Amount amount = new Amount();
		    amount.setCurrency(items.get("Currency"));
		    amount.setTotal(items.get("Total"));
		    Transaction transaction = new Transaction();
		    transaction.setAmount(amount);
		    List<Transaction> transactions = new ArrayList<Transaction>();
		    transactions.add(transaction);

		    Payer payer = new Payer();
		    payer.setPaymentMethod("paypal");

		    Payment payment = new Payment();
		    payment.setIntent("sale");
		    payment.setPayer(payer);
		    payment.setTransactions(transactions);

		    RedirectUrls redirectUrls = new RedirectUrls();
		    redirectUrls.setCancelUrl(items.get("CancelUrl"));
		    redirectUrls.setReturnUrl(items.get("ReturnUrl"));
		    payment.setRedirectUrls(redirectUrls);
		    Payment createdPayment;
		    try {
		        String redirectUrl = "";
		        APIContext context = new APIContext(clientId, clientSecret, "sandbox");
		        createdPayment = payment.create(context);
		        if(createdPayment!=null){
		            List<Links> links = createdPayment.getLinks();
		            for (Links link:links) {
		                if(link.getRel().equals("approval_url")){
		                    redirectUrl = link.getHref();
		                    break;
		                }
		            }
		            response.Status =  "success";
		            response.RedirectUrl = redirectUrl;
		            
		        }
		    } catch (PayPalRESTException e) {
		    	response.Status =  "error";
		        System.out.println("Error happened during payment creation!");
		    }
		    System.out.println("response");
		    System.out.print(response.RedirectUrl);
            return response;
	}
}
