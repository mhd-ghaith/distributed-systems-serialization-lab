import com.distributed.lab.CustomerProfileProto.CustomerProfile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class ProtobufLab {
    public static void main(String[] args) throws Exception {
        // Build the object with the Builder pattern
        CustomerProfile profile = CustomerProfile.newBuilder()
                .setCustomerName("Ahmad Saleh")
                .addAllPurchasedItems(Arrays.asList("Laptop", "Mouse"))
                .addAllItemPrices(Arrays.asList(1200, 25))
                .setIsHolidayDealEligible(true)
                .build();

        // Serialize to bytes
        byte[] protoPayload = profile.toByteArray();
        System.out.println("Protobuf size: " + protoPayload.length + " bytes");

        // Save the bytes to a file (needed later for the rename test)
        Files.write(Path.of("payload.bin"), protoPayload);

        // Deserialize
        CustomerProfile restored = CustomerProfile.parseFrom(protoPayload);
        System.out.println("Name: " + restored.getCustomerName());
        System.out.println("City: " + restored.getCity());
        System.out.println("hasCity: " + restored.hasCity());

        // JSON size of the same data (compact), for the comparison
        String json = "{\"customerName\":\"Ahmad Saleh\",\"purchasedItems\":[\"Laptop\",\"Mouse\"],"
                + "\"itemPrices\":[1200,25],\"isHolidayDealEligible\":true}";
        System.out.println("JSON size: " + json.getBytes("UTF-8").length + " bytes");
    }
}