//package com.WorldInPocket.Spring.security.paypal;
//
//import java.io.IOException;
//
//import com.paypal.api.payments.PayerInfo;
//import com.paypal.api.payments.Payment;
//import com.paypal.api.payments.ShippingAddress;
//import com.paypal.api.payments.Transaction;
//import com.paypal.base.rest.APIContext;
//import com.paypal.base.rest.PayPalRESTException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/review_payment")
//public class ReviewPaymentServlet extends HttpServlet{
//	private static final String MODE = "sandbox";
//	private String clientId = "ARAvkmld2iyJq2Kuw9cCN6yg84JCuCe92BhlubB4TEsy0yMGjvsciKLgYGgr4fxq8e0WSpap0V-Cfj8X";
//	private String clientSecret = "EJI86n-2WFONwhO2OMgMED0EvpbSd5JQl9SNVsWa9HHqRwgvtdEGHOXibuRNYKUdjff6D2Aj-iHvWYLc";
//	private static final long serialVersionUID = 1L;
//	 
//    public ReviewPaymentServlet() {
//    }
// 
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String paymentId = request.getParameter("paymentId");
//        String payerId = request.getParameter("PayerID");
//         
//        try {
//            PaymentServices paymentServices = new PaymentServices();
//            Payment payment = paymentServices.getPaymentDetails(paymentId);
//             
//            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
//            Transaction transaction = payment.getTransactions().get(0);
//            ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
//             
//            request.setAttribute("payer", payerInfo);
//            request.setAttribute("transaction", transaction);
//            request.setAttribute("shippingAddress", shippingAddress);
//             
//            String url = "review.jsp?paymentId=" + paymentId + "&PayerID=" + payerId;
//             
//            request.getRequestDispatcher(url).forward(request, response);
//             
//        } catch (PayPalRESTException ex) {
//            request.setAttribute("errorMessage", ex.getMessage());
//            ex.printStackTrace();
//            request.getRequestDispatcher("error.jsp").forward(request, response);
//        }      
//    }
//    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
//        APIContext apiContext = new APIContext(clientId, clientSecret, MODE);
//        return Payment.get(apiContext, paymentId);
//    }
//}
