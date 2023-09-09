package com.zerobase.productapi.config.encrypt;

import org.bouncycastle.crypto.InvalidCipherTextException;
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
  private static final String KEY = "wnviowenvemwpemcd1232190fwef10203";
  private static final String INSTANCE = "AES/ECB/PKCS5Padding";
  public String decode(String data) throws InvalidCipherTextException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    Security.addProvider(new BouncyCastleProvider());
    Cipher cipher = Cipher.getInstance(INSTANCE);

    byte[] decodedEncryptedMessage = Base64.getDecoder().decode(data);
    byte[] decryptedMessageBytes = cipher.doFinal(decodedEncryptedMessage);

    return new String(decryptedMessageBytes, StandardCharsets.UTF_8);
  }
  public String encode(String data) throws InvalidCipherTextException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
    Security.addProvider(new BouncyCastleProvider());
    byte[] encryptionKeyBytes = KEY.getBytes(StandardCharsets.UTF_8);

    Cipher cipher = Cipher.getInstance(INSTANCE);
    SecretKey secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    byte[] encrpyedMessageBytes = cipher.doFinal(data.getBytes());

    return Base64.getEncoder().encodeToString(encrpyedMessageBytes);
  }




}
