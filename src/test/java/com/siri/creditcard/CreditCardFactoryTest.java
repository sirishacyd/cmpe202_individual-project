package com.siri.creditcard;

import org.junit.Test;

import com.siri.creditcard.AmExCC;
import com.siri.creditcard.CreditCard;
import com.siri.creditcard.CreditCardFactory;
import com.siri.creditcard.DiscoverCC;
import com.siri.creditcard.MasterCC;
import com.siri.creditcard.VisaCC;

import static org.junit.Assert.*;

public class CreditCardFactoryTest {

    @Test
    public void test_CreditCardFactory_DiscoverCard() {
        CreditCardFactory factory = new CreditCardFactory();
        CreditCard cc = factory.getCreditCard("6011123456789123");
        assertTrue(cc instanceof DiscoverCC);
        assertEquals("Discover", cc.toString());
    }

    @Test
    public void test_CreditCardFactory_VisaCC() {
        CreditCardFactory factory = new CreditCardFactory();
        CreditCard cc = factory.getCreditCard("4120000000000");
        assertTrue(cc instanceof VisaCC);
        assertEquals("Visa", cc.toString());
    }

    @Test
    public void test_CreditCardFactory_AmexCC() {
        CreditCardFactory factory = new CreditCardFactory();
        CreditCard cc = factory.getCreditCard("341000000000000");
        assertTrue(cc instanceof AmExCC);
        assertEquals("AmericanExpress", cc.toString());
    }

    @Test
    public void test_CreditCardFactory_MasterCC() {
        CreditCardFactory factory = new CreditCardFactory();
        CreditCard cc = factory.getCreditCard("5410000000000000");
        assertTrue(cc instanceof MasterCC);
        assertEquals("MasterCard", cc.toString());

    }


}
