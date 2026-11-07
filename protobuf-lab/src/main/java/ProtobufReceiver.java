import com.distributed.lab.receiver.CustomerProfileReceiverProto.CustomerProfile;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProtobufReceiver {
    public static void main(String[] args) throws Exception {
        // Bytes produced by the ORIGINAL sender (ProtobufLab), unchanged
        byte[] payload = Files.readAllBytes(Path.of("payload.bin"));

        // Show the raw bytes in hex
        StringBuilder hex = new StringBuilder();
        for (byte b : payload) hex.append(String.format("%02X ", b));
        System.out.println("Payload (hex): " + hex);

        // Parse with the receiver's renamed schema
        CustomerProfile received = CustomerProfile.parseFrom(payload);

        System.out.println("Full client name: " + received.getFullClientName());
        System.out.println("City: " + received.getCity());
        System.out.println("Items: " + received.getPurchasedItemsList());
        System.out.println("Prices: " + received.getItemPricesList());
        System.out.println("Holiday eligible: " + received.getIsHolidayDealEligible());
    }
}