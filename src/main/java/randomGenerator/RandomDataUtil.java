package randomGenerator;

import java.util.*;

public class RandomDataUtil {
    private static final StringBuilder CAPITAL_SMALL_LATIN_LETTERS_DIGITS = createCapitalSmallLatinLettersDigits();
    private static final int LENGTH = CAPITAL_SMALL_LATIN_LETTERS_DIGITS.length();
    private static final Random RANDOM = new Random();

    private RandomDataUtil() {
    }

    public static String getRandomValidEmail() {
        int boundaryMax1 = 10;
        int boundaryMin1 = 2;
        int emailLengthBeforeA = RANDOM.nextInt((boundaryMax1 - boundaryMin1) + 1) + boundaryMin1;

        StringBuilder randomEmailBeforeA = new StringBuilder(emailLengthBeforeA);

        randomEmailBeforeA.append(CAPITAL_SMALL_LATIN_LETTERS_DIGITS.charAt(RANDOM.nextInt(LENGTH)));

        for (int index = 1; index < emailLengthBeforeA - 1; index++) {
            randomEmailBeforeA.append(CAPITAL_SMALL_LATIN_LETTERS_DIGITS.charAt(RANDOM.nextInt(LENGTH)));
        }

        randomEmailBeforeA.append(CAPITAL_SMALL_LATIN_LETTERS_DIGITS.charAt(RANDOM.nextInt(LENGTH)));

        randomEmailBeforeA.append("@example.com");

        return randomEmailBeforeA.toString();
    }

    public static String getValidRandomPhone() {
        int phoneLength = 12;
        StringBuilder phone = new StringBuilder(phoneLength);

        int zeroChar = 48;
        int index = 0;
        int bound = 10;

        phone.append("+");
        do {
            phone.append((char) ((RANDOM.nextInt(bound)) + zeroChar));
            index++;
        } while (index < phoneLength);

        return phone.toString();
    }

    private static StringBuilder createCapitalSmallLatinLettersDigits() {
        int maxLength = 62;
        StringBuilder capitalSmallLatinLettersDigits = new StringBuilder(maxLength);

        int minUnicodeA = 65;
        int maxUnicodeZ = 90;
        for (int index = minUnicodeA; index <= maxUnicodeZ; index++) {
            capitalSmallLatinLettersDigits.append((char) index);
        }

        int aUnicodeMin = 97;
        int zUnicodeMax = 122;
        for (int index = aUnicodeMin; index <= zUnicodeMax; index++) {
            capitalSmallLatinLettersDigits.append((char) index);
        }

        int zeroUnicode = 48;
        int nineUnicode = 57;
        for (int index = zeroUnicode; index <= nineUnicode; index++) {
            capitalSmallLatinLettersDigits.append((char) index);
        }

        return capitalSmallLatinLettersDigits;
    }
}

