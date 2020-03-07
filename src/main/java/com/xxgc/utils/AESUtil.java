package com.xxgc.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

public class AESUtil {
	/*
	 * AES�����㷨��Ϊ��һ�������ݼ��ܱ�׼�����ǿ��ȫ�ԡ������ܡ���Ч�ʡ����ú������ŵ㡣 AES�����������Կ���ȣ�128��192��256 λ��
	 * ��Զ��ԣ�AES��128��Կ��DES��56��Կǿ��1021��
	 */

	/**
	 * �û��Զ������Կ����ǰ���Э��ȷ�� ����������Ӧ���ڼӽ��ܷ����Ĳ����б�¶����AES�İ�ȫ�ԣ�ȡ������Կ�İ�ȫ�ԡ�
	 */
	private static final String KEY = "agdfscxcvz";
	/**
	 * AES:�㷨��ECB:ģʽ��PKCS5Padding:���뷽ʽ
	 */
	private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

	/**
	 * AES����
	 * 
	 * @param message
	 *            Ҫ���ܵ���Ϣ
	 * @return ���ܺ���ַ���
	 */
	public static String encrypt(String message) {
		return doAES(message, KEY, Cipher.ENCRYPT_MODE);
	}

	/**
	 * AES����
	 * 
	 * @param message
	 *            Ҫ���ܵ���Ϣ
	 * @return ���ܺ���ַ���
	 */
	public static String decrypt(String message) {
		return doAES(message, KEY, Cipher.DECRYPT_MODE);
	}

	/**
	 * ���ܻ���ܵ�ʵ�ʲ�������
	 * 
	 * @param message
	 *            ���������Ϣ
	 * @param key
	 *            AES�ӽ��ܹ�����Ҫ����Կ
	 * @param mode
	 *            �ӽ���mode
	 * @return ���ܻ���ܺ����Ϣ
	 */
	private static String doAES(String message,String key, int mode){
			if (StringUtils.isBlank(message) || StringUtils.isBlank(key)){
                return null;
			}
            // ����AES�㷨Ҫ����Կ�ĳ���Ϊ16�ı�������1,2,3,4������Ŀ��: ���û��Զ������Կ�滻��16λ����Կ

            // 1. ������Կ��������ָ��ΪAES�㷨
            KeyGenerator keyGenerator = null;
			try {
				keyGenerator = KeyGenerator.getInstance("AES");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            // 2. �����û��Զ�����Կ��Ӧ���ֽ����飬����һ��128λ�����Դ��ֻ����128 or 192 or 256�е�һ����
			//windows�����֣�����һ�У�
            //keyGenerator.init(128, new SecureRandom(key.getBytes()));
			//��ĳЩlinuxƽ̨��ʹ�����ַ���������8�У�������Ч�������Ϊ����linuxд��������������
			SecureRandom secureRandom = null;
			try {
				secureRandom = SecureRandom.getInstance("SHA1PRNG");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			secureRandom.setSeed(key.getBytes());
		    keyGenerator.init(128 ,secureRandom);
            // 3. ����AES�㷨��ԭʼ�Գ���Կ
            SecretKey secretKey = keyGenerator.generateKey();
            // 4. ��ȡԭʼ�Գ���Կ���ֽ�����
            byte[] enCodeFormat = secretKey.getEncoded();

            // 5. �����ֽ���������AES��Կ
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat,"AES");
            // 6.����ָ���㷨AES�Գ�������
            Cipher cipher = null;
			try {
				cipher = Cipher.getInstance(ALGORITHM);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            // 7.��ʼ������������һ������Ϊ����(Encrypt_mode)���߽���(Decrypt_mode)�������ڶ�������Ϊʹ�õ�KEY
            try {
				cipher.init(mode, secretKeySpec);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            if (mode == Cipher.ENCRYPT_MODE) {
                byte[] content = message.getBytes();
                byte[] result = null;
				try {
					result = cipher.doFinal(content);
				} catch (IllegalBlockSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                // !!! ���ܣ�AES���ܺ�Ľ��Ĭ����Base64��ʽ���ֽ�����
                return Base64.encodeBase64String(result);
            } else {
                byte[] content = Base64.decodeBase64(message);
                byte[] result = null;
				try {
					result = cipher.doFinal(content);
				} catch (IllegalBlockSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                return new String(result);
            }
	}
}
