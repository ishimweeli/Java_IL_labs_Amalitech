public  class Shapes {
    public static abstract class Shape{
        abstract double area();
            abstract double perimeter();
    }

    public static class  Square extends Shape{
        double side;
        public Square(double side){
            this.side=side;
        }
        public double area(){
         return side*side;
        };
        public double perimeter(){
          return  side*4;
        };
    }

    public static void main(String[] args) {
        Square square=new Square(25);
        System.out.println("this is area:"+square.area()+"this is perimeter:"+square.perimeter());
    }
}