public class LengthOfLastWord {

        public int lengthOfLastWord(String s) {
            String[] words=new StringBuilder(s).toString().trim().split("\\s+");
            String lastWord=words[words.length-1];

            return lastWord.length();
        }
}
