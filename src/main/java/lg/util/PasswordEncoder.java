package lg.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class PasswordEncoder {
    private static final int SALT_LENGTH = 16;
    private static final int HASH_ITERATIONS = 10000;

    public static String encodePassword(String password) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);

            byte[] passwordBytes = password.getBytes();
            byte[] saltedPassword = new byte[salt.length + passwordBytes.length];
            System.arraycopy(salt, 0, saltedPassword, 0, salt.length);
            System.arraycopy(passwordBytes, 0, saltedPassword, salt.length, passwordBytes.length);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = saltedPassword;
            for (int i = 0; i < HASH_ITERATIONS; i++) {
                hash = md.digest(hash);
            }

            byte[] saltedHash = new byte[salt.length + hash.length];
            System.arraycopy(salt, 0, saltedHash, 0, salt.length);
            System.arraycopy(hash, 0, saltedHash, salt.length, hash.length);

            return Base64.getEncoder().encodeToString(saltedHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm is not available.");
        }
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        try {
            byte[] saltedHash = Base64.getDecoder().decode(hashedPassword);
            byte[] salt = Arrays.copyOfRange(saltedHash, 0, SALT_LENGTH);

            byte[] passwordBytes = password.getBytes();
            byte[] saltedPassword = new byte[salt.length + passwordBytes.length];
            System.arraycopy(salt, 0, saltedPassword, 0, salt.length);
            System.arraycopy(passwordBytes, 0, saltedPassword, salt.length, passwordBytes.length);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = saltedPassword;
            for (int i = 0; i < HASH_ITERATIONS; i++) {
                hash = md.digest(hash);
            }

            return Arrays.equals(saltedHash, saltedHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm is not available.");
        }
    }
}
