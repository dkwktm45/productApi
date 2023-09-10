package com.zerobase.productapi.config.encrypt;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Base64;

@Service
public class EncryptionService {
  private static final String KEY = "thisisa16bytekey";
  private static final String INSTANCE = "AES/ECB/PKCS5Padding";

  static {
    Security.addProvider(new BouncyCastleProvider());
  }

  public String decode(String data) {
    try {
      byte[] encryptionKeyBytes = KEY.getBytes(StandardCharsets.UTF_8);
      SecretKey secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
      Cipher cipher = getCipher();
      cipher.init(Cipher.DECRYPT_MODE,secretKey);
      byte[] decryptedMessageBytes =
          cipher.doFinal(Base64.getDecoder().decode(data));

      return new String(decryptedMessageBytes, StandardCharsets.UTF_8);
    } catch (NoSuchPaddingException | NoSuchAlgorithmException |
             IllegalBlockSizeException | BadPaddingException |
             InvalidKeyException e) {
      throw new RuntimeException(e);
    }
  }

  public String encode(String data) {
    try {
      byte[] encryptionKeyBytes = KEY.getBytes(StandardCharsets.UTF_8);
      SecretKey secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
      Cipher cipher = getCipher();
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      byte[] encrpyedMessageBytes = cipher.doFinal(data.getBytes());
      return Base64.getEncoder().encodeToString(encrpyedMessageBytes);
    } catch (NoSuchPaddingException | NoSuchAlgorithmException |
             IllegalBlockSizeException | BadPaddingException |
             InvalidKeyException e) {
      throw new RuntimeException(e);
    }
  }

  private static Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {

    Cipher cipher = Cipher.getInstance(INSTANCE);
    return cipher;
  }


}
