package com.gsoc.freebase.wikilinks.utils;

/**
 * <p>Utility class for WikiLinks</p>
 * @author Antonio David Perez Morales <adperezmorales@gmail.com>
 *
 */
public class WikiLinksUtils
{
    /**
     * <p>Converts the Freebase Id based on a GUID into the new Freebase Id</p>
     * <p>The process to be done is:
     * <ul>
     * <li>Take the GUID</li>
     * <li>Strip off the leading "#9202a8c04000641f8"</li>
     * <li>Take what's left and interpret it as a hex number</li>
     * <li>Express that number in base 32 using the character set 0123456789bcdfghjklmnpqrstvwxyz_ (ie the digits, the letters excluding the vowels and underscore)</li>
     * <li>Prepend 0 to what you've got.(prepend /m/0 to obtain the last part of a freebase entity uri) </li>
     * </ul>
     * </p>
     * 
     * @param freebaseGuid the GUID freebase id to be converted
     * @param extendedForm indicating whether to obtain only the freebase id or also the /m part
     * @return the new Freebase Id
     */
    public static String convertFreebaseId(String freebaseGuid, boolean extendedForm) {
        
        String alphabet = "0123456789bcdfghjklmnpqrstvwxyz_";
        String mId = freebaseGuid.replace("9202a8c04000641f8", "");
        int freebaseMId = Integer.parseInt(mId, 16);
        
        String newMId = "";

        int quotient, rest;
        rest = -1;
        int number = freebaseMId;
        quotient = -1;
        while (number >= 32)
        {
            quotient = number / 32;
            rest = number % 32;
            newMId = alphabet.charAt(rest) + newMId;
            number = quotient;

        }
        if (quotient != -1)
            newMId = alphabet.charAt(quotient) + newMId;

        newMId = "0" + newMId;
        newMId = extendedForm ? "/m/"+newMId : newMId;
       
        return newMId;
    }
    
    /**
     * <p>Converts the Freebase Id based on a GUID into the new Freebase Id</p>
     * <p>The process to be done is:
     * <ul>
     * <li>Take the GUID</li>
     * <li>Strip off the leading "#9202a8c04000641f8"</li>
     * <li>Take what's left and interpret it as a hex number</li>
     * <li>Express that number in base 32 using the character set 0123456789bcdfghjklmnpqrstvwxyz_ (ie the digits, the letters excluding the vowels and underscore)</li>
     * <li>Prepend 0 to what you've got.</li>
     * </ul>
     * </p>
     * 
     * @param freebaseGuid the GUID freebase id to be converted
     * @return the new Freebase Id
     */
    public static String convertFreebaseId(String freebaseGuid) {
        return convertFreebaseId(freebaseGuid, false);
    }
}
