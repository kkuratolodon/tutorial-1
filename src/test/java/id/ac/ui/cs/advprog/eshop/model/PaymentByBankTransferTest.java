package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class PaymentByBankTransferTest {
    List<Product> products;
    List<Order> orders;
    List<Payment> payments;

    @BeforeEach
    void setUp() {
        products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductQuantity(2);
        product1.setProductName("Sampo Cap Bambang");
        products.add(product1);

        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-4664-83c7-f32db8620155");
        product2.setProductQuantity(1);
        product2.setProductName("Sampo Cap Usep");
        products.add(product2);

        orders = new ArrayList<>();
        Order order1 = new Order("136522556-012a-4c07-b546-54eb1396d79b",
                products, 1708560000L, "Bambang Sugeni");
        orders.add(order1);
        Order order2 = new Order("7f9e15bb-4b15-42f4-aebc-c3af385fb078",
                products, 1708570000L, "Tatang Sutanto");
        orders.add(order2);
        Order order3 = new Order("e334ef40-9eff-4da8-9487-8ee697ecbf1e",
                products, 1708570000L, "Bambang Sugeni");
        orders.add(order3);
    }

    @Test
    void testCreatePaymentByBankTransferSuccessful() {
        Map<String, String> paymentDataBankTransfer = new HashMap<>();
        paymentDataBankTransfer.put("bankName", "FLEECA");
        paymentDataBankTransfer.put("referenceCode", "69707172");

        Payment payment = new PaymentByBankTransfer("02657834-7df4-4ad4-b164-4bb6be61cf7f", orders.get(0), PaymentMethod.BANK.getValue(), paymentDataBankTransfer);
        assertSame(orders.get(0), payment.getOrder());
        assertEquals(paymentDataBankTransfer, payment.getPaymentData());
        assertEquals("02657834-7df4-4ad4-b164-4bb6be61cf7f", payment.getId());
        assertEquals(PaymentMethod.BANK.getValue(), payment.getMethod());
    }

    @Test
    void testCreatePaymentBankTransferWithStatus() {
        Map<String, String> paymentDataBankTransfer = new HashMap<>();
        paymentDataBankTransfer.put("bankName", "BCA");
        paymentDataBankTransfer.put("referenceCode", "69707172");

        PaymentByBankTransfer paymentBankTransfer = new PaymentByBankTransfer("02657834-7df4-4ad4-b164-4bb6be61cf7f",orders.get(0), PaymentMethod.BANK.getValue(), paymentDataBankTransfer, PaymentStatus.SUCCESS.getValue());
        assertSame(orders.get(0), paymentBankTransfer.getOrder());
        assertEquals("02657834-7df4-4ad4-b164-4bb6be61cf7f", paymentBankTransfer.getId());
        assertEquals(PaymentMethod.BANK.getValue(), paymentBankTransfer.getMethod());
        assertEquals(paymentDataBankTransfer, paymentBankTransfer.getPaymentData());
        assertEquals(PaymentStatus.SUCCESS.getValue(), paymentBankTransfer.getStatus());
    }

    @Test
    void testCreatePaymentFailedEmptyBankName() {
        Map<String, String> paymentDataBankTransfer = new HashMap<>();
        paymentDataBankTransfer.put("bankName", "");
        paymentDataBankTransfer.put("referenceCode", "0123456789");

        assertThrows(IllegalArgumentException.class, ()-> {
            new PaymentByBankTransfer("02657834-7df4-4ad4-b164-4bb6be61cf7f", orders.get(1),PaymentMethod.BANK.getValue(), paymentDataBankTransfer);
        });
    }

    @Test
    void testCreatePaymentFailedEmptyReferenceCode() {
        Map<String, String> paymentDataBankTransfer = new  HashMap<>();
        paymentDataBankTransfer.put("bankName", "BNI");
        paymentDataBankTransfer.put("referenceCode", "");

        assertThrows(IllegalArgumentException.class, ()-> {
            new PaymentByBankTransfer("02657834-7df4-4ad4-b164-4bb6be61cf7f", orders.get(1),PaymentMethod.BANK.getValue(), paymentDataBankTransfer);
        });
    }
}