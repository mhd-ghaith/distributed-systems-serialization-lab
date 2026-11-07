import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CustomerProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    // Class-level field: NOT serialized
    public static String systemVersion = "v2.4";

    // Temporary field: NOT serialized
    private transient String tempDiscountToken;

    // Normal fields: serialized automatically
    private String customerName;
    private List<String> purchasedItems;
    private int[] itemPrices;
    private boolean isHolidayDealEligible;

    private Address address = new Address();

    public CustomerProfile() {}

    public CustomerProfile(String customerName, List<String> purchasedItems,
                           int[] itemPrices, boolean isHolidayDealEligible, String token) {
        this.customerName = customerName;
        this.purchasedItems = purchasedItems;
        this.itemPrices = itemPrices;
        this.isHolidayDealEligible = isHolidayDealEligible;
        this.tempDiscountToken = token;
    }

    @Override
    public String toString() {
        return "CustomerProfile{" +
                "systemVersion='" + systemVersion + '\'' +
                ", tempDiscountToken='" + tempDiscountToken + '\'' +
                ", customerName='" + customerName + '\'' +
                ", purchasedItems=" + purchasedItems +
                ", itemPrices=" + Arrays.toString(itemPrices) +
                ", isHolidayDealEligible=" + isHolidayDealEligible +
                '}';
    }
}