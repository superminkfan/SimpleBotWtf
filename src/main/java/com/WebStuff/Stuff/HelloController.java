package com.WebStuff.Stuff;

import com.AesEncrypt.CoolAes256;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name) {

        Optional<String> opt = Optional.ofNullable(name);

        SecretKey key = null;

        try {
            key = CoolAes256.getKeyFromPassword(name, "salt");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        String input = "world";
        //создаем усложнение
        IvParameterSpec ivParameterSpec = CoolAes256.generateIv();
        String cipherText = "";
        String plainText = "";
        try {

            cipherText = CoolAes256.encrypt(input, key, ivParameterSpec);
            plainText = CoolAes256.decrypt(cipherText, key, ivParameterSpec);

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        System.out.println("cipher = " + cipherText);
        System.out.println("decryption text = " + plainText);

        return "Hello, " + plainText;
    }
}
