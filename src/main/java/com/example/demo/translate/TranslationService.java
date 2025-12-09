package com.example.demo.translate;

import okhttp3.*;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class TranslationService {

    public String translate(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "";
        }

        String[] amharicWords = text.split(" ");
        StringBuilder englishText = new StringBuilder();

        for (int i = 0; i < amharicWords.length; i++) {
            if(getHonorWords().get(amharicWords[i])!=null){
                englishText.append(getHonorWords().get(amharicWords[i])+" ");
                continue;
            }
            char[] amharicCharacters = amharicWords[i].toCharArray();
            StringBuilder englishWord = new StringBuilder();

            for (int j = 0; j < amharicCharacters.length; j++) {
                String transliteration = getTransliterationMap().get(amharicCharacters[j]);
                if (transliteration != null) {
                    englishWord.append(transliteration);
                } else {
                    // If character not found in map, keep it as is
                    englishWord.append(amharicCharacters[j]);
                }
            }

            englishText.append(englishWord.toString());
            if (i < amharicWords.length - 1) {
                englishText.append(" "); // Add space between words
            }
        }

        return englishText.toString();
    }
        public static HashMap<Character, String> getTransliterationMap() {
            HashMap<Character, String> translitMap = new HashMap<>();

            // ሀ series
            translitMap.put('ሀ', "ha");
            translitMap.put('ሁ', "hu");
            translitMap.put('ሂ', "hi");
            translitMap.put('ሃ', "ha");
            translitMap.put('ሄ', "he");
            translitMap.put('ህ', "h");
            translitMap.put('ሆ', "ho");

            // ለ series
            translitMap.put('ለ', "le");
            translitMap.put('ሉ', "lu");
            translitMap.put('ሊ', "li");
            translitMap.put('ላ', "la");
            translitMap.put('ሌ', "le");
            translitMap.put('ል', "l");
            translitMap.put('ሎ', "lo");
             //ሐ series
            translitMap.put('ሐ', "ha");
            translitMap.put('ሑ', "hu");
            translitMap.put('ሒ', "hi");
            translitMap.put('ሓ', "ha");
            translitMap.put('ሔ', "he");
            translitMap.put('ሕ', "h");
            translitMap.put('ሖ', "ho");

            // መ series
            translitMap.put('መ', "me");
            translitMap.put('ሙ', "mu");
            translitMap.put('ሚ', "mi");
            translitMap.put('ማ', "ma");
            translitMap.put('ሜ', "me");
            translitMap.put('ም', "m");
            translitMap.put('ሞ', "mo");

            // ሠ series
            translitMap.put('ሠ', "se");
            translitMap.put('ሡ', "su");
            translitMap.put('ሢ', "si");
            translitMap.put('ሣ', "sa");
            translitMap.put('ሤ', "se");
            translitMap.put('ሥ', "s");
            translitMap.put('ሦ', "so");

            // ረ series
            translitMap.put('ረ', "re");
            translitMap.put('ሩ', "ru");
            translitMap.put('ሪ', "ri");
            translitMap.put('ራ', "ra");
            translitMap.put('ሬ', "re");
            translitMap.put('ር', "r");
            translitMap.put('ሮ', "ro");

            // ሰ series
            translitMap.put('ሰ', "se");
            translitMap.put('ሱ', "su");
            translitMap.put('ሲ', "si");
            translitMap.put('ሳ', "sa");
            translitMap.put('ሴ', "se");
            translitMap.put('ስ', "s");
            translitMap.put('ሶ', "so");

            // ሸ series
            translitMap.put('ሸ', "she");
            translitMap.put('ሹ', "shu");
            translitMap.put('ሺ', "shi");
            translitMap.put('ሻ', "sha");
            translitMap.put('ሼ', "she");
            translitMap.put('ሽ', "sh");
            translitMap.put('ሾ', "sho");

            // ቀ series
            translitMap.put('ቀ', "qe");
            translitMap.put('ቁ', "qu");
            translitMap.put('ቂ', "qi");
            translitMap.put('ቃ', "qa");
            translitMap.put('ቄ', "qe");
            translitMap.put('ቅ', "q");
            translitMap.put('ቆ', "qo");

            // በ series
            translitMap.put('በ', "be");
            translitMap.put('ቡ', "bu");
            translitMap.put('ቢ', "bi");
            translitMap.put('ባ', "ba");
            translitMap.put('ቤ', "be");
            translitMap.put('ብ', "b");
            translitMap.put('ቦ', "bo");

            // ተ series
            translitMap.put('ተ', "te");
            translitMap.put('ቱ', "tu");
            translitMap.put('ቲ', "ti");
            translitMap.put('ታ', "ta");
            translitMap.put('ቴ', "te");
            translitMap.put('ት', "t");
            translitMap.put('ቶ', "to");

            // ቸ series
            translitMap.put('ቸ', "che");
            translitMap.put('ቹ', "chu");
            translitMap.put('ቺ', "chi");
            translitMap.put('ቻ', "cha");
            translitMap.put('ቼ', "che");
            translitMap.put('ች', "ch");
            translitMap.put('ቾ', "cho");

            // ነ series
            translitMap.put('ነ', "ne");
            translitMap.put('ኑ', "nu");
            translitMap.put('ኒ', "ni");
            translitMap.put('ና', "na");
            translitMap.put('ኔ', "ne");
            translitMap.put('ን', "n");
            translitMap.put('ኖ', "no");

            translitMap.put('ኘ', "ne");
            translitMap.put('ኙ', "nu");
            translitMap.put('ኚ', "ni");
            translitMap.put('ኛ', "na");
            translitMap.put('ኜ', "ne");
            translitMap.put('ኝ', "n");
            translitMap.put('ኞ', "no");


            // አ series
            translitMap.put('አ', "a");
            translitMap.put('ኡ', "u");
            translitMap.put('ኢ', "i");
            translitMap.put('ኣ', "a");
            translitMap.put('ኤ', "e");
            translitMap.put('እ', "e");
            translitMap.put('ኦ', "o");

            // ከ series
            translitMap.put('ከ', "ke");
            translitMap.put('ኩ', "ku");
            translitMap.put('ኪ', "ki");
            translitMap.put('ካ', "ka");
            translitMap.put('ኬ', "ke");
            translitMap.put('ክ', "k");
            translitMap.put('ኮ', "ko");
            translitMap.put('ኳ',"kua");

            // ኸ series
            translitMap.put('ኸ', "he");
            translitMap.put('ኹ', "hu");
            translitMap.put('ኺ', "hi");
            translitMap.put('ኻ', "ha");
            translitMap.put('ኼ', "he");
            translitMap.put('ኽ', "h");
            translitMap.put('ኾ', "ho");

            // ወ series
            translitMap.put('ወ', "we");
            translitMap.put('ዉ', "wu");
            translitMap.put('ዊ', "wi");
            translitMap.put('ዋ', "wa");
            translitMap.put('ዌ', "we");
            translitMap.put('ው', "w");
            translitMap.put('ዎ', "wo");

            // ዐ series
            translitMap.put('ዐ', "a");
            translitMap.put('ዑ', "u");
            translitMap.put('ዒ', "i");
            translitMap.put('ዓ', "a");
            translitMap.put('ዔ', "e");
            translitMap.put('ዕ', "e");
            translitMap.put('ዖ', "o");

            // ዘ series
            translitMap.put('ዘ', "ze");
            translitMap.put('ዙ', "zu");
            translitMap.put('ዚ', "zi");
            translitMap.put('ዛ', "za");
            translitMap.put('ዜ', "ze");
            translitMap.put('ዝ', "z");
            translitMap.put('ዞ', "zo");

            // ዠ series
            translitMap.put('ዠ', "je");
            translitMap.put('ዡ', "ju");
            translitMap.put('ዢ', "ji");
            translitMap.put('ዣ', "ja");
            translitMap.put('ዤ', "je");
            translitMap.put('ዥ', "j");
            translitMap.put('ዦ', "jo");

            // የ series
            translitMap.put('የ', "ye");
            translitMap.put('ዩ', "yu");
            translitMap.put('ዪ', "yi");
            translitMap.put('ያ', "ya");
            translitMap.put('ዬ', "ye");
            translitMap.put('ይ', "y");
            translitMap.put('ዮ', "yo");

            // ደ series
            translitMap.put('ደ', "de");
            translitMap.put('ዱ', "du");
            translitMap.put('ዲ', "di");
            translitMap.put('ዳ', "da");
            translitMap.put('ዴ', "de");
            translitMap.put('ድ', "d");
            translitMap.put('ዶ', "do");
            translitMap.put('ዷ',"dua");

            // ጀ series
            translitMap.put('ጀ', "je");
            translitMap.put('ጁ', "ju");
            translitMap.put('ጂ', "ji");
            translitMap.put('ጃ', "ja");
            translitMap.put('ጄ', "je");
            translitMap.put('ጅ', "j");
            translitMap.put('ጆ', "jo");

            // ገ series
            translitMap.put('ገ', "ge");
            translitMap.put('ጉ', "gu");
            translitMap.put('ጊ', "gi");
            translitMap.put('ጋ', "ga");
            translitMap.put('ጌ', "ge");
            translitMap.put('ግ', "g");
            translitMap.put('ጎ', "go");
            translitMap.put('ጐ', "go");


            translitMap.put('ኀ', "he");
            translitMap.put('ኁ', "hu");
            translitMap.put('ኂ', "hi");
            translitMap.put('ኃ', "ha");
            translitMap.put('ኄ', "he");
            translitMap.put('ኅ', "h");
            translitMap.put('ኆ', "ho");
            translitMap.put('ኋ',"hua");

            // ጠ series
            translitMap.put('ጠ', "te");
            translitMap.put('ጡ', "tu");
            translitMap.put('ጢ', "ti");
            translitMap.put('ጣ', "ta");
            translitMap.put('ጤ', "te");
            translitMap.put('ጥ', "t");
            translitMap.put('ጦ', "to");

            // ጨ series
            translitMap.put('ጨ', "che");
            translitMap.put('ጩ', "chu");
            translitMap.put('ጪ', "chi");
            translitMap.put('ጫ', "cha");
            translitMap.put('ጬ', "che");
            translitMap.put('ጭ', "ch");
            translitMap.put('ጮ', "cho");

            // ጰ series
            translitMap.put('ጰ', "pe");
            translitMap.put('ጱ', "pu");
            translitMap.put('ጲ', "pi");
            translitMap.put('ጳ', "pa");
            translitMap.put('ጴ', "pe");
            translitMap.put('ጵ', "p");
            translitMap.put('ጶ', "po");

            // ጸ series
            translitMap.put('ጸ', "tse");
            translitMap.put('ጹ', "tsu");
            translitMap.put('ጺ', "tsi");
            translitMap.put('ጻ', "tsa");
            translitMap.put('ጼ', "tse");
            translitMap.put('ጽ', "ts");
            translitMap.put('ጾ', "tso");

            // ፀ series
            translitMap.put('ፀ', "tse");
            translitMap.put('ፁ', "tsu");
            translitMap.put('ፂ', "tsi");
            translitMap.put('ፃ', "tsa");
            translitMap.put('ፄ', "tse");
            translitMap.put('ፅ', "ts");
            translitMap.put('ፆ', "tso");

            // ፈ series
            translitMap.put('ፈ', "fe");
            translitMap.put('ፉ', "fu");
            translitMap.put('ፊ', "fi");
            translitMap.put('ፋ', "fa");
            translitMap.put('ፌ', "fe");
            translitMap.put('ፍ', "f");
            translitMap.put('ፎ', "fo");

            // ፐ series
            translitMap.put('ፐ', "pe");
            translitMap.put('ፑ', "pu");
            translitMap.put('ፒ', "pi");
            translitMap.put('ፓ', "pa");
            translitMap.put('ፔ', "pe");
            translitMap.put('ፕ', "p");
            translitMap.put('ፖ', "po");

            return translitMap;
        }

        public static  HashMap<String,String> getHonorWords(){
            HashMap<String, String>  honorMap = new HashMap<>();
            honorMap.put("አቶ","Mr");
            honorMap.put("ሼክ","Shekh");
            honorMap.put("ወ/ሮ","Mrs");
            honorMap.put("ወ/ር","Mrs");
            honorMap.put("ፕ/ር","Professor");
            honorMap.put("ኘ/ር","Professor");
            honorMap.put("ዶ/ር","PHD");
            honorMap.put("ኮ/ል","Colonel");
            honorMap.put("ኢ/ር","Inspector");
            honorMap.put("ክቡር","His Excellency");
            honorMap.put("ክብርት","Her Excellency");
            honorMap.put("ኢንጂነር","Engineer");
            honorMap.put("ኢንጅነር","Engineer");
            return  honorMap;
        }

}
