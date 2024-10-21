/*
 * Class: CMSC203 20932
 * Instructor:Professor  Ahmed Tarek
 * Description: (Give a brief description for each Class)
 * Due: 10/16/2024
 * Platform/compiler: ECLIPSE IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Leoul Hailu Woldeyes
*/

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple substitution cipher where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_LIMIT = ' ';
	private static final char UPPER_LIMIT = '_';
	private static final int TOTAL_RANGE = UPPER_LIMIT - LOWER_LIMIT + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes
	 * according to the LOWER_LIMIT and UPPER_LIMIT characters.
	 * @param inputText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds(String inputText) {
		for (int index = 0; index < inputText.length(); index++) {
			char character = inputText.charAt(index);
			if (character < LOWER_LIMIT || character > UPPER_LIMIT) {
				return false; // Character is outside the allowable bounds
			}
		}
		return true; // All characters are within the allowable bounds
	}

	/**
	 * Encrypts a string according to the Caesar Cipher. The integer shiftKey specifies an offset
	 * and each character in inputText is replaced by the character "offset" away from it.
	 * @param inputText a string to be encrypted.
	 * @param shiftKey an integer that specifies the offset of each character.
	 * @return the encrypted string.
	 */
	public static String caesarEncryption(String inputText, int shiftKey) {
		StringBuilder encryptedResult = new StringBuilder();
		if (!isStringInBounds(inputText)) {
			return "The selected string is not in bounds. Try again.";
		}

		shiftKey = shiftKey % TOTAL_RANGE; // Normalize key to be within the range

		for (int index = 0; index < inputText.length(); index++) {
			char originalCharacter = inputText.charAt(index);
			char encryptedCharacter;

			if (isStringInBounds(Character.toString(originalCharacter))) {
				encryptedCharacter = (char) (((originalCharacter - LOWER_LIMIT + shiftKey) % TOTAL_RANGE) + LOWER_LIMIT);
			} else {
				encryptedCharacter = originalCharacter; // Leave unchanged if out of bounds
			}

			encryptedResult.append(encryptedCharacter);
		}

		return encryptedResult.toString();
	}

	/**
	 * Encrypts a string according to the Bellaso Cipher. Each character in inputText is offset
	 * according to the ASCII value of the corresponding character in keyword, which is repeated
	 * to correspond to the length of inputText.
	 * @param inputText a string to be encrypted.
	 * @param keyword a string that specifies the offsets, character by character.
	 * @return the encrypted string.
	 */
	public static String bellasoEncryption(String inputText, String keyword) {
		StringBuilder encryptedResult = new StringBuilder();
		StringBuilder repeatedKeyword = new StringBuilder();

		// Extend the keyword to match the length of inputText
		while (repeatedKeyword.length() < inputText.length()) {
			repeatedKeyword.append(keyword);
		}

		for (int index = 0; index < inputText.length(); index++) {
			char originalCharacter = inputText.charAt(index);
			char bellasoCharacter = repeatedKeyword.charAt(index);
			char encryptedCharacter;

			if (isStringInBounds(Character.toString(originalCharacter))) {
				// Calculate the offset by adding the ASCII values
				int offset = (originalCharacter - LOWER_LIMIT + (bellasoCharacter - LOWER_LIMIT)) % TOTAL_RANGE + LOWER_LIMIT;
				encryptedCharacter = (char) offset;
			} else {
				encryptedCharacter = originalCharacter; // Leave unchanged if out of bounds
			}

			encryptedResult.append(encryptedCharacter);
		}

		return encryptedResult.toString();
	}

	/**
	 * Decrypts a string according to the Caesar Cipher. The integer shiftKey specifies an offset
	 * and each character in encryptedText is replaced by the character "offset" characters before it.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param shiftKey an integer that specifies the offset of each character.
	 * @return the plain text string.
	 */
	public static String caesarDecryption(String encryptedText, int shiftKey) {
		StringBuilder decryptedResult = new StringBuilder();
		shiftKey = shiftKey % TOTAL_RANGE; // Normalize key to be within the range

		for (int index = 0; index < encryptedText.length(); index++) {
			char encryptedCharacter = encryptedText.charAt(index);
			char decryptedCharacter;

			if (isStringInBounds(Character.toString(encryptedCharacter))) {
				decryptedCharacter = (char) (((encryptedCharacter - LOWER_LIMIT - shiftKey + TOTAL_RANGE) % TOTAL_RANGE) + LOWER_LIMIT);
			} else {
				decryptedCharacter = encryptedCharacter; // Leave unchanged if out of bounds
			}

			decryptedResult.append(decryptedCharacter);
		}

		return decryptedResult.toString();
	}

	/**
	 * Decrypts a string according to the Bellaso Cipher. Each character in encryptedText is replaced by
	 * the character corresponding to the character in keyword, which is repeated
	 * to correspond to the length of inputText.
	 * @param encryptedText a string to be decrypted.
	 * @param keyword a string that specifies the offsets, character by character.
	 * @return the decrypted string.
	 */
	public static String bellasoDecryption(String encryptedText, String keyword) {
		StringBuilder decryptedResult = new StringBuilder();
		StringBuilder repeatedKeyword = new StringBuilder();

		// Extend the keyword to match the length of encryptedText
		while (repeatedKeyword.length() < encryptedText.length()) {
			repeatedKeyword.append(keyword);
		}

		for (int index = 0; index < encryptedText.length(); index++) {
			char encryptedCharacter = encryptedText.charAt(index);
			char bellasoCharacter = repeatedKeyword.charAt(index);
			char decryptedCharacter;

			if (isStringInBounds(Character.toString(encryptedCharacter))) {
				// Calculate the offset by subtracting the ASCII values
				int offset = (encryptedCharacter - LOWER_LIMIT - (bellasoCharacter - LOWER_LIMIT) + TOTAL_RANGE) % TOTAL_RANGE + LOWER_LIMIT;
				decryptedCharacter = (char) offset;
			} else {
				decryptedCharacter = encryptedCharacter; // Leave unchanged if out of bounds
			}

			decryptedResult.append(decryptedCharacter);
		}

		return decryptedResult.toString();
	}
}
