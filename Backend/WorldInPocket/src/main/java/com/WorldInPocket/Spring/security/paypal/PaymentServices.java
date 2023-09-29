//package com.WorldInPocket.Spring.security.paypal;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.paypal.api.payments.Amount;
//import com.paypal.api.payments.Details;
//import com.paypal.api.payments.Item;
//import com.paypal.api.payments.ItemList;
//import com.paypal.api.payments.Links;
//import com.paypal.api.payments.Payer;
//import com.paypal.api.payments.PayerInfo;
//import com.paypal.api.payments.Payment;
//import com.paypal.api.payments.PaymentExecution;
//import com.paypal.api.payments.RedirectUrls;
//import com.paypal.api.payments.Transaction;
//import com.paypal.base.rest.APIContext;
//import com.paypal.base.rest.PayPalRESTException;
//
//public class PaymentServices {
//	private static final String CLIENT_ID = "ARAvkmld2iyJq2Kuw9cCN6yg84JCuCe92BhlubB4TEsy0yMGjvsciKLgYGgr4fxq8e0WSpap0V-Cfj8X";
//    private static final String CLIENT_SECRET = "EJI86n-2WFONwhO2OMgMED0EvpbSd5JQl9SNVsWa9HHqRwgvtdEGHOXibuRNYKUdjff6D2Aj-iHvWYLc";
//    private static final String MODE = "sandbox";
//
//    public String authorizePayment(OrderDetail orderDetail)        
//            throws PayPalRESTException {       
// 
//        Payer payer = getPayerInformation();
//        RedirectUrls redirectUrls = getRedirectURLs();
//        List<Transaction> listTransaction = getTransactionInformation(orderDetail);
//         
//        Payment requestPayment = new Payment();
//        requestPayment.setTransactions(listTransaction);
//        requestPayment.setRedirectUrls(redirectUrls);
//        requestPayment.setPayer(payer);
//        requestPayment.setIntent("authorize");
// 
//        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
// 
//        Payment approvedPayment = requestPayment.create(apiContext);
// 
//        return getApprovalLink(approvedPayment);
// 
//    }
//    
//    private Payer getPayerInformation() {
//        Payer payer = new Payer();
//        payer.setPaymentMethod("paypal");
//         
//        PayerInfo payerInfo = new PayerInfo();
//        payerInfo.setFirstName("William")
//                 .setLastName("Peterson")
//                 .setEmail("william.peterson@company.com");
//         
//        payer.setPayerInfo(payerInfo);
//         
//        return payer;
//    }
//    
//    private RedirectUrls getRedirectURLs() {
//        RedirectUrls redirectUrls = new RedirectUrls();
//        redirectUrls.setCancelUrl("http://localhost:8080/PaypalTest/cancel.html");
//        redirectUrls.setReturnUrl("http://localhost:8080/PaypalTest/review_payment");
//         
//        return redirectUrls;
//    }
//
//    private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
//        Details details = new Details();
//        details.setShipping(orderDetail.getShipping());
//        details.setSubtotal(orderDetail.getSubtotal());
//        details.setTax(orderDetail.getTax());
//     
//        Amount amount = new Amount();
//        amount.setCurrency("EUR");
//        amount.setTotal(orderDetail.getTotal());
//        amount.setDetails(details);
//     
//        Transaction transaction = new Transaction();
//        transaction.setAmount(amount);
//        transaction.setDescription(orderDetail.getProductName());
//         
//        ItemList itemList = new ItemList();
//        List<Item> items = new ArrayList<>();
//         
//        Item item = new Item();
//        item.setCurrency("USD");
//        item.setName(orderDetail.getProductName());
//        item.setPrice(orderDetail.getSubtotal());
//        item.setTax(orderDetail.getTax());
//        item.setQuantity("1");
//         
//        items.add(item);
//        itemList.setItems(items);
//        transaction.setItemList(itemList);
//     
//        List<Transaction> listTransaction = new ArrayList<>();
//        listTransaction.add(transaction);  
//         
//        return listTransaction;
//    }
//    
//    private String getApprovalLink(Payment approvedPayment) {
//        List<Links> links = approvedPayment.getLinks();
//        String approvalLink = null;
//         
//        for (Links link : links) {
//            if (link.getRel().equalsIgnoreCase("approval_url")) {
//                approvalLink = link.getHref();
//                break;
//            }
//        }      
//         
//        return approvalLink;
//    }
//    
//    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
//        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
//        return Payment.get(apiContext, paymentId);
//    }
//    
//    public Payment executePayment(String paymentId, String payerId)
//            throws PayPalRESTException {
//        PaymentExecution paymentExecution = new PaymentExecution();
//        paymentExecution.setPayerId(payerId);
//     
//        Payment payment = new Payment().setId(paymentId);
//     
//        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
//     
//        return payment.execute(apiContext, paymentExecution);
//    }
//    
//}
