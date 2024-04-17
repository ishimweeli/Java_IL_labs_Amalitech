public class EnterviewChallenge {
//    Write a function to convert a name into initials. This kata strictly takes two words with one space in between them.
//    The output should be two capital letters with a dot separating them.
//    It should look like this:
//    Sam Harris => S.H
//    patrick feeney => P.F

    //intialise function

    //if its is empty or has charqacters
    //looping on each name
    //check where thers space and separate them
    //taking characters which have index

    public static void main(String[] args) {

        String name="ishimwe eliab";

        String[] splitNames=name.split("\\s+");

        StringBuilder initials=new StringBuilder();

        initials.append(splitNames[0].toUpperCase().charAt(0));
        initials.append(".");
        initials.append(splitNames[1].toUpperCase().charAt(0));
      System.out.println(initials);

    }


}
