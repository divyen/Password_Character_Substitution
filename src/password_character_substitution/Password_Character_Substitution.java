package password_character_substitution;

import java.util.ArrayList;
import java.util.HashMap;

public class Password_Character_Substitution {

    static HashMap<Character, String[]> mappings = new HashMap<Character, String[]>();

    public static void main(String[] args) {
        
        init_character_mapping();

        ArrayList<String> passwords = generate_password_possibilities("abook");
        
        for(int i=0;i<passwords.size();i++) {
            System.out.print(passwords.get(i) + "\t\t");
            if(i%10==0) {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("Number of Password Combinations:" + passwords.size());
        
    }

    static ArrayList<String> generate_password_possibilities(String overheardpassword) {
        ArrayList<String> password_list = new ArrayList<String>();
        if (overheardpassword != null && overheardpassword.length()!=0) {
            generate_password_helper(password_list, "", overheardpassword);
        }
        return password_list;
    }

    static void generate_password_helper(ArrayList<String> password_list, String password_prefix, String password_remaining) {
        char password_char = password_remaining.substring(0, 1).charAt(0);
        String[] replacements = mappings.get(Character.valueOf(password_char));
         
        if (password_remaining.length() == 1) {
            if (replacements != null) {
                for (int i = 0; i < replacements.length; i++) {
                    password_list.add(password_prefix + replacements[i]);
                }
            } else {
                password_list.add(password_prefix + password_char);
            }
        } else {

            if (replacements != null) {
                for (int i = 0; i < replacements.length; i++) {
                    generate_password_helper(password_list, password_prefix + replacements[i], password_remaining.substring(1));
                }
            } else {
                generate_password_helper(password_list, password_prefix + password_char, password_remaining.substring(1));
            }

        }
    }
    
    static void init_character_mapping() {
        mappings.put(Character.valueOf('a'), new String[]{"a", "A", "@"});
        mappings.put(Character.valueOf('b'), new String[]{"b", "B", "8","|3"});
        mappings.put(Character.valueOf('c'), new String[]{"c", "C"});
        mappings.put(Character.valueOf('d'), new String[]{"d", "D"});
        mappings.put(Character.valueOf('e'), new String[]{"e", "E", "3"});
        mappings.put(Character.valueOf('f'), new String[]{"f", "F"});
        mappings.put(Character.valueOf('g'), new String[]{"g", "G", "9", "6"});
        mappings.put(Character.valueOf('h'), new String[]{"h", "H"});
        mappings.put(Character.valueOf('i'), new String[]{"i", "I", "!", "1"});
        mappings.put(Character.valueOf('j'), new String[]{"j", "J"});
        mappings.put(Character.valueOf('k'), new String[]{"k", "K", "|<"});
        mappings.put(Character.valueOf('l'), new String[]{"l", "L"});
        mappings.put(Character.valueOf('m'), new String[]{"m", "M"});
        mappings.put(Character.valueOf('n'), new String[]{"n", "N"});
        mappings.put(Character.valueOf('o'), new String[]{"o", "O", "0"});
        mappings.put(Character.valueOf('p'), new String[]{"p", "P", "9"});
        mappings.put(Character.valueOf('q'), new String[]{"Q", "q"});
        mappings.put(Character.valueOf('r'), new String[]{"r", "R"});
        mappings.put(Character.valueOf('s'), new String[]{"s", "S", "$", "5"});
        mappings.put(Character.valueOf('t'), new String[]{"t", "T", "7"});
        mappings.put(Character.valueOf('u'), new String[]{"u", "U", "you"});
        mappings.put(Character.valueOf('v'), new String[]{"v", "V"});
        mappings.put(Character.valueOf('w'), new String[]{"w", "W"});
        mappings.put(Character.valueOf('x'), new String[]{"x", "X"});
        mappings.put(Character.valueOf('y'), new String[]{"y", "Y"});
        mappings.put(Character.valueOf('z'), new String[]{"z", "Z"});
        mappings.put(Character.valueOf(' '), new String[]{"?"});
        mappings.put(Character.valueOf('1'), new String[]{"1", "!"});
        mappings.put(Character.valueOf('2'), new String[]{"2", "Z"});
        mappings.put(Character.valueOf('3'), new String[]{"3", "E"});
        mappings.put(Character.valueOf('4'), new String[]{"4", "?"});
        mappings.put(Character.valueOf('5'), new String[]{"5", "S", "s", "$"});
        mappings.put(Character.valueOf('6'), new String[]{"6"});
        mappings.put(Character.valueOf('7'), new String[]{"7", "T"});
        mappings.put(Character.valueOf('8'), new String[]{"8", "B"});
        mappings.put(Character.valueOf('9'), new String[]{"9"});
        mappings.put(Character.valueOf('0'), new String[]{"0", "0", "O"});
    }
}
