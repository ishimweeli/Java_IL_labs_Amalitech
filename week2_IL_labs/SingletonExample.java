package com.personalExercises;

public class SingletonExample {
    public static void main(String[] args) {
PrintHello hii=PrintHello.getInstance();
hii.printWord("I have two cows");
hii.printWord("we have three cows");

    }
    public static class PrintHello {

        private static PrintHello instance =new PrintHello();

        private  String   word;

        private PrintHello(){

        }


        public static PrintHello getInstance(){
            return instance;
        }

        private void printWord(String word){
            this.word=word;
            System.out.println(word);
        }

    }
}
