package darkranger.libutil.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;


/**
 * 创建者  : 唐朝
 * 创建时间: 2017/6/2.
 * 类名    :AES加解密算法
 * 类功能  :
 */
public class DES {

	public static final String Key = "zbh7DN0sLZYI5d6L0NzCwklr0NtZExi3RJ6ERKrjIzYuGz6WZYjplu2J0tKqEA8T";
	

	public static String encode(String value) throws Exception {
		return encode(value, Key);
	}

	public static String encode(String value, String kk) throws Exception {
		byte[] key = kk.getBytes();
		byte[] keyiv = new byte[8];

		byte[] data = value.getBytes("UTF-8");
		return Base64.encode(des3EncodeCBC(key, keyiv, data));
	}

	public static String Decode(String value) throws Exception {
		return Decode(value, Key);
	}

	public static String Decode(String value, String kk) throws Exception {
		byte[] key = kk.getBytes();
		byte[] keyiv = new byte[8];
		byte[] data = Base64.decode(value);
		return new String(des3DecodeCBC(key, keyiv, data), "UTF-8");
	}

	private static byte[] des3EncodeCBC(byte[] key, byte[] keyiv, byte[] data) throws Exception {

		java.security.Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede" + "/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(keyiv);
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] bOut = cipher.doFinal(data);
		return bOut;
	}

	private static byte[] des3DecodeCBC(byte[] key, byte[] keyiv, byte[] data) throws Exception {

		java.security.Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede" + "/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(keyiv);

		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

		byte[] bOut = cipher.doFinal(data);

		return bOut;

	}

}