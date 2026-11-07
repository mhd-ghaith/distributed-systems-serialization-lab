import java.io.*;
import java.util.Arrays;

public class JavaSerializationLab {

    // Object -> bytes
    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.flush();
        return bos.toByteArray();
    }

    // bytes -> object
    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        return ois.readObject();
    }

    public static void main(String[] args) throws Exception {
        CustomerProfile original = new CustomerProfile(
                "Ahmad Saleh",
                Arrays.asList("Laptop", "Mouse"),
                new int[]{1200, 25},
                true,
                "SECRET-TOKEN-999");

        System.out.println("BEFORE serialization:\n" + original);

        byte[] payload = serialize(original);
        System.out.println("\nPayload size: " + payload.length + " bytes");

        // Task 2.3 (3): view the raw bytes as text
        System.out.println("\nPayload as text:\n" + new String(payload));

        // Change the static field BEFORE deserializing, to test its behavior
        CustomerProfile.systemVersion = "v3.0-UPDATED";

        CustomerProfile reconstructed = (CustomerProfile) deserialize(payload);
        System.out.println("\nAFTER deserialization:\n" + reconstructed);
    }
}