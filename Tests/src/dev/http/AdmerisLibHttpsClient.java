package dev.http;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.admeris.creditcard.api.AvsRequest;
import com.admeris.creditcard.api.CreditCardReceipt;
import com.admeris.creditcard.api.Cvv2Request;
import com.admeris.creditcard.api.HttpsCreditCardService;
import com.admeris.creditcard.api.Merchant;
import com.admeris.creditcard.api.PeriodicPurchaseInfo.Schedule;
import com.admeris.creditcard.api.PeriodicPurchaseInfo.ScheduleType;
import com.admeris.creditcard.api.VerificationRequest;

public class AdmerisLibHttpsClient
{
	public final static void main(String[] args) throws Exception
    {
        try
        {
            String stringUrl = "https://test.admeris.com/ccgateway/cc/processor.do";

            /*Data that needs to be sent to PG*/
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String orderId = timeStamp+"0";
			long amount = 20l;
			int merchantId = 50418;
			String apiToken = "0Wrg336gJLgDJ1y0";
			String storageTokenId = "test--token";
			boolean isRecurring = false;
			//Using admeris API library.
            //For merchant not using the storeId.
			Merchant merchant = new Merchant(merchantId, apiToken);
            boolean isSecured = true;
            HttpsCreditCardService service = new HttpsCreditCardService(merchant, stringUrl, isSecured);
            VerificationRequest verificationRequest = new VerificationRequest(AvsRequest.VERIFY_STREET_AND_ZIP, Cvv2Request.CVV2_NOT_SUBMITTED);
            CreditCardReceipt receipt;
            Date endDate = new Date(System.currentTimeMillis() + 736364745758l);
            System.out.println("----------------------------------------");
            if(isRecurring)
            	receipt = service.recurringPurchase(orderId, storageTokenId, amount, new Date(), 
            			endDate, new Schedule(ScheduleType.DAY, (short) 20), verificationRequest);
            else
            	receipt = service.singlePurchase(orderId, storageTokenId, amount, verificationRequest);
            
            System.out.println("Response: "+receipt.getResponse());
            System.out.println("DebugMessage:"+receipt.getDebugMessage());
            System.out.println("----------------------------------------");
        }
        catch(Exception e)
        {
        	
        }
    }
}
