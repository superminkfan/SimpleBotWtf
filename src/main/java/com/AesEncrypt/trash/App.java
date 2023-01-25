package com.AesEncrypt.trash;

import javax.crypto.Cipher;
import java.security.SecureRandom;

public class App {

    public static void main(String[] args)  {
        Aes256Class aes256 = new Aes256Class();
        //Массив для соли
        byte[] salt = new byte[8];
        //Исходное сообщение
        String mes = "Опасность";

        for (int i = 0; i < 10; i++) {
            //Генерация соли
            SecureRandom random = new SecureRandom();
            random.nextBytes(salt);
            //Преобразуем исходный текст в поток байт и добавим полученную соль
            byte[]srcMessage = mes.getBytes();
            byte[]fullsrcMessage = new byte[srcMessage.length+8];
            System.arraycopy(srcMessage, 0, fullsrcMessage, 0, srcMessage.length);
            System.arraycopy(salt, 0, fullsrcMessage, srcMessage.length, salt.length);
            //Шифруем
            byte[] shifr = aes256.makeAes(fullsrcMessage, Cipher.ENCRYPT_MODE);
            System.out.println(new String(shifr));
            //Дешифруем
            byte[] src = aes256.makeAes(shifr, Cipher.DECRYPT_MODE);
            System.out.println(new String(src));
        }

    }
}
