package com.personalExercises;

public class FactoryDesignPattern {


        public interface OS{
            void mySpec();

        }

        public static class Android implements OS{
           @Override
            public void mySpec() {
                System.out.println("this is best open android");
            }
        }

        public static class Ios implements OS{
            @Override
           public void mySpec(){
                System.out.println("this is most secure OS");
            }
        }

        public static class Windows implements OS{
            @Override
           public void mySpec(){
                System.out.println("this is Dying OS");
            }
        }

        public static class Factory{
            public OS FactoryMethod(String string) {

                if (string.equals("open")) {
                    return new Android();
                } else if (string.equals("secure")){
                    return new Ios();
                }
                return new Windows();
            }
        }



        public static void main(String[] args) {

Factory factory=new Factory();
OS os=factory.FactoryMethod("open");
os.mySpec();

        }


    }






