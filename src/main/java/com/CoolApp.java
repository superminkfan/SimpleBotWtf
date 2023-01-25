package com;

import com.AesEncrypt.CoolAes256;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class CoolApp {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        //создаем ключ
        SecretKey key = CoolAes256.getKeyFromPassword("NadodBlya", "NemnogoSsdsdsdolyi");
        String input = "hui";
        //создаем усложнение
        IvParameterSpec ivParameterSpec = CoolAes256.generateIv();
        //шифруем
        String cipherText = CoolAes256.encrypt(input, key, ivParameterSpec);
        //дешифруем
        String plainText = CoolAes256.decrypt(cipherText, key, ivParameterSpec);

        System.out.println(cipherText);
        System.out.println(plainText);
    }
}
